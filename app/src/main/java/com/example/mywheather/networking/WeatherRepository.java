package com.example.mywheather.networking;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.internal.EverythingIsNonNull;

public class WeatherRepository {

    private static WeatherRepository instance;
    private final MutableLiveData<WeatherModel> searchedWeatherData;

    public WeatherRepository() {
        searchedWeatherData = new MutableLiveData<>();
    }

    public static synchronized WeatherRepository getInstance(){
        if(instance == null){
            instance = new WeatherRepository();
        }
        return instance;
    }

    public LiveData<WeatherModel> getSearchedWeatherData(){
        return searchedWeatherData;
    }

    public void searchWeatherData(String city){
        WeatherApi weatherApi = ServiceGenerator.getWeatherApi();
        Call<WResponse> call = weatherApi.getWeather(WeatherApi.API_KEY, city);
        call.enqueue(new Callback<WResponse>() {
            @EverythingIsNonNull
            @Override
            public void onResponse(Call<WResponse> call, Response<WResponse> response) {
                if(response.isSuccessful()){
                    searchedWeatherData.setValue(response.body().getWeather());
                }
            }
            @EverythingIsNonNull
            @Override
            public void onFailure(Call<WResponse> call, Throwable t) {
                Log.i("Retrofit", "Something went wrong >>(");
            }
        });
    }


}
