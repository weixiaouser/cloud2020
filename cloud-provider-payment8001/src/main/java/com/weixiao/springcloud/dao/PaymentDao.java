package com.weixiao.springcloud.dao;

import com.weixiao.springcloud.entitys.Payment;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author :weixiao
 * @description :
 * @date :2020/11/7 21:41
 */
@Mapper
public interface PaymentDao {

    public int create(Payment payment);

    public Payment getPaymentById(Long id);
}
