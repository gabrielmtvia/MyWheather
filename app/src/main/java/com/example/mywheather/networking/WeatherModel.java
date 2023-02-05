package com.example.mywheather.networking;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Objects;

@Entity(tableName = "home_table")
public class WeatherModel {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private String region;
    private String date;
    private String icon;
    private double code;

    public WeatherModel(String name, String region, String date, String icon, double code) {
        this.name = name;
        this.region = region;
        this.date = date;
        this.icon = icon;
        this.code = code;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public double getCode() {
        return code;
    }

    public void setCode(double code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "WeatherModel{" +
                "name='" + name + '\'' +
                ", region='" + region + '\'' +
                ", Date='" + date + '\'' +
                ", icon='" + icon + '\'' +
                ", code=" + code +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WeatherModel)) return false;
        WeatherModel that = (WeatherModel) o;
        return getName().equals(that.getName()) && getRegion().equals(that.getRegion()) && getDate().equals(that.getDate()) && getIcon().equals(that.getIcon());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getRegion(), getDate(), getIcon());
    }
}