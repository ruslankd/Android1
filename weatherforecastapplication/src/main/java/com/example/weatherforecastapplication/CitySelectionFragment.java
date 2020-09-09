package com.example.weatherforecastapplication;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

public class CitySelectionFragment extends Fragment {

    RecyclerView rvCities;
    Settings settings;
    View root;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_city_selection, container, false);

        settings = Settings.getInstance();
        String[] data = settings.getCities();
        initRwCities(data);

        root.findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });
        return root;
    }

    private void initRwCities(String[] data) {
        rvCities = (RecyclerView) root.findViewById(R.id.rvCities);
        rvCities.setHasFixedSize(true);

        DividerItemDecoration itemDecoration = new DividerItemDecoration(getContext(),
                LinearLayoutManager.VERTICAL);
        itemDecoration.setDrawable(getContext().getResources().getDrawable(R.drawable.separator));
        rvCities.addItemDecoration(itemDecoration);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        rvCities.setLayoutManager(layoutManager);

        CityAdapter adapter = new CityAdapter(data);
        rvCities.setAdapter(adapter);

        adapter.SetOnItemClickListener(new CityAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                settings.setCurrentIndexOfCity(position);
                getFragmentManager().popBackStack();
            }
        });
    }
}