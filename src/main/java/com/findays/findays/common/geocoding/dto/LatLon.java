package com.findays.findays.common.geocoding.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@Getter
public class LatLon {
    @Schema(description ="")
    private double lat;
    @Schema(description ="")
    private double lon;
}
