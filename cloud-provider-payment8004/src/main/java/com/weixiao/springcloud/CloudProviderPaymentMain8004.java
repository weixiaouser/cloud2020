package com.weixiao.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author :weixiao
 * @description :
 * @date :2020/11/24 14:07
 */
@SpringBootApplication
@EnableDiscoveryClient  //该注解用于向使用consul或者zookeeper作为注册中心时注册服务
public class CloudProviderPaymentMain8004 {

    public static void main(String[] args) {
        SpringApplication.run(CloudProviderPaymentMain8004.class,args);
    }
}
