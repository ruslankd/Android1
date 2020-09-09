package com.example.weatherforecastapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Html;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

public class MainFragment extends Fragment implements View.OnClickListener {

    Settings settings;
    TextView textViewOfCity, tv2;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        settings = Settings.getInstance();
        textViewOfCity = (TextView) root.findViewById(R.id.textViewCity);
        textViewOfCity.setText(settings.getCities()[settings.getCurrentIndexOfCity()]);

        ((Button) root.findViewById(R.id.button)).setOnClickListener(this);
        ((Button) root.findViewById(R.id.buttonInfo)).setOnClickListener(this);
        ((Button) root.findViewById(R.id.buttonSettings)).setOnClickListener(this);

        tv2 = root.findViewById(R.id.textView2);
        int currentT = settings.getTemperatures()[settings.getCurrentIndexOfCity()][0];
        String currentTString = ((currentT > 0) ? "+" : "") + String.valueOf(currentT);
        currentTString += "°";
        tv2.setText(currentTString);

        initRecyclerView(settings.getTemperatures()[settings.getCurrentIndexOfCity()], root);

        return root;
    }

    private void initRecyclerView(int[] data, View root) {
        RecyclerView rwTemperature = root.findViewById(R.id.rwTemperature);
        rwTemperature.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(),
                LinearLayoutManager.HORIZONTAL, false);
        rwTemperature.setLayoutManager(layoutManager);

        TemperatureAdapter adapter = new TemperatureAdapter(data);
        rwTemperature.setAdapter(adapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        textViewOfCity.setText(settings.getCities()[settings.getCurrentIndexOfCity()]);

        View v = getView().getRootView().findViewById(R.id.mainLayout);
        v.setBackgroundResource(settings.isDarkThemeFlag() ? R.drawable.dark : R.drawable.background);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button :
                CitySelectionFragment citySelectionFragment = new CitySelectionFragment();
                getFragmentManager().beginTransaction()
                        .replace(R.id.fragmentContainer, citySelectionFragment)
                        .addToBackStack(null)
                        .commit();
                break;
            case R.id.buttonInfo :
                String url = "https://en.wikipedia.org/wiki/" + settings.getCities()[settings.getCurrentIndexOfCity()];
                Uri uri = Uri.parse(url);
                Intent browser = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(browser);
                break;
            case R.id.buttonSettings :
                SettingsFragment settingsFragment = new SettingsFragment();
                getFragmentManager().beginTransaction()
                        .replace(R.id.fragmentContainer, settingsFragment)
                        .addToBackStack(null)
                        .commit();
                break;
        }
    }
}