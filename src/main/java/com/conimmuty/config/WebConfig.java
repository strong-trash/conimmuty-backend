package com.conimmuty.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(final CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("")
                .allowedMethods("GET,HEAD,POST,PUT,DELETE,TRACE,OPTIONS,PATCH".split(","))
                .allowedHeaders("Content-Type,Accept".split(","))
                .allowCredentials(true)
                .exposedHeaders(HttpHeaders.LOCATION);
    }
}
