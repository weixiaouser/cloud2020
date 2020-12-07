package com.weixiao.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author :weixiao
 * @description :
 * @date :2020/12/4 9:44
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ProviderPayment9002 {

    public static void main(String[] args) {
        SpringApplication.run(ProviderPayment9002.class,args);
    }
}
