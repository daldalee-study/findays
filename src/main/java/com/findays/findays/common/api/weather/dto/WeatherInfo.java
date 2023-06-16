package com.findays.findays.common.api.weather.dto;

import lombok.Getter;

@Getter
public class WeatherInfo {

    private int id;
    private String main;
    private String description;
    private String icon;
}
