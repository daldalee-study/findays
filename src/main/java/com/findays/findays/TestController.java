package com.findays.findays;

import com.findays.findays.common.papago.PapagoTranslateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RequiredArgsConstructor
@RestController
public class TestController {

    private final PapagoTranslateService ppg;

    @GetMapping("/test")
    public Map<String, Object> test(){
        return ppg.translation("미국");
    }
}
