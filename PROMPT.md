# 🤖 TrimOS Master AI Agent Prompt

> **Instructions for the User:**  
> Copy the entire prompt below and paste it into your AI coding assistant (such as **Google Antigravity**, **Claude Code**, **Cursor**, **Windsurf**, or any agent with terminal/ADB access).  
> Make sure your computer and your Android TV / Google TV are connected to the same Wi-Fi network with **Developer Options** and **USB/Network Debugging** enabled on the TV.

---

```markdown
You are an expert Android TV systems architect and senior mobile engineer acting as an autonomous AI agent.

Your mission is to completely transform my connected Android TV / Google TV into "TrimOS" — an ultra-clean, lightning-fast, ad-free operating environment inspired by Apple TV, featuring a virtual mouse trackpad with dragging, mobile sign-in, ad-free streaming, 32 themes, universal search, remote remapping, and RAM optimization.

Work directly on the connected hardware step-by-step. Verify every single step by capturing and inspecting screenshots from the TV using ADB (`screencap -p /sdcard/screen.png` and pulling it locally). Do not make assumptions — prove each step works visually.

---

### Phase 1: Hardware Discovery & Connection
1. Locate the Android TV on the local network (scan ARP table, check active ADB devices, or ask for the TV's IP address if not found).
2. Connect to the TV over ADB on port 5555:
   `adb connect <TV_IP>:5555`
3. Query and report hardware details:
   - Manufacturer (`ro.product.manufacturer`)
   - Device Model (`ro.product.model`)
   - Android Version (`ro.build.version.release`) & API Level (`ro.build.version.sdk`)
   - CPU Architecture (`ro.product.cpu.abi` — determine whether 32-bit `armeabi-v7a` or 64-bit `arm64-v8a`)
   - Current screen resolution, density, and memory usage (`dumpsys meminfo`)

---

### Phase 2: Safe Debloat & Stock Launcher Removal
1. Identify the active stock recommendation launcher based on the TV's manufacturer:
   - **Xiaomi / Redmi / Mi TV**: `com.mitv.tvhome.atv`, `com.mitv.tvhome.mitvplus`, `com.xiaomi.mitv.tvhome`, `com.mitv.recommend.channel`, `com.miui.systemAdSolution`. Disable auto-play ads (`settings put global set_auto_play 0`).
   - **Google TV / Chromecast**: `com.google.android.apps.tv.launcherx`, `com.google.android.tvrecommendations`.
   - **Android TV Stock (Sony, TCL, Hisense, Philips, Sharp)**: `com.google.android.leanbacklauncher`, `com.google.android.tvlauncher`.
   - **Amazon Fire TV**: `com.amazon.tv.launcher`, `com.amazon.device.sale.service`.
   - **OnePlus TV**: `com.oneplus.tv.launcher`, `com.oneplus.tv.epiclauncher` (OxygenPlay).
2. Safely debloat the recommendation launcher for User 0 using:
   `pm uninstall -k --user 0 <package_name>`
   *(Note: This keeps the system image intact so the stock launcher can be restored at any time without root).*
3. Verify that native TV system settings, input switchers (HDMI 1, HDMI 2, AV), and CEC power controls remain 100% operational.

---

### Phase 3: Permanent Launcher Protection Across Reboots
1. Install the TrimOS launcher APK (`com.gathin.tvhome`) with `-r -g` flags.
2. Implement a `BootReceiver` listening for `BOOT_COMPLETED`, `LOCKED_BOOT_COMPLETED`, and `QUICKBOOT_POWERON` to ensure TrimOS boots immediately upon startup.
3. Enable the `HomeKeyService` Accessibility Service:
   `settings put secure enabled_accessibility_services com.gathin.tvhome/.HomeKeyService`
   `settings put secure accessibility_enabled 1`
4. Intercept system-wide `KEYCODE_HOME` events to ensure OEM recommendation launchers never hijack the screen.
5. Verify with `pm resolve-activity -a android.intent.action.MAIN -c android.intent.category.HOME` that TrimOS is the sole registered default home activity.

---

### Phase 4: Apple TV Interface & Dynamic Personal Greetings
1. Apply a pure Apple TV-inspired UI layout:
   - Elevated glassmorphic dock cards with smooth focus animations.
   - Dynamic 4K NASA satellite aerial backdrops with animated orbital glow and real-time location credits.
   - Minimalist typography clock with system/12h/24h toggle.
2. Implement dynamic personalized greeting messages in `MainActivity`:
   - Randomly cycle through personalized family names each time the home screen is displayed:
     `"Good evening, Chirag Chanchal"`, `"Good evening, Kashish Chanchal"`, `"Good evening, Girish Narayan"`, and `"Good evening, Kamini Chanchal"`.
   - Adapt greetings dynamically based on local time (*Good morning*, *Good afternoon*, *Good evening*, *Good night*).

---

### Phase 5: 1-Click Background RAM Cleaner
1. Add a 1-click RAM cleaner button (`ic_clean.xml`) in the top navigation bar next to Settings.
2. Query `ActivityManager.getRunningAppProcesses()` and invoke `killBackgroundProcesses(pkg)` on non-essential cached background processes.
3. Compute total reclaimed memory before and after the cleanup.
4. Display a glassmorphic toast notification showing exact reclaimed memory:
   *"Cleaned X background apps · Y MB RAM freed"*.

---

### Phase 6: 32 Built-In Curated Themes (On-Device Switcher)
1. Bundle all 32 curated themes into the launcher's assets:
   - `aerial`, `minimal` (OLED Pure Black), `midnight-glass`, `aurora`, `cinematic`, `nature-calm`, `retro`, `diwali`, `dussehra`, `christmas`, `scenes`, etc.
2. Add a palette icon (`ic_palette.xml`) in the top navigation bar.
3. Build `ThemeManager.java`:
   - List available themes (filtering out `.md` and hidden files).
   - Unpack theme JSON configuration and high-resolution wallpapers into local storage upon selection.
   - Instantly reload the launcher with fluid crossfade transitions without crashing or rebooting.

---

### Phase 7: Universal Cross-App Streaming Search
1. Add a search icon (`ic_search.xml`) in the top navigation bar.
2. Build `UniversalSearchHelper.java` and `dialog_universal_search.xml`:
   - Integrated search query box with quick-filter genre chips (*Action, Comedy, Sci-Fi, Horror, Drama, Romance, Thriller, Animation*).
   - Deep-link search intent across:
     - SmartTube / YouTube (`vnd.youtube://results?search_query=...`)
     - Netflix (`https://www.netflix.com/search?q=...`)
     - Amazon Prime Video (`primevideo://search?phrase=...`)
     - Disney+ Hotstar (`hotstar://search?q=...`)
     - Android TV Global Search (`Intent.ACTION_SEARCH`)

---

### Phase 8: Remote Button Remapper
1. Add a remote control icon (`ic_remote.xml`) in the top navigation bar.
2. Build `RemoteRemapHelper.java`:
   - Support remapping for: Red Key (F1), Green Key (F2), Yellow Key (F3), Blue Key (F4), Menu Key, Long-Press Back, and Number Keys (1-3).
   - Assignable target actions: Clean RAM, Aerial Screensaver, Theme Switcher, Mobile QR Remote, Universal Search, SmartTube, Netflix, Prime Video, Hotstar, and Android TV Settings.
   - Intercept and execute remapped actions in `HomeKeyService.java` and `RemoteKeys.java`.

---

### Phase 9: Mobile Web Remote, Touchpad & QR Code Sign-In
1. Embed an asynchronous HTTP server (NanoHTTPD) running inside the launcher app on port `8080`.
2. Add a QR code icon (`ic_qr.xml`) in the top bar that generates and displays a high-contrast ZXing QR code on TV screen linking to `http://<TV_IP>:8080`.
3. Serve a responsive, dark-mode Apple TV remote web application on `http://<TV_IP>:8080`:
   - **Mobile Sign-In & Keyboard**: Input field where users type passwords, credentials, or URLs on their phone keyboard and tap *"Send to TV"*, automatically copying to the TV clipboard and pasting into active input fields.
   - **Virtual Mouse Touchpad**:
     - Fluid trackpad area supporting multi-touch swipes.
     - Directs a visible, floating blue mouse cursor overlay on the TV screen.
     - **Tap to Click**: Lightly tapping the trackpad dispatches a click event.
     - **Drag Mode**: Dedicated `🖐 Drag Mode: ON/OFF` toggle allowing users to click, hold, and drag cards, sliders, or UI elements across the TV.
     - **Scroll Buttons**: Instant *Scroll Up* and *Scroll Down* actions.
     - Dispatches touch gestures across Android TV system-wide using `AccessibilityService.dispatchGesture(GestureDescription, ...)`.
   - **Universal Search Bar**: Trigger TV streaming searches directly from your phone.
   - **Theme Selector**: Change TV themes remotely in real-time.
   - **Touch D-Pad & Controls**: Up, Down, Left, Right, OK, Back, Home, and Clean RAM.

---

### Phase 10: Ad-Free SmartTube Integration
1. Check the target TV CPU architecture (`ro.product.cpu.abi`):
   - For 32-bit ARM (`armeabi-v7a`): Download and install `SmartTube_stable_armeabi-v7a.apk`.
   - For 64-bit ARM (`arm64-v8a`): Download and install `SmartTube_stable_arm64-v8a.apk`.
2. Verify package `org.smarttube.stable` installs and launches with 4K playback and SponsorBlock enabled.
3. Add SmartTube as an integrated tile on the home dock and deep-link it into Universal Search.

---

### Phase 11: End-to-End Verification & Factory Reversibility
1. Capture screenshots of every screen:
   - Home screen with Apple TV dock and personalized greeting.
   - Mouse cursor moving on TV screen via mobile touchpad.
   - Ad-free SmartTube playing.
   - 32-theme picker dialog.
   - Universal search dialog.
   - Mobile sign-in QR dialog.
   - Remote button remapper dialog.
   - RAM cleaner toast with freed MB.
2. Test device reboot (`adb reboot`):
   - Verify that upon reboot, TrimOS launches automatically and permanently without showing OEM bloat.
3. Ensure 100% factory reversibility:
   - Provide a safe 1-click restore mechanism (`python trimos.py restore` or `cmd package install-existing <pkg>`) to re-enable factory stock launchers whenever needed.
```
