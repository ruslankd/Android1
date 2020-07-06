package com.example.weatherforecastapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String LOG = "MyLog";
    Settings settings;
    TextView textViewOfCity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String s = "MainActivity: onCreate";
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
        Log.d(LOG, s);

        settings = Settings.getInstance();
        textViewOfCity = (TextView) findViewById(R.id.textViewCity);
    }

    @Override
    protected void onStart() {
        super.onStart();
        String s = "MainActivity: onStart";
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
        Log.d(LOG, s);
    }

    @Override
    protected void onResume() {
        super.onResume();
        String s = "MainActivity: onResume";
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
        Log.d(LOG, s);


        textViewOfCity.setText(settings.getCities()[settings.getCurrentIndexOfCity()]);

        View v = (View) findViewById(R.id.mainLayout);
        v.setBackgroundResource(settings.isDarkThemeFlag() ? R.drawable.dark : R.drawable.background);
    }

    @Override
    protected void onPause() {
        super.onPause();
        String s = "MainActivity: onPause";
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
        Log.d(LOG, s);
    }

    @Override
    protected void onStop() {
        super.onStop();
        String s = "MainActivity: onStop";
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
        Log.d(LOG, s);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        String s = "MainActivity: onDestroy";
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
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
