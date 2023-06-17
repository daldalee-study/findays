package com.findays.findays.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.function.Supplier;

@Component
public class GlobalConfig {

    public static String APP_ID;

    @Value("#{environment['weather.appId']}")
    public void setAppId(String value){
        APP_ID = value;
    }


}
