package com.findays.findays.common.api.weather.dto;

import com.findays.findays.common.geocoding.dto.LatLon;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import org.hibernate.annotations.Comment;

import java.util.List;

@Getter
public class NowWeatherRes {
    private LatLon coord;
    private List<WeatherInfo> weather;

    private String base;

    private MainWeather main;

    private int visibility;

    private WindInfo wind;

    private CloudInfo clouds;

    @Schema(description = "데이터 계산 시간/유닉스, UTC")
    private long dt;

    private EtcInfo sys;

    private int timezone;
    @Schema(description ="지역 id")
    private int id;

    @Schema(description ="지역명")
    private String name;
    private int cod;

}
