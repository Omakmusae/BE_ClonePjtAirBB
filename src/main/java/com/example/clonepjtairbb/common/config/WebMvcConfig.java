package com.example.clonepjtairbb.common.config;

import com.example.clonepjtairbb.common.utils.JwtUtil;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
@EnableWebMvc
public class WebMvcConfig implements WebMvcConfigurer {
    private final static String CLIENT_URL = "http://airbnb-clone-hh99.s3-website.ap-northeast-2.amazonaws.com";

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:3000", CLIENT_URL)
                .allowedMethods("OPTIONS", "GET", "POST", "PUT", "DELETE")
                .allowedHeaders("*")
                .exposedHeaders(JwtUtil.AUTHORIZATION_HEADER)
                .allowCredentials(true);
    }
}
