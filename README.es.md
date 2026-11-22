# 🍎 TrimOS

<div align="center">

![TrimOS Logo Banner](docs/screenshots/01_home_apple_tv.png)

### **El entorno operativo ultra limpio y sin anuncios para Android TV y Google TV**
*Transforma cualquier televisor lento y plagado de publicidad en una experiencia ultrarrápida inspirada en Apple TV.*

[![Licencia: MIT](https://img.shields.io/badge/Licencia-MIT-blue.svg)](LICENSE)
[![Android TV](https://img.shields.io/badge/Android%20TV-5.0%20a%2014+-brightgreen.svg)](https://android.com/tv)
[![No requiere Root](https://img.shields.io/badge/Root-NO%20requerido-success.svg)](#)
[![Consumo de RAM](https://img.shields.io/badge/Consumo%20RAM-~22%20MB-purple.svg)](#)
[![Sin anuncios](https://img.shields.io/badge/Publicidad-0%25%20Bloatware-red.svg)](#)

[English](README.md) • [Deutsch](README.de.md) • [Español](README.es.md) • [Français](README.fr.md) • [Italiano](README.it.md) • [Português (Brasil)](README.pt-BR.md) • [Nederlands](README.nl.md) • [Türkçe](README.tr.md) • [Ελληνικά](README.el.md) • [עברית](README.he.md) • [Українська](README.uk.md) • [Oʻzbekcha](README.uz.md) • [Tiếng Việt](README.vi.md) • [日本語](README.ja.md) • [简体中文](README.zh-CN.md) • [繁體中文](README.zh-TW.md)

[Características](#-por-qu%C3%A9-trimos) • [Capturas](#-galer%C3%ADa-visual) • [Inicio Rápido](#-inicio-r%C3%A1pido) • [Televisores Soportados](#-televisores-compatibles-y-perfiles) • [Mando Móvil](#-inicio-de-sesi%C3%B3n-m%C3%B3vil-y-mando-t%C3%A1ctil) • [Restauración](#-%EF%B8%8F-seguridad-y-restauraci%C3%B3n-en-1-clic)

</div>

---

## ⚡ ¿Por qué TrimOS?

Los televisores inteligentes actuales sufren de invasivos anuncios en vídeo a pantalla completa, reproducción automática obligatoria, carruseles patrocinados y telemetría que consume hasta el 80% de la limitada memoria RAM de su dispositivo.

**TrimOS** reemplaza por completo el bloatware del fabricante (Xiaomi PatchWall, recomendaciones de Google TV, anuncios de Fire TV, etc.) por un entorno fluido, de alto rendimiento y libre de distracciones inspirado en Apple TV:

| Característica | Smart TV de Fábrica | TrimOS |
| :--- | :---: | :---: |
| **Anuncios y Vídeos Automáticos** | ❌ Invasivos en todas partes | 🟢 **100% Sin Publicidad** |
| **Consumo de Memoria RAM** | ❌ 600 MB – 1.2 GB | 🟢 **~22 MB (Ultraligero)** |
| **Fluidez y Navegación** | ❌ Lento y con tirones | 🟢 **60 fps completamente fluidos** |
| **YouTube sin Anuncios** | ❌ Anuncios constantes de 30s | 🟢 **SmartTube con SponsorBlock** |
| **Escribir Contraseñas** | ❌ Difícil con el mando a distancia | 🟢 **Escanea el QR y escribe desde el móvil** |
| **Ratón Virtual / Touchpad** | ❌ Inexistente | 🟢 **Trackpad completo con arrastre** |
| **Personalización de Temas** | ❌ 1 diseño fijo del fabricante | 🟢 **32 Temas integrados** |
| **Búsqueda Universal de Streaming** | ❌ Búsqueda sesgada del fabricante | 🟢 **Búsqueda unificada entre plataformas** |
| **Reasignación de Botones** | ❌ Botones promocionales bloqueados | 🟢 **Mando totalmente reasignable** |
| **Requiere Root** | ⚠️ Peligroso y complejo | 🟢 **Sin Root (ADB 100% seguro)** |

---

## 📸 Galería Visual

### 1. Interfaz Estilo Apple TV y Saludos Personalizados
> Pantalla de inicio limpia con fondos aéreos en 4K vía satélite de la NASA, elevación suave de tarjetas y mensajes de bienvenida dinámicos para los miembros de la familia.
<div align="center">
  <img src="docs/screenshots/01_home_apple_tv.png" alt="Pantalla de inicio TrimOS Apple TV" width="92%" />
</div>

---

### 2. 📱 Mando Móvil y Touchpad Virtual con Arrastre
> Abre el código QR o entra a `http://<ip-del-tv>:8080` desde cualquier smartphone en tu red Wi-Fi. Controla un cursor flotante suave, pulsa para hacer clic, mantén presionado para arrastrar elementos y usa controles de desplazamiento dedicados.
<div align="center">
  <img src="docs/screenshots/02_virtual_mouse_touchpad.png" alt="Ratón virtual TrimOS" width="92%" />
</div>

---

### 3. 📺 Integración con SmartTube Sin Anuncios
> Integración preconfigurada de SmartTube con SponsorBlock automático (omite patrocinios, intros e interrupciones) y reproducción fluida en 4K.
<div align="center">
  <img src="docs/screenshots/03_smarttube_adfree.png" alt="SmartTube en TV" width="92%" />
</div>

---

### 4. 🎨 32 Temas Integrados (Selector en el Dispositivo)
> Cambia instantáneamente entre 32 temas directamente en tu TV o desde el móvil: **Aerial**, **Minimal (OLED Negro Puro)**, **Midnight Glass**, **Aurora Boreal**, **Teatro Cinemático**, **Retro Synthwave años 80**, **Festividades** y más.
<div align="center">
  <img src="docs/screenshots/04_theme_switcher.png" alt="Selector de 32 temas" width="92%" />
</div>

---

### 5. 🔍 Búsqueda Universal en Streaming
> Busca de una sola vez en Netflix, SmartTube, Amazon Prime Video y Disney+ por título, actor o género.
<div align="center">
  <img src="docs/screenshots/05_universal_search.png" alt="Búsqueda Universal" width="92%" />
</div>

---

### 6. 📱 Código QR e Inicio de Sesión Móvil
> Nunca más vuelvas a teclear contraseñas letra por letra con el mando. Escanea el código QR y utiliza el teclado o gestor de contraseñas de tu teléfono para enviarlo al portapapeles del televisor.
<div align="center">
  <img src="docs/screenshots/06_mobile_qr_signin.png" alt="Inicio de sesión por QR" width="92%" />
</div>

---

### 7. 🎛️ Reasignador de Botones del Mando
> Reasigna botones de colores (Rojo/Verde/Amarillo/Azul), Menú, Atrás o números para abrir el Optimizador de RAM, la Búsqueda Universal, el Selector de Temas o tus aplicaciones favoritas.
<div align="center">
  <img src="docs/screenshots/07_remote_remapper.png" alt="Reasignador de botones" width="92%" />
</div>

---

### 8. 🧹 Limpiador de RAM y Optimización en 1 Clic
> Libera memoria RAM al instante con un solo toque. Cierra de forma segura procesos en caché de segundo plano y muestra los megabytes recuperados.
<div align="center">
  <img src="docs/screenshots/09_ram_cleaner.png" alt="Limpiador de RAM" width="92%" />
</div>

---

### 9. 🌌 Salvapantallas Aéreo Estilo Apple TV
> Salvapantallas dinámico con tomas aéreas satelitales en alta resolución de la NASA, brillo ambiental animado y un elegante reloj tipográfico.
<div align="center">
  <img src="docs/screenshots/10_aerial_screensaver.png" alt="Salvapantallas Aéreo" width="92%" />
</div>

---

## 🚀 Inicio Rápido

### Requisitos Previos
1. **Activar Opciones de Desarrollador y Depuración ADB en el televisor**:
   - Vaya a **Ajustes** del TV → **Preferencias del dispositivo** → **Información**.
   - Pulse sobre **Compilación** 7 veces hasta ver *"¡Ya eres desarrollador!"*.
   - Vuelva a **Opciones de desarrollador** y active **Depuración USB** y **Depuración de red / ADB**.
2. Asegúrese de que su ordenador y el televisor estén conectados a la misma red Wi-Fi.

---

### Instalación Automática en 1 Clic (Recomendado)

Clone el repositorio y ejecute el instalador universal:

```bash
git clone https://github.com/chiragchanchal/TrimOS.git
cd TrimOS
```

#### En Windows:
```powershell
python trimos.py install --ip <IP_DE_SU_TELEVISOR>
# o simplemente haga doble clic en trimos.bat
```

#### En macOS / Linux:
```bash
python3 trimos.py install --ip <IP_DE_SU_TELEVISOR>
```

*El instalador detectará automáticamente el fabricante de su televisor, instalará la aplicación TrimOS, habilitará la protección permanente del botón de inicio, desactivará la publicidad del sistema de forma segura e instalará SmartTube sin anuncios adaptado a la arquitectura de su procesador.*

---

### Instalación Manual (Sin necesidad de Python)

Si ya tiene `adb` instalado en su equipo:

```bash
# 1. Conectar al televisor
adb connect <IP_DE_SU_TELEVISOR>:5555

# 2. Instalar TrimOS
adb install -r -g release/TrimOS-v1.0.apk

# 3. Habilitar servicio de accesibilidad para botón Home y Touchpad
adb shell settings put secure enabled_accessibility_services com.gathin.tvhome/.HomeKeyService
adb shell settings put secure accessibility_enabled 1

# 4. (Opcional) Instalar SmartTube
# Para televisores de 32 bits (Mi TV 4A/4C, FireStick, etc.):
adb install -r release/SmartTube-v32.71-armeabi-v7a.apk
# Para televisores de 64 bits (Shield TV, Google TV modernos):
adb install -r release/SmartTube-v32.71-arm64-v8a.apk

# 5. Iniciar TrimOS
adb shell am start -n com.gathin.tvhome/.MainActivity
```

---

## 📺 Televisores Compatibles y Perfiles

TrimOS incluye perfiles específicos para los paquetes de software de las principales marcas del mercado:

| Marca / Plataforma | Dispositivos Probados | Qué limpia y optimiza TrimOS |
| :--- | :--- | :--- |
| **Xiaomi / Redmi** | Mi TV 4A, 4C, 5X, X-Series, Horizon, Redmi TV | Deshabilita el launcher PatchWall, banners de vídeo y canales promocionales. Mantiene entradas HDMI y CEC intactos. |
| **Google TV** | Chromecast con Google TV (HD/4K), Sony Bravia, TCL | Desactiva los carruseles de anuncios en `launcherx` y filas patrocinadas. Conserva Google Cast y Play Store. |
| **Android TV Stock** | Sony Bravia, TCL, Hisense, Philips, Sharp, Skyworth | Reemplaza el launcher Leanback. Los controles de imagen y sonido se mantienen plenamente funcionales. |
| **Amazon Fire TV** | Fire TV Stick 4K / Max, Fire TV Cube, Omni Series | Omite la interfaz cargada de anuncios de Fire OS y fija el botón de inicio en TrimOS. |
| **OnePlus TV** | OnePlus TV Q1, U1S, Y1S | Elimina OxygenPlay y servicios de recomendación en segundo plano. |
| **Dispositivos Genéricos** | Nvidia Shield TV, Mecool, Dynalink, Formuler, X96 | Experiencia nativa a 60 fps con mínimo consumo de RAM. |

---

## 📱 Inicio de Sesión Móvil y Mando Táctil

Cada televisor con TrimOS cuenta con un panel web local sin dependencia de la nube en su red doméstica:

1. Pulse en el **icono de código QR** en la barra superior del TV (o abra `http://<ip-del-tv>:8080` en el navegador del móvil).
2. **Touchpad Virtual**:
   - **Mover dedo**: Desplaza con suavidad el puntero en la pantalla.
   - **Tocar**: Clic.
   - **Modo Arrastre**: Active **Drag Mode: ON** para arrastrar elementos.
   - **Botones de Desplazamiento**: Subir y bajar rápidamente en menús.
3. **Inicio de Sesión Móvil**:
   - Escriba credenciales en el teléfono y pulse **"Send to TV Keyboard / Clipboard"**.
4. **Selector Instantáneo de Temas**:
   - Cambie de tema directamente desde el menú desplegable en el móvil.

---

## 🛡️ Seguridad y Restauración en 1 Clic

TrimOS es **100% no destructivo**:
- La desactivación de apps se efectúa con `pm uninstall -k --user 0 <paquete>`, retirándolas solo del espacio de usuario activo mientras la partición del sistema permanece intacta.
- No se borran archivos esenciales del sistema ni se requiere Root.

Para volver al launcher original de fábrica en cualquier momento:

```bash
python trimos.py restore --ip <IP_DE_SU_TELEVISOR>
```

Esto reactivará de inmediato su launcher de fábrica (PatchWall, Google TV, etc.) sin perder ninguna configuración.

---

## 🛠️ Comandos CLI y Utilidades

El comando `trimos.py` es una navaja suiza de gestión para su televisor:

```bash
# Comprobar estado de conexión, actividad en pantalla y RAM
python trimos.py status --ip 192.168.1.9

# Ejecutar limpieza de RAM de forma remota
python trimos.py clean --ip 192.168.1.9

# Cambiar de tema remotamente
python trimos.py theme --theme-name aurora --ip 192.168.1.9

# Tomar una captura de pantalla del TV al PC
python trimos.py screenshot --ip 192.168.1.9

# Abrir el mando web en el navegador del ordenador
python trimos.py remote --ip 192.168.1.9
```

---

## 📁 Estructura del Repositorio

```
TrimOS/
├── release/                      # Paquetes APK listos para instalar
│   ├── TrimOS-v1.0.apk           # APK compilado del Launcher TrimOS
│   ├── SmartTube-v32.71-armeabi-v7a.apk  # SmartTube 32 bits sin anuncios
│   └── SmartTube-v32.71-arm64-v8a.apk    # SmartTube 64 bits sin anuncios
├── docs/
│   └── screenshots/              # Capturas reales tomadas en el televisor
├── launcher/                     # Código fuente completo de Android Studio
│   └── app/src/main/
│       ├── java/com/gathin/tvhome/
│       │   ├── MainActivity.java         # Interfaz de usuario estilo Apple TV
│       │   ├── HomeKeyService.java       # Servicio de accesibilidad y botón Home
│       │   ├── BootReceiver.java         # Receptor para persistencia tras reinicio
│       │   ├── MouseController.java      # Puntero de ratón flotante y arrastre
│       │   ├── TvHttpServer.java         # Servidor web local de mando y teclado
│       │   ├── ThemeManager.java         # Administrador de los 32 temas
│       │   ├── UniversalSearchHelper.java# Buscador universal entre apps
│       │   ├── RemoteRemapHelper.java    # Reasignación de teclas de control
│       │   └── QrCodeHelper.java         # Generador de códigos QR
│       └── assets/themes/                # 32 temas y fondos integrados
├── trimos.py                     # Instalador y herramienta CLI universal
├── trimos.bat                    # Acceso directo para Windows en 1 clic
├── trimos.sh                     # Acceso directo para Linux / macOS
├── LICENSE                       # Licencia MIT
└── README.md                     # Documentación principal en inglés
```

---

## 📜 Licencia

Este proyecto está bajo la **Licencia MIT** – consulte el archivo [LICENSE](LICENSE) para más información.

---

<div align="center">
  <b>Diseñado para ofrecer una experiencia en televisión más rápida, limpia y sin anuncios.</b><br>
  <sub>¿TrimOS mejoró tu televisor? ¡Deja una ⭐️ en GitHub!</sub>
</div>
