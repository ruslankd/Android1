package com.example.weatherforecastapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Switch;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
    }

    public void clickThemeSwitch(View view) {
        Switch themeSwitch = (Switch) findViewById(R.id.switch1);
        themeSwitch.setText(themeSwitch.isChecked() ? R.string.dark_theme : R.string.light_theme);
    }
}