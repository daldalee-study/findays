package com.findays.findays.common.api.papago;

import com.findays.findays.common.api.papago.dto.PapagoReq;
import com.findays.findays.common.api.papago.dto.PapagoRes;
import com.findays.findays.common.api.papago.model.RegionDictionary;
import com.findays.findays.common.api.papago.respository.RegionDictionaryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Slf4j
@RequiredArgsConstructor
@Service
public class PapagoTranslateService {

    private final RegionDictionaryRepository regionDictionaryRepository;
    private final PapagoTranslateClient papagoTranslateClient;

    public RegionDictionary translation(String text) throws Exception {
        return regionDictionaryRepository
            .findByKoRegion(text)
            .orElse(regionTranslation2(text));
    }

    public RegionDictionary regionTranslation2(String text) throws Exception {
        try {
            PapagoRes response =
                papagoTranslateClient.translation(
                    new PapagoReq(
                        "ko",
                        "en",
                        text
                    )
                );
            return new RegionDictionary(
                response.getMessage().getResult().getTranslatedText(),
                text
            );
        } catch (Exception e){
            log.error("Translation Fail");
            log.error(Arrays.toString(e.getStackTrace()));
            throw new Exception("실패~");
        }
    }

}
