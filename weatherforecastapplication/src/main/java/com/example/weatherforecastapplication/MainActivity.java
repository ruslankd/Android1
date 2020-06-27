package com.example.weatherforecastapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);

        String[] cities = new String[]{
                "Moscow",
                "St. Petersburg",
                "Yekaterinburg",
                "Sochi",
                "Vladivostok"
        };

        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<>(
                this,R.layout.spinner_item, cities
        );
        spinnerArrayAdapter.setDropDownViewResource(R.layout.spinner_item);
        spinner.setAdapter(spinnerArrayAdapter);
    }
}
