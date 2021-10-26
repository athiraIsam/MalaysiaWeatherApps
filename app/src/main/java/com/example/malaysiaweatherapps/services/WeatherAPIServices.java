package com.example.malaysiaweatherapps.services;

import com.example.malaysiaweatherapps.json.ForecastGeneralRespond;
import com.example.malaysiaweatherapps.json.ForecastGeneralResult;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;

public interface WeatherAPIServices {

        String BASE_URL = "https://api.met.gov.my/v2.1/";

        @GET("/data")
         void getResult(Callback<ForecastGeneralRespond> cb);

}
