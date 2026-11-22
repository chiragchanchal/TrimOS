# 🍎 TrimOS

<div align="center">

![TrimOS Logo Banner](docs/screenshots/01_home_apple_tv.png)

### **סביבת הפעלה נקייה במיוחד וללא פרסומות עבור Android TV ו-Google TV**
*הפכו כל טלוויזיה חכמה איטית ורוויית פרסומות לחוויה מהירה כברק בהשראת Apple TV.*

[![רישיון: MIT](https://img.shields.io/badge/License-MIT-blue.svg)](LICENSE)
[![Android TV](https://img.shields.io/badge/Android%20TV-5.0%20%D7%A2%D7%93%2014+-brightgreen.svg)](https://android.com/tv)
[![ללא צורך ב-Root](https://img.shields.io/badge/Root-%D7%9C%D7%90%20%D7%A0%D7%93%D7%A8%D7%A9-success.svg)](#)
[![צריכת זיכרון RAM](https://img.shields.io/badge/%D7%A6%D7%A8%D7%99%D7%9B%D7%AA%20RAM-~22%20MB-purple.svg)](#)
[![ללא פרסומות](https://img.shields.io/badge/%D7%A4%D7%A8%D7%A1%D7%95%D7%9E%D7%95%D7%AA-0%25%20Bloatware-red.svg)](#)

[English](README.md) • [Deutsch](README.de.md) • [Español](README.es.md) • [Français](README.fr.md) • [Italiano](README.it.md) • [Português (Brasil)](README.pt-BR.md) • [Nederlands](README.nl.md) • [Türkçe](README.tr.md) • [Ελληνικά](README.el.md) • [עברית](README.he.md) • [Українська](README.uk.md) • [Oʻzbekcha](README.uz.md) • [Tiếng Việt](README.vi.md) • [日本語](README.ja.md) • [简体中文](README.zh-CN.md) • [繁體中文](README.zh-TW.md)

[תכונות](#-למה-trimos) • [תמונות מסך](#-גלריה-חזותית) • [התחלה מהירה](#-התחלה-מהירה) • [דגמים נתמכים](#-טלוויזיות-נתמכות-ופרופילים) • [שלט נייד](#-התחברות-מהנייד-ומשטח-מגע-וירטואלי) • [שחזור](#-בטיחות-ושחזור-בלחיצה-אחת)

</div>

---

## ⚡ למה TrimOS?

טלוויזיות חכמות כיום מוצפות בפרסומות וידאו במסך מלא, סרטונים שמתנגנים אוטומטית, שורות ממומנות ושירותי מעקב כבדים שגוזלים עד 80% מזיכרון ה-RAM המוגבל של הטלוויזיה שלכם.

**TrimOS** מחליפה לחלוטין את ממשקי היצרן הכבדים (Xiaomi PatchWall, המלצות Google TV, באנרים ב-Fire TV וכו') בסביבה מהירה וקלילה בהשראת Apple TV:

| תכונה | טלוויזיה מהמפעל | TrimOS |
| :--- | :---: | :---: |
| **פרסומות וסרטונים אוטומטיים** | ❌ מציפים בכל פינה | 🟢 **100% ללא פרסומות** |
| **צריכת זיכרון RAM** | ❌ 600 MB – 1.2 GB | 🟢 **~22 MB (קל משקל במיוחד)** |
| **זמני תגובה ואיטיות** | ❌ קטוע ומקרטע | 🟢 **ממשק מהיר וחלק ב-60fps** |
| **יוטיוב ללא פרסומות** | ❌ הפסקות פרסומת תכופות | 🟢 **SmartTube עם SponsorBlock** |
| **הקלדת סיסמאות** | ❌ מייגעת באמצעות השלט | 🟢 **סריקת קוד QR והקלדה מהנייד** |
| **עכבר וירטואלי / משטח מגע** | ❌ לא קיים | 🟢 **משטח מגע מלא עם תמיכה בגרירה** |
| **התאמת ערכות נושא** | ❌ מראה יצרן יחיד וקבוע | 🟢 **32 ערכות נושא מובנות** |
| **חיפוש תכנים אוניברסלי** | ❌ מוטה לטובת מפרסמים | 🟢 **חיפוש מאוחד בכל האפליקציות** |
| **מיפוי מקשי שלט** | ❌ מקשי חסויות נעולים | 🟢 **שלט הניתן להתאמה מלאה** |
| **דרישת Root** | ⚠️ מסוכן ומסובך | 🟢 **ללא Root (חיבור ADB בטוח)** |

---

## 📸 גלריה חזותית

### 1. ממשק בסגנון Apple TV וברכות אישיות
> מסך בית נקי עם צילומי לוויין אוויריים באיכות 4K מנאס"א, תנועת כרטיסים חלקה והודעות ברכה מתחלפות עבור בני המשפחה.
<div align="center">
  <img src="docs/screenshots/01_home_apple_tv.png" alt="מסך הבית של TrimOS Apple TV" width="92%" />
</div>

---

### 2. 📱 שלט נייד ומשטח מגע וירטואלי עם גרירה
> סרקו את קוד ה-QR או היכנסו מהנייד ברשת ה-Wi-Fi לכתובת `http://<tv-ip>:8080`. שלטו בסמן עכבר חלק, הקישו ללחיצה, החזיקו לגרירת כרטיסים והשתמשו במקשי גלילה ייעודיים.
<div align="center">
  <img src="docs/screenshots/02_virtual_mouse_touchpad.png" alt="עכבר וירטואלי של TrimOS" width="92%" />
</div>

---

### 3. 📺 שילוב SmartTube ללא פרסומות
> שילוב מוגדר מראש של SmartTube עם מנגנון SponsorBlock אוטומטי (דילוג על חסויות, פתיחים ותזכורות הרשמה) וניגון 4K חלק.
<div align="center">
  <img src="docs/screenshots/03_smarttube_adfree.png" alt="SmartTube בטלוויזיה" width="92%" />
</div>

---

### 4. 🎨 32 ערכות נושא מובנות (מעבר ישיר על המסך)
> מעבר מיידי בין 32 ערכות נושא ישירות מהטלוויזיה או מהטלפון: **Aerial**, **Minimal (שחור מוחלט ל-OLED)**, **Midnight Glass**, **זוהר הקוטב**, **קולנוע**, **רטרו שנות ה-80**, **חגים** ועוד.
<div align="center">
  <img src="docs/screenshots/04_theme_switcher.png" alt="בורר 32 ערכות נושא" width="92%" />
</div>

---

### 5. 🔍 חיפוש תכנים אוניברסלי
> חפשו בבת אחת ב-Netflix, SmartTube, Amazon Prime Video ו-Disney+ לפי כותר, שחקן או ז'אנר.
<div align="center">
  <img src="docs/screenshots/05_universal_search.png" alt="חיפוש אוניברסלי" width="92%" />
</div>

---

### 6. 📱 כניסה מהירה והקלדה באמצעות קוד QR
> אל תבזבזו זמן בהקלדת סיסמאות עם חיצי השלט. סרקו את קוד ה-QR והשתמשו במקלדת הטלפון או במנהל הסיסמאות להדבקת טקסט ישירות לטלוויזיה.
<div align="center">
  <img src="docs/screenshots/06_mobile_qr_signin.png" alt="התחברות באמצעות QR" width="92%" />
</div>

---

### 7. 🎛️ מיפוי מקשים לשלט הרחוק
> הגדירו מקשים צבעוניים (אדום/ירוק/צהוב/כחול), תפריט, חזור או מספרים להפעלת ניקוי זיכרון RAM, חיפוש מהיר, החלפת ערכות נושא או אפליקציות מועדפות.
<div align="center">
  <img src="docs/screenshots/07_remote_remapper.png" alt="מיפוי מקשים" width="92%" />
</div>

---

### 8. 🧹 ניקוי זיכרון RAM ומיטוב בלחיצה אחת
> פנו זיכרון RAM באופן מיידי בלחיצה בודדת. סוגר בבטחה תהליכי רקע שמורים במטמון ומציג את כמות הזיכרון ששוחררה.
<div align="center">
  <img src="docs/screenshots/09_ram_cleaner.png" alt="הודעת ניקוי RAM" width="92%" />
</div>

---

### 9. 🌌 שומר מסך אווירי בסגנון Apple TV
> שומר מסך דינמי עם צילומי אוויר של כדור הארץ מנאס"א ברזולוציה גבוהה, תאורה עדינה ושעון מעוצב.
<div align="center">
  <img src="docs/screenshots/10_aerial_screensaver.png" alt="שומר מסך אווירי" width="92%" />
</div>

---

## 🚀 התחלה מהירה

### דרישות מוקדמות
1. **הפעלת אפשרויות מפתח וניפוי שגיאות ADB בטלוויזיה**:
   - היכנסו ל**הגדרות** בטלוויזיה ← **העדפות מכשיר** ← **אודות**.
   - הקישו 7 פעמים על **מספר גרסת Build** עד לקבלת ההודעה *"כעת אתה מפתח!"*.
   - חזרו לתפריט **אפשרויות למפתחים** והפעילו את **ניפוי שגיאות ב-USB** ו**ניפוי שגיאות רשת / ADB**.
2. ודאו שהמחשב והטלוויזיה מחוברים לאותה רשת Wi-Fi.

---

### התקנה אוטומטית בלחיצה אחת (מומלץ)

שכפלו את המאגר והפעילו את כלי ההתקנה:

```bash
git clone https://github.com/chiragchanchal/TrimOS.git
cd TrimOS
```

#### במערכת Windows:
```powershell
python trimos.py install --ip <TV_IP_ADDRESS>
# או לחצו פעמיים על קובץ trimos.bat
```

#### במערכת macOS / Linux:
```bash
python3 trimos.py install --ip <TV_IP_ADDRESS>
```

*הכלי יזהה אוטומטית את יצרן הטלוויזיה, יתקין את אפליקציית TrimOS, יפעיל נעילת מקש בית קבועה, ישבית שירותי פרסום בבטחה ויתקין גרסת SmartTube התואמת למעבד שלכם.*

---

### התקנה ידנית (ללא צורך ב-Python)

אם כלי ה-`adb` כבר מותקן במחשבכם:

```bash
# 1. התחברות לטלוויזיה
adb connect <TV_IP_ADDRESS>:5555

# 2. התקנת TrimOS
adb install -r -g release/TrimOS-v1.0.apk

# 3. הפעלת שירות נגישות למקש הבית ומשטח המגע
adb shell settings put secure enabled_accessibility_services com.gathin.tvhome/.HomeKeyService
adb shell settings put secure accessibility_enabled 1

# 4. (אופציונלי) התקנת SmartTube
# עבור טלוויזיות 32 סיביות (Mi TV 4A/4C, FireStick וכו'):
adb install -r release/SmartTube-v32.71-armeabi-v7a.apk
# עבור טלוויזיות 64 סיביות (Shield TV, דגמי Google TV חדישים):
adb install -r release/SmartTube-v32.71-arm64-v8a.apk

# 5. הפעלת TrimOS
adb shell am start -n com.gathin.tvhome/.MainActivity
```

---

## 📺 טלוויזיות נתמכות ופרופילים

TrimOS כוללת פרופילים מותאמים אישית לניהול חבילות התוכנה של מותגי הטלוויזיות המובילים:

| מותג / פלטפורמה | מכשירים שנבדקו | מה TrimOS מנקה ומייעלת |
| :--- | :--- | :--- |
| **Xiaomi / Redmi** | Mi TV 4A, 4C, 5X, סדרה X, Horizon, Redmi TV | משביתה את PatchWall, סרטוני פרסומת וערוצי המלצות. שומרת על חיבורי HDMI ו-CEC תקינים. |
| **Google TV** | Chromecast Google TV (HD/4K), Sony Bravia, TCL | מכבה את באנרי המודעות ב-`launcherx`. תכונות Google Cast ו-Play Store נשארות פעילות. |
| **Android TV רגיל** | Sony Bravia, TCL, Hisense, Philips, Sharp, Skyworth | מחליפה את ממשק Leanback האיטי. תפריטי תמונה וקול נשארים זמינים במלואם. |
| **Amazon Fire TV** | Fire TV Stick 4K / Max, Fire TV Cube, סדרת Omni | עוקפת את דף הבית העמוס בפרסומות של Fire OS ומצמידה את מקש הבית ל-TrimOS. |
| **OnePlus TV** | OnePlus TV Q1, U1S, Y1S | מסירה את יישומי OxygenPlay ושירותי ההמלצות ברקע. |
| **מזרימי מדיה שונים** | Nvidia Shield TV, Mecool, Dynalink, Formuler, X96 | חוויה חלקה ב-60fps עם צריכת זיכרון מינימלית. |

---

## 📱 התחברות מהנייד ומשטח מגע וירטואלי

כל טלוויזיה עם TrimOS כוללת שרת אינטרנט מקומי מהיר שאינו תלוי בענן ונגיש מכל מכשיר ברשת הביתית:

1. לחצו על **סמל ה-QR** בסרגל העליון במסך (או פתחו את הכתובת `http://<tv-ip>:8080` בדפדפן הנייד).
2. **משטח מגע וירטואלי**:
   - **החלקת אצבע**: תנועת סמן מדויקת על גבי הטלוויזיה.
   - **הקשה**: קליק.
   - **מצב גרירה**: הפעילו **Drag Mode: ON** לגרירת פריטים.
   - **מקשי גלילה**: מעבר נוח מעלה ומטה.
3. **הקלדה מהנייד**:
   - הקלידו סיסמאות או קישורים בטלפון ולחצו על **"Send to TV Keyboard / Clipboard"**.
4. **מחליף ערכות נושא מהיר**:
   - שנו את ערכת הנושא ישירות מהתפריט הנפתח בנייד.

---

## 🛡️ בטיחות ושחזור בלחיצה אחת

TrimOS פועלת באופן **בטוח וניתן לשחזור מלא**:
- השבתת היישומים מתבצעת בעזרת `pm uninstall -k --user 0 <package>`, שמסירה אותם רק עבור המשתמש הפעיל מבלי לגעת בקבצי המערכת הצרובים.
- שום קובץ מערכת אינו נמחק ולא נדרשת גישת Root.

לחזרה לממשק היצרן המקורי בכל עת:

```bash
python trimos.py restore --ip <TV_IP_ADDRESS>
```

פקודה זו תחזיר מיד את ממשק ברירת המחדל (PatchWall, Google TV וכו').

---

## 🛠️ פקודות CLI וכלים שימושיים

הכלי `trimos.py` מספק מגוון פקודות שימושיות לניהול הטלוויזיה:

```bash
# בדיקת מצב חיבור, יישום פעיל וצריכת זיכרון RAM
python trimos.py status --ip 192.168.1.9

# ביצוע ניקוי זיכרון RAM מרחוק
python trimos.py clean --ip 192.168.1.9

# החלפת ערכת נושא מרחוק
python trimos.py theme --theme-name aurora --ip 192.168.1.9

# צילום מסך מהטלוויזיה והורדתו למחשב
python trimos.py screenshot --ip 192.168.1.9

# פתיחת השלט הווירטואלי בדפדפן המחשב
python trimos.py remote --ip 192.168.1.9
```

---

## 📁 מבנה הפרויקט

```
TrimOS/
├── release/                      # קובצי APK מוכנים להתקנה
│   ├── TrimOS-v1.0.apk           # קובץ APK מהודר של TrimOS Launcher
│   ├── SmartTube-v32.71-armeabi-v7a.apk  # SmartTube ללא פרסומות ב-32 סיביות
│   └── SmartTube-v32.71-arm64-v8a.apk    # SmartTube ללא פרסומות ב-64 סיביות
├── docs/
│   └── screenshots/              # תמונות מסך אותנטיות שנלקחו מטלוויזיות
├── launcher/                     # קוד המקור המלא ב-Android Studio
│   └── app/src/main/
│       ├── java/com/gathin/tvhome/
│       │   ├── MainActivity.java         # ממשק בסגנון Apple TV ומנוע פוקוס
│       │   ├── HomeKeyService.java       # שירות נגישות לנעילת מקש הבית
│       │   ├── BootReceiver.java         # הפעלה אוטומטית בהדלקה
│       │   ├── MouseController.java      # סמן עכבר צף ומנוע גרירה
│       │   ├── TvHttpServer.java         # שרת שלט מקומי והזנת טקסט
│       │   ├── ThemeManager.java         # מנהל 32 ערכות הנושא
│       │   ├── UniversalSearchHelper.java# חיפוש תכנים מאוחד
│       │   ├── RemoteRemapHelper.java    # מודול מיפוי מקשי שלט
│       │   └── QrCodeHelper.java         # מחולל קוד QR מובנה
│       └── assets/themes/                # 32 ערכות נושא וטפטים מובנים
├── trimos.py                     # כלי התקנה וניהול אוניברסלי
├── trimos.bat                    # הפעלה בלחיצה אחת ב-Windows
├── trimos.sh                     # הפעלה ב-Linux / macOS
├── LICENSE                       # רישיון MIT
└── README.md                     # תיעוד ראשי באנגלית
```

---

## 📜 רישיון

פרויקט זה מופץ תחת תנאי **רישיון MIT** – ראו את הקובץ [LICENSE](LICENSE) לפרטים נוספים.

---

<div align="center">
  <b>נבנה במטרה להעניק חוויית צפייה מהירה, נקייה ונטולת פרסומות לחלוטין.</b><br>
  <sub>אם TrimOS שיפרה את הטלוויזיה שלכם, נשמח לכוכב ⭐️ ב-GitHub!</sub>
</div>
