package com.example.malaysiaweatherapps.json;

import com.google.gson.annotations.SerializedName;

public class WeatherAttributes {

    @SerializedName("code")
    String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
