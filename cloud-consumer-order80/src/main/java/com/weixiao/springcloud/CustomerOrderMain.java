package com.weixiao.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author :weixiao
 * @description :
 * @date :2020/11/9 10:49
 */
@SpringBootApplication
@EnableEurekaClient
public class CustomerOrderMain {

    public static void main(String[] args) {
        SpringApplication.run(CustomerOrderMain.class,args);
    }
}
