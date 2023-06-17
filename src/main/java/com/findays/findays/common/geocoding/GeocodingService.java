package com.findays.findays.common.geocoding;

import com.findays.findays.common.GlobalConfig;
import com.findays.findays.common.api.papago.PapagoTranslateService;
import com.findays.findays.common.api.papago.model.RegionDictionary;
import com.findays.findays.common.geocoding.dto.GeocodeRes;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Slf4j
@RequiredArgsConstructor
@Service
public class GeocodingService {

    private final GeocodingClient reversGeocodingClient;
    private final PapagoTranslateService papagoTranslateService;

    public GeocodeRes geocoding(String koRegion) {
        RegionDictionary regionDictionary = papagoTranslateService.translation(koRegion);
        return regionDictionary.getLat() == 0.0 ?
            newGeocoding(regionDictionary) : new GeocodeRes(regionDictionary);
        /*
        해당 지역명을 가진 여러 국가의 해당 지역 좌표를 뽑아준다.
        여기서 limit 은 국가의 갯수를 의미하고, 나오는 순서로 보았을 때, 가장 많은 결과를 가진.
        즉, 가장 대표적이라고 생각되는 것이 최상단으로 나오고 1로 했을 때 그 최상단의 값만 나온다.
        따라서 limit 을 1로 두어 가장 많은 결과 값을 가진 대표 국가의 좌표만 가져오도록 하자.
         */
    }

    @Transactional(rollbackOn = Exception.class)
    public GeocodeRes newGeocoding (RegionDictionary regionDictionary){
        try{
            GeocodeRes geocodeRes =
                reversGeocodingClient
                    .geocoding(regionDictionary.getEnRegion(), GlobalConfig.APP_ID, 1).get(0);
            regionDictionary.addCoordinate(geocodeRes.getLat(), geocodeRes.getLon());
            return geocodeRes;
        } catch (Exception e){
            log.error("Fail geocoding");
            log.error(Arrays.toString(e.getStackTrace()));
            return null;
        }
    }

}
