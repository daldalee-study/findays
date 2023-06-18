package com.findays.findays.util.encrypt.Jasypt;

import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JasyptConfig {

    @Bean(name = "jasyptStringEncryptor")
    public StringEncryptor stringEncryptor() {
        // Encrypter
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        // 환경 변수에 등록되어 있는 시크릿 키들
        String secretKey = System.getenv("jasyptEncodeSecretKey");
        String encodeAlgorithm = System.getenv("jasyptEncodeAlgorithm");
        // 알고리즘 및 시크릿 키 , 알고리즘 설정
        encryptor.setPassword(secretKey);
        encryptor.setAlgorithm(encodeAlgorithm);
        // Return Encrypter
        return encryptor;
    }
}
