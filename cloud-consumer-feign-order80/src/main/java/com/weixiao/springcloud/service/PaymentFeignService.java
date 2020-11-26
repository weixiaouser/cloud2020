package com.weixiao.springcloud.service;

import com.weixiao.springcloud.entitys.CommonResult;
import com.weixiao.springcloud.entitys.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author :weixiao
 * @description :
 * @date :2020/11/26 11:12
 */
@Component
@FeignClient(value = "PROVIDER-PAYMENT")
public interface PaymentFeignService {

     @GetMapping(value = "/payment/get/{id}")
     public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);

    @GetMapping(value = "/payment/feginTimeout")
    public String getFeginTimeout();
}
