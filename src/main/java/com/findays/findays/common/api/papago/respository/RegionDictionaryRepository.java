package com.findays.findays.common.api.papago.respository;

import com.findays.findays.common.api.papago.model.RegionDictionary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RegionDictionaryRepository extends JpaRepository<RegionDictionary, Long> {
    Optional<RegionDictionary> findByKoRegion(String koRegion);
}
