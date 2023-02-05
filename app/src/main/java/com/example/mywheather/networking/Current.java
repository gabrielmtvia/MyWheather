package com.example.mywheather.networking;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class Current{

	@SerializedName("uv")
	private Object uv;

	@SerializedName("condition")
	private Condition condition;

	@SerializedName("temp_c")
	private Object tempC;

	public Object getUv(){
		return uv;
	}

	public Condition getCondition(){
		return condition;
	}

	public Object getTempC(){
		return tempC;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Current)) return false;
		Current current = (Current) o;
		return getUv().equals(current.getUv()) && getCondition().equals(current.getCondition()) && getTempC().equals(current.getTempC());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getUv(), getCondition(), getTempC());
	}
}