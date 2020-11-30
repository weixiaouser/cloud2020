package com.weixiao.springcloud.controller;

import com.weixiao.springcloud.service.HystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author :weixiao
 * @description :
 * @date :2020/11/27 13:37
 */
@RestController
@Slf4j
public class HystrixController {
    @Autowired
    private HystrixService hystrixService;

    @GetMapping(value = "/payment/ok/{id}")
    public String payment_ok(@PathVariable("id") Integer id){
        String result = hystrixService.payment_ok(id);
        log.info("*****payment_ok*****result:"+result);
        return result;
    }

    @GetMapping(value = "/payment/timeout/{id}")
    public String paymentTimeout(@PathVariable("id")Integer id){
        String result = hystrixService.paymentTimeout(id);
        log.info("*****payment_timeout*****result:"+result);
        return result;
    }
    @GetMapping(value = "/payment/circuit/{id}")
    public String circuitBreaker(@PathVariable("id") Integer id){
        return hystrixService.paymentCircuitBreaker(id);
    }


}
