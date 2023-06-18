package com.findays.findays.unitTest.utilTest.util.encrypt;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class TestValueDecryptModule {
    // Secret Key & Encrypt Algorithm
    static String secretKey = System.getenv("jasyptEncodeSecretKey");
    static String encodeAlgorithm = System.getenv("jasyptEncodeAlgorithm");
    public static String decryptTestValue(String encryptedValue) {
        StandardPBEStringEncryptor encrypter = new StandardPBEStringEncryptor();

        // 알고리즘 및 시크릿 키 , 알고리즘 설정
        encrypter.setPassword(secretKey);
        encrypter.setAlgorithm(encodeAlgorithm);
        return encrypter.decrypt(encryptedValue);
    }
}
