package com.findays.findays.common.papago.dto;

import lombok.Getter;

@Getter
public class Result {
    private String srcLangType;
    private String tarLangType;
    private String translatedText;
    private String engineType;
}
