package com.findays.findays.common.api.weather.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@Getter
public class WindInfo {
    @Schema(description ="")
    private double speed;

    @Schema(description ="")
    private int deg;

}
