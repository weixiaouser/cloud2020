package com.weixiao.springcloud.service;

import com.weixiao.springcloud.entitys.Payment;

/**
 * @author :weixiao
 * @description :
 * @date :2020/11/7 21:43
 */
public interface PaymentService {

    public int create(Payment payment);

    public Payment getPaymentById(Long id);
}
