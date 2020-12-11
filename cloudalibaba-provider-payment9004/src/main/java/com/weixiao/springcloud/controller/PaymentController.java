package com.weixiao.springcloud.controller;

import com.weixiao.springcloud.entitys.CommonResult;
import com.weixiao.springcloud.entitys.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @author :weixiao
 * @description :
 * @date :2020/12/10 11:19
 */
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    public static HashMap<Long, Payment> hashMap = new HashMap<>();

    static {

        hashMap.put(1L,new Payment(1L,"28230239203923231"));
        hashMap.put(2L,new Payment(2L,"23433333333333331"));
        hashMap.put(3L,new Payment(3L,"34344444444434341"));
    }

    @GetMapping("/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id){
        Payment payment = hashMap.get(id);
        CommonResult result = new CommonResult(200, "from mysql,serverPort:" + serverPort, payment);
        return result;
    }
}
