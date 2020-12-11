package com.weixiao.springcloud.service;

import com.weixiao.springcloud.entitys.CommonResult;
import com.weixiao.springcloud.entitys.Payment;
import org.springframework.stereotype.Service;

/**
 * @author :weixiao
 * @description :
 * @date :2020/12/10 16:21
 */
@Service
public class PaymentFallBackService implements PaymentService{
    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(444,"服务降级返回，----PaymentFallBackService",new Payment(id,"errorService"));
    }
}
