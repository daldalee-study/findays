package com.findays.findays.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Location {
    @Id
    @GeneratedValue
    private Long id;

    private double lat;

    private double lon;

    private String cityName;

    private String stateCode;

    private String countryCode;

    private String placeId;

}
