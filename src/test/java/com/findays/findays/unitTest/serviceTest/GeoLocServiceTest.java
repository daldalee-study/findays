package com.findays.findays.unitTest.serviceTest;

import com.findays.findays.util.request.Impl.JobReqServiceGeoCoImpl;
import com.findays.findays.util.request.JobRequest;
import com.findays.findays.util.request.JobRequestObject;
import com.findays.findays.util.request.JobRequestService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
public class GeoLocServiceTest {

    @Autowired
    private JobRequest jobRequest;
    @Autowired
    @Qualifier("jobReqObjectGeoCoImpl")
    private JobRequestObject jobRequestObject;

    @Autowired
    @Qualifier("jobReqServiceGeoCoImpl")
    private JobRequestService jobRequestService;

    @Test
    @DisplayName("RedCase 구현되지 않았기 때문에 ")
    public void RedCase(){
        Map paramValue = new HashMap();
        paramValue.put("address" , "서울특별시 강남구 삼성로86길 26");
        jobRequestObject.setFieldValues(paramValue);
        jobRequestService.sendRequest();
        ResponseEntity send = jobRequest.send();
        System.out.println(send.getBody());
    }
}
