package com.gathin.tvhome;

import android.accessibilityservice.GestureDescription;
import android.graphics.Path;
import android.os.Handler;
import android.os.Looper;
import android.view.View;

public class MouseController {
    private static MouseController instance;
    private float cursorX = 960f;
    private float cursorY = 540f;
    private View cursorView;
    private final Handler handler = new Handler(Looper.getMainLooper());
    private final Runnable hideCursorRunnable = () -> {
        if (cursorView != null) {
            cursorView.animate().alpha(0f).setDuration(300).withEndAction(() -> cursorView.setVisibility(View.GONE)).start();
        }
    };

    private MouseController() {}

    public static synchronized MouseController getInstance() {
        if (instance == null) {
            instance = new MouseController();
        }
        return instance;
    }

    public void setCursorView(View view) {
        this.cursorView = view;
        if (cursorView != null) {
            cursorView.setX(cursorX);
            cursorView.setY(cursorY);
        }
    }

    public void onMove(float dx, float dy, boolean isDragging) {
        handler.post(() -> {
            MainActivity activity = MainActivity.getInstance();
            if (activity == null) return;

            int width = activity.getResources().getDisplayMetrics().widthPixels;
            int height = activity.getResources().getDisplayMetrics().heightPixels;

            float prevX = cursorX;
            float prevY = cursorY;

            cursorX = Math.max(0, Math.min(width - 10, cursorX + dx));
            cursorY = Math.max(0, Math.min(height - 10, cursorY + dy));

            if (cursorView != null) {
                cursorView.setVisibility(View.VISIBLE);
                cursorView.setAlpha(1f);
                cursorView.setX(cursorX);
                cursorView.setY(cursorY);
                handler.removeCallbacks(hideCursorRunnable);
                handler.postDelayed(hideCursorRunnable, 4000);
            }

            if (isDragging && HomeKeyService.running != null) {
                dispatchDrag(prevX, prevY, cursorX, cursorY, 80);
            }
        });
    }

    public void onClick() {
        handler.post(() -> {
            if (cursorView != null) {
                cursorView.setVisibility(View.VISIBLE);
                cursorView.setAlpha(1f);
                cursorView.animate().scaleX(1.4f).scaleY(1.4f).setDuration(80)
                        .withEndAction(() -> cursorView.animate().scaleX(1f).scaleY(1f).setDuration(80).start())
                        .start();
                handler.removeCallbacks(hideCursorRunnable);
                handler.postDelayed(hideCursorRunnable, 4000);
            }

            if (HomeKeyService.running != null) {
                Path path = new Path();
                path.moveTo(cursorX, cursorY);
                GestureDescription.StrokeDescription stroke = new GestureDescription.StrokeDescription(path, 0, 50);
                GestureDescription gesture = new GestureDescription.Builder().addStroke(stroke).build();
                HomeKeyService.running.dispatchGesture(gesture, null, null);
            }
        });
    }

    public void onScroll(String direction) {
        handler.post(() -> {
            if (HomeKeyService.running != null) {
                float startX = cursorX;
                float startY = cursorY;
                float endX = cursorX;
                float endY = "up".equalsIgnoreCase(direction) ? cursorY + 300 : cursorY - 300;
                dispatchDrag(startX, startY, endX, endY, 200);
            }
        });
    }

    private void dispatchDrag(float startX, float startY, float endX, float endY, long durationMs) {
        if (HomeKeyService.running == null) return;
        Path path = new Path();
        path.moveTo(startX, startY);
        path.lineTo(endX, endY);
        GestureDescription.StrokeDescription stroke = new GestureDescription.StrokeDescription(path, 0, Math.max(50, durationMs));
        GestureDescription gesture = new GestureDescription.Builder().addStroke(stroke).build();
        HomeKeyService.running.dispatchGesture(gesture, null, null);
    }
}
