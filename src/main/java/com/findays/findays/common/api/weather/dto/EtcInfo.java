package com.findays.findays.common.api.weather.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@Getter
public class EtcInfo {
    private int id;
    private int type;

    @Schema(description ="국가 코드(GB, JP 등)")
    private String country;

    @Schema(description ="일출 시간/유닉스, UTC")
    private long sunrise;

    @Schema(description ="일몰 시간/유닉스, UTC")
    private long sunset;

}
