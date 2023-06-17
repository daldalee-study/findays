package com.findays.findays.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "좌표 값 응답DTO")
@Data
public class GeocodeResponseDto {

    @Schema(description = "위도", example = "38.9071923") // 구글 키: lat
    private String lat;

    @Schema(description = "경도", example = "-77.0368707") // 구글 키: lng
    private String lng;

    @Schema(description = "시/구", example = "District of Columbia") // 구글 키: locality
    private String secondLevelArea;

    @Schema(description = "주/도/시", example = "DC/Gyeonggi-do/Seoul") // 구글 키: administrative_area_level_1
    private String firstLevelArea;

    @Schema(description = "국가", example = "KR/US") // 구글 키: country
    private String country;

    @Schema(description = "우편번호", example = "07778") // 구글 키: postal_code
    private String zip;

    @Schema(description = "구글 주소 api 아이디", example = "ChIJ8RnGu9NEQogR_QFSGxol3Ng") // 구글 키: place_id
    private String placeId;
}
