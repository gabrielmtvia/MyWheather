package com.example.mywheather.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.mywheather.networking.WeatherModel;

import java.util.List;

@Dao
public interface WeatherDAO {
    @Insert
    void insert(WeatherModel model);

    @Delete
    void delete(WeatherModel model);

    @Query("SELECT * FROM home_table ORDER BY id ASC")
    LiveData<List<WeatherModel>> getAll();

}
