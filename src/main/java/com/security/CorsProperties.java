package com.security;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Getter
@Setter
public class CorsProperties {
    @Value("${endpoints.cors.allowed-origins}")
    private List<String> allowedOrigins;
    @Value("${endpoints.cors.allowed-methods}")
    private List<String> allowedMethods;
    @Value("${endpoints.cors.allowed-headers}")
    private List<String> allowedHeaders;

}
