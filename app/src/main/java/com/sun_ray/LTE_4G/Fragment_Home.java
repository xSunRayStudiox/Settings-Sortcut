package com.sun_ray.LTE_4G;

import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

import java.util.Objects;

public class Fragment_Home extends Fragment {

    LinearLayout NetworkSwitch, Dev_Opt, Application_Settings, Manage_Application,
            Accessibility_settings, Add_account, search_settings, device_info,
            user_dictionary;
    ImageView about;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        FindViewByID_Initialization(view);

        about.setOnClickListener(v -> {
            Navigation.findNavController(v).navigate(R.id.action_fragment_Home_to_fragment_About);
        });

        FunctionClick();

        return view;
    }


    private void FindViewByID_Initialization(View view) {
        about = view.findViewById(R.id.about);
        NetworkSwitch = view.findViewById(R.id.Radio_info);
        Dev_Opt = view.findViewById(R.id.Dev_Opt);
        Application_Settings = view.findViewById(R.id.app_settings);
        Manage_Application = view.findViewById(R.id.app_manage);
        Accessibility_settings = view.findViewById(R.id.Accessibility_Settings);
        Add_account = view.findViewById(R.id.add_account);
        search_settings = view.findViewById(R.id.search_settings);
        device_info = view.findViewById(R.id.device_info);
        user_dictionary = view.findViewById(R.id.user_dictionary);
    }

    private void FunctionClick() {

        NetworkSwitch.setOnClickListener(v -> {
            NetworkSwitchCheck();
        });

        Dev_Opt.setOnClickListener(v -> {
            if (isDeveloperModeOn(requireContext())) {
                Intent intent = new Intent(Settings.ACTION_APPLICATION_DEVELOPMENT_SETTINGS);
                startActivity(intent);
            } else {
                showDeveloperModeInstructions();
            }
        });

        Application_Settings.setOnClickListener(v -> {
            Intent intent = new Intent(Settings.ACTION_APPLICATION_SETTINGS);
            startActivity(intent);
        });

        Manage_Application.setOnClickListener(v -> {
            Intent intent = new Intent(Settings.ACTION_MANAGE_APPLICATIONS_SETTINGS);
            startActivity(intent);
        });

        Accessibility_settings.setOnClickListener(v -> {
            Intent intent = new Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS);
            startActivity(intent);
        });

        Add_account.setOnClickListener(v -> {
            Intent intent = new Intent(Settings.ACTION_ADD_ACCOUNT);
            startActivity(intent);
        });

        search_settings.setOnClickListener(v -> {
            Intent intent = new Intent(Settings.ACTION_APP_SEARCH_SETTINGS);
            startActivity(intent);
        });

        device_info.setOnClickListener(v -> {
            Intent intent = new Intent(Settings.ACTION_DEVICE_INFO_SETTINGS);
            startActivity(intent);
        });

        user_dictionary.setOnClickListener(v -> {
            Intent intent = new Intent(Settings.ACTION_USER_DICTIONARY_SETTINGS);
            startActivity(intent);
        });
    }

    private void NetworkSwitchCheck() {
        try {
            Intent intent = new Intent();
            intent.setClassName("com.android.settings", "com.android.settings.RadioInfo");
            startActivity(intent);
        } catch (Exception e) {
            try {
                Intent i = new Intent("android.intent.action.MAIN");
                i.setClassName("com.android.phone", "com.android.phone.settings.RadioInfo");
                startActivity(i);
            } catch (Exception e1) {
                try {
                    Intent i1 = new Intent("android.intent.action.MAIN");
                    i1.setClassName("com.android.settings", "com.android.settings.RadioInfo");
                    startActivity(i1);
                } catch (Exception e3) {
                    try {
                        Intent i3 = new Intent();
                        i3.setComponent(new ComponentName("com.android.settings", "com.android.settings.RadioInfo"));
                        startActivity(i3);
                    } catch (Exception e4) {
                        Toast.makeText(requireActivity(), "Not Support in this Device", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        }
    }

    private void showDeveloperModeInstructions() {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        builder.setTitle("Enable Developer Mode")
                .setMessage("To enable Developer Mode on your device, follow these steps:\n\n" +
                        "1. Open Settings.\n" +
                        "2. Scroll down and select 'About phone' or 'About device'.\n" +
                        "3. Find 'Build number' or 'Software information'.\n" +
                        "4. Tap the build number 7 times.\n" +
                        "5. You will see a message that Developer Mode is enabled.\n" +
                        "6. Go back to Settings, and you will find 'Developer options' now available.")
                .setPositiveButton("Go To About Phone", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent i = new Intent(Settings.ACTION_DEVICE_INFO_SETTINGS);
                        startActivity(i);
                    }
                })
                .show();
    }

    private static boolean isDeveloperModeOn(Context context) {
        int developer =
                Settings.Global.getInt(context.getContentResolver(),
                        Settings.Global.DEVELOPMENT_SETTINGS_ENABLED, 0);
        return developer != 0;
    }
}