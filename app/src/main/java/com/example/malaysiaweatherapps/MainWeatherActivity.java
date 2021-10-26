package com.example.malaysiaweatherapps;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.malaysiaweatherapps.contract.WeatherConstant;
import com.example.malaysiaweatherapps.contract.WeatherMainContract;
import com.example.malaysiaweatherapps.model.WeatherMainModel;
import com.example.malaysiaweatherapps.pojo.ForecastDetail;
import com.example.malaysiaweatherapps.presenter.WeatherMainPresenter;

public class MainWeatherActivity extends AppCompatActivity implements WeatherMainContract.View {

    private WeatherMainPresenter presenter;
    private TextView todayName,minTemp,maxTemp,morAtt,aftAtt,nightAtt;
    private ImageView morImage,aftImage,nightImage;
    private Spinner selectLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        todayName = findViewById(R.id.todayName);
        minTemp = findViewById(R.id.todayMinTemp);
        maxTemp = findViewById(R.id.todayMaxTemp);
        morAtt = findViewById(R.id.morningAttribute);
        aftAtt = findViewById(R.id.afternoonAttribute);
        nightAtt = findViewById(R.id.nightAttribute);
        selectLocation = findViewById(R.id.selectLocation);
        morImage = findViewById(R.id.morningImage);
        aftImage = findViewById(R.id.afternoonImage);
        nightImage = findViewById(R.id.nightImage);

        hideComponent();

        this.presenter = new WeatherMainPresenter(this,new WeatherMainModel());
        this.presenter.getGeneralForecast();

        ArrayAdapter locationAdapter = new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item, WeatherConstant.GetAllLocations().values().toArray());
        selectLocation.setAdapter(locationAdapter);
        selectLocation.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String locationId = String.valueOf(WeatherConstant.GetAllLocations().keySet().toArray()[i]);
                presenter.SetLocation(locationId);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
    @Override
    public void OnForecastGeneralResult(ForecastDetail forecastDetails) {

        if(forecastDetails!=null) {
            showComponent();
            minTemp.setText(forecastDetails.getMinTemp());
            maxTemp.setText(forecastDetails.getMaxTemp());
            morAtt.setText(forecastDetails.getMorningAttribute());
            aftAtt.setText(forecastDetails.getAfterAttribute());
            nightAtt.setText(forecastDetails.getNightAttribute());
            todayName.setText(forecastDetails.getTodayName());
            morImage.setImageResource(0);
            aftImage.setImageResource(0);
            nightImage.setImageResource(0);
            morImage.setImageResource(forecastDetails.getMorningImage());
            aftImage.setImageResource(forecastDetails.getAfternoonImage());
            nightImage.setImageResource(forecastDetails.getNightImage());
        }

    }

    private void hideComponent()
    {
        todayName.setVisibility(View.GONE);
        minTemp.setVisibility(View.GONE);
        maxTemp.setVisibility(View.GONE);
        morAtt.setVisibility(View.GONE);
        aftAtt.setVisibility(View.GONE);
        nightAtt.setVisibility(View.GONE);
        selectLocation.setVisibility(View.GONE);
        morImage.setVisibility(View.GONE);
        aftImage.setVisibility(View.GONE);
        nightImage.setVisibility(View.GONE);
    }
    private void showComponent()
    {
        todayName.setVisibility(View.VISIBLE);
        minTemp.setVisibility(View.VISIBLE);
        maxTemp.setVisibility(View.VISIBLE);
        morAtt.setVisibility(View.VISIBLE);
        aftAtt.setVisibility(View.VISIBLE);
        nightAtt.setVisibility(View.VISIBLE);
        selectLocation.setVisibility(View.VISIBLE);
        morImage.setVisibility(View.VISIBLE);
        aftImage.setVisibility(View.VISIBLE);
        nightImage.setVisibility(View.VISIBLE);
    }

    @Override
    public void onFailure(String error) {
        Toast.makeText(this,error,Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }
}
