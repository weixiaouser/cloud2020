package com.weixiao.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author :weixiao
 * @description :
 * @date :2020/12/7 21:45
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SentinelServiceMain8401 {

    public static void main(String[] args) {
        SpringApplication.run(SentinelServiceMain8401.class,args);
    }
}
