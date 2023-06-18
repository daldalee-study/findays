package com.findays.findays.util.request.Impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.findays.findays.util.request.JobRequestObject;
import com.findays.findays.util.request.JobRequestService;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class JobReqServiceGeoCoImpl implements JobRequestService {
    // TODO : DI Model로 리팩터 (secretkey @value 의존성 주입 못하는 이슈)
    @Qualifier("JobReqObjectGeoCoImpl")
    private final JobRequestObject jobRequestObjectGeoLoc;

//    @Override
//    public <T extends JobRequestObject> void setJobRequestObject(T _jobRequestObject) {
//        this.jobRequestObjectGeoLoc = _jobRequestObject;
//    }

    @Override
    public ResponseEntity sendRequest() {
        Map<String, String> objectFieldMap = jobRequestObjectGeoLoc.getFieldValues();
        // Set GeoApiConfig
        GeoApiContext context = new GeoApiContext.Builder()
                .apiKey(objectFieldMap.get("secretKey"))
                .build();
        // Send Geo API [GET] https://maps.googleapis.com/maps/api/geocode/json
        GeocodingResult[] results = new GeocodingResult[0];
        JsonNode resJson = null;

        try {
            results = GeocodingApi.geocode(context, "서울특별시 강남구 삼성로86길 26").await();
            // Response Convert
            resJson = new ObjectMapper().valueToTree(results);
            return new ResponseEntity(resJson , HttpStatus.OK);
        } catch (ApiException | InterruptedException | IOException geoException) {
            return new ResponseEntity(resJson , HttpStatus.OK);
        }
    }
}