package com.example.weatherforecastapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] cities = new String[]{
                "Moscow",
                "St. Petersburg",
                "Yekaterinburg",
                "Sochi",
                "Vladivostok"
        };

    }

    public void clickChangeCity(View view) {
        Intent intent = new Intent(this, CitySelectionActivity.class);
        startActivity(intent);
    }
}
