package com.findays.findays.common.api.weather.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@Getter
public class CloudInfo {
    @Schema(description ="흐림 정도/%")
    private int all;
}
