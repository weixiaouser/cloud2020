package com.weixiao.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author :weixiao
 * @description :
 * @date :2020/11/25 10:49
 */
@RestController
public class OrderConsulController {

    private static final String INVOKE_URL="http://consul-provider-payment";

    @Autowired
    private RestTemplate restTemplate;


    @GetMapping(value = "/customer/payment/cl")
    public String paymentInfo(){
        String result = restTemplate.getForObject(INVOKE_URL+"/payment/consul",String.class);
        return result;
    }
}
