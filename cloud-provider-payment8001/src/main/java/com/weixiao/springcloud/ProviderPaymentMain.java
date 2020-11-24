package com.weixiao.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author :weixiao
 * @description :
 * @date :2020/11/6 10:07
 */
@SpringBootApplication
@EnableEurekaClient     //开启Eureka客户端
@EnableDiscoveryClient   //开启服务发现
public class ProviderPaymentMain {

    public static void main(String[] args) {
        SpringApplication.run(ProviderPaymentMain.class,args);
    }
}
