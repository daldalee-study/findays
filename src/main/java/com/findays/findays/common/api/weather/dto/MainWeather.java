package com.findays.findays.common.api.weather.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@Getter
public class MainWeather {
    @Schema(description ="")
    private double temp;

    @Schema(description ="")
    private double feels_like;

    @Schema(description ="")
    private double temp_min;

    @Schema(description ="")
    private double temp_max;

    @Schema(description ="")
    private int pressure;

    @Schema(description ="")
    private int humidity;
}
