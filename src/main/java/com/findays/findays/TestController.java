package com.findays.findays;

import com.findays.findays.common.GlobalConfig;
import com.findays.findays.common.api.weather.WeatherClient;
import com.findays.findays.common.geocoding.ReversGeocodingService;
import com.findays.findays.common.geocoding.dto.ReversGeocodeRes;
import com.findays.findays.common.api.papago.PapagoTranslateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class TestController {

    private final PapagoTranslateService papagoTranslateService;
    private final ReversGeocodingService reversGeocodingService;
    private final WeatherClient weatherClient;

    @GetMapping("/test/{text}")
    public Object test(
        @PathVariable
        String text
    ){
        ReversGeocodeRes geocodingRes = reversGeocodingService.reversGeocoding(text);
        double lat = geocodingRes.getLat();
        double lon = geocodingRes.getLon();
        return weatherClient.findTodayWeather(
            lat,
            lon,
            GlobalConfig.APP_ID
        );
    }

}
