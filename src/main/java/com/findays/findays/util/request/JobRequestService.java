package com.findays.findays.util.request;

import org.springframework.http.ResponseEntity;

public interface JobRequestService{

    // JobRequestService에서 사용될 JobObjectRequest 객체 할당
//    <T extends JobRequestObject> void setJobRequestObject(T _jobRequestObject);

    // 실제 외부 API에 Request 요청
    ResponseEntity sendRequest();
}