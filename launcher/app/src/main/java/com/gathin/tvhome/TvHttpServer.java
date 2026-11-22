package com.gathin.tvhome;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.Looper;
import android.text.format.Formatter;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;

public class TvHttpServer {
    private static final String TAG = "TrimOS_Http";
    public static final int PORT = 8080;

    private static TvHttpServer instance;
    private ServerSocket serverSocket;
    private Thread serverThread;
    private boolean isRunning = false;
    private final Context appContext;
    private final Handler mainHandler = new Handler(Looper.getMainLooper());

    private TvHttpServer(Context context) {
        this.appContext = context.getApplicationContext();
    }

    public static synchronized TvHttpServer getInstance(Context context) {
        if (instance == null) {
            instance = new TvHttpServer(context);
        }
        return instance;
    }

    public synchronized void startServer() {
        if (isRunning) return;
        isRunning = true;
        serverThread = new Thread(() -> {
            try {
                serverSocket = new ServerSocket(PORT);
                Log.d(TAG, "TvHttpServer started on port " + PORT);
                while (isRunning) {
                    try {
                        Socket client = serverSocket.accept();
                        handleClient(client);
                    } catch (Exception e) {
                        if (!isRunning) break;
                        Log.e(TAG, "Error accepting client", e);
                    }
                }
            } catch (Exception e) {
                Log.e(TAG, "Server socket exception", e);
            }
        });
        serverThread.start();
    }

    public synchronized void stopServer() {
        isRunning = false;
        if (serverSocket != null) {
            try {
                serverSocket.close();
            } catch (Exception ignored) {}
        }
    }

    public static String getIpAddress(Context context) {
        try {
            WifiManager wm = (WifiManager) context.getApplicationContext().getSystemService(Context.WIFI_SERVICE);
            if (wm != null && wm.getConnectionInfo() != null) {
                int ip = wm.getConnectionInfo().getIpAddress();
                if (ip != 0) {
                    return Formatter.formatIpAddress(ip);
                }
            }
        } catch (Exception ignored) {}

        try {
            List<NetworkInterface> interfaces = Collections.list(NetworkInterface.getNetworkInterfaces());
            for (NetworkInterface intf : interfaces) {
                List<InetAddress> addrs = Collections.list(intf.getInetAddresses());
                for (InetAddress addr : addrs) {
                    if (!addr.isLoopbackAddress()) {
                        String sAddr = addr.getHostAddress();
                        if (sAddr != null && sAddr.indexOf(':') < 0) {
                            return sAddr;
                        }
                    }
                }
            }
        } catch (Exception ignored) {}
        return "127.0.0.1";
    }

    private void handleClient(Socket socket) {
        new Thread(() -> {
            try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
                 OutputStream out = socket.getOutputStream()) {

                String line = in.readLine();
                if (line == null) return;

                String[] parts = line.split(" ");
                if (parts.length < 2) return;
                String method = parts[0];
                String path = parts[1];

                int contentLength = 0;
                while ((line = in.readLine()) != null && !line.isEmpty()) {
                    if (line.toLowerCase().startsWith("content-length:")) {
                        contentLength = Integer.parseInt(line.substring(15).trim());
                    }
                }

                String body = "";
                if (contentLength > 0) {
                    char[] buf = new char[contentLength];
                    int read = in.read(buf, 0, contentLength);
                    body = new String(buf, 0, read);
                }

                if ("GET".equalsIgnoreCase(method)) {
                    if ("/".equals(path) || path.startsWith("/?")) {
                        sendHtmlResponse(out, getMobileWebPage());
                    } else {
                        send404(out);
                    }
                } else if ("POST".equalsIgnoreCase(method)) {
                    handlePost(path, body, out);
                }
            } catch (Exception e) {
                Log.e(TAG, "Client handling exception", e);
            }
        }).start();
    }

    private void handlePost(String path, String body, OutputStream out) throws Exception {
        String paramKey = "";
        String paramVal = "";
        if (body.contains("=")) {
            String[] kv = body.split("=", 2);
            paramKey = URLDecoder.decode(kv[0], "UTF-8");
            paramVal = kv.length > 1 ? URLDecoder.decode(kv[1], "UTF-8") : "";
        }

        if ("/api/text".equals(path)) {
            final String text = paramVal.isEmpty() ? body : paramVal;
            mainHandler.post(() -> {
                ClipboardManager cm = (ClipboardManager) appContext.getSystemService(Context.CLIPBOARD_SERVICE);
                if (cm != null) {
                    cm.setPrimaryClip(ClipData.newPlainText("Mobile Input", text));
                }
                Toast.makeText(appContext, "📱 Mobile Text Copied to Clipboard:\n" + text, Toast.LENGTH_LONG).show();
            });
            sendJsonResponse(out, "{\"status\":\"ok\",\"message\":\"Text copied to TV clipboard\"}");
        } else if ("/api/search".equals(path)) {
            String q = "";
            String target = "all";
            String[] pairs = body.split("&");
            for (String pair : pairs) {
                String[] kv = pair.split("=", 2);
                if (kv.length == 2) {
                    String k = URLDecoder.decode(kv[0], "UTF-8");
                    String v = URLDecoder.decode(kv[1], "UTF-8");
                    if ("q".equalsIgnoreCase(k)) q = v;
                    else if ("target".equalsIgnoreCase(k)) target = v;
                }
            }
            if (q.isEmpty()) q = paramVal;
            final String searchQuery = q;
            final String searchTarget = target;
            mainHandler.post(() -> UniversalSearchHelper.performSearch(appContext, searchQuery, searchTarget));
            sendJsonResponse(out, "{\"status\":\"ok\",\"message\":\"Search started\"}");
        } else if ("/api/mouse".equals(path)) {
            String action = "move";
            float dx = 0f;
            float dy = 0f;
            boolean isDrag = false;
            String dir = "down";

            String[] pairs = body.split("&");
            for (String pair : pairs) {
                String[] kv = pair.split("=", 2);
                if (kv.length == 2) {
                    String k = URLDecoder.decode(kv[0], "UTF-8").trim();
                    String v = URLDecoder.decode(kv[1], "UTF-8").trim();
                    if ("action".equalsIgnoreCase(k)) action = v;
                    else if ("dx".equalsIgnoreCase(k)) {
                        try { dx = Float.parseFloat(v); } catch (Exception ignored) {}
                    } else if ("dy".equalsIgnoreCase(k)) {
                        try { dy = Float.parseFloat(v); } catch (Exception ignored) {}
                    } else if ("drag".equalsIgnoreCase(k)) isDrag = Boolean.parseBoolean(v);
                    else if ("dir".equalsIgnoreCase(k)) dir = v;
                }
            }

            if ("move".equalsIgnoreCase(action)) {
                MouseController.getInstance().onMove(dx, dy, isDrag);
            } else if ("click".equalsIgnoreCase(action)) {
                MouseController.getInstance().onClick();
            } else if ("scroll".equalsIgnoreCase(action)) {
                MouseController.getInstance().onScroll(dir);
            }
            sendJsonResponse(out, "{\"status\":\"ok\"}");
        } else if ("/api/key".equals(path)) {
            final String key = paramVal;
            mainHandler.post(() -> {
                MainActivity activity = MainActivity.getInstance();
                if (activity != null) {
                    activity.handleRemoteKeyCommand(key);
                }
            });
            sendJsonResponse(out, "{\"status\":\"ok\"}");
        } else if ("/api/theme".equals(path)) {
            final String theme = paramVal;
            mainHandler.post(() -> {
                MainActivity activity = MainActivity.getInstance();
                if (activity != null) {
                    ThemeManager.applyTheme(activity, theme);
                    activity.recreate();
                }
            });
            sendJsonResponse(out, "{\"status\":\"ok\"}");
        } else {
            sendJsonResponse(out, "{\"status\":\"unknown_endpoint\"}");
        }
    }

    private void sendJsonResponse(OutputStream out, String json) throws Exception {
        byte[] bytes = json.getBytes(StandardCharsets.UTF_8);
        String header = "HTTP/1.1 200 OK\r\n"
                + "Content-Type: application/json; charset=utf-8\r\n"
                + "Access-Control-Allow-Origin: *\r\n"
                + "Content-Length: " + bytes.length + "\r\n"
                + "Connection: close\r\n\r\n";
        out.write(header.getBytes(StandardCharsets.UTF_8));
        out.write(bytes);
        out.flush();
    }

    private void sendHtmlResponse(OutputStream out, String html) throws Exception {
        byte[] bytes = html.getBytes(StandardCharsets.UTF_8);
        String header = "HTTP/1.1 200 OK\r\n"
                + "Content-Type: text/html; charset=utf-8\r\n"
                + "Content-Length: " + bytes.length + "\r\n"
                + "Connection: close\r\n\r\n";
        out.write(header.getBytes(StandardCharsets.UTF_8));
        out.write(bytes);
        out.flush();
    }

    private void send404(OutputStream out) throws Exception {
        String msg = "Not Found";
        String resp = "HTTP/1.1 404 Not Found\r\nContent-Length: " + msg.length() + "\r\n\r\n" + msg;
        out.write(resp.getBytes(StandardCharsets.UTF_8));
        out.flush();
    }

    private String getMobileWebPage() {
        return "<!DOCTYPE html>\n"
                + "<html lang=\"en\">\n"
                + "<head>\n"
                + "<meta charset=\"UTF-8\" />\n"
                + "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no\" />\n"
                + "<title>Apple TV Remote, Touchpad & Sign-In</title>\n"
                + "<style>\n"
                + "  * { box-sizing: border-box; margin: 0; padding: 0; font-family: -apple-system, BlinkMacSystemFont, 'SF Pro Display', 'Segoe UI', Roboto, sans-serif; }\n"
                + "  body { background: #0c0d12; color: #fff; padding: 16px; display: flex; flex-direction: column; align-items: center; min-height: 100vh; }\n"
                + "  .container { max-width: 440px; width: 100%; }\n"
                + "  .header { text-align: center; margin-bottom: 18px; }\n"
                + "  .header h1 { font-size: 20px; font-weight: 700; letter-spacing: -0.5px; margin-bottom: 2px; }\n"
                + "  .header p { font-size: 13px; color: #8e8e93; }\n"
                + "  .card { background: rgba(255,255,255,0.08); backdrop-filter: blur(20px); border-radius: 18px; padding: 16px; margin-bottom: 16px; border: 1px solid rgba(255,255,255,0.1); }\n"
                + "  .card-title { font-size: 13px; font-weight: 600; text-transform: uppercase; letter-spacing: 0.8px; color: #0a84ff; margin-bottom: 10px; }\n"
                + "  input, textarea, select { width: 100%; background: rgba(0,0,0,0.5); border: 1px solid rgba(255,255,255,0.2); border-radius: 12px; padding: 12px 14px; color: #fff; font-size: 15px; margin-bottom: 10px; outline: none; }\n"
                + "  input:focus, textarea:focus { border-color: #0a84ff; }\n"
                + "  .btn { display: block; width: 100%; background: #0a84ff; color: #fff; border: none; border-radius: 12px; padding: 12px; font-size: 15px; font-weight: 600; cursor: pointer; text-align: center; transition: background 0.15s; }\n"
                + "  .btn:active { background: #0066cc; transform: scale(0.98); }\n"
                + "  .touchpad {\n"
                + "    width: 100%; height: 210px;\n"
                + "    background: radial-gradient(circle at center, rgba(255,255,255,0.06) 0%, rgba(0,0,0,0.4) 100%);\n"
                + "    border: 2px dashed rgba(255,255,255,0.2); border-radius: 16px;\n"
                + "    display: flex; flex-direction: column; align-items: center; justify-content: center;\n"
                + "    position: relative; touch-action: none; user-select: none; cursor: grab; overflow: hidden;\n"
                + "  }\n"
                + "  .touchpad:active { border-color: #0a84ff; cursor: grabbing; }\n"
                + "  .touchpad.drag-active { border-color: #ff9f0a; border-style: solid; background: rgba(255,159,10,0.12); }\n"
                + "  .trackpad-label { font-size: 13px; color: rgba(255,255,255,0.5); text-align: center; pointer-events: none; line-height: 1.6; }\n"
                + "  .touch-dot { width: 36px; height: 36px; border-radius: 50%; background: rgba(10,132,255,0.6); position: absolute; pointer-events: none; display: none; transform: translate(-50%, -50%); }\n"
                + "  .dpad { display: grid; grid-template-columns: repeat(3, 1fr); gap: 10px; max-width: 240px; margin: 0 auto; }\n"
                + "  .dpad button { background: rgba(255,255,255,0.12); color: #fff; border: none; border-radius: 50%; height: 60px; width: 60px; font-size: 18px; font-weight: bold; cursor: pointer; display: flex; align-items: center; justify-content: center; margin: auto; transition: background 0.1s; }\n"
                + "  .dpad button:active { background: #0a84ff; }\n"
                + "  .row-btns { display: flex; gap: 8px; margin-top: 10px; }\n"
                + "  .row-btns button { flex: 1; padding: 10px; border-radius: 10px; border: none; background: rgba(255,255,255,0.12); color: #fff; font-weight: 600; font-size: 13px; cursor: pointer; }\n"
                + "  .row-btns button:active { background: #0a84ff; }\n"
                + "  .toast { position: fixed; bottom: 20px; background: #30d158; color: #000; padding: 10px 18px; border-radius: 20px; font-size: 14px; font-weight: 600; display: none; z-index: 999; }\n"
                + "</style>\n"
                + "</head>\n"
                + "<body>\n"
                + "<div class=\"container\">\n"
                + "  <div class=\"header\">\n"
                + "    <h1> Apple TV Remote & Touchpad</h1>\n"
                + "    <p>Xiaomi Mi TV • Connected via Wi-Fi</p>\n"
                + "  </div>\n"
                + "\n"
                + "  <!-- Touchpad & Mouse Drag Card -->\n"
                + "  <div class=\"card\">\n"
                + "    <div class=\"card-title\">🖱️ Touchpad &amp; Mouse Drag</div>\n"
                + "    <div id=\"touchpad\" class=\"touchpad\">\n"
                + "      <div class=\"trackpad-label\">\n"
                + "        <span>👆 Swipe to move cursor</span><br />\n"
                + "        <span>👆 Tap to Click • ✋ Hold to Drag</span>\n"
                + "      </div>\n"
                + "      <div id=\"touchCursor\" class=\"touch-dot\"></div>\n"
                + "    </div>\n"
                + "    <div class=\"row-btns\">\n"
                + "      <button id=\"btnDragToggle\" onclick=\"toggleDragMode()\">✋ Drag Mode: OFF</button>\n"
                + "      <button onclick=\"sendMouseClick()\">🖱️ Click</button>\n"
                + "      <button onclick=\"sendMouseScroll('up')\">🔼 Scroll Up</button>\n"
                + "      <button onclick=\"sendMouseScroll('down')\">🔽 Scroll Down</button>\n"
                + "    </div>\n"
                + "  </div>\n"
                + "\n"
                + "  <!-- Sign-in / Keyboard Card -->\n"
                + "  <div class=\"card\">\n"
                + "    <div class=\"card-title\">🔑 Mobile Sign-In & Keyboard</div>\n"
                + "    <textarea id=\"textInput\" rows=\"2\" placeholder=\"Type login email, password, or URL here...\"></textarea>\n"
                + "    <button class=\"btn\" onclick=\"sendText()\">Send to TV Keyboard / Clipboard</button>\n"
                + "  </div>\n"
                + "\n"
                + "  <!-- Universal Search Card -->\n"
                + "  <div class=\"card\">\n"
                + "    <div class=\"card-title\">🔍 Universal Streaming Search</div>\n"
                + "    <input id=\"searchInput\" type=\"text\" placeholder=\"Search movie, series, or actor...\" />\n"
                + "    <div class=\"row-btns\">\n"
                + "      <button onclick=\"sendSearch('smarttube')\" style=\"background:#ff3b30;\">📺 SmartTube</button>\n"
                + "      <button onclick=\"sendSearch('youtube')\">▶️ YouTube</button>\n"
                + "      <button onclick=\"sendSearch('netflix')\">🔴 Netflix</button>\n"
                + "      <button onclick=\"sendSearch('prime')\">🔵 Prime</button>\n"
                + "    </div>\n"
                + "  </div>\n"
                + "\n"
                + "  <!-- Touch Remote Control Card -->\n"
                + "  <div class=\"card\">\n"
                + "    <div class=\"card-title\">🕹️ Touch Remote Control</div>\n"
                + "    <div class=\"dpad\">\n"
                + "      <div></div><button onclick=\"sendKey('up')\">▲</button><div></div>\n"
                + "      <button onclick=\"sendKey('left')\">◀</button><button onclick=\"sendKey('ok')\" style=\"background:#0a84ff;\">OK</button><button onclick=\"sendKey('right')\">▶</button>\n"
                + "      <div></div><button onclick=\"sendKey('down')\">▼</button><div></div>\n"
                + "    </div>\n"
                + "    <div class=\"row-btns\">\n"
                + "      <button onclick=\"sendKey('back')\">BACK</button>\n"
                + "      <button onclick=\"sendKey('home')\">HOME</button>\n"
                + "      <button onclick=\"sendKey('clean')\" style=\"color:#30d158;\">🧹 CLEAN RAM</button>\n"
                + "    </div>\n"
                + "  </div>\n"
                + "\n"
                + "  <!-- Theme Switcher Card -->\n"
                + "  <div class=\"card\">\n"
                + "    <div class=\"card-title\">🎨 Instant Theme Switcher</div>\n"
                + "    <select id=\"themeSelect\" onchange=\"changeTheme(this.value)\">\n"
                + "      <option value=\"aerial\">Aerial (Apple TV Satellite)</option>\n"
                + "      <option value=\"minimal\">Minimal (OLED Black)</option>\n"
                + "      <option value=\"midnight-glass\">Midnight Glass</option>\n"
                + "      <option value=\"aurora\">Aurora Borealis</option>\n"
                + "      <option value=\"cinematic\">Cinematic Theatre</option>\n"
                + "      <option value=\"nature-calm\">Nature Calm</option>\n"
                + "      <option value=\"retro\">Retro 80s Synthwave</option>\n"
                + "      <option value=\"diwali\">Diwali Festive</option>\n"
                + "      <option value=\"dussehra\">Dussehra Festive</option>\n"
                + "      <option value=\"christmas\">Christmas Festive</option>\n"
                + "    </select>\n"
                + "  </div>\n"
                + "</div>\n"
                + "<div id=\"toast\" class=\"toast\">Sent successfully!</div>\n"
                + "\n"
                + "<script>\n"
                + "  function showToast(msg) {\n"
                + "    var t = document.getElementById('toast');\n"
                + "    t.innerText = msg || 'Sent successfully!';\n"
                + "    t.style.display = 'block';\n"
                + "    setTimeout(function() { t.style.display = 'none'; }, 2000);\n"
                + "  }\n"
                + "  function post(url, data, callback) {\n"
                + "    var x = new XMLHttpRequest();\n"
                + "    x.open('POST', url, true);\n"
                + "    x.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');\n"
                + "    x.onload = function() { showToast(); if (callback) callback(); };\n"
                + "    x.send(data);\n"
                + "  }\n"
                + "  function sendText() {\n"
                + "    var val = document.getElementById('textInput').value;\n"
                + "    if (!val) return;\n"
                + "    post('/api/text', 'text=' + encodeURIComponent(val), function() {\n"
                + "      document.getElementById('textInput').value = '';\n"
                + "    });\n"
                + "  }\n"
                + "  function sendSearch(target) {\n"
                + "    var val = document.getElementById('searchInput').value;\n"
                + "    if (!val) return;\n"
                + "    post('/api/search', 'q=' + encodeURIComponent(val) + '&target=' + encodeURIComponent(target || 'all'));\n"
                + "  }\n"
                + "  function sendKey(key) {\n"
                + "    post('/api/key', 'key=' + encodeURIComponent(key));\n"
                + "  }\n"
                + "  function changeTheme(theme) {\n"
                + "    post('/api/theme', 'theme=' + encodeURIComponent(theme), function() {\n"
                + "      showToast('Theme applied: ' + theme);\n"
                + "    });\n"
                + "  }\n"
                + "  var pad = document.getElementById('touchpad');\n"
                + "  var dot = document.getElementById('touchCursor');\n"
                + "  var dragMode = false;\n"
                + "  var lastX = 0, lastY = 0, startX = 0, startY = 0;\n"
                + "  var touchStartTime = 0;\n"
                + "  var pendingDx = 0, pendingDy = 0;\n"
                + "  var sendTimer = null;\n"
                + "  function toggleDragMode() {\n"
                + "    dragMode = !dragMode;\n"
                + "    var btn = document.getElementById('btnDragToggle');\n"
                + "    if (dragMode) {\n"
                + "      btn.innerText = '✋ Drag Mode: ON (ACTIVE)';\n"
                + "      btn.style.background = '#ff9f0a';\n"
                + "      pad.classList.add('drag-active');\n"
                + "    } else {\n"
                + "      btn.innerText = '✋ Drag Mode: OFF';\n"
                + "      btn.style.background = 'rgba(255,255,255,0.12)';\n"
                + "      pad.classList.remove('drag-active');\n"
                + "    }\n"
                + "  }\n"
                + "  function flushMouse() {\n"
                + "    if (pendingDx !== 0 || pendingDy !== 0) {\n"
                + "      post('/api/mouse', 'action=move&dx=' + pendingDx.toFixed(1) + '&dy=' + pendingDy.toFixed(1) + '&drag=' + dragMode);\n"
                + "      pendingDx = 0; pendingDy = 0;\n"
                + "    }\n"
                + "    sendTimer = null;\n"
                + "  }\n"
                + "  function scheduleSend() {\n"
                + "    if (!sendTimer) sendTimer = setTimeout(flushMouse, 30);\n"
                + "  }\n"
                + "  pad.addEventListener('touchstart', function(e) {\n"
                + "    if (e.touches.length > 0) {\n"
                + "      var t = e.touches[0];\n"
                + "      var rect = pad.getBoundingClientRect();\n"
                + "      lastX = t.clientX; lastY = t.clientY;\n"
                + "      startX = t.clientX; startY = t.clientY;\n"
                + "      touchStartTime = Date.now();\n"
                + "      dot.style.left = (t.clientX - rect.left) + 'px';\n"
                + "      dot.style.top = (t.clientY - rect.top) + 'px';\n"
                + "      dot.style.display = 'block';\n"
                + "    }\n"
                + "    e.preventDefault();\n"
                + "  }, { passive: false });\n"
                + "  pad.addEventListener('touchmove', function(e) {\n"
                + "    if (e.touches.length > 0) {\n"
                + "      var t = e.touches[0];\n"
                + "      var rect = pad.getBoundingClientRect();\n"
                + "      var dx = (t.clientX - lastX) * 2.2;\n"
                + "      var dy = (t.clientY - lastY) * 2.2;\n"
                + "      lastX = t.clientX; lastY = t.clientY;\n"
                + "      pendingDx += dx; pendingDy += dy;\n"
                + "      scheduleSend();\n"
                + "      dot.style.left = (t.clientX - rect.left) + 'px';\n"
                + "      dot.style.top = (t.clientY - rect.top) + 'px';\n"
                + "    }\n"
                + "    e.preventDefault();\n"
                + "  }, { passive: false });\n"
                + "  pad.addEventListener('touchend', function(e) {\n"
                + "    dot.style.display = 'none';\n"
                + "    flushMouse();\n"
                + "    var duration = Date.now() - touchStartTime;\n"
                + "    var dist = Math.hypot(lastX - startX, lastY - startY);\n"
                + "    if (duration < 250 && dist < 12) sendMouseClick();\n"
                + "    e.preventDefault();\n"
                + "  }, { passive: false });\n"
                + "  function sendMouseClick() {\n"
                + "    post('/api/mouse', 'action=click');\n"
                + "  }\n"
                + "  function sendMouseScroll(dir) {\n"
                + "    post('/api/mouse', 'action=scroll&dir=' + dir);\n"
                + "  }\n"
                + "</script>\n"
                + "</body>\n"
                + "</html>\n";
    }
}
