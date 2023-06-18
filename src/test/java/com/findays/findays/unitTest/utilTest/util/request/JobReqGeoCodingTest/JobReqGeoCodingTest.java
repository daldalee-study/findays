package com.findays.findays.unitTest.utilTest.util.request.JobReqGeoCodingTest;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.findays.findays.unitTest.utilTest.util.encrypt.TestValueDecryptModule;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;

@ExtendWith(MockitoExtension.class)
public class JobReqGeoCodingTest {

    private String encodeApiKey = "Jja10kR1WjXzdRwiWmlCq2F8Ac8BrZBPqz/kbaXuz9EmbLtn2q5z6di1YEzjOzrI";

    @BeforeEach
    public void setup() {
        encodeApiKey = TestValueDecryptModule.decryptTestValue(encodeApiKey);
    }

    @Test
    @DisplayName("사용자의 현재 위치를 받아 GeoCoding API에서 사용자 좌표 값 얻기")
    public void testGetCurrentLocationFromGeoCodingApi() throws IOException, InterruptedException, ApiException {
        // Set GeoApiConfig
        GeoApiContext context = new GeoApiContext.Builder()
                .apiKey(encodeApiKey)
                .build();
        // Send Geo API [GET] https://maps.googleapis.com/maps/api/geocode/json
        GeocodingResult[] results = GeocodingApi.geocode(context, "서울특별시 강남구 삼성로86길 26").await();
        // Response Convert
        JsonNode resJson = new ObjectMapper().valueToTree(results);
        // 예상되는 결과 노드 생성
        ObjectNode expectedObjectNode = new ObjectMapper().readValue("{\"lat\":37.50607440,\"lng\":127.05970310}", ObjectNode.class);
        // 테스트
        resJson.forEach(x -> Assertions.assertEquals(x.get("geometry").get("location") , expectedObjectNode));
    }

}
