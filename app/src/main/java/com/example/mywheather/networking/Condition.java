package com.example.mywheather.networking;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class Condition{

	@SerializedName("code")
	private int code;

	@SerializedName("icon")
	private String icon;

	public int getCode(){
		return code;
	}

	public String getIcon(){
		return icon;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Condition)) return false;
		Condition condition = (Condition) o;
		return getCode() == condition.getCode() && getIcon().equals(condition.getIcon());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getCode(), getIcon());
	}
}