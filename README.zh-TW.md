# 🍎 TrimOS

<div align="center">

![TrimOS Logo Banner](docs/screenshots/01_home_apple_tv.png)

### **專為 Android TV 與 Google TV 打造的極致純淨、零廣告作業系統環境**
*將任何卡頓、廣告泛濫的智慧電視轉變為如 Apple TV 般絲滑極速的頂級體驗。*

[![開源授權: MIT](https://img.shields.io/badge/License-MIT-blue.svg)](LICENSE)
[![Android TV](https://img.shields.io/badge/Android%20TV-5.0%20%E8%87%B3%2014+-brightgreen.svg)](https://android.com/tv)
[![無需 Root](https://img.shields.io/badge/Root-%E7%84%A1%E9%9C%80%20Root-success.svg)](#)
[![超低記憶體佔用](https://img.shields.io/badge/%E8%A8%98%E6%86%B6%E9%AB%94%E4%BD%94%E7%94%A8-~22%20MB-purple.svg)](#)
[![零廣告體驗](https://img.shields.io/badge/%E5%BB%A3%E5%91%8A-0%25%20%E9%99%84%E5%B8%B6-red.svg)](#)

[English](README.md) • [Deutsch](README.de.md) • [Español](README.es.md) • [Français](README.fr.md) • [Italiano](README.it.md) • [Português (Brasil)](README.pt-BR.md) • [Nederlands](README.nl.md) • [Türkçe](README.tr.md) • [Ελληνικά](README.el.md) • [עברית](README.he.md) • [Українська](README.uk.md) • [Oʻzbekcha](README.uz.md) • [Tiếng Việt](README.vi.md) • [日本語](README.ja.md) • [简体中文](README.zh-CN.md) • [繁體中文](README.zh-TW.md)

[核心特色](#-為什麼選擇-trimos) • [實機展示](#-介面實拍展示) • [快速開始](#-快速開始) • [支援電視型號](#-支援的電視與廠商設定檔) • [手機遙控器](#-手機觸控板遙控--快速掃碼輸入) • [安全還原](#-安全保障--一鍵還原出廠)

</div>

---

## ⚡ 為什麼選擇 TrimOS？

現今的智慧電視普遍充斥著全螢幕開機影音廣告、無法關閉的自動播放預告、贊助推廣欄位以及背景高頻率資料蒐集服務，佔用了電視本就有限的系統記憶體（RAM）高達 80%。

**TrimOS** 完全取代電視原廠笨重的系統桌面（小米電視 PatchWall、Google TV 推廣卡片、Fire TV 贊助橫幅等），為您帶來極簡、流暢且受 Apple TV 設計啟發的純淨體驗：

| 功能特色 | 原廠智慧電視 | TrimOS |
| :--- | :---: | :---: |
| **影音廣告與自動播放** | ❌ 無所不在，強烈干擾 | 🟢 **100% 純淨無廣告** |
| **系統記憶體（RAM）消耗** | ❌ 600 MB – 1.2 GB | 🟢 **約 22 MB（極致輕量）** |
| **開機與選單按鍵延遲** | ❌ 頓挫延遲，反應緩慢 | 🟢 **穩定 60fps 絲滑流暢** |
| **免廣告 YouTube / 影視** | ❌ 頻繁穿插 30 秒廣告 | 🟢 **整合 SmartTube 與 SponsorBlock** |
| **遙控器輸入密碼** | ❌ 依賴方向鍵痛苦費時 | 🟢 **手機掃碼直接輸入與貼上** |
| **虛擬滑鼠 / 觸控板** | ❌ 無原生支援 | 🟢 **支援拖曳的流暢手機觸控板** |
| **主題個人化** | ❌ 僅限原廠單一固定桌布 | 🟢 **內建 32 款精緻主題** |
| **串流影視全平台跨搜** | ❌ 僅限商業推廣合作內容 | 🟢 **主流串流影音整合跨搜** |
| **遙控器按鍵自訂** | ❌ 贊助商專用按鍵鎖定 | 🟢 **支援遙控器按鍵自由重映射** |
| **是否需要 Root 權限** | ⚠️ 有變磚風險且複雜 | 🟢 **無需 Root（安全 ADB 協定）** |

---

## 📸 介面實拍展示

### 1. Apple TV 極簡風格主螢幕與動態家庭問候
> 高畫質 4K NASA 衛星空拍動態背景，搭配細緻卡片微動效與專屬家庭成員動態問候語。
<div align="center">
  <img src="docs/screenshots/01_home_apple_tv.png" alt="TrimOS Apple TV 主螢幕" width="92%" />
</div>

---

### 2. 📱 手機虛擬觸控板與卡片拖曳
> 掃描螢幕 QR Code 或直接在區域網路內以手機瀏覽器開啟 `http://<電視IP>:8080`。如實體滑鼠般順暢移動游標、輕觸點擊、長按拖曳卡片或進度條，並可使用專屬捲動按鈕。
<div align="center">
  <img src="docs/screenshots/02_virtual_mouse_touchpad.png" alt="TrimOS 手機虛擬滑鼠" width="92%" />
</div>

---

### 3. 📺 深度整合無廣告 SmartTube
> 內建 SmartTube 4K 高畫質播放支援，配備 SponsorBlock 自動略過片頭、廣告贊助及訂閱宣傳。
<div align="center">
  <img src="docs/screenshots/03_smarttube_adfree.png" alt="電視端 SmartTube" width="92%" />
</div>

---

### 4. 🎨 內建 32 款精選主題（隨時在螢幕切換）
> 在電視或手機上秒切 32 款主題：**Aerial（空拍）**、**極簡 OLED 純黑**、**Midnight Glass（午夜琉璃）**、**極光**、**經典劇院**、**80 年代蒸氣波**、**節慶主題** 等。
<div align="center">
  <img src="docs/screenshots/04_theme_switcher.png" alt="32款主題切換器" width="92%" />
</div>

---

### 5. 🔍 串流影視全平台跨應用搜尋
> 一鍵同時搜尋 Netflix、SmartTube、Amazon Prime Video 及 Disney+ 的片名、演員或劇集。
<div align="center">
  <img src="docs/screenshots/05_universal_search.png" alt="串流影視跨應用搜尋" width="92%" />
</div>

---

### 6. 📱 手機掃碼直連與快速鍵入
> 告別遙控器逐字敲密碼的痛苦體驗。掃描螢幕 QR Code，直接使用手機鍵盤或密碼管理工具將長密碼、複雜網址一鍵傳送至電視剪貼簿。
<div align="center">
  <img src="docs/screenshots/06_mobile_qr_signin.png" alt="手機掃碼輸入" width="92%" />
</div>

---

### 7. 🎛️ 遙控器按鍵重映射工具
> 將電視遙控器上的色彩鍵（紅/綠/黃/藍）、選單鍵、返回鍵或數字鍵自由對應為：一鍵記憶體清理、全域搜尋、主題切換或常用 App 直達。
<div align="center">
  <img src="docs/screenshots/07_remote_remapper.png" alt="按鍵重映射工具" width="92%" />
</div>

---

### 8. 🧹 一鍵清理記憶體與極速優化
> 輕輕一按立即釋放系統記憶體。安全終止背景快取行程，螢幕即時顯示已釋放的記憶體容量（MB）。
<div align="center">
  <img src="docs/screenshots/09_ram_cleaner.png" alt="記憶體清理提示" width="92%" />
</div>

---

### 9. 🌌 Apple TV 風格空拍動態螢幕保護程式
> 壯麗的 NASA 4K 地球空拍桌布、柔和光暈呼吸效果與高質感極簡時鐘螢幕保護程式。
<div align="center">
  <img src="docs/screenshots/10_aerial_screensaver.png" alt="空拍動態螢幕保護程式" width="92%" />
</div>

---

## 🚀 快速開始

### 行前準備
1. **在電視上開啟開發人員選項與 ADB 偵錯**：
   - 開啟電視 **設定** → **裝置偏好設定** → **關於**。
   - 連續點擊 **版本號碼（Build Number）** 7 次，直到螢幕顯示 *「您現在已是開發人員！」*。
   - 返回 **開發人員選項**，啟用 **USB 偵錯** 以及 **網路 / ADB 偵錯**。
2. 確認電腦與電視連線至同一個 Wi-Fi 區域網路。

---

### 一鍵全自動安裝（強烈建議）

複製專案並執行通用安裝指令稿：

```bash
git clone https://github.com/chiragchanchal/TrimOS.git
cd TrimOS
```

#### Windows 使用者：
```powershell
python trimos.py install --ip <你的電視IP>
# 或者直接點兩下執行 trimos.bat
```

#### macOS / Linux 使用者：
```bash
python3 trimos.py install --ip <你的電視IP>
```

*安裝工具會自動辨識電視品牌、安裝 TrimOS 應用程式、鎖定 Home 主畫面鍵、安全停用原廠推播廣告，並依硬體架構自動安裝相應的免廣告 SmartTube。*

---

### 手動安裝（無須 Python 環境）

若電腦中已有 `adb` 工具：

```bash
# 1. 連線至電視
adb connect <你的電視IP>:5555

# 2. 安裝 TrimOS 主程式
adb install -r -g release/TrimOS-v1.0.apk

# 3. 啟用主畫面鍵攔截與觸控板無障礙協助工具服務
adb shell settings put secure enabled_accessibility_services com.gathin.tvhome/.HomeKeyService
adb shell settings put secure accessibility_enabled 1

# 4.（選填）安裝 SmartTube
# 適用於 32 位元電視（小米電視 4A/4C、FireStick 等）：
adb install -r release/SmartTube-v32.71-armeabi-v7a.apk
# 適用於 64 位元電視（Nvidia Shield、新款 Google TV 等）：
adb install -r release/SmartTube-v32.71-arm64-v8a.apk

# 5. 啟動 TrimOS
adb shell am start -n com.gathin.tvhome/.MainActivity
```

---

## 📺 支援的電視與廠商設定檔

TrimOS 內建專為各主要電視品牌量身打造的調校設定檔：

| 品牌 / 系統 | 實機測試裝置 | TrimOS 優化與清理項目 |
| :--- | :--- | :--- |
| **小米 / Redmi** | 小米電視 4A, 4C, 5X, X系列, Horizon, Redmi 電視 | 停用 PatchWall 桌面、影音橫幅廣告與推薦頻道，完整保留 HDMI 輸入埠與 CEC 聯動。 |
| **Google TV** | Chromecast with Google TV, Sony Bravia, TCL | 關閉 `launcherx` 廣告列及贊助列，Google Cast 與 Play 商店維持正常運作。 |
| **標準原生 Android TV** | Sony Bravia, TCL, 海信 Hisense, 飛利浦, 夏普 | 替換反應遲緩的原廠 Leanback 桌面，電視原生畫質與音效設定選單完好如初。 |
| **亞馬遜 Fire TV** | Fire TV Stick 4K / Max, Fire TV Cube, Omni 系列 | 繞過 Fire OS 繁複的商品廣告主頁，將 Home 鍵直接鎖定為 TrimOS。 |
| **OnePlus TV** | OnePlus TV Q1, U1S, Y1S | 清理 OxygenPlay 內建推廣服務與背景推送程序。 |
| **通用智慧電視盒** | Nvidia Shield TV, Mecool, Dynalink, Formuler, X96 | 極低記憶體開銷下實現穩定 60 幀純淨體驗。 |

---

## 📱 手機觸控板遙控 & 快速掃碼輸入

安裝 TrimOS 的電視均具備低延遲本機微型 Web 伺服器，無須連線外部雲端：

1. 點擊電視頂端工作列的 **QR Code 圖示**（或在手機瀏覽器輸入 `http://<電視IP>:8080`）。
2. **手機虛擬觸控板**：
   - **手指滑動**：在電視螢幕上平滑引導滑鼠游標。
   - **輕觸**：點選確認。
   - **拖曳切換**：開啟 **Drag Mode: ON** 可長按拖曳卡片及調整進度。
   - **捲動鍵**：便捷上下捲動長列表頁面。
3. **手機秒傳文字**：
   - 在手機輸入長密碼或貼上超長網址，點擊 **"Send to TV Keyboard / Clipboard"** 即可秒傳上螢幕。
4. **即時切換主題**：
   - 在手機下拉選單中直接選擇切換電視的主題外觀。

---

## 🛡️ 安全保障 & 一鍵還原出廠

TrimOS **絕對安全且完全可逆**：
- 系統精簡僅透過標準 Android 指令 `pm uninstall -k --user 0 <套件名稱>` 執行，僅針對當前使用者空間隱藏停用，絕不更動系統底層唯讀韌體分割區。
- 絕不刪除任何核心系統檔案，且完全無須 Root 權限。

隨時可一鍵無損還原回電視原廠桌面：

```bash
python trimos.py restore --ip <你的電視IP>
```

原廠桌面（PatchWall、Google TV 等）將立即復原，所有偏好設定絲毫不受影響。

---

## 🛠️ CLI 常用管理指令

隨附的 `trimos.py` 指令稿提供完整的電視維護指令：

```bash
# 查看電視連線狀態、前景執行應用程式及目前記憶體佔用
python trimos.py status --ip 192.168.1.9

# 遠端觸發電視記憶體快速釋放清理
python trimos.py clean --ip 192.168.1.9

# 遠端更換電視桌面主題
python trimos.py theme --theme-name aurora --ip 192.168.1.9

# 將電視目前畫面擷圖並清晰儲存至電腦
python trimos.py screenshot --ip 192.168.1.9

# 在電腦瀏覽器中開啟 Web 遙控面板
python trimos.py remote --ip 192.168.1.9
```

---

## 📁 專案目錄結構

```
TrimOS/
├── release/                      # 即開即用的預先編譯安裝套件
│   ├── TrimOS-v1.0.apk           # 預先編譯 TrimOS 桌面安裝套件
│   ├── SmartTube-v32.71-armeabi-v7a.apk  # 32位元無廣告版 SmartTube
│   └── SmartTube-v32.71-arm64-v8a.apk    # 64位元無廣告版 SmartTube
├── docs/
│   └── screenshots/              # 真實電視實拍介面高解析度擷圖
├── launcher/                     # 完整的 Android Studio 原始碼專案
│   └── app/src/main/
│       ├── java/com/gathin/tvhome/
│       │   ├── MainActivity.java         # Apple TV 風格核心互動與焦點引擎
│       │   ├── HomeKeyService.java       # 主畫面鍵攔截與協助工具手勢引擎
│       │   ├── BootReceiver.java         # 開機自動啟動與保活監聽
│       │   ├── MouseController.java      # 虛擬游標平滑控制與拖曳引擎
│       │   ├── TvHttpServer.java         # 本機 Web 遙控與文字輸入伺服器
│       │   ├── ThemeManager.java         # 32 套內建主題資源管理員
│       │   ├── UniversalSearchHelper.java# 全平台串流影視整合搜尋模組
│       │   ├── RemoteRemapHelper.java    # 遙控器按鍵自訂管理員
│       │   └── QrCodeHelper.java         # QR Code 快速產生工具
│       └── assets/themes/                # 32 套內建主題樣式與桌布
├── trimos.py                     # 跨平台一鍵部署與管理工具
├── trimos.bat                    # Windows 一鍵執行啟動批次檔
├── trimos.sh                     # Linux / macOS 啟動指令稿
├── LICENSE                       # MIT 開源授權
└── README.md                     # 英文原版主說明文件
```

---

## 📜 開源協議

本專案基於 **MIT 授權條款** 開放原始碼 – 詳情請參閱 [LICENSE](LICENSE) 檔案。

---

<div align="center">
  <b>專注於更純粹、更迅捷、無廣告的客廳大螢幕觀影體驗。</b><br>
  <sub>如果 TrimOS 讓您的電視重獲新生，歡迎在 GitHub 上點亮一顆 ⭐️！</sub>
</div>
