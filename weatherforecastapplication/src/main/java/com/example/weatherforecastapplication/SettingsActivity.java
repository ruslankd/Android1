package com.example.weatherforecastapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Switch;

public class SettingsActivity extends AppCompatActivity {

    Switch darkThemeSwitch;
    Settings settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        darkThemeSwitch = findViewById(R.id.switch1);
        settings = Settings.getInstance();
    }

    @Override
    protected void onStart() {
        super.onStart();
        darkThemeSwitch.setChecked(settings.isDarkThemeFlag());
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("darkThemeFlag", settings.isDarkThemeFlag());
        startActivity(intent);
    }

    public void clickThemeSwitch(View view) {
        settings.setDarkTheme(darkThemeSwitch.isChecked());
    }

    public void clickButtonBackFromSettings(View view) {
        onBackPressed();
    }
}