package com.findays.findays.common.api.weather.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@Getter
public class MainWeather {
    @Schema(description ="온도")
    private double temp;

    @Schema(description ="날씨에 대한 인간의 인식 값")
    private double feels_like;

    @Schema(description ="현재 최저 기온")
    private double temp_min;

    @Schema(description ="현재 최고 기온")
    private double temp_max;

    @Schema(description ="대기압")
    private int pressure;

    @Schema(description ="습도/%")
    private int humidity;
}
