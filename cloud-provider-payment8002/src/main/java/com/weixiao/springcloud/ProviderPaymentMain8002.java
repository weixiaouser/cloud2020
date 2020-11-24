package com.weixiao.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author :weixiao
 * @description :
 * @date :2020/11/23 22:02
 */
@SpringBootApplication
@EnableEurekaClient
public class ProviderPaymentMain8002 {
    public static void main(String[] args) {
        SpringApplication.run(ProviderPaymentMain8002.class,args);
    }
}
