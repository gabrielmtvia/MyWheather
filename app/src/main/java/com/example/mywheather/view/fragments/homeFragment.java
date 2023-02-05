package com.example.mywheather.view.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mywheather.R;
import com.example.mywheather.adapter.RecyclerTouchListener;
import com.example.mywheather.adapter.WeatherAdapter;
import com.example.mywheather.networking.WeatherModel;
import com.example.mywheather.viewmodel.WeatherViewModel;

import java.util.List;

public class homeFragment extends Fragment {

    private RecyclerView recyclerView;
    private WeatherAdapter adapter;
    private WeatherViewModel viewModel;


    public homeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        viewModel = new ViewModelProvider(this).get(WeatherViewModel.class);

        System.out.println("viewmodel to string on home fragment "+ viewModel);

        adapter = new WeatherAdapter(viewModel.getList().getValue());
        adapter.notifyDataSetChanged();


        recyclerView = view.findViewById(R.id.RecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adapter);

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(view.getContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
            }

            @Override
            public void onLongClick(View view, int position) {
                System.out.println("int position == " + position + " getListSize == " + viewModel.getListSize());
                if(viewModel.getListSize()!=0 && position < viewModel.getListSize())
                    viewModel.removeFromList(viewModel.getList().getValue().get(position));
                adapter = new WeatherAdapter(viewModel.getList().getValue());
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        }));

        viewModel.getList().observe(getViewLifecycleOwner(), new Observer<List<WeatherModel>>() {
            @Override
            public void onChanged(List<WeatherModel> weatherModels) {
                adapter = new WeatherAdapter(viewModel.getList().getValue());
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        });

        return view;
    }


}