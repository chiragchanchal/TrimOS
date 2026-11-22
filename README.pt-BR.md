# 🍎 TrimOS

<div align="center">

![TrimOS Logo Banner](docs/screenshots/01_home_apple_tv.png)

### **O ambiente operacional ultra limpo e sem anúncios para Android TV e Google TV**
*Transforme qualquer Smart TV lenta e repleta de anúncios em uma experiência ultrarrápida inspirada na Apple TV.*

[![Licença: MIT](https://img.shields.io/badge/License-MIT-blue.svg)](LICENSE)
[![Android TV](https://img.shields.io/badge/Android%20TV-5.0%20a%2014+-brightgreen.svg)](https://android.com/tv)
[![Sem Root Necessário](https://img.shields.io/badge/Root-N%C3%83O%20Necess%C3%A1rio-success.svg)](#)
[![Uso de RAM](https://img.shields.io/badge/Uso%20de%20RAM-~22%20MB-purple.svg)](#)
[![Sem Anúncios](https://img.shields.io/badge/An%C3%BAncios-0%25%20Bloatware-red.svg)](#)

[English](README.md) • [Deutsch](README.de.md) • [Español](README.es.md) • [Français](README.fr.md) • [Italiano](README.it.md) • [Português (Brasil)](README.pt-BR.md) • [Nederlands](README.nl.md) • [Türkçe](README.tr.md) • [Ελληνικά](README.el.md) • [עברית](README.he.md) • [Українська](README.uk.md) • [Oʻzbekcha](README.uz.md) • [Tiếng Việt](README.vi.md) • [日本語](README.ja.md) • [简体中文](README.zh-CN.md) • [繁體中文](README.zh-TW.md)

[Recursos](#-por-que-o-trimos) • [Capturas](#-mostra-visual) • [Início Rápido](#-in%C3%ADcio-r%C3%A1pido) • [TVs Suportadas](#-tvs-compat%C3%ADveis-e-perfis) • [Controle pelo Celular](#-login-pelo-celular-e-touchpad-remoto) • [Restauração](#-%EF%B8%8F-seguran%C3%A7a-e-restaura%C3%A7%C3%A3o-em-1-clique)

</div>

---

## ⚡ Por que o TrimOS?

As TVs inteligentes modernas são sobrecarregadas por anúncios invasivos em tela cheia, reprodução automática de trailers, carrosséis patrocinados e telemetria pesada que consome até 80% da memória RAM disponível.

O **TrimOS** substitui integralmente os aplicativos e telas pesadas de fábrica (Xiaomi PatchWall, recomendações do Google TV, barras patrocinadas do Fire TV, etc.) por um ambiente de altíssimo desempenho, fluido e sem distrações, inspirado no design da Apple TV:

| Recurso | Smart TV de Fábrica | TrimOS |
| :--- | :---: | :---: |
| **Anúncios e Vídeos em Reprodução Automática** | ❌ Invasivos em toda a interface | 🟢 **100% Livre de Anúncios** |
| **Consumo de Memória RAM** | ❌ 600 MB – 1.2 GB | 🟢 **~22 MB (Extremamente leve)** |
| **Fluidez de Navegação** | ❌ Lenta e travando | 🟢 **Interface fluida a 60 fps** |
| **YouTube Sem Anúncios** | ❌ Anúncios frequentes de 30s | 🟢 **SmartTube com SponsorBlock** |
| **Digitação de Senhas** | ❌ Lenta pelo controle remoto | 🟢 **Escaneie o QR e digite no celular** |
| **Mouse Virtual / Touchpad** | ❌ Não possui | 🟢 **Trackpad completo com arrastar e soltar** |
| **Personalização de Temas** | ❌ 1 tema fixo do fabricante | 🟢 **32 Temas integrados** |
| **Busca Universal de Streaming** | ❌ Focada em parceiros comerciais | 🟢 **Busca unificada entre plataformas** |
| **Remapeamento de Teclas** | ❌ Botões promocionais bloqueados | 🟢 **Controle 100% remapeável** |
| **Necessita de Root** | ⚠️ Complexo e arriscado | 🟢 **Sem Root (ADB 100% seguro)** |

---

## 📸 Mostra Visual

### 1. Interface Estilo Apple TV e Saudações Personalizadas
> Tela inicial limpa com imagens aéreas de satélite em 4K da NASA, elevação dinâmica de ícones e saudações que se alternam para cada membro da família.
<div align="center">
  <img src="docs/screenshots/01_home_apple_tv.png" alt="Tela inicial TrimOS Apple TV" width="92%" />
</div>

---

### 2. 📱 Controle Móvel e Touchpad Virtual com Arrastar
> Abra o código QR ou acesse `http://<ip-da-tv>:8080` de qualquer smartphone na mesma rede Wi-Fi. Movimente o cursor do mouse na tela, toque para clicar, mantenha pressionado para arrastar itens e use os controles de rolagem.
<div align="center">
  <img src="docs/screenshots/02_virtual_mouse_touchpad.png" alt="Mouse virtual TrimOS" width="92%" />
</div>

---

### 3. 📺 Integração com SmartTube Sem Anúncios
> SmartTube integrado com suporte nativo ao SponsorBlock (pula anúncios, introduções e pedidos de inscrição) e reprodução estável em 4K.
<div align="center">
  <img src="docs/screenshots/03_smarttube_adfree.png" alt="SmartTube na TV" width="92%" />
</div>

---

### 4. 🎨 32 Temas Integrados (Seletor Direto na TV)
> Alterne instantaneamente entre 32 temas no televisor ou celular: **Aerial**, **Minimal (Preto Puro OLED)**, **Midnight Glass**, **Aurora Boreal**, **Cinema**, **Retro Anos 80**, **Temas Festivos** e muito mais.
<div align="center">
  <img src="docs/screenshots/04_theme_switcher.png" alt="Seletor de 32 temas" width="92%" />
</div>

---

### 5. 🔍 Busca Universal em Streaming
> Pesquise de uma única vez na Netflix, SmartTube, Amazon Prime Video e Disney+ por título, ator ou gênero.
<div align="center">
  <img src="docs/screenshots/05_universal_search.png" alt="Busca Universal" width="92%" />
</div>

---

### 6. 📱 Código QR e Login pelo Celular
> Chega de sofrer para digitar senhas complexas letra por letra no controle. Escaneie o código QR e use o teclado ou gerenciador de senhas do seu celular para colar direto na TV.
<div align="center">
  <img src="docs/screenshots/06_mobile_qr_signin.png" alt="Login por QR no celular" width="92%" />
</div>

---

### 7. 🎛️ Remapeador de Botões do Controle Remoto
> Redefina botões coloridos (Vermelho/Verde/Amarelo/Azul), Menu, Voltar ou números para acionar a Limpeza de RAM, a Busca Universal, a Troca de Temas ou seus apps de streaming favoritos.
<div align="center">
  <img src="docs/screenshots/07_remote_remapper.png" alt="Remapeador de controle" width="92%" />
</div>

---

### 8. 🧹 Limpador de RAM e Otimização em 1 Clique
> Libere a memória RAM da TV instantaneamente. Fecha processos em cache em segundo plano com total segurança e exibe a quantidade exata de memória recuperada.
<div align="center">
  <img src="docs/screenshots/09_ram_cleaner.png" alt="Notificação de limpeza de RAM" width="92%" />
</div>

---

### 9. 🌌 Protetor de Tela Aéreo Estilo Apple TV
> Protetor de tela dinâmico com fotos aéreas da Terra da NASA em alta resolução, iluminação suave e relógio com tipografia moderna.
<div align="center">
  <img src="docs/screenshots/10_aerial_screensaver.png" alt="Protetor de tela aéreo" width="92%" />
</div>

---

## 🚀 Início Rápido

### Pré-requisitos
1. **Ativar Opções do Desenvolvedor e Depuração ADB na TV**:
   - Acesse **Configurações** da TV → **Preferências do dispositivo** → **Sobre**.
   - Toque em **Número da Versão / Build** 7 vezes consecutivas até aparecer *"Você agora é um desenvolvedor!"*.
   - Volte em **Opções do desenvolvedor** e ative **Depuração USB** e **Depuração de rede / ADB**.
2. Conecte o computador e a TV na mesma rede Wi-Fi.

---

### Instalação Automatizada em 1 Clique (Recomendado)

Clone o repositório e execute o instalador universal:

```bash
git clone https://github.com/chiragchanchal/TrimOS.git
cd TrimOS
```

#### No Windows:
```powershell
python trimos.py install --ip <IP_DA_SUA_TV>
# ou dê um duplo clique no arquivo trimos.bat
```

#### No macOS / Linux:
```bash
python3 trimos.py install --ip <IP_DA_SUA_TV>
```

*O script identificará automaticamente a marca da sua TV, instalará o APK do TrimOS, ativará a proteção permanente da tecla Home, desativará com segurança os módulos de anúncio e instalará o SmartTube compatível com o seu processador.*

---

### Instalação Manual (Sem necessidade de Python)

Caso você já possua o `adb` instalado no computador:

```bash
# 1. Conectar à TV
adb connect <IP_DA_SUA_TV>:5555

# 2. Instalar o TrimOS
adb install -r -g release/TrimOS-v1.0.apk

# 3. Ativar serviço de acessibilidade para a tecla Home e Touchpad
adb shell settings put secure enabled_accessibility_services com.gathin.tvhome/.HomeKeyService
adb shell settings put secure accessibility_enabled 1

# 4. (Opcional) Instalar o SmartTube
# Para TVs de 32 bits (Mi TV 4A/4C, FireStick, etc.):
adb install -r release/SmartTube-v32.71-armeabi-v7a.apk
# Para TVs de 64 bits (Shield TV, Google TVs recentes):
adb install -r release/SmartTube-v32.71-arm64-v8a.apk

# 5. Iniciar o TrimOS
adb shell am start -n com.gathin.tvhome/.MainActivity
```

---

## 📺 TVs Compatíveis e Perfis

O TrimOS conta com perfis dedicados que respeitam os pacotes e peculiaridades de cada fabricante:

| Marca / Plataforma | Dispositivos Testados | O que o TrimOS limpa e otimiza |
| :--- | :--- | :--- |
| **Xiaomi / Redmi** | Mi TV 4A, 4C, 5X, Linha X, Horizon, Redmi TV | Remove PatchWall, banners de anúncios em vídeo e canais promocionais. Mantém entradas HDMI e CEC em pleno funcionamento. |
| **Google TV** | Chromecast com Google TV (HD/4K), Sony Bravia, TCL | Desativa os anúncios do `launcherx` e linhas patrocinadas. Mantém Google Cast e Play Store intactos. |
| **Android TV Padrão** | Sony Bravia, TCL, Hisense, Philips, Sharp, Skyworth | Substitui a interface pesada do Leanback. Ajustes de áudio e vídeo de fábrica permanecem funcionais. |
| **Amazon Fire TV** | Fire TV Stick 4K / Max, Fire TV Cube, Linha Omni | Ignora a interface sobrecarregada do Fire OS e fixa o botão Home no TrimOS. |
| **OnePlus TV** | OnePlus TV Q1, U1S, Y1S | Desativa o OxygenPlay e serviços promocionais em segundo plano. |
| **TV Boxes Genéricas** | Nvidia Shield TV, Mecool, Dynalink, Formuler, X96 | Experiência fluida a 60 fps com consumo mínimo de memória RAM. |

---

## 📱 Login pelo Celular e Touchpad Remoto

Toda TV com TrimOS conta com um servidor web local integrado, rápido e sem dependência de nuvem:

1. Clique no **ícone de QR Code** na barra superior da TV (ou acesse `http://<ip-da-tv>:8080` no navegador do celular).
2. **Touchpad Virtual**:
   - **Mover o dedo**: Deslize o cursor suavemente pela TV.
   - **Tocar**: Clique.
   - **Modo Arrastar**: Ative **Drag Mode: ON** para arrastar itens na tela.
   - **Botões de Rolagem**: Suba e desça com agilidade.
3. **Login Móvel**:
   - Digite senhas ou cole URLs no celular e clique em **"Send to TV Keyboard / Clipboard"**.
4. **Troca Rápida de Temas**:
   - Selecione o tema da TV diretamente pelo menu no celular.

---

## 🛡️ Segurança e Restauração em 1 Clique

O TrimOS é **100% não destrutivo**:
- A remoção de aplicativos desnecessários é feita com `pm uninstall -k --user 0 <pacote>`, desativando-os apenas para a conta de usuário primária sem alterar o firmware original gravado no sistema.
- Nenhum arquivo essencial é excluído e não é necessário Root.

Para voltar à tela de fábrica a qualquer momento:

```bash
python trimos.py restore --ip <IP_DA_SUA_TV>
```

Seu launcher original de fábrica (PatchWall, Google TV, etc.) será reativado na hora.

---

## 🛠️ Comandos CLI e Utilitários

O script `trimos.py` funciona como uma central completa de manutenção para a sua TV:

```bash
# Verificar status de conexão, app ativa e consumo de RAM
python trimos.py status --ip 192.168.1.9

# Executar limpeza remota da memória RAM
python trimos.py clean --ip 192.168.1.9

# Trocar de tema remotamente
python trimos.py theme --theme-name aurora --ip 192.168.1.9

# Capturar screenshot da TV direto para o computador
python trimos.py screenshot --ip 192.168.1.9

# Abrir o controle remoto web no navegador do computador
python trimos.py remote --ip 192.168.1.9
```

---

## 📁 Estrutura do Repositório

```
TrimOS/
├── release/                      # APKs pré-compilados prontos para instalar
│   ├── TrimOS-v1.0.apk           # APK do inicializador TrimOS compilado
│   ├── SmartTube-v32.71-armeabi-v7a.apk  # SmartTube 32-bit sem anúncios
│   └── SmartTube-v32.71-arm64-v8a.apk    # SmartTube 64-bit sem anúncios
├── docs/
│   └── screenshots/              # Capturas reais efetuadas em televisores
├── launcher/                     # Código-fonte completo do projeto Android Studio
│   └── app/src/main/
│       ├── java/com/gathin/tvhome/
│       │   ├── MainActivity.java         # Interface Apple TV e gerenciador de foco
│       │   ├── HomeKeyService.java       # Serviço de acessibilidade da tecla Home
│       │   ├── BootReceiver.java         # Reinício automático na inicialização
│       │   ├── MouseController.java      # Cursor flutuante e motor de arraste
│       │   ├── TvHttpServer.java         # Servidor web local para controle e teclado
│       │   ├── ThemeManager.java         # Gerenciador dos 32 temas incluídos
│       │   ├── UniversalSearchHelper.java# Sistema de busca entre aplicativos
│       │   ├── RemoteRemapHelper.java    # Gerenciador de remapeamento de botões
│       │   └── QrCodeHelper.java         # Gerador de códigos QR integrado
│       └── assets/themes/                # 32 temas e papéis de parede embutidos
├── trimos.py                     # Instalador universal e ferramenta CLI
├── trimos.bat                    # Atalho de execução para Windows em 1 clique
├── trimos.sh                     # Script de execução para Linux / macOS
├── LICENSE                       # Licença MIT
└── README.md                     # Documentação principal em inglês
```

---

## 📜 Licença

Este projeto é disponibilizado sob a **Licença MIT** – consulte o arquivo [LICENSE](LICENSE) para mais detalhes.

---

<div align="center">
  <b>Construído para uma experiência de TV mais rápida, limpa e livre de anúncios.</b><br>
  <sub>Se o TrimOS melhorou a sua Smart TV, deixe uma ⭐️ no GitHub!</sub>
</div>
