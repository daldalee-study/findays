package com.findays.findays.common.geocoding.dto;

import lombok.Getter;

@Getter
public class ReversGeocodeRes {
    private String name;
//    private LocalName local_names;
    private double lat;
    private double lon;
}
