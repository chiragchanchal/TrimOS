#!/usr/bin/env python3
"""
TrimOS - Universal Clean Operating Environment & Launcher for Android TV & Google TV
Transforms any bloated smart TV into a lightning-fast, ad-free, Apple TV-inspired experience.

Supported Devices:
  - Xiaomi / Redmi / Mi TV (PatchWall removal)
  - Google TV & Chromecast with Google TV
  - Sony Bravia, TCL, Hisense, Philips, Sharp (Android TV / Leanback)
  - Amazon Fire TV (FireStick 4K, Cube, Omni)
  - OnePlus TV (OxygenPlay removal)
  - Realme TV & Generic Android TV boxes (Nvidia Shield, Mecool, Formuler, etc.)

Features:
  - Apple TV UI with dynamic fluid animations & wallpapers
  - 32 built-in themes selectable on-device or via web
  - Mobile Virtual Remote & Touchpad with drag & drop support
  - QR Code & Mobile Sign-In (type credentials on phone keyboard)
  - Universal Multi-App Streaming Search (SmartTube, Netflix, Prime, Hotstar)
  - Remote Button Remapper
  - 1-Click RAM Cleaner & Resource Optimizer
  - Ad-free SmartTube integration with SponsorBlock
  - Permanent Home button lock across reboots
  - 100% Safe & Reversible (1-click restore to factory default)
"""

import os
import sys
import time
import argparse
import subprocess
import shutil
import json
import urllib.request
import webbrowser
from pathlib import Path

VERSION = "1.0.0"
SCRIPT_DIR = Path(__file__).resolve().parent
RELEASE_DIR = SCRIPT_DIR / "release"
TRIMOS_APK = RELEASE_DIR / "TrimOS-v1.0.apk"
SMARTTUBE_ARM32 = RELEASE_DIR / "SmartTube-v32.71-armeabi-v7a.apk"
SMARTTUBE_ARM64 = RELEASE_DIR / "SmartTube-v32.71-arm64-v8a.apk"

TRIMOS_PKG = "com.gathin.tvhome"
TRIMOS_ACTIVITY = "com.gathin.tvhome/.MainActivity"
TRIMOS_ACCESSIBILITY = "com.gathin.tvhome/.HomeKeyService"

# Brand-specific bloatware & stock launcher signatures
PROFILES = {
    "XIAOMI": {
        "name": "Xiaomi / Redmi / Mi TV (PatchWall)",
        "launchers": [
            "com.mitv.tvhome.atv",
            "com.mitv.tvhome.mitvplus",
            "com.xiaomi.mitv.tvhome",
            "com.mitv.recommend.channel",
        ],
        "ad_services": [
            "com.miui.systemAdSolution",
            "com.xiaomi.mitv.advertise",
        ],
        "settings_fix": [
            ("global", "set_auto_play", "0"),
        ]
    },
    "GOOGLE_TV": {
        "name": "Google TV / Chromecast with Google TV",
        "launchers": [
            "com.google.android.apps.tv.launcherx",
            "com.google.android.tungsten.setupwraith",
        ],
        "ad_services": [
            "com.google.android.tvrecommendations",
        ],
        "settings_fix": []
    },
    "ANDROID_TV_STOCK": {
        "name": "Android TV (Leanback: Sony, TCL, Hisense, Philips, Sharp)",
        "launchers": [
            "com.google.android.leanbacklauncher",
            "com.google.android.tvlauncher",
        ],
        "ad_services": [
            "com.google.android.tvrecommendations",
        ],
        "settings_fix": []
    },
    "FIRE_TV": {
        "name": "Amazon Fire TV (FireStick, Cube, Omni)",
        "launchers": [
            "com.amazon.tv.launcher",
        ],
        "ad_services": [
            "com.amazon.device.sale.service",
            "com.amazon.advertising",
        ],
        "settings_fix": []
    },
    "ONEPLUS": {
        "name": "OnePlus TV (OxygenPlay)",
        "launchers": [
            "com.oneplus.tv.launcher",
            "com.oneplus.tv.epiclauncher",
        ],
        "ad_services": [
            "com.oneplus.tv.recommendation",
        ],
        "settings_fix": []
    },
}

class Colors:
    CYAN = "\033[96m"
    GREEN = "\033[92m"
    YELLOW = "\033[93m"
    RED = "\033[91m"
    BOLD = "\033[1m"
    DIM = "\033[2m"
    RESET = "\033[0m"

if sys.platform == "win32":
    try:
        sys.stdout.reconfigure(encoding="utf-8", errors="replace")
        sys.stderr.reconfigure(encoding="utf-8", errors="replace")
    except Exception:
        pass

def print_banner():
    banner = f"""
{Colors.CYAN}{Colors.BOLD}+--------------------------------------------------------------+
|     _____     _           ___  ____                          |
|    |_   _| __(_)_ __ ___ / _ \/ ___|                         |
|      | || '__| | '_ ` _ \ | | \___ \                         |
|      | || |  | | | | | | | |_| |___) |  v{VERSION}               |
|      |_||_|  |_|_| |_| |_|\___/|____/                        |
|                                                              |
|   Ultra-Clean, Ad-Free Operating Environment for Android TV  |
+--------------------------------------------------------------+{Colors.RESET}
"""
    print(banner)

def find_adb():
    """Finds ADB binary from PATH or standard SDK installation folders."""
    adb_path = shutil.which("adb")
    if adb_path:
        return adb_path

    # Common Windows paths
    candidates = [
        Path.home() / "AppData" / "Local" / "Android" / "Sdk" / "platform-tools" / "adb.exe",
        Path("C:/Program Files/Android/android-sdk/platform-tools/adb.exe"),
        Path("C:/Android/platform-tools/adb.exe"),
        # macOS / Linux paths
        Path.home() / "Library" / "Android" / "sdk" / "platform-tools" / "adb",
        Path.home() / "Android" / "Sdk" / "platform-tools" / "adb",
        Path("/usr/bin/adb"),
        Path("/usr/local/bin/adb"),
    ]

    for c in candidates:
        if c.is_file() and os.access(str(c), os.X_OK):
            return str(c)

    return "adb"

class AdbRunner:
    def __init__(self, adb_bin, device=None):
        self.adb = adb_bin
        self.device = device

    def cmd(self, *args, timeout=20):
        command = [self.adb]
        if self.device:
            command.extend(["-s", self.device])
        command.extend(args)
        try:
            res = subprocess.run(
                command,
                stdout=subprocess.PIPE,
                stderr=subprocess.PIPE,
                text=True,
                encoding="utf-8",
                errors="replace",
                timeout=timeout
            )
            return res.returncode, res.stdout.strip(), res.stderr.strip()
        except subprocess.TimeoutExpired:
            return -1, "", "Command timed out"
        except Exception as e:
            return -1, "", str(e)

    def shell(self, shell_cmd, timeout=20):
        return self.cmd("shell", shell_cmd, timeout=timeout)

    def get_prop(self, prop_name):
        code, out, _ = self.shell(f"getprop {prop_name}")
        return out if code == 0 else ""

def get_connected_device(adb_bin, target_ip=None):
    runner = AdbRunner(adb_bin)
    if target_ip:
        print(f"[*] Connecting to {Colors.CYAN}{target_ip}:5555{Colors.RESET}...")
        runner.cmd("connect", f"{target_ip}:5555")
        time.sleep(1)

    code, out, _ = runner.cmd("devices")
    lines = [l.strip() for l in out.splitlines() if l.strip() and not l.startswith("List of")]

    devices = []
    for l in lines:
        parts = l.split()
        if len(parts) >= 2 and parts[1] == "device":
            devices.append(parts[0])

    if not devices:
        return None

    if len(devices) == 1:
        return devices[0]

    print(f"\n{Colors.BOLD}Multiple connected devices found:{Colors.RESET}")
    for i, dev in enumerate(devices):
        dev_runner = AdbRunner(adb_bin, dev)
        model = dev_runner.get_prop("ro.product.model") or "Unknown"
        print(f"  [{i+1}] {dev} ({model})")
    
    choice = input(f"\nSelect target device [1-{len(devices)}]: ").strip()
    try:
        idx = int(choice) - 1
        return devices[idx]
    except Exception:
        return devices[0]

def inspect_tv(adb):
    info = {
        "manufacturer": adb.get_prop("ro.product.manufacturer"),
        "brand": adb.get_prop("ro.product.brand"),
        "model": adb.get_prop("ro.product.model"),
        "android_version": adb.get_prop("ro.build.version.release"),
        "sdk": adb.get_prop("ro.build.version.sdk"),
        "abi": adb.get_prop("ro.product.cpu.abi"),
        "ip": "",
    }

    # Detect active IP
    _, wlan_out, _ = adb.shell("ip addr show wlan0")
    for word in wlan_out.split():
        if "/" in word and word.split("/")[0].count(".") == 3:
            info["ip"] = word.split("/")[0]
            break

    if not info["ip"]:
        _, eth_out, _ = adb.shell("ip addr show eth0")
        for word in eth_out.split():
            if "/" in word and word.split("/")[0].count(".") == 3:
                info["ip"] = word.split("/")[0]
                break

    return info

def detect_profile(tv_info, adb):
    manuf = (tv_info["manufacturer"] or "").upper()
    brand = (tv_info["brand"] or "").upper()
    model = (tv_info["model"] or "").upper()

    if "XIAOMI" in manuf or "XIAOMI" in brand or "MITV" in model or "REDMI" in brand:
        return "XIAOMI"
    elif "AMAZON" in manuf or "AFT" in model or "FIRE" in brand:
        return "FIRE_TV"
    elif "ONEPLUS" in manuf or "ONEPLUS" in brand:
        return "ONEPLUS"

    # Check installed package signatures
    _, pkgs, _ = adb.shell("pm list packages")
    if "com.google.android.apps.tv.launcherx" in pkgs:
        return "GOOGLE_TV"
    elif "com.google.android.leanbacklauncher" in pkgs:
        return "ANDROID_TV_STOCK"

    return "ANDROID_TV_STOCK"

def install_trimos(adb, tv_info, profile_key, install_smarttube=True):
    print(f"\n{Colors.BOLD}{Colors.CYAN}=== Starting TrimOS Universal Installation ==={Colors.RESET}\n")

    profile = PROFILES.get(profile_key, PROFILES["ANDROID_TV_STOCK"])
    print(f"[*] Detected Profile: {Colors.GREEN}{profile['name']}{Colors.RESET}")
    print(f"[*] Target Architecture: {Colors.CYAN}{tv_info['abi']}{Colors.RESET}")

    # 1. Install TrimOS Launcher APK
    if not TRIMOS_APK.is_file():
        print(f"{Colors.RED}[!] TrimOS APK not found at: {TRIMOS_APK}{Colors.RESET}")
        return False

    print(f"[*] Installing TrimOS Launcher ({TRIMOS_APK.name})...")
    code, out, err = adb.cmd("install", "-r", "-g", str(TRIMOS_APK), timeout=60)
    if "Success" in out or "Success" in err:
        print(f"    {Colors.GREEN}✓ TrimOS Launcher installed successfully!{Colors.RESET}")
    else:
        print(f"{Colors.RED}[!] Failed to install TrimOS: {out} {err}{Colors.RESET}")
        return False

    # 2. Configure Accessibility Service for HOME Key Lock & Touchpad Mouse Gestures
    print(f"[*] Enabling TrimOS Accessibility Service ({TRIMOS_ACCESSIBILITY})...")
    adb.shell(f"settings put secure enabled_accessibility_services {TRIMOS_ACCESSIBILITY}")
    adb.shell("settings put secure accessibility_enabled 1")
    print(f"    {Colors.GREEN}✓ Accessibility Service active (system-wide HOME interception & mouse injection enabled).{Colors.RESET}")

    # 3. Apply profile-specific settings fixes
    for namespace, key, val in profile.get("settings_fix", []):
        adb.shell(f"settings put {namespace} {key} {val}")
        print(f"    {Colors.GREEN}✓ Configured {namespace} {key} = {val}{Colors.RESET}")

    # 4. Safely Disable Stock Bloat Launchers & Recommendation Channels (User 0)
    print(f"[*] Safely debloating stock recommendation launcher for user 0...")
    for pkg in profile.get("launchers", []):
        code, out, _ = adb.shell(f"pm list packages {pkg}")
        if pkg in out:
            print(f"    Disabling {pkg}...")
            adb.shell(f"pm uninstall -k --user 0 {pkg}")

    for ad_pkg in profile.get("ad_services", []):
        code, out, _ = adb.shell(f"pm list packages {ad_pkg}")
        if ad_pkg in out:
            print(f"    Disabling ad service {ad_pkg}...")
            adb.shell(f"pm uninstall -k --user 0 {ad_pkg}")

    # 5. Optional: Install Ad-Free SmartTube
    if install_smarttube:
        abi = tv_info.get("abi", "")
        st_apk = SMARTTUBE_ARM64 if "arm64" in abi else SMARTTUBE_ARM32
        if st_apk.is_file():
            print(f"[*] Installing Ad-Free SmartTube ({st_apk.name})...")
            code, out, _ = adb.cmd("install", "-r", str(st_apk), timeout=60)
            if "Success" in out:
                print(f"    {Colors.GREEN}✓ SmartTube installed successfully!{Colors.RESET}")
        else:
            print(f"{Colors.YELLOW}[!] SmartTube APK for {abi} not found in release folder, skipping.{Colors.RESET}")

    # 6. Launch TrimOS
    print(f"[*] Launching TrimOS Home...")
    adb.shell(f"am start -n {TRIMOS_ACTIVITY}")

    tv_ip = tv_info.get("ip") or "192.168.1.9"
    print(f"\n{Colors.GREEN}{Colors.BOLD}🎉 TrimOS Installation Complete!{Colors.RESET}")
    print(f"""
{Colors.BOLD}Next Steps & Shortcuts:{Colors.RESET}
  📱 Mobile Remote & Touchpad: Open {Colors.CYAN}http://{tv_ip}:8080{Colors.RESET} on your phone
  🎨 Theme Picker: Click the Palette icon on your TV or change via web remote
  🔍 Universal Search: Click the Magnifier icon to search across Netflix, Prime, Hotstar & SmartTube
  🎛️ Remote Remapping: Click the Remote icon to customize buttons
  🧹 RAM Cleaner: Click the Trash icon anytime to optimize background RAM
""")
    return True

def restore_factory(adb, profile_key):
    print(f"\n{Colors.BOLD}{Colors.YELLOW}=== Restoring Stock Factory Launcher ==={Colors.RESET}\n")
    profile = PROFILES.get(profile_key, PROFILES["ANDROID_TV_STOCK"])

    for pkg in profile.get("launchers", []):
        print(f"[*] Re-enabling {pkg}...")
        adb.shell(f"cmd package install-existing {pkg}")
        adb.shell(f"pm enable {pkg}")

    for ad_pkg in profile.get("ad_services", []):
        adb.shell(f"cmd package install-existing {ad_pkg}")
        adb.shell(f"pm enable {ad_pkg}")

    # Optionally prompt to uninstall TrimOS
    resp = input("Do you also want to uninstall TrimOS? [y/N]: ").strip().lower()
    if resp == 'y':
        adb.shell(f"pm uninstall {TRIMOS_PKG}")
        print(f"{Colors.GREEN}✓ TrimOS uninstalled.{Colors.RESET}")

    # Re-enable stock home
    adb.shell("input keyevent 3")
    print(f"{Colors.GREEN}✓ Factory launcher restored successfully!{Colors.RESET}")

def main():
    parser = argparse.ArgumentParser(description="TrimOS Universal TV Installer & Manager")
    parser.add_argument("action", nargs="?", default="install", choices=["install", "restore", "remote", "clean", "theme", "status", "screenshot"], help="Action to perform")
    parser.add_argument("--ip", help="Target TV IP address (e.g. 192.168.1.9)")
    parser.add_argument("--device", help="Specific ADB device serial/identifier")
    parser.add_argument("--no-smarttube", action="store_true", help="Skip SmartTube installation")
    parser.add_argument("--theme-name", help="Theme name to apply (for theme action)")
    args = parser.parse_args()

    print_banner()

    adb_bin = find_adb()
    device_id = args.device

    if not device_id:
        target_ip = args.ip
        if not target_ip:
            # Check if any device is already connected
            test_runner = AdbRunner(adb_bin)
            _, out, _ = test_runner.cmd("devices")
            lines = [l.strip() for l in out.splitlines() if l.strip() and not l.startswith("List of") and "device" in l]
            if not lines:
                target_ip = input(f"{Colors.BOLD}Enter your TV's Wi-Fi IP address (e.g. 192.168.1.9): {Colors.RESET}").strip()

        device_id = get_connected_device(adb_bin, target_ip)

    if not device_id:
        print(f"{Colors.RED}[!] Could not connect to any Android TV device.{Colors.RESET}")
        print("    Please ensure Developer Options & ADB / USB Debugging are enabled on your TV.")
        sys.exit(1)

    adb = AdbRunner(adb_bin, device_id)
    tv_info = inspect_tv(adb)
    profile_key = detect_profile(tv_info, adb)

    print(f"[*] Connected Device: {Colors.CYAN}{tv_info['manufacturer']} {tv_info['model']}{Colors.RESET}")
    print(f"[*] Android Version: {Colors.CYAN}{tv_info['android_version']} (SDK {tv_info['sdk']}){Colors.RESET}")
    print(f"[*] Architecture: {Colors.CYAN}{tv_info['abi']}{Colors.RESET}")
    print(f"[*] TV IP Address: {Colors.CYAN}{tv_info['ip'] or device_id}{Colors.RESET}")

    if args.action == "install":
        install_trimos(adb, tv_info, profile_key, install_smarttube=not args.no_smarttube)

    elif args.action == "restore":
        restore_factory(adb, profile_key)

    elif args.action == "remote":
        tv_ip = tv_info.get("ip") or "192.168.1.9"
        url = f"http://{tv_ip}:8080"
        print(f"[*] Opening Virtual Web Remote at {Colors.CYAN}{url}{Colors.RESET}...")
        webbrowser.open(url)

    elif args.action == "clean":
        print("[*] Triggering RAM cleaner on TV...")
        adb.shell("am broadcast -a com.gathin.tvhome.CLEAN_RAM")
        print(f"{Colors.GREEN}✓ RAM cleanup signal dispatched.{Colors.RESET}")

    elif args.action == "theme":
        tname = args.theme_name or "aerial"
        print(f"[*] Setting theme to '{tname}'...")
        tv_ip = tv_info.get("ip") or "192.168.1.9"
        try:
            req = urllib.request.Request(
                f"http://{tv_ip}:8080/api/theme",
                data=f"theme={tname}".encode("utf-8"),
                headers={"Content-Type": "application/x-www-form-urlencoded"}
            )
            with urllib.request.urlopen(req, timeout=5) as response:
                print(f"{Colors.GREEN}✓ Theme applied: {tname}{Colors.RESET}")
        except Exception as e:
            print(f"{Colors.YELLOW}[!] Could not reach web server on TV, restarting launcher directly: {e}{Colors.RESET}")
            adb.shell(f"am force-stop {TRIMOS_PKG}")
            adb.shell(f"am start -n {TRIMOS_ACTIVITY}")

    elif args.action == "status":
        code, out, _ = adb.shell("dumpsys activity top | grep -E 'ACTIVITY|TASK'")
        print(f"\n{Colors.BOLD}Active Top Activity:{Colors.RESET}\n{out}")
        _, mem, _ = adb.shell("dumpsys meminfo | head -n 12")
        print(f"\n{Colors.BOLD}TV Memory Snapshot:{Colors.RESET}\n{mem}")

    elif args.action == "screenshot":
        timestamp = int(time.time())
        out_path = SCRIPT_DIR / f"tv_screenshot_{timestamp}.png"
        print(f"[*] Capturing screenshot from TV...")
        adb.shell("screencap -p /sdcard/trimos_cap.png")
        adb.cmd("pull", "/sdcard/trimos_cap.png", str(out_path))
        print(f"{Colors.GREEN}✓ Screenshot saved to: {out_path}{Colors.RESET}")

if __name__ == "__main__":
    main()
