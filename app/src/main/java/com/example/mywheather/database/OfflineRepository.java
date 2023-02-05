package com.example.mywheather.database;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;

import androidx.core.os.HandlerCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;

import com.example.mywheather.dao.WeatherDAO;
import com.example.mywheather.networking.WeatherModel;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class OfflineRepository {

    private WeatherDAO weatherDao;
    private LiveData<List<WeatherModel>> listLiveData;
    private ExecutorService executorService;
    //private Handler mainThreadHandler;
    private static OfflineRepository instance;

    private OfflineRepository(Application application){
        WeatherDatabase database = WeatherDatabase.getInstance(application);
        weatherDao = database.weatherDao();
        executorService = Executors.newFixedThreadPool(2);
        //mainThreadHandler = HandlerCompat.createAsync(Looper.getMainLooper());
        listLiveData = weatherDao.getAll();
    }

    public static synchronized OfflineRepository getInstance(Application application){
        if(instance == null)
            instance = new OfflineRepository(application);

        return instance;
    }

    public LiveData<List<WeatherModel>> getListLiveData(){
        return listLiveData;
    }

    public void insert(WeatherModel model){
        executorService.execute(()->weatherDao.insert(model));
        System.out.println("INSERTED MODEL IN DATABASE " + model.toString() +"  ");
    }

    public void delete(WeatherModel model){
        executorService.execute(()-> weatherDao.delete(model));
    }





}
