package com.weixiao.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author :weixiao
 * @description :fallback方法对方服务宕机或者其他异常情况会调用fallback所对应类中的方法
 * @date :2020/11/28 8:36
 */
@Component
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT",fallback = PaymentHystrixServiceImplFallBack.class)
public interface PaymentHystrixService {

    @GetMapping("/payment/ok/{id}")
    public String payment_ok(@PathVariable("id") Integer id);

    @GetMapping("/payment/timeout/{id}")
    public String payment_timeout(@PathVariable("id") Integer id);
}
