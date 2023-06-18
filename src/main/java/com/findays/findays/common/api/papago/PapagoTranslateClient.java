package com.findays.findays.common.api.papago;

import com.findays.findays.common.api.papago.dto.PapagoReq;
import com.findays.findays.common.api.papago.dto.PapagoRes;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
    name = "PapagoTranslateImpl2",
    url = "https://openapi.naver.com/v1/papago/n2mt",
    configuration = {PapagoHeaderConfig.class}
)
public interface PapagoTranslateClient {

    @PostMapping(value = "")
    public PapagoRes translation(
        @RequestBody
        PapagoReq req
    );

}
