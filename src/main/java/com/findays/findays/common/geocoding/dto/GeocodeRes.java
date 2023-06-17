package com.findays.findays.common.geocoding.dto;

import com.findays.findays.common.api.papago.model.RegionDictionary;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class GeocodeRes {
    @Schema(description ="지역명")
    private String name;

    @Schema(description ="위도")
    private double lat;

    @Schema(description ="경도")
    private double lon;

    public GeocodeRes (RegionDictionary regionDictionary){
        this.name = regionDictionary.getEnRegion();
        this.lat = regionDictionary.getLat();
        this.lon = regionDictionary.getLon();
    }
}
