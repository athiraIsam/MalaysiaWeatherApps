package com.example.malaysiaweatherapps.json;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class ForecastGeneralResult {

    @SerializedName("locationid")
    String locationId;

    @SerializedName("datatype")
    String datatype;

    @SerializedName("value")
    String value;

    @SerializedName("date")
    String date;

    @SerializedName("attributes")
    WeatherAttributes attributes;


    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    public String getDatatype() {
        return datatype;
    }

    public void setDatatype(String datatype) {
        this.datatype = datatype;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public WeatherAttributes getAttributes() {
        return attributes;
    }

    public void setAttributes(WeatherAttributes attributes) {
        this.attributes = attributes;
    }
}
