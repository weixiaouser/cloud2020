package com.weixiao.springcloud.controller;

import com.weixiao.springcloud.entitys.CommonResult;
import com.weixiao.springcloud.entitys.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author :weixiao
 * @description :
 * @date :2020/11/9 11:07
 */
@RestController
public class OrderController {

    //public static final String PAYMENT_URL="http://localhost:8001";//单机版
    public static final String PAYMENT_URL="http://PROVIDER-PAYMENT";//集群版

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/customer/payment/create")
    public CommonResult create(Payment payment){

       return  restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment,CommonResult.class);
    }

    @GetMapping("/customer/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
    }
}
