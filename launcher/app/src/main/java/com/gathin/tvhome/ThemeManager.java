package com.gathin.tvhome;

import android.app.AlertDialog;
import android.content.Context;
import android.content.res.AssetManager;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class ThemeManager {
    private ThemeManager() {}

    public static final String[] HIGHLIGHTED_THEMES = {
        "aerial", "minimal", "midnight-glass", "aurora", "onyx", "retro",
        "cinematic", "nature-calm", "dock-glass", "twilight", "diwali",
        "dussehra", "christmas", "new-year", "stockholm", "istanbul"
    };

    public static List<String> getAvailableThemes(Context ctx) {
        try {
            String[] list = ctx.getAssets().list("themes");
            if (list != null && list.length > 0) {
                List<String> result = new ArrayList<>();
                for (String s : list) {
                    if (!s.endsWith(".md") && !s.startsWith(".")) {
                        result.add(s);
                    }
                }
                Collections.sort(result);
                return result;
            }
        } catch (Exception ignored) {}
        return Arrays.asList(HIGHLIGHTED_THEMES);
    }

    public static boolean applyTheme(Context ctx, String themeName) {
        File targetDir = Config.dir(ctx);
        if (targetDir == null || !targetDir.exists()) {
            targetDir = ctx.getExternalFilesDir(null);
        }
        if (targetDir == null) return false;

        try {
            File currentConfig = new File(targetDir, Config.FILE_NAME);
            if (currentConfig.exists()) currentConfig.delete();
            File currentWp = new File(targetDir, "wallpaper.jpg");
            if (currentWp.exists()) currentWp.delete();
            File wpDir = new File(targetDir, "wallpapers");
            deleteRecursive(wpDir);

            AssetManager am = ctx.getAssets();
            String assetBasePath = "themes/" + themeName;
            copyAssetFolder(am, assetBasePath, targetDir);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private static void copyAssetFolder(AssetManager am, String srcPath, File destDir) throws Exception {
        String[] files = am.list(srcPath);
        if (files == null || files.length == 0) {
            copyAssetFile(am, srcPath, new File(destDir.getParentFile(), new File(srcPath).getName()));
            return;
        }
        if (!destDir.exists()) destDir.mkdirs();
        for (String file : files) {
            String subSrc = srcPath + "/" + file;
            String[] subFiles = am.list(subSrc);
            if (subFiles != null && subFiles.length > 0) {
                File subDest = new File(destDir, file);
                copyAssetFolder(am, subSrc, subDest);
            } else {
                copyAssetFile(am, subSrc, new File(destDir, file));
            }
        }
    }

    private static void copyAssetFile(AssetManager am, String srcPath, File destFile) throws Exception {
        File parent = destFile.getParentFile();
        if (parent != null) parent.mkdirs();
        try (InputStream in = am.open(srcPath);
             OutputStream out = new FileOutputStream(destFile)) {
            byte[] buf = new byte[8192];
            int read;
            while ((read = in.read(buf)) != -1) {
                out.write(buf, 0, read);
            }
            out.flush();
        }
    }

    private static void deleteRecursive(File fileOrDir) {
        if (fileOrDir != null && fileOrDir.exists()) {
            if (fileOrDir.isDirectory()) {
                File[] children = fileOrDir.listFiles();
                if (children != null) {
                    for (File child : children) deleteRecursive(child);
                }
            }
            fileOrDir.delete();
        }
    }

    public static void showThemeDialog(MainActivity activity) {
        List<String> themes = getAvailableThemes(activity);
        String[] themeArray = themes.toArray(new String[0]);
        String[] displayNames = new String[themeArray.length];
        for (int i = 0; i < themeArray.length; i++) {
            String raw = themeArray[i];
            String formatted = raw.replace('-', ' ');
            displayNames[i] = Character.toUpperCase(formatted.charAt(0)) + formatted.substring(1);
        }

        new AlertDialog.Builder(activity, android.R.style.Theme_DeviceDefault_Dialog_Alert)
                .setTitle("🎨 Choose Theme")
                .setItems(displayNames, (dialog, which) -> {
                    String chosen = themeArray[which];
                    boolean success = applyTheme(activity, chosen);
                    if (success) {
                        Toast.makeText(activity, "Theme applied: " + displayNames[which], Toast.LENGTH_SHORT).show();
                        activity.recreate();
                    } else {
                        Toast.makeText(activity, "Failed to apply theme", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("Cancel", null)
                .show();
    }
}
