package com.weixiao.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author :weixiao
 * @description :
 * @date :2020/12/7 9:48
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConfigNacosClient3377 {

    public static void main(String[] args) {
        SpringApplication.run(ConfigNacosClient3377.class,args);
    }
}
