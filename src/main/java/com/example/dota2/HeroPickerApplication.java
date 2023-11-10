package com.example.dota2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@EnableAutoConfiguration(exclude = DataSourceAutoConfiguration.class)
@SpringBootApplication

public class HeroPickerApplication {

    public static void main(String[] args) {
        SpringApplication.run(HeroPickerApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public FilterRegistrationBean<CorsFilter> corsFilter() {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("http://mydota2heropickerappbucket.s3-website-us-east-1.amazonaws.com");
        config.addAllowedOrigin("https://mydota2heropickerappbucket.s3-website-us-east-1.amazonaws.com");
        config.addAllowedOrigin("https://d1mnuatqjgcek6.cloudfront.net");
        config.addAllowedOrigin("http://d1mnuatqjgcek6.cloudfront.net");
        config.addAllowedOrigin("http://www.dota2heropicker.com");
        config.addAllowedOrigin("https://www.dota2heropicker.com");
        config.addAllowedOrigin("http://dota2heropicker.com");
        config.addAllowedOrigin("https://dota2heropicker.com");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);

        FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<>(new CorsFilter(source));
        bean.setOrder(0);

        return bean;
    }
}