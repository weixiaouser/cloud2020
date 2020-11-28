package com.weixiao.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author :weixiao
 * @description :
 * @date :2020/11/27 11:33
 */
@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker  //开启服务降级
public class ProviderHystrixPayment8001 {

    public static void main(String[] args) {
        SpringApplication.run(ProviderHystrixPayment8001.class,args);
    }
}
