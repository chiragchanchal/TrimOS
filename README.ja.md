# 🍎 TrimOS

<div align="center">

![TrimOS Logo Banner](docs/screenshots/01_home_apple_tv.png)

### **Android TV & Google TV 向け 超軽量・完全広告フリー オペレーティング環境**
*もっさりして広告だらけのスマートTVを、Apple TV着想の電光石火の快適環境へと生まれ変わらせます。*

[![ライセンス: MIT](https://img.shields.io/badge/License-MIT-blue.svg)](LICENSE)
[![Android TV](https://img.shields.io/badge/Android%20TV-5.0%20%E3%80%9C%2014+-brightgreen.svg)](https://android.com/tv)
[![Root化不要](https://img.shields.io/badge/Root-%E4%B8%8D%E8%A6%81-success.svg)](#)
[![RAMフットプリント](https://img.shields.io/badge/RAM%E4%BD%BF%E7%94%A8%E9%87%8F-~22%20MB-purple.svg)](#)
[![広告ゼロ](https://img.shields.io/badge/%E5%BA%83%E5%91%8A-0%25%20%E4%B8%8D%E8%A6%81%E3%82%A2%E3%83%97%E3%83%AA-red.svg)](#)

[English](README.md) • [Deutsch](README.de.md) • [Español](README.es.md) • [Français](README.fr.md) • [Italiano](README.it.md) • [Português (Brasil)](README.pt-BR.md) • [Nederlands](README.nl.md) • [Türkçe](README.tr.md) • [Ελληνικά](README.el.md) • [עברית](README.he.md) • [Українська](README.uk.md) • [Oʻzbekcha](README.uz.md) • [Tiếng Việt](README.vi.md) • [日本語](README.ja.md) • [简体中文](README.zh-CN.md) • [繁體中文](README.zh-TW.md)

[特徴](#-なぜtrimosなのか) • [スクリーンショット](#-ビジュアル紹介) • [クイックスタート](#-クイックスタート) • [対応テレビ一覧](#-対応テレビ--プロファイル) • [スマホリモコン](#-スマホ文字入力--バーチャルタッチパッド) • [復元方法](#-安全性--1クリック簡単復元)

</div>

---

## ⚡ なぜTrimOSなのか？

現在のスマートTVは、全画面での動画広告、強制的な自動再生トレーラー、スポンサー枠、そしてテレビの貴重なRAMの最大80%を占有する追跡サービスに悩まされています。

**TrimOS** は、各メーカーの不要なプリインストールアプリや重いホーム画面（Xiaomi PatchWall、Google TV の広告カルーセル、Fire TV のスポンサー広告など）を、Apple TVに着想を得た高速で洗練された環境へと完全に置き換えます：

| 機能 | 出荷時スマートTV | TrimOS |
| :--- | :---: | :---: |
| **広告・自動再生ビデオ** | ❌ どこにでも常時表示 | 🟢 **100% 広告ゼロ** |
| **RAM消費量** | ❌ 600 MB 〜 1.2 GB | 🟢 **約22 MB（極限の軽さ）** |
| **起動・操作のカクつき** | ❌ もたつきと遅延 | 🟢 **滑らかな 60fps UI** |
| **広告なしYouTube** | ❌ 30秒の広告が頻発 | 🟢 **SponsorBlock搭載 SmartTube** |
| **パスワードの入力** | ❌ リモコンの十字キーで苦痛 | 🟢 **QRを読み取りスマホから直接入力** |
| **バーチャルマウス / タッチパッド** | ❌ 非搭載 | 🟢 **ドラッグ＆ドロップ対応トラックパッド** |
| **テーマのカスタマイズ** | ❌ メーカー固定の1種類 | 🟢 **32種類の内蔵テーマ** |
| **動画配信横断検索** | ❌ 提携先優先の検索結果 | 🟢 **複数配信アプリの一括検索** |
| **リモコンキーの割り当て** | ❌ 固定された広告ボタン | 🟢 **自由に変更可能なリモコン設定** |
| **Root化の必要性** | ⚠️ 危険で複雑 | 🟢 **Root不要（安全なADB制御）** |

---

## 📸 ビジュアル紹介

### 1. Apple TV風インターフェース & パーソナルグリーティング
> NASAの高解像度4K衛星空撮映像を背景に、滑らかにアニメーションするカードデザインと、家族それぞれの名前に対応した動的な挨拶メッセージを表示。
<div align="center">
  <img src="docs/screenshots/01_home_apple_tv.png" alt="TrimOS Apple TV ホーム画面" width="92%" />
</div>

---

### 2. 📱 スマホリモコン & ドラッグ対応バーチャルタッチパッド
> QRコードを読み取るか、同一Wi-Fi内のスマホで `http://<tv-ip>:8080` を開きます。画面上のマウスポインターを滑らかに動かし、タップで決定、長押しでカードをドラッグ＆ドロップ、専用スクロールボタンも使用可能。
<div align="center">
  <img src="docs/screenshots/02_virtual_mouse_touchpad.png" alt="TrimOS バーチャルマウス" width="92%" />
</div>

---

### 3. 📺 広告フリー SmartTube 連携
> スポンサー告知やイントロ、チャンネル登録の呼びかけを自動でスキップする SponsorBlock を備えた SmartTube と連携し、高画質4K動画を快適に再生。
<div align="center">
  <img src="docs/screenshots/03_smarttube_adfree.png" alt="テレビでのSmartTube" width="92%" />
</div>

---

### 4. 🎨 32種類の内蔵テーマ（画面上で即座に切替）
> テレビ画面またはスマホから32種類のデザインを瞬時に切り替え可能：**Aerial**、**Minimal（OLED完全ブラック）**、**Midnight Glass**、**オーロラ**、**シネマ**、**80年代シンセウェーブ**、**祝祭テーマ**など多数。
<div align="center">
  <img src="docs/screenshots/04_theme_switcher.png" alt="32テーマ切り替え画面" width="92%" />
</div>

---

### 5. 🔍 動画配信サービス横断検索
> Netflix、SmartTube、Amazon Prime Video、Disney+ から、作品名・俳優名・ジャンルで一度にまとめて検索。
<div align="center">
  <img src="docs/screenshots/05_universal_search.png" alt="横断検索画面" width="92%" />
</div>

---

### 6. 📱 QRコード読み取り＆スマホからの文字入力
> テレビのリモコンでパスワードを入力するストレスから解放されます。QRコードをスキャンし、スマホのキーボードやパスワード管理アプリから直接テレビのクリップボードへ貼り付けられます。
<div align="center">
  <img src="docs/screenshots/06_mobile_qr_signin.png" alt="QRコードでのスマホログイン" width="92%" />
</div>

---

### 7. 🎛️ リモコンボタン再割り当て（リマッパー）
> カラーボタン（赤/青/黄/緑）やメニューボタン、数字ボタンに、RAMクリーナー、横断検索、テーマ切り替え、お気に入りアプリの即時起動を割り当て可能。
<div align="center">
  <img src="docs/screenshots/07_remote_remapper.png" alt="リモコンリマッパー" width="92%" />
</div>

---

### 8. 🧹 1クリック RAMクリーナー＆最適化
> ワンクリックでテレビの空きメモリを即座に確保。キャッシュされた不要なバックグラウンドプロセスを安全に終了し、解放されたメモリ量を画面に通知します。
<div align="center">
  <img src="docs/screenshots/09_ram_cleaner.png" alt="RAMクリーナー通知" width="92%" />
</div>

---

### 9. 🌌 Apple TV風 空撮スクリーンセーバー
> NASAによる超高解像度の地球の衛星空撮映像に、柔らかな光のグロー効果と美しいタイポグラフィ時計を組み合わせたスクリーンセーバー。
<div align="center">
  <img src="docs/screenshots/10_aerial_screensaver.png" alt="空撮スクリーンセーバー" width="92%" />
</div>

---

## 🚀 クイックスタート

### 事前準備
1. **テレビで「開発者向けオプション」と「ADBデバッグ」を有効化**:
   - テレビの **設定** → **デバイス設定** → **端末情報** を開きます。
   - *"これでデベロッパーになりました！"* と表示されるまで、**ビルド番号** を連続で7回押します。
   - **開発者向けオプション** に戻り、**USBデバッグ** と **ネットワーク / ADBデバッグ** をオンにします。
2. パソコンとテレビが同じWi-Fiネットワークに接続されていることを確認します。

---

### 1クリック自動インストール（推奨）

リポジトリを取得し、自動インストールスクリプトを実行します：

```bash
git clone https://github.com/chiragchanchal/TrimOS.git
cd TrimOS
```

#### Windowsの場合:
```powershell
python trimos.py install --ip <テレビのIPアドレス>
# または trimos.bat をダブルクリック
```

#### macOS / Linuxの場合:
```bash
python3 trimos.py install --ip <テレビのIPアドレス>
```

*インストーラーがテレビのメーカーを自動判別し、TrimOSアプリの導入、ホームボタンの常時固定、広告アプリの安全な停止、プロセッサに適した広告なしSmartTubeのインストールを一括して行います。*

---

### 手動インストール（Python不要）

お使いのPCにすでに `adb` が設定されている場合：

```bash
# 1. テレビに接続
adb connect <テレビのIPアドレス>:5555

# 2. TrimOSのインストール
adb install -r -g release/TrimOS-v1.0.apk

# 3. ホームボタン制御とタッチパッドのユーザー補助サービスを有効化
adb shell settings put secure enabled_accessibility_services com.gathin.tvhome/.HomeKeyService
adb shell settings put secure accessibility_enabled 1

# 4. (任意) SmartTubeのインストール
# 32bitテレビ向け (Mi TV 4A/4C, Fire TV Stick など):
adb install -r release/SmartTube-v32.71-armeabi-v7a.apk
# 64bitテレビ向け (Shield TV, 新型Google TV など):
adb install -r release/SmartTube-v32.71-arm64-v8a.apk

# 5. TrimOSを起動
adb shell am start -n com.gathin.tvhome/.MainActivity
```

---

## 📺 対応テレビ & プロファイル

TrimOSは、主要各社のテレビに合わせた専用プロファイルを内蔵しています：

| ブランド / プラットフォーム | 実機検証済み機種 | TrimOSがクリーンアップ・最適化する内容 |
| :--- | :--- | :--- |
| **Xiaomi / Redmi** | Mi TV 4A, 4C, 5X, Xシリーズ, Horizon, Redmi TV | PatchWall、動画広告バナー、推薦チャンネルを無効化。HDMI入力やCEC連動は正常に維持。 |
| **Google TV** | Chromecast with Google TV (HD/4K), Sony Bravia, TCL | `launcherx` の広告枠やスポンサー列を停止。Google CastやPlayストアは完全に保持。 |
| **標準 Android TV** | Sony Bravia, TCL, Hisense, Philips, Sharp, Skyworth | 重いLeanbackホーム画面を置換。画質・音質設定メニューはそのまま利用可能。 |
| **Amazon Fire TV** | Fire TV Stick 4K / Max, Fire TV Cube, Omni シリーズ | 広告過多なFire OSのホームを迂回し、ホームボタンを直接TrimOSに割り当て。 |
| **OnePlus TV** | OnePlus TV Q1, U1S, Y1S | OxygenPlayおよびバックグラウンドの推薦サービスを安全に除去。 |
| **汎用TVボックス** | Nvidia Shield TV, Mecool, Dynalink, Formuler, X96 | 最小限のメモリ消費で極めて快適な60fpsの操作感を実現。 |

---

## 📱 スマホ文字入力 & バーチャルタッチパッド

TrimOSを導入したテレビには、クラウド不要の軽量ローカルWebサーバーが稼働します：

1. テレビ画面上部の **QRアイコン** を選択（またはスマホのブラウザで `http://<tv-ip>:8080` を開く）。
2. **バーチャルタッチパッド**:
   - **指でスワイプ**: テレビ上のマウスカーソルをスムーズに操作。
   - **タップ**: 選択・クリック。
   - **ドラッグモード**: **Drag Mode: ON** に切り替えてアイテムをドラッグ＆ドロップ。
   - **スクロールボタン**: 上下メニューを素早く移動。
3. **スマホ文字入力**:
   - 長いパスワードやURLをスマホで入力し、**"Send to TV Keyboard / Clipboard"** を押すとテレビに即座に反映。
4. **テーマのクイック変更**:
   - スマホのドロップダウンメニューからテレビのデザインを瞬時に切り替え。

---

## 🛡️ 安全性 & 1クリック簡単復元

TrimOSは **100%安全で完全に元に戻せます**:
- 不要なアプリの停止は `pm uninstall -k --user 0 <パッケージ名>` を通じて実行されるため、現在のユーザー空間のみで無効化され、テレビ本体の初期ファームウェアは改変されません。
- システムの重要ファイルは一切削除されず、Root化も行いません。

いつでも元の工場出荷時ホーム画面に戻すことができます：

```bash
python trimos.py restore --ip <テレビのIPアドレス>
```

このコマンドを実行すると、工場出荷時の純正ホーム（PatchWallやGoogle TVなど）が即座に再有効化されます。

---

## 🛠️ CLIコマンド＆便利ツール

付属の `trimos.py` ツールでテレビの各種メンテナンスが行えます：

```bash
# 接続状態、実行中のアプリ、RAM使用量を確認
python trimos.py status --ip 192.168.1.9

# リモートからRAMのクリーンアップを実行
python trimos.py clean --ip 192.168.1.9

# リモートからテーマを変更
python trimos.py theme --theme-name aurora --ip 192.168.1.9

# テレビ画面のスクリーンショットをPCに保存
python trimos.py screenshot --ip 192.168.1.9

# パソコンのブラウザでWebリモコン画面を開く
python trimos.py remote --ip 192.168.1.9
```

---

## 📁 リポジトリ構成

```
TrimOS/
├── release/                      # すぐにインストールできる完成済みAPK
│   ├── TrimOS-v1.0.apk           # ビルド済みのTrimOSランチャーAPK
│   ├── SmartTube-v32.71-armeabi-v7a.apk  # 32bit用 広告なしSmartTube
│   └── SmartTube-v32.71-arm64-v8a.apk    # 64bit用 広告なしSmartTube
├── docs/
│   └── screenshots/              # 実機テレビで撮影した高解像度画面写真
├── launcher/                     # Android Studio プロジェクトソースコード一式
│   └── app/src/main/
│       ├── java/com/gathin/tvhome/
│       │   ├── MainActivity.java         # Apple TV風UI・フォーカスエンジン
│       │   ├── HomeKeyService.java       # ホームボタン固定のユーザー補助サービス
│       │   ├── BootReceiver.java         # テレビ起動時の自動起動制御
│       │   ├── MouseController.java      # 画面上のマウスカーソル＆ドラッグ制御
│       │   ├── TvHttpServer.java         # ローカルWebリモコン＆入力サーバー
│       │   ├── ThemeManager.java         # 32種類のテーマ管理
│       │   ├── UniversalSearchHelper.java# 動画配信サービス横断検索
│       │   ├── RemoteRemapHelper.java    # リモコンキー再割り当て管理
│       │   └── QrCodeHelper.java         # QRコード生成機能
│       └── assets/themes/                # 32種類の内蔵テーマ＆壁紙
├── trimos.py                     # 総合インストーラー＆CLI管理ツール
├── trimos.bat                    # Windows用 1クリック起動バッチ
├── trimos.sh                     # Linux / macOS用 起動スクリプト
├── LICENSE                       # MITライセンス
└── README.md                     # メインの英語ドキュメント
```

---

## 📜 ライセンス

本プロジェクトは **MITライセンス** のもとで公開されています。詳細は [LICENSE](LICENSE) ファイルをご確認ください。

---

<div align="center">
  <b>より速く、美しく、広告のない快適なテレビライフのために。</b><br>
  <sub>TrimOSがお役に立ちましたら、ぜひGitHubで ⭐️ をお願いします！</sub>
</div>
