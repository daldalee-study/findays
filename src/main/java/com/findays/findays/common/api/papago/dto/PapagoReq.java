package com.findays.findays.common.api.papago.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class PapagoReq {
    private String source;
    private String target;
    private String text;

    public PapagoReq(String source, String target, String text){
        this.source = source;
        this.target = target;
        this.text = text;
    }
}
