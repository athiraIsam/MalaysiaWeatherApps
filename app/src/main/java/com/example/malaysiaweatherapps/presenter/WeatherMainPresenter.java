package com.example.malaysiaweatherapps.presenter;

import com.example.malaysiaweatherapps.contract.WeatherMainContract;
import com.example.malaysiaweatherapps.pojo.ForecastDetail;

public class WeatherMainPresenter implements WeatherMainContract.Presenter,WeatherMainContract.Model.onListener {

    private WeatherMainContract.View mainView;
    private WeatherMainContract.Model mainModel;

    public WeatherMainPresenter(WeatherMainContract.View mainView, WeatherMainContract.Model mainModel) {
        this.mainView = mainView;
        this.mainModel = mainModel;
    }

    @Override
    public void onSuccess(ForecastDetail respond) {
        if(mainView!=null)
            mainView.OnForecastGeneralResult(respond);

    }

    @Override
    public void onFailure(String error) {
        if(mainView!=null)
            mainView.onFailure(error);
    }

    @Override
    public void getGeneralForecast() {
        if(mainModel!=null)
            mainModel.getGeneralForecast(this);
    }

    @Override
    public void SetLocation(String locationId) {
            this.mainModel.SetLocation(locationId,this);
    }


    @Override
    public void onDestroy() {
        this.mainView = null;
        this.mainModel = null;
    }

}
