package com.weixiao.springcloud.controller;

import com.weixiao.springcloud.entitys.CommonResult;
import com.weixiao.springcloud.entitys.Payment;
import com.weixiao.springcloud.service.PaymentFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author :weixiao
 * @description :
 * @date :2020/11/26 11:14
 */
@RestController
public class PaymentFeignController {
    @Autowired
    private PaymentFeignService paymentFeignService;

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentInfo(@PathVariable("id") Long id){
        return paymentFeignService.getPaymentById(id);
    }

    @GetMapping(value = "/consumer/payment/feginTimeout")
    public String getFeginTimeout(){
        return paymentFeignService.getFeginTimeout();
    }
}
