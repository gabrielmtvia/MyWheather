package com.example.mywheather.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.mywheather.dao.WeatherDAO;
import com.example.mywheather.networking.WeatherModel;

@Database(entities={WeatherModel.class}, version = 1)
public abstract class WeatherDatabase extends RoomDatabase {

    private static WeatherDatabase instance;
    public abstract WeatherDAO weatherDao();

    public static synchronized WeatherDatabase getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    WeatherDatabase.class, "weather_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}
