package com.weixiao.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author :weixiao
 * @description :
 * @date :2020/11/27 15:43
 */
@SpringBootApplication
@EnableFeignClients
public class FeignHystrixOrderMain80 {

    public static void main(String[] args) {
        SpringApplication.run(FeignHystrixOrderMain80.class,args);
    }
}
