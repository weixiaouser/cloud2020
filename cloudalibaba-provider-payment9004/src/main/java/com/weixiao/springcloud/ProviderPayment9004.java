package com.weixiao.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.PropertySource;

/**
 * @author :weixiao
 * @description :
 * @date :2020/12/10 11:15
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ProviderPayment9004 {

    public static void main(String[] args) {
        SpringApplication.run(ProviderPayment9004.class,args);
    }
}
