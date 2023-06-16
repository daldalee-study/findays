package com.findays.findays.common;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class GlobalConfig {

    public static String APP_ID;

    @Value("#{environment['weather.appId']}")
    public void setAppId(String value){
        APP_ID = value;
    }


}
