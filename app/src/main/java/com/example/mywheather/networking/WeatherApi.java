package com.example.mywheather.networking;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface WeatherApi {

    String BASE_URL = "http://api.weatherapi.com/v1/";
    String API_KEY = "74e90cad699345dba18202905233001";

    @GET("current.json")
    Call<WResponse> getWeather(@Query("key") String key, @Query("q") String city);
}
