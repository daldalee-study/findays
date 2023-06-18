package com.findays.findays;

import com.findays.findays.common.api.weather.WeatherService;
import com.findays.findays.common.api.weather.dto.NowWeatherRes;
import com.findays.findays.common.geocoding.GeocodingService;
import com.findays.findays.common.geocoding.dto.GeocodeRes;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class TestController {

    private final GeocodingService geocodingService;
    private final WeatherService weatherService;

    @GetMapping("/test/{text}")
    public NowWeatherRes test(
        @PathVariable
        String text
    ) throws Exception {
        GeocodeRes geocodingRes = geocodingService.geocoding(text);
        double lat = geocodingRes.getLat();
        double lon = geocodingRes.getLon();
        return weatherService.findNowWeather(lat, lon);
    }

}
