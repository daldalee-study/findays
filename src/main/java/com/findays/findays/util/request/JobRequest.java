package com.findays.findays.util.request;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class JobRequest {
    private final JobRequestService jobRequestService;
    private final JobRequestObject jobRequestObject;

    public JobRequest(JobRequestObject _jobRequestObject , JobRequestService _jobRequestService) {
        this.jobRequestObject = _jobRequestObject;
        this.jobRequestService = _jobRequestService;
    }

    public ResponseEntity send(){
//        this.jobRequestService.setJobRequestObject(this.jobRequestObject);
        return this.jobRequestService.sendRequest();
    }
}

