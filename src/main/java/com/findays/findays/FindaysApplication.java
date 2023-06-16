package com.findays.findays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class FindaysApplication {

    public static void main(String[] args) {
        SpringApplication.run(FindaysApplication.class, args);
    }

}
