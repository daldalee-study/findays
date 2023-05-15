package com.findays.findays.config.swagger;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI squeakOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("FinDays API")
                        .description("FinDays API")
                        .version("v0.0.1")
                        .license(new License()
                                .name("Apache License Version 2.0")
                                .url("http://www.apache.org/licenses/LICENSE-2.0"))
                );
    }
}
