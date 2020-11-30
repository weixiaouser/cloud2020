package com.weixiao.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author :weixiao
 * @description : 实现PaymentHystrixService接口实现服务降级处理
 * @date :2020/11/30 11:00
 */
@Component
public class PaymentHystrixServiceImplFallBack implements PaymentHystrixService {
    @Override
    public String payment_ok(Integer id) {
        return "对方服务器已宕机，请稍后重试！PaymentHystrixServiceImplFallBack  ---------payment_ok----" ;
    }

    @Override
    public String payment_timeout(Integer id) {
        return "对方服务器已宕机，请稍后重试！PaymentHystrixServiceImplFallBack  ---------payment_timeout----" ;
    }
}
