package com.example.malaysiaweatherapps.model;


import com.example.malaysiaweatherapps.R;
import com.example.malaysiaweatherapps.contract.WeatherConstant;
import com.example.malaysiaweatherapps.contract.WeatherMainContract;
import com.example.malaysiaweatherapps.json.ForecastGeneralRespond;
import com.example.malaysiaweatherapps.json.ForecastGeneralResult;
import com.example.malaysiaweatherapps.pojo.ForecastDetail;
import com.example.malaysiaweatherapps.services.WeatherAPIServices;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import retrofit.Callback;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class WeatherMainModel implements WeatherMainContract.Model {

    private onListener listener ;
    private String todayName;
    private String locationId;

    @Override
    public void getGeneralForecast(onListener onListener) {
        this.listener = onListener;
        GetForecastRespond();
    }

    private void GetForecastRespond()
    {
        final String todayDate;
        Calendar calendar = Calendar.getInstance();
        todayDate = calendar.get(Calendar.YEAR) + "-" + ((calendar.get(Calendar.MONTH))+1) + "-" + calendar.get(Calendar.DATE) ;
        todayName = WeatherConstant.GetDayName(calendar.get(Calendar.DAY_OF_WEEK));

        RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint(WeatherAPIServices.BASE_URL).setRequestInterceptor(new RequestInterceptor() {
            @Override
            public void intercept(RequestFacade request) {
                request.addHeader(WeatherConstant.AUTHORIZATION, WeatherConstant.API_KEY);
                request.addEncodedQueryParam(WeatherConstant.GeneralForecastQuery.datasetid.name(), WeatherConstant.FORECAST);
                request.addEncodedQueryParam(WeatherConstant.GeneralForecastQuery.datacategoryid.name(),WeatherConstant.GENERAL);
                if(locationId==null)
                    locationId = "2";
                request.addEncodedQueryParam(WeatherConstant.GeneralForecastQuery.locationid.name(),"LOCATION:" + locationId);
                request.addEncodedQueryParam(WeatherConstant.GeneralForecastQuery.start_date.name(),todayDate);
                request.addEncodedQueryParam(WeatherConstant.GeneralForecastQuery.end_date.name(),todayDate);

            }
        }).setLogLevel(RestAdapter.LogLevel.FULL).build();

        WeatherAPIServices services = restAdapter.create(WeatherAPIServices.class);
        services.getResult(new Callback<ForecastGeneralRespond>() {
            @Override
            public void success(ForecastGeneralRespond forecastGeneralRespond, Response response) {
                listener.onSuccess(setForecastInformation(forecastGeneralRespond));
            }

            @Override
            public void failure(RetrofitError error) {
                listener.onFailure(error.getMessage());
            }
        });


    }

    public ForecastDetail  setForecastInformation(ForecastGeneralRespond respond) {

        ForecastDetail forecastDetail = new ForecastDetail();

        if (respond.getResults().size() != 0) {

            forecastDetail.setTodayName(todayName);
                for (ForecastGeneralResult result : respond.getResults()) {
                    {
                        switch (result.getDatatype()) {
                            case WeatherConstant.FGM:
                                forecastDetail.setMorningAttribute(result.getValue());
                                forecastDetail.setMorningImage(setAttributeImage(result.getValue()));
                                break;

                            case WeatherConstant.FGA:
                                forecastDetail.setAfterAttribute(result.getValue());
                                forecastDetail.setAfternoonImage(setAttributeImage(result.getValue()));
                                break;

                            case WeatherConstant.FGN:
                                forecastDetail.setNightAttribute(result.getValue());
                                forecastDetail.setNightImage(setAttributeImage(result.getValue()));
                                break;

                            case WeatherConstant.FMINT:
                                forecastDetail.setMinTemp(result.getValue());
                                break;

                            case WeatherConstant.FMAXT:
                                forecastDetail.setMaxTemp(result.getValue());
                                break;
                        }

                    }

                }

            }

        return forecastDetail;
    }

    private int setAttributeImage(String attributeType)
    {
        if(attributeType.contains("Sunny"))
            return R.drawable.sunny;
        else if(attributeType.contains("No Rain") || (attributeType.contains("No rain")))
            return R.drawable.sunny;
        else if(attributeType.contains("Thunderstorms") || (attributeType.contains("thunderstorms")))
             return R.drawable.thunderstorm;
        else if(attributeType.contains("Rain"))
            return R.drawable.rain;
        else if(attributeType.contains("Isolated"))
            return R.drawable.cloudy;

        return R.drawable.cloudy;
    }

    @Override
    public void SetLocation(String locationId, onListener onListener) {
        this.locationId = locationId;
        GetForecastRespond();
    }
}
