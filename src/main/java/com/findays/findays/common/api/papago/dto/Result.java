package com.findays.findays.common.api.papago.dto;

import lombok.Getter;

@Getter
public class Result {
    private String srcLangType;
    private String tarLangType;
    private String translatedText;
    private String engineType;
}
