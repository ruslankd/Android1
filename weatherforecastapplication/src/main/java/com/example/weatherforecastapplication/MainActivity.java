package com.example.weatherforecastapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String LOG = "MyLog";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String s = "onCreate";
        Toast.makeText(this, s, Toast.LENGTH_LONG);
        Log.d(LOG, s);

        Intent intent = getIntent();
        Boolean checkedDarkTheme = intent.getBooleanExtra("darkThemeFlag", false);
        if (checkedDarkTheme) {
            //((View) findViewById(R.id.mainLayout)).setBackground(R.drawable);
        }

        String[] cities = new String[]{
                "Moscow",
                "St. Petersburg",
                "Yekaterinburg",
                "Sochi",
                "Vladivostok"
        };
    }

    @Override
    protected void onStart() {
        super.onStart();
        String s = "onStart";
        Toast.makeText(this, s, Toast.LENGTH_LONG);
        Log.d(LOG, s);
    }

    @Override
    protected void onResume() {
        super.onResume();
        String s = "onResume";
        Toast.makeText(this, s, Toast.LENGTH_LONG);
        Log.d(LOG, s);
    }

    @Override
    protected void onPause() {
        super.onPause();
        String s = "onPause";
        Toast.makeText(this, s, Toast.LENGTH_LONG);
        Log.d(LOG, s);
    }

    @Override
    protected void onStop() {
        super.onStop();
        String s = "onStop";
        Toast.makeText(this, s, Toast.LENGTH_LONG);
        Log.d(LOG, s);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        String s = "onDestroy";
        Toast.makeText(this, s, Toast.LENGTH_LONG);
        Log.d(LOG, s);
    }

    public void clickChangeCity(View view) {
        Intent intent = new Intent(this, CitySelectionActivity.class);
        startActivity(intent);
    }

    public void clickButtonSettings(View view) {
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }
}
