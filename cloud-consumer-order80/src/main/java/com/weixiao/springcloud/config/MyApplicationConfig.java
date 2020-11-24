package com.weixiao.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author :weixiao
 * @description :
 * @date :2020/11/9 11:09
 */
@Configuration
public class MyApplicationConfig {

    @Bean
    @LoadBalanced //添加负载均衡机制
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
