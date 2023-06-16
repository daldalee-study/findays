package com.findays.findays.common.papago;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@Service
public class PapagoTranslateService {

    private final PapagoTranslateImpl papagoTranslateImpl;

    private static String apiURL = "https://openapi.naver.com/v1/papago/n2mt";

    @Value("${naver.papago.clientId}")
    private String clientId;//애플리케이션 클라이언트 아이디값";

    @Value("${naver.papago.clientSecret}")
    private String clientSecret;//애플리케이션 클라이언트 시크릿값";

    public Map<String, Object> translation(String text){
//        tring clientId = "YOUR_CLIENT_ID";//애플리케이션 클라이언트 아이디값";
//        String clientSecret = "YOUR_CLIENT_SECRET";//애플리케이션 클라이언트 시크릿값";

//        String apiURL = "https://openapi.naver.com/v1/papago/n2mt";
//        String text;
        try {
            text = URLEncoder.encode(text, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("인코딩 실패", e);
        }

        System.out.println(clientId);
        System.out.println(clientSecret);

        Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("X-Naver-Client-Id", clientId);
        requestHeaders.put("X-Naver-Client-Secret", clientSecret);

        String responseBody = papagoTranslateImpl.post(apiURL, requestHeaders, text);

        System.out.println(responseBody);
        Gson gson = new Gson();
//        PapagoTranslationRes r = gson.fromJson(responseBody, PapagoTranslationRes.class);
        Map<String, Object> gsonMap = gson.fromJson(responseBody, new TypeToken<Map<String, Object>>(){}.getType());
        //todo : 이렇게 맵으로 하니까 json 형태로 잘나옴 ! 이렇게 변환한다음 translatedText 뽑아내면 될듯.

        return gsonMap;
//        return papagoTranslateImpl.post(apiURL, requestHeaders, text);
    }


}
