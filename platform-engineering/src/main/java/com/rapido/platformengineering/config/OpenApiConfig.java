package com.rapido.platformengineering.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.*;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI platformApi() {

        return new OpenAPI()
                .info(new Info()
                        .title("Platform Engineering API")
                        .version("1.0"));
    }
}