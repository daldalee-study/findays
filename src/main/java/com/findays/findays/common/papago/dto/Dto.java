package com.findays.findays.common.papago.dto;

public class Dto {
    private String source = "ko";
    private String target="en";
    private String text = "";

    public Dto(String text){
        this.text = text;
    }
}
