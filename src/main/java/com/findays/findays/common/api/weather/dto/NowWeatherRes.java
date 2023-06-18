package com.findays.findays.common.api.weather.dto;

import com.findays.findays.common.geocoding.dto.LatLon;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

import java.util.List;

@Getter
public class NowWeatherRes {

    @Schema(description ="위도, 경도")
    private LatLon coord;

    @Schema(description ="기상 조건 코드 추가 정보")
    private List<WeatherInfo> weather;

    @Schema(description ="내부 매개변수")
    private String base;

    @Schema(description ="날씨 정보")
    private MainWeather main;

    @Schema(description ="가시성/m (최대값 10km)")
    private int visibility;

    @Schema(description ="바람 정보")
    private WindInfo wind;

    @Schema(description ="흐림 정도/%")
    private CloudInfo clouds;

    @Schema(description = "데이터 계산 시간/유닉스, UTC")
    private long dt;

    @Schema(description ="기타 정보")
    private EtcInfo sys;

    @Schema(description ="시간/s (UTC -> 초로 변환)")
    private int timezone;

    @Schema(description ="지역 id")
    private int id;

    @Schema(description ="지역명")
    private String name;

    @Schema(description ="상태코드")
    private int cod;

}
