package com.example.mywheather.networking;

import com.google.gson.annotations.SerializedName;

public class WResponse {

	@SerializedName("current")
	private Current current;

	@SerializedName("location")
	private Location location;

	public Current getCurrent(){
		return current;
	}

	public Location getLocation(){
		return location;
	}

	public WeatherModel getWeather(){
		WeatherModel model = new WeatherModel(getLocation().getName(), getLocation().getRegion(), getLocation().getLocaltime(), "http:"+getCurrent().getCondition().getIcon(), (double) getCurrent().getTempC());
		return model;
	}
}