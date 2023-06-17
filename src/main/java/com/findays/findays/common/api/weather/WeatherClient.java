package com.findays.findays.common.api.weather;

import com.findays.findays.common.api.weather.dto.NowWeatherRes;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(
    name = "WeatherClient",
    url = "https://api.openweathermap.org"
)
public interface WeatherClient {

    @GetMapping("/data/2.5/weather")
    public NowWeatherRes findTodayWeather(
        @RequestParam
        Double lat,
        @RequestParam
        Double lon,
        @RequestParam
        String appid
    );

}
