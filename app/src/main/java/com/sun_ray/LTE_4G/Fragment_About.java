package com.sun_ray.LTE_4G;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

public class Fragment_About extends Fragment {

    WebView webView;
    ImageView rate_us, more_apps;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_about, container, false);

        FindViewByID_Initialization(view);

        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("file:///android_asset/web_page.html");

        return view;
    }

    private void FindViewByID_Initialization(View view) {
        webView = view.findViewById(R.id.webView);
        rate_us = view.findViewById(R.id.rateUs);
        more_apps = view.findViewById(R.id.more_apps);
    }


    private void ClickAbout(){
        rate_us.setOnClickListener(v -> {
        });

        more_apps.setOnClickListener(v -> {
        });
    }

}