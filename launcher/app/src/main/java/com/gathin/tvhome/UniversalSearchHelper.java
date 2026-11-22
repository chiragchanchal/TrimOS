package com.gathin.tvhome;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.net.URLEncoder;

public final class UniversalSearchHelper {
    private UniversalSearchHelper() {}

    public static final String[] GENRES = {
        "Action", "Comedy", "Sci-Fi", "Drama", "Thriller", "Horror", "Animation & Kids", "Romance", "Documentary"
    };

    public static void showSearchDialog(MainActivity activity) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity, android.R.style.Theme_DeviceDefault_Dialog_Alert);
        View view = LayoutInflater.from(activity).inflate(R.layout.dialog_universal_search, null);
        builder.setView(view);

        AlertDialog dialog = builder.create();
        dialog.show();

        EditText editSearch = view.findViewById(R.id.editSearchQuery);
        Button btnSearchAll = view.findViewById(R.id.btnSearchAll);
        Button btnSearchYoutube = view.findViewById(R.id.btnSearchYoutube);
        Button btnSearchNetflix = view.findViewById(R.id.btnSearchNetflix);
        Button btnSearchSmartTube = view.findViewById(R.id.btnSearchSmartTube);
        Button btnSearchPrime = view.findViewById(R.id.btnSearchPrime);
        Button btnSearchHotstar = view.findViewById(R.id.btnSearchHotstar);
        LinearLayout genreContainer = view.findViewById(R.id.genreContainer);

        View.OnClickListener searchListener = v -> {
            String query = editSearch.getText().toString().trim();
            if (query.isEmpty()) {
                Toast.makeText(activity, "Please enter a movie, show, or actor", Toast.LENGTH_SHORT).show();
                return;
            }
            int id = v.getId();
            String target = "all";
            if (id == R.id.btnSearchSmartTube) target = "smarttube";
            else if (id == R.id.btnSearchYoutube) target = "youtube";
            else if (id == R.id.btnSearchNetflix) target = "netflix";
            else if (id == R.id.btnSearchPrime) target = "prime";
            else if (id == R.id.btnSearchHotstar) target = "hotstar";

            dialog.dismiss();
            performSearch(activity, query, target);
        };

        btnSearchAll.setOnClickListener(searchListener);
        if (btnSearchSmartTube != null) btnSearchSmartTube.setOnClickListener(searchListener);
        btnSearchYoutube.setOnClickListener(searchListener);
        btnSearchNetflix.setOnClickListener(searchListener);
        btnSearchPrime.setOnClickListener(searchListener);
        btnSearchHotstar.setOnClickListener(searchListener);

        // Add genre chips
        for (String genre : GENRES) {
            Button chip = new Button(activity);
            chip.setText(genre);
            chip.setTextSize(13);
            chip.setTextColor(0xFFFFFFFF);
            chip.setBackgroundResource(R.drawable.pill_bg);
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );
            lp.setMargins(6, 4, 6, 4);
            chip.setLayoutParams(lp);
            chip.setOnClickListener(v -> {
                editSearch.setText(genre);
                editSearch.setSelection(genre.length());
            });
            genreContainer.addView(chip);
        }
    }

    public static void performSearch(Context context, String query, String target) {
        if (query == null || query.trim().isEmpty()) return;
        String encoded;
        try {
            encoded = URLEncoder.encode(query, "UTF-8");
        } catch (Exception e) {
            encoded = query;
        }

        Intent intent = null;
        switch (target.toLowerCase()) {
            case "smarttube":
                intent = new Intent(Intent.ACTION_SEARCH);
                intent.setPackage("org.smarttube.stable");
                intent.putExtra("query", query);
                break;
            case "youtube":
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/results?search_query=" + encoded));
                intent.setPackage("com.google.android.youtube.tv");
                break;
            case "netflix":
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("nflx://www.netflix.com/search?q=" + encoded));
                break;
            case "prime":
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://app.primevideo.com/search?phrase=" + encoded));
                break;
            case "hotstar":
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("hotstar://search?q=" + encoded));
                break;
            default: // all / global
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/results?search_query=" + encoded));
                break;
        }

        try {
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        } catch (Exception e) {
            // Fallback to web search
            try {
                Intent web = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/search?q=" + encoded));
                web.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(web);
            } catch (Exception ex) {
                Toast.makeText(context, "Could not open search provider", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
