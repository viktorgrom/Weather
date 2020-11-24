package com.molfar.weather.Retrofit;

import com.google.gson.annotations.SerializedName;

public class Example {

    @SerializedName("main")
    private Main main;

    @SerializedName("wind")
    private Wind wind;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @SerializedName("name")
    private String name;

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }
}
