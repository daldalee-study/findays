package com.findays.findays.common.geocoding;

import com.findays.findays.common.geocoding.dto.ReversGeocodeRes;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(
    name = "ReversGeocodingClient",
    url = "http://api.openweathermap.org"
)
public interface ReversGeocodingClient {

    @GetMapping("/geo/1.0/direct")
    List<ReversGeocodeRes> reversGeocoding(
        @RequestParam
        String q,
        @RequestParam
        String appId,
        @RequestParam
        int limit
    );

}
