package com.findays.findays.unitTest.utilTest.util.encrypt;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class JasyptEncodeTest {
    @Test
    @DisplayName("Jasypt 암호화 테스트입니다. 추후 암호화되어야하는 값이 있다면 아래 module을 사용하여 암호화 해주세요")
    public void testJasyptEncoding() {
        // Encrypter
        StandardPBEStringEncryptor encrypter = new StandardPBEStringEncryptor();
        // Secret Key & Encrypt Algorithm
        String secretKey = System.getenv("jasyptEncodeSecretKey");
        String encodeAlgorithm = System.getenv("jasyptEncodeAlgorithm");
        // Encrypter Set Secret Key & Encrypt Algorithm
        encrypter.setPassword(secretKey);
        encrypter.setAlgorithm(encodeAlgorithm);
        // encode Test 객체
        String encTestA = encrypter.encrypt("encTest");
        String encTestB = encrypter.encrypt("encTest");
        // decode 검증
        String decTestA = encrypter.decrypt(encTestA);
        String decTestB = encrypter.decrypt(encTestB);
        Assertions.assertEquals(decTestA , decTestB);
    }
}
