package com.findays.findays.common.api.weather.dto;

import lombok.Getter;

@Getter
public class MainWeather {
    private double temp;
    private double feels_like;
    private double temp_min;
    private double temp_max;
    private int pressure;
    private int humidity;
}
