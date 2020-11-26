package com.weixiao.springcloud.service.impl;

import com.weixiao.springcloud.dao.PaymentDao;
import com.weixiao.springcloud.entitys.Payment;
import com.weixiao.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author :weixiao
 * @description :
 * @date :2020/11/7 21:44
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }


}
