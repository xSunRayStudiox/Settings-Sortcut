package com.sun_ray.LTE_4G;

import android.graphics.PorterDuff;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

public class Fragment_About extends Fragment {

    TabLayout tabLayout;
    WebView About_text;
    TextView rate_us, more_apps;

    String[] TabTexts = {"Network Change Forcely", "Developer Mode", "Application Settings", "Manage Application",
            "Accessibility Settings", "Add Account", "Search Settings", "Device Info", "User Dictionary"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_about, container, false);

        FindViewByID_Initialization(view);

        // Tab SetUp
        TabSetAndSetText();
        About_text.loadUrl("file:///android_asset/radio_info.html");

        return view;
    }

    private void TabSetAndSetText() {

        for (String tabText : TabTexts) {
            tabLayout.addTab(tabLayout.newTab().setText(tabText));
        }

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                int i = tab.getPosition();
                About_text.getSettings().setJavaScriptEnabled(true);

                switch (i) {
                    case 0:
                        About_text.loadUrl("file:///android_asset/radio_info.html");
                        break;
                    case 1:
                        About_text.loadUrl("file:///android_asset/developer_mode.html");
                        break;
                    case 2:
                        About_text.loadUrl("file:///android_asset/app_settings.html");
                        break;
                    case 3:
                        About_text.loadUrl("file:///android_asset/manage_app.html");
                        break;
                    case 4:
                        About_text.loadUrl("file:///android_asset/accessibility_settings.html");
                        break;
                    case 5:
                        About_text.loadUrl("file:///android_asset/add_accounts.html");
                        break;
                    case 6:
                        About_text.loadUrl("file:///android_asset/search_settings.html");
                        break;
                    case 7:
                        About_text.loadUrl("file:///android_asset/device_info.html");
                        break;
                    case 8:
                        About_text.loadUrl("file:///android_asset/user_dictionary.html");
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {}

            @Override
            public void onTabReselected(TabLayout.Tab tab) {}
        });
    }

    private void FindViewByID_Initialization(View view) {
        tabLayout = view.findViewById(R.id.tab_layout);
        About_text = view.findViewById(R.id.about_text);
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