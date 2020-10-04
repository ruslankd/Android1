package com.example.weatherforecastapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_24);

        Intent intent = getIntent();
        Fragment fragment = null;
        if ("city".equals(Objects.requireNonNull(intent.getStringExtra("fragment")))) {
            fragment = new CitySelectionFragment();
        }

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.fragmentContainer, Objects.requireNonNull(fragment));
        transaction.addToBackStack(null);
        transaction.commit();


    }

    @Override
    protected void onResume() {
        super.onResume();

        View v = findViewById(R.id.fragmentContainer);
        v.setBackgroundResource(Settings.getInstance().isDarkThemeFlag() ? R.drawable.dark : R.drawable.background);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
