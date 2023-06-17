package com.findays.findays.common.api.papago;

import com.findays.findays.common.api.papago.model.RegionDictionary;
import com.findays.findays.common.api.papago.respository.RegionDictionaryRepository;
import com.findays.findays.common.api.papago.dto.PapagoRes;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Slf4j
@RequiredArgsConstructor
@Service
public class PapagoTranslateService {

    private final PapagoTranslateImpl papagoTranslateImpl;
    private final RegionDictionaryRepository regionDictionaryRepository;

    public RegionDictionary translation(String text){
        return regionDictionaryRepository
            .findByKoRegion(text)
            .orElse(regionTranslation(text));
    }

    public RegionDictionary regionTranslation(String text){
        try {
            text = URLEncoder.encode(text, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("인코딩 실패", e);
        }

        String responseBody = papagoTranslateImpl.post(text);

        Gson gson = new Gson();
        PapagoRes gsonMap = gson.fromJson(responseBody, PapagoRes.class);
        System.out.println(gsonMap);
        System.out.println(gsonMap.getMessage().getResult().getTranslatedText());

        RegionDictionary newRegion =
            new RegionDictionary(
                gsonMap
                    .getMessage()
                    .getResult()
                    .getTranslatedText(),
                text
            );

        regionDictionaryRepository.save(newRegion);

        return newRegion;
    }
}
