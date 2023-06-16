package com.findays.findays.common.api.weather.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@Getter
public class WeatherInfo {
    @Schema(description ="")
    private int id;

    @Schema(description ="")
    private String main;

    @Schema(description ="")
    private String description;

    @Schema(description ="")
    private String icon;
}
