package com.example.weatherforecastapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;

public class SettingsFragment extends Fragment {

    Switch darkThemeSwitch;
    Settings settings;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_settings, container, false);

        darkThemeSwitch = layout.findViewById(R.id.switch1);
        settings = Settings.getInstance();

        layout.findViewById(R.id.buttonBackFromSettings).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });

        layout.findViewById(R.id.switch1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                settings.setDarkTheme(darkThemeSwitch.isChecked());
            }
        });

        return layout;
    }

    @Override
    public void onStart() {
        super.onStart();
        darkThemeSwitch.setChecked(settings.isDarkThemeFlag());
    }
}