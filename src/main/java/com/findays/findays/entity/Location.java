package com.findays.findays.entity;

import com.findays.findays.dto.GeocodeResponseDto;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@Getter
@RequiredArgsConstructor
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Schema(description = "위도", example = "38.9071923")
    private String lat;

    @Schema(description = "경도", example = "-77.0368707")
    private String lng;

    @Schema(description = "시/구", example = "District of Columbia")
    private String secondLevelArea;

    @Schema(description = "주/도/시", example = "DC/Gyeonggi-do/Seoul")
    private String firstLevelArea;

    @Schema(description = "국가코드", example = "KR/US")
    private String countryCode;

    @Schema(description = "구글 주소 api 아이디", example = "ChIJ8RnGu9NEQogR_QFSGxol3Ng")
    private String placeId;

    @Schema(description = "우편번호", example = "07778")
    private String zip;


    public Location(GeocodeResponseDto geocodeResponseDto) {
        this.lat = geocodeResponseDto.getLat();
        this.lng = geocodeResponseDto.getLng();
        this.secondLevelArea = geocodeResponseDto.getSecondLevelArea();
        this.firstLevelArea = geocodeResponseDto.getFirstLevelArea();
        this.countryCode = geocodeResponseDto.getCountry();
        this.placeId = geocodeResponseDto.getPlaceId();
        this.zip = geocodeResponseDto.getZip();
    }
}
