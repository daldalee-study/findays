package com.findays.findays;

import com.findays.findays.common.GlobalConfig;
import com.findays.findays.common.api.weather.WeatherClient;
import com.findays.findays.common.api.weather.dto.NowWeatherRes;
import com.findays.findays.common.geocoding.ReversGeocodingService;
import com.findays.findays.common.geocoding.dto.ReversGeocodeRes;
import com.findays.findays.common.papago.PapagoTranslateService;
import com.findays.findays.common.papago.model.RegionDictionary;
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

    @GetMapping("/test/{x}")
    public Object test(
        @PathVariable
        String x
    ){
        ReversGeocodeRes t = reversGeocodingService.reversGeocoding(x);
        double l = t.getLat();
        System.out.println(l);
        double i = t.getLon();
        System.out.println(i);
        return weatherClient.findTodayWeather(
            l,
            i,
            GlobalConfig.APP_ID
        );
    }

}
