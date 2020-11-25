package com.weixiao.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author :weixiao
 * @description :
 * @date :2020/11/24 16:28
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConsumerZkOrderMain80 {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerZkOrderMain80.class,args);
    }
}
