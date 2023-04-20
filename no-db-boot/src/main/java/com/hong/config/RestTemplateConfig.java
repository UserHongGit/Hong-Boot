package com.hong.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {
    @Bean
    public RestTemplate restTemplate() {

        RestTemplate restTemplate = new RestTemplate(getClientHttpRequestFactory());
        restTemplate.setRequestFactory(new HttpComponentsClientRestfulHttpRequestFactory());
        return restTemplate;
    }

    // 设置超时时间
    private SimpleClientHttpRequestFactory getClientHttpRequestFactory() {
        SimpleClientHttpRequestFactory clientHttpRequestFactory = new SimpleClientHttpRequestFactory();
        // Connect timeout 3s
        clientHttpRequestFactory.setConnectTimeout(60000);
        // Read timeout 3s
        clientHttpRequestFactory.setReadTimeout(60000);
        return clientHttpRequestFactory;
    }
}