package com.findays.findays.common.api.weather.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@Getter
public class WeatherInfo {
    @Schema(description ="날씨 조건 id")
    private int id;

    @Schema(description ="날씨 매개번수 그룹(눈, 비 등)")
    private String main;

    @Schema(description ="그룹 내 기상 조건")
    private String description;

    @Schema(description ="날씨 아이콘 id")
    private String icon;
}
