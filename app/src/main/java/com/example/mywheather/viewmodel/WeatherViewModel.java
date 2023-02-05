package com.example.mywheather.viewmodel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mywheather.database.OfflineRepository;
import com.example.mywheather.networking.WeatherModel;
import com.example.mywheather.networking.WeatherRepository;

import java.util.ArrayList;
import java.util.List;

public class WeatherViewModel extends AndroidViewModel {

    private WeatherRepository repository;
    private OfflineRepository offlineRepository;


    public WeatherViewModel(Application app){
        super(app);
        offlineRepository = OfflineRepository.getInstance(app);
        repository = WeatherRepository.getInstance();
    }

    public LiveData<WeatherModel> getSearchedWeather(){
        return repository.getSearchedWeatherData();
    }

    public void searchForWeatherInCity(String city){
        repository.searchWeatherData(city);
    }

    public LiveData<List<WeatherModel>> getList(){
        return offlineRepository.getListLiveData();
    }

    public int getListSize(){
        return offlineRepository.getListLiveData().getValue().size();
    }

    public void addToList(WeatherModel model){
        offlineRepository.insert(model);
    }

    public void removeFromList(WeatherModel model){
        offlineRepository.delete(model);
    }

}
