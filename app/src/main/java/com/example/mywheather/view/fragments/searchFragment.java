package com.example.mywheather.view.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.mywheather.R;
import com.example.mywheather.adapter.RecyclerTouchListener;
import com.example.mywheather.adapter.WeatherAdapter;
import com.example.mywheather.networking.WeatherModel;
import com.example.mywheather.viewmodel.WeatherViewModel;

import java.util.ArrayList;
import java.util.List;

public class searchFragment extends Fragment {

    private EditText editText;
    private WeatherViewModel viewModel;
    private RecyclerView recyclerView;
    private List<WeatherModel> list = new ArrayList<>();


    public searchFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        viewModel = new ViewModelProvider(this).get(WeatherViewModel.class);
        editText = view.findViewById(R.id.searchCity);
        recyclerView = view.findViewById(R.id.RecyclerView2);

        WeatherAdapter adapter = new WeatherAdapter(list);

        Button button = view.findViewById(R.id.button);

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(view.getContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
            }

            @Override
            public void onLongClick(View view, int position) {
                viewModel.addToList(list.get(position));
            }
        }));

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchCityWeather(view);
                viewModel.getSearchedWeather().observe(getViewLifecycleOwner(), new Observer<WeatherModel>() {
                    @Override
                    public void onChanged(WeatherModel weatherModel) {
                        if(!list.contains(weatherModel))
                            list.add(weatherModel);
                        recyclerView.setAdapter(adapter);
                        adapter.notifyDataSetChanged();
                        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext(), LinearLayoutManager.VERTICAL, false));
                    }
                });
            }
        });

        return view;
    }


    public void searchCityWeather(View view){
        viewModel.searchForWeatherInCity(editText.getText().toString());
    }

}