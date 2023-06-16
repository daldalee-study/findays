package com.findays.findays.common.api.weather.dto;

import com.findays.findays.common.geocoding.dto.LatLon;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import org.hibernate.annotations.Comment;

import java.util.List;

@Getter
public class NowWeatherRes {

    @Schema(description ="")
    private LatLon coord;

    @Schema(description ="")
    private List<WeatherInfo> weather;

    @Schema(description ="")
    private String base;

    @Schema(description ="")
    private MainWeather main;

    @Schema(description ="")
    private int visibility;

    @Schema(description ="")
    private WindInfo wind;

    @Schema(description ="")
    private CloudInfo clouds;

    @Schema(description = "데이터 계산 시간/유닉스, UTC")
    private long dt;

    @Schema(description ="")
    private EtcInfo sys;

    @Schema(description ="")
    private int timezone;

    @Schema(description ="지역 id")
    private int id;

    @Schema(description ="지역명")
    private String name;

    @Schema(description ="")
    private int cod;

}
