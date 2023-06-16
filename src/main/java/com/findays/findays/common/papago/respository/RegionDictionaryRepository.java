package com.findays.findays.common.papago.respository;

import com.findays.findays.common.papago.model.RegionDictionary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RegionDictionaryRepository extends JpaRepository<RegionDictionary, Long> {
    Optional<RegionDictionary> findByKoRegion(String koRegion);
}
