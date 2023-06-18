package com.findays.findays.common.api.weather;

import com.findays.findays.common.GlobalConfig;
import com.findays.findays.common.api.weather.dto.NowWeatherRes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class WeatherService {

    private final WeatherClient weatherClient;

    public NowWeatherRes findNowWeather(double lat, double lon) {
        return weatherClient.findTodayWeather(lat, lon, GlobalConfig.APP_ID);
    }


}
