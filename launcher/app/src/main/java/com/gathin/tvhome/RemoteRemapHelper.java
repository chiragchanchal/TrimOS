package com.gathin.tvhome;

import android.app.AlertDialog;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public final class RemoteRemapHelper {
    private RemoteRemapHelper() {}

    public static class RemoteKeyOption {
        final String displayName;
        final String keyCodeString;

        RemoteKeyOption(String displayName, String keyCodeString) {
            this.displayName = displayName;
            this.keyCodeString = keyCodeString;
        }
    }

    public static class ActionOption {
        final String displayName;
        final String target;

        ActionOption(String displayName, String target) {
            this.displayName = displayName;
            this.target = target;
        }
    }

    private static final RemoteKeyOption[] KEYS = {
        new RemoteKeyOption("🔴 Red Button (KEYCODE_PROG_RED)", "183"),
        new RemoteKeyOption("🟢 Green Button (KEYCODE_PROG_GREEN)", "184"),
        new RemoteKeyOption("🟡 Yellow Button (KEYCODE_PROG_YELLOW)", "185"),
        new RemoteKeyOption("🔵 Blue Button (KEYCODE_PROG_BLUE)", "186"),
        new RemoteKeyOption("⚙️ Menu / Settings Key", "KEYCODE_SETTINGS"),
        new RemoteKeyOption("⬅️ Long-Press Back Button", "hold:back"),
        new RemoteKeyOption("1️⃣ Number 1 Button", "KEYCODE_1"),
        new RemoteKeyOption("2️⃣ Number 2 Button", "KEYCODE_2"),
        new RemoteKeyOption("3️⃣ Number 3 Button", "KEYCODE_3")
    };

    private static final ActionOption[] ACTIONS = {
        new ActionOption("🧹 Clean RAM & Background Apps", "clean"),
        new ActionOption("🌌 Apple TV Aerial Screensaver", "screensaver"),
        new ActionOption("🎨 Change Theme", "theme"),
        new ActionOption("📱 QR Code & Mobile Sign-In", "mobile"),
        new ActionOption("🔍 Universal Search", "search"),
        new ActionOption("🎬 Open Netflix", "com.netflix.ninja"),
        new ActionOption("📺 Open SmartTube (Ad-Free YouTube)", "org.smarttube.stable"),
        new ActionOption("▶️ Open YouTube", "com.google.android.youtube.tv"),
        new ActionOption("🔵 Open Prime Video", "com.amazon.amazonvideo.livingroom"),
        new ActionOption("🌟 Open JioHotstar", "in.startv.hotstar"),
        new ActionOption("⚙️ Open TV Settings", "settings")
    };

    public static void showRemapDialog(MainActivity activity) {
        String[] keyLabels = new String[KEYS.length];
        for (int i = 0; i < KEYS.length; i++) keyLabels[i] = KEYS[i].displayName;

        new AlertDialog.Builder(activity, android.R.style.Theme_DeviceDefault_Dialog_Alert)
                .setTitle("🎮 Select Remote Button to Remap")
                .setItems(keyLabels, (dialog, whichKey) -> {
                    RemoteKeyOption selectedKey = KEYS[whichKey];
                    showActionDialog(activity, selectedKey);
                })
                .setNegativeButton("Cancel", null)
                .show();
    }

    private static void showActionDialog(MainActivity activity, RemoteKeyOption keyOption) {
        String[] actionLabels = new String[ACTIONS.length];
        for (int i = 0; i < ACTIONS.length; i++) actionLabels[i] = ACTIONS[i].displayName;

        new AlertDialog.Builder(activity, android.R.style.Theme_DeviceDefault_Dialog_Alert)
                .setTitle("Select Action for " + keyOption.displayName)
                .setItems(actionLabels, (dialog, whichAction) -> {
                    ActionOption selectedAction = ACTIONS[whichAction];
                    saveMapping(activity, keyOption.keyCodeString, selectedAction.target);
                    Toast.makeText(activity, "Mapped " + keyOption.displayName + " to " + selectedAction.displayName, Toast.LENGTH_LONG).show();
                    activity.recreate();
                })
                .setNegativeButton("Back", (d, w) -> showRemapDialog(activity))
                .show();
    }

    private static void saveMapping(MainActivity activity, String keyCode, String target) {
        File dir = Config.dir(activity);
        if (dir == null) return;
        File file = new File(dir, Config.FILE_NAME);
        try {
            JSONObject json = new JSONObject();
            if (file.exists()) {
                try (FileInputStream in = new FileInputStream(file)) {
                    byte[] data = new byte[(int) file.length()];
                    in.read(data);
                    json = new JSONObject(new String(data, StandardCharsets.UTF_8));
                } catch (Exception ignored) {}
            }

            JSONArray appKeys = json.optJSONArray("app_keys");
            List<String> list = new ArrayList<>();
            if (appKeys != null) {
                for (int i = 0; i < appKeys.length(); i++) {
                    String entry = appKeys.getString(i);
                    if (!entry.startsWith(keyCode + ":")) {
                        list.add(entry);
                    }
                }
            }
            list.add(keyCode + ":" + target);

            JSONArray newArray = new JSONArray();
            for (String s : list) newArray.put(s);
            json.put("app_keys", newArray);

            try (FileOutputStream out = new FileOutputStream(file)) {
                out.write(json.toString(2).getBytes(StandardCharsets.UTF_8));
                out.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
