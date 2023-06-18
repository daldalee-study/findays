package com.findays.findays.common.api.papago.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
public class RegionDictionary {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String enRegion;

    @Column(nullable = false)
    private String koRegion;

    @Column(nullable = false)
    private double lat = 0.0;

    @Column(nullable = false)
    private double lon = 0.0;

    public RegionDictionary(String enRegion, String koRegion){
        this.enRegion = enRegion;
        this.koRegion = koRegion;
    }

    public void addCoordinate(double lat, double lon){
        this.lat = lat;
        this.lon = lon;
    }
}


