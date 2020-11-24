package com.molfar.weather;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.molfar.weather.Retrofit.ApiClient;
import com.molfar.weather.Retrofit.ApiInterface;
import com.molfar.weather.Retrofit.Example;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    ImageView seach;
    TextView tempText, descText, humidityText, windSpeedText, cityNameText, pressureText;
    EditText textField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seach = (ImageView) findViewById(R.id.search);
        tempText = (TextView) findViewById(R.id.temp_text);
        descText = (TextView) findViewById(R.id.desc_text);
        windSpeedText = (TextView) findViewById(R.id.wind_speed_text);
        humidityText = (TextView) findViewById(R.id.humidity_text);
        cityNameText = (TextView) findViewById(R.id.city_text);
        pressureText = (TextView) findViewById(R.id.pressure_text);
        textField = (EditText) findViewById(R.id.text_field);

        seach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getWeatherData(textField.getText().toString().trim());

            }
        });


    }

    private void getWeatherData(String name){
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);

        Call<Example> call = apiInterface.getWeatherData(name);

        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {

                tempText.setText("Темп:"+ " " +response.body().getMain().getTemp()+" C.");
                descText.setText("Відчувається як:"+ " " +response.body().getMain().getFeels_like()+" C.");
                humidityText.setText("Вологысть:"+ " " +response.body().getMain().getHumidity());
                windSpeedText.setText("Вітер:" + "" + response.body().getWind().getSpeed()+" м/c");
                cityNameText.setText(response.body().getName());
                pressureText.setText("Тиск:"+ " " +response.body().getMain().getPressure()+" Па");


            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {

            }
        });
    }



}