package com.imooc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {

    public CorsConfig(){

    }

    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedOrigin("http://localhost:8080");

        //设置是否发送附加信息，比如cookie
        corsConfiguration.setAllowCredentials(true);

        //GET, POST
        corsConfiguration.addAllowedMethod("*");

        corsConfiguration.addAllowedHeader("*");

        //为url添加映射路径

        UrlBasedCorsConfigurationSource urlSource = new UrlBasedCorsConfigurationSource();
        urlSource.registerCorsConfiguration("/**", corsConfiguration);

        return new CorsFilter(urlSource);
    }
}
