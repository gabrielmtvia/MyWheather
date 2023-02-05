package com.example.mywheather.networking;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class Location{

	@SerializedName("localtime")
	private String localtime;

	@SerializedName("country")
	private String country;

	@SerializedName("localtime_epoch")
	private int localtimeEpoch;

	@SerializedName("name")
	private String name;

	@SerializedName("lon")
	private Object lon;

	@SerializedName("region")
	private String region;

	@SerializedName("lat")
	private Object lat;

	@SerializedName("tz_id")
	private String tzId;

	public String getLocaltime(){
		return localtime;
	}

	public String getCountry(){
		return country;
	}

	public int getLocaltimeEpoch(){
		return localtimeEpoch;
	}

	public String getName(){
		return name;
	}

	public Object getLon(){
		return lon;
	}

	public String getRegion(){
		return region;
	}

	public Object getLat(){
		return lat;
	}

	public String getTzId(){
		return tzId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Location)) return false;
		Location location = (Location) o;
		return getLocaltimeEpoch() == location.getLocaltimeEpoch() && getLocaltime().equals(location.getLocaltime()) && getCountry().equals(location.getCountry()) && getName().equals(location.getName()) && getLon().equals(location.getLon()) && getRegion().equals(location.getRegion()) && getLat().equals(location.getLat()) && getTzId().equals(location.getTzId());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getLocaltime(), getCountry(), getLocaltimeEpoch(), getName(), getLon(), getRegion(), getLat(), getTzId());
	}
}