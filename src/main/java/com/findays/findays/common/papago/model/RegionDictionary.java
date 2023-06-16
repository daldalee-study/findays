package com.findays.findays.common.papago.model;

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

    public RegionDictionary(String enRegion, String koRegion){
        this.enRegion = enRegion;
        this.koRegion = koRegion;
    }
}


