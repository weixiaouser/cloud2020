package com.weixiao.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author :weixiao
 * @description :
 * @date :2020/11/24 16:34
 */
@RestController
public class ConsumerZkController {

    private static final String INVOKE_URL="http://provider-payment";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "/customer/payment/zk")
    public String paymentInfo(){
        String result = restTemplate.getForObject(INVOKE_URL+"/payment/zk",String.class);
        return result;
    }

}
