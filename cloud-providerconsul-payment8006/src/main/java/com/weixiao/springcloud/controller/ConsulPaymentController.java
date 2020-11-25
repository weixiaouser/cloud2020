package com.weixiao.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author :weixiao
 * @description :
 * @date :2020/11/25 10:12
 */
@RestController
@Slf4j
public class ConsulPaymentController {

    @Value("${server.port}")
    private String serverPort;


    @GetMapping(value = "/payment/consul")
    public String paymentInfo(){
        return "Spring Cloud Consul Server Port:"+serverPort+"\t"+ UUID.randomUUID().toString();
    }
}
