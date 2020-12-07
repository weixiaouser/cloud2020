package com.weixiao.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author :weixiao
 * @description :
 * @date :2020/12/4 10:06
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosConsumerMain83 {

    public static void main(String[] args) {
        SpringApplication.run(NacosConsumerMain83.class,args);
    }
}
