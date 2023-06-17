package com.findays.findays.controller;

import com.findays.findays.dto.GeocodeResponseDto;
import com.findays.findays.service.LocationService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

import org.springframework.context.annotation.PropertySource;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Tag(name= "location", description = "주소와 좌표를 상호변환할 수 있는 API")
@RestController
@RequestMapping("/api/location")
@RequiredArgsConstructor
@PropertySource("classpath:apiKey.properties")
public class LocationController {

    private final LocationService locationService;

//    @ApiResponses(value ={
//            @ApiResponse(responseCode = "200", description = "좌표 수신 성공", content = @Content(schema = @Schema(implementation = GeocodeResponseDto.class))),
//            @ApiResponse(responseCode = "404", description = "존재하지 않는 리소스 접근", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
//    })
    @GetMapping("/geocode")
    public Map<String, String> getGeo(String completeAddress) {
        return locationService.getGeo(completeAddress);
    }


}
