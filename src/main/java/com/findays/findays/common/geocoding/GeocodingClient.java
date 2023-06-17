package com.findays.findays.common.geocoding;

import com.findays.findays.common.geocoding.dto.GeocodeRes;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(
    name = "ReversGeocodingClient",
    url = "http://api.openweathermap.org"
)
public interface GeocodingClient {

    @GetMapping("/geo/1.0/direct")
    List<GeocodeRes> geocoding(
        @RequestParam
        String q,
        @RequestParam
        String appId,
        @RequestParam
        int limit
    );

}
