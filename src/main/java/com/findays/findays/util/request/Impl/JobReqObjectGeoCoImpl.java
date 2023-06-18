package com.findays.findays.util.request.Impl;

import com.findays.findays.util.request.JobRequestObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;


@Component
public class JobReqObjectGeoCoImpl implements JobRequestObject {
    @Value("${geocoding.secret-key}")
    String secretKey;
    private String address = "";

    @Override
    public Map<String, String> getFieldValues() {
        Map<String, String> filedValue = new HashMap<>();
        filedValue.put("address" , this.address);
        filedValue.put("secretKey" , this.secretKey);
        return filedValue;
    }

    @Override
    public void setFieldValues(Map<String, String> fieldValue) {
        this.address = fieldValue.get("address");
    }
}