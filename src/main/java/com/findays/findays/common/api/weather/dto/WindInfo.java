package com.findays.findays.common.api.weather.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@Getter
public class WindInfo {
    @Schema(description ="바람 속도")
    private double speed;

    @Schema(description ="풍향")
    private int deg;

}
