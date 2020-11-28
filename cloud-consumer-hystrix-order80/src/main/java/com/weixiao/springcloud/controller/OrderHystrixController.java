package com.weixiao.springcloud.controller;

import com.weixiao.springcloud.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author :weixiao
 * @description :
 * @date :2020/11/28 8:38
 */
@RestController
@Slf4j
public class OrderHystrixController {
    @Autowired
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/consumer/payment/ok/{id}")
    public String payment_ok(@PathVariable("id") Integer id){
        String result = paymentHystrixService.payment_ok(id);
        return result;
    }

    @GetMapping("/consumer/payment/timeout/{id}")
    public String payment_timeout(@PathVariable("id") Integer id){
        String result = paymentHystrixService.payment_timeout(id);
        return result;
    }
}
