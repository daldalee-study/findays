package com.findays.findays.common.geocoding;

import com.findays.findays.common.GlobalConfig;
import com.findays.findays.common.api.papago.PapagoTranslateService;
import com.findays.findays.common.geocoding.dto.ReversGeocodeRes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ReversGeocodingService {

    private final ReversGeocodingClient reversGeocodingClient;
    private final PapagoTranslateService papagoTranslateService;

    public ReversGeocodeRes reversGeocoding(String koRegion){
        String enRegion = papagoTranslateService.translation(koRegion);
        return reversGeocodingClient.reversGeocoding(enRegion, GlobalConfig.APP_ID, 1).get(0);
        /*
        해당 지역명을 가진 여러 국가의 해당 지역 좌표를 뽑아준다.
        여기서 limit 은 국가의 갯수를 의미하고, 나오는 순서로 보았을 때, 가장 많은 결과를 가진.
        즉, 가장 대표적이라고 생각되는 것이 최상단으로 나오고 1로 했을 때 그 최상단의 값만 나온다.
        따라서 limit 을 1로 두어 가장 많은 결과 값을 가진 대표 국가의 좌표만 가져오도록 하자.
         */
    }

}
