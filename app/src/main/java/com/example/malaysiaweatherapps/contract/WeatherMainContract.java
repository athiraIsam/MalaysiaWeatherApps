package com.example.malaysiaweatherapps.contract;

import com.example.malaysiaweatherapps.json.ForecastGeneralRespond;
import com.example.malaysiaweatherapps.pojo.ForecastDetail;

import java.util.List;

public interface WeatherMainContract {

    interface View{
        void OnForecastGeneralResult(ForecastDetail forecastDetails);
        void onFailure(String error);
    }
    interface Model {
        interface onListener{
            void onSuccess(ForecastDetail forecastDetails);
            void onFailure(String error);
        }
        void getGeneralForecast(Model.onListener onListener);
        void SetLocation(String locationId,Model.onListener onListener);
    }

    interface Presenter {
        void getGeneralForecast();
        void SetLocation(String locationId);
        void onDestroy();
    }
}

