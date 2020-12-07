package com.weixiao.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author :weixiao
 * @description :
 * @date :2020/12/3 16:09
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ProviderNacosMain9001 {

    public static void main(String[] args) {
        SpringApplication.run(ProviderNacosMain9001.class,args);
    }
}
