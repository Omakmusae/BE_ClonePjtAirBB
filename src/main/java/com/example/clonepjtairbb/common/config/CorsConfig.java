//package com.example.clonepjtairbb.common.config;
//
//import com.example.clonepjtairbb.common.utils.JwtUtil;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.CorsConfigurationSource;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//
//import java.util.List;
//
//@Configuration
//public class CorsConfig {
//    private static final String CLIENT_URL = "http://localhost:3000";
//
//    @Bean
//    public CorsConfigurationSource corsConfigurationSource() {
//        CorsConfiguration config = new CorsConfiguration();
//
//        config.setAllowedOrigins(List.of(CLIENT_URL));
//        config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS"));
//        config.setAllowedHeaders(List.of("Cookie","Access-Control-Request-Method","Access-Control-Request-Headers"));
//        config.setExposedHeaders(List.of(JwtUtil.AUTHORIZATION_HEADER));
//        config.setAllowCredentials(true);
//
//        //URL별 설정
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", config);
//        return source;
//    }
//}
