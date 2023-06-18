package com.findays.findays.common.api.papago;

import feign.RequestInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

public class PapagoHeaderConfig {

    @Value("#{environment['naver.papago.clientId']}")
    public String clientId;//애플리케이션 클라이언트 아이디값";

    @Value("#{environment['naver.papago.clientSecret']}")
    public String clientSecret;//애플리케이션 클라이언트 시크릿값";

    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            requestTemplate.header("X-Naver-Client-Id", clientId);
            requestTemplate.header("X-Naver-Client-Secret", clientSecret);
        };
    }
}
