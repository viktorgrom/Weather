package com.molfar.weather.Retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("weather?id=2172797&appid=ca3bf5086fc6da6305561df31a414245&units=metric")
    Call<Example> getWeatherData(@Query("q") String name);

}
