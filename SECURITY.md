# Security Policy

TrimOS interacts with TVs over ADB and provides a replacement launcher environment. Please report any potential vulnerabilities privately so they can be addressed promptly.

## How to report

Use GitHub's private vulnerability reporting:
1. Open the [TrimOS Security tab](https://github.com/chiragchanchal/TrimOS/security).
2. Click **Report a vulnerability**.

Please include:
- The component affected (the installer, a tool in `tools/`, the launcher APK, or a device profile).
- Step-by-step instructions to reproduce the issue.
- Potential impact and threat scenario.

## What counts

- **Launcher Security:** The launcher (`com.gathin.tvhome`) exposing private data, unauthenticated endpoints on the local web remote, or unintended privilege escalation.
- **Tools & Scripts:** Installer tools (`trimos.py`, `tools/tv.py`, `disable.ps1`) mishandling network inputs or executing arbitrary unauthorized commands.
- **Device Protection:** Any debloat profile that causes irreversible bricking without recovery.

ADB network debugging is powerful by design. Always disable network/wireless debugging after setup completes.
