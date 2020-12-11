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
 * @date :2020/12/10 10:54
 */
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    public static HashMap<Long, Payment> hashMap = new HashMap<>();

    static {

        hashMap.put(1L,new Payment(1L,"2823023920392323"));
        hashMap.put(2L,new Payment(2L,"2343333333333333"));
        hashMap.put(3L,new Payment(3L,"3434444444443434"));
    }

    @GetMapping("/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id){
        Payment payment = hashMap.get(id);
        CommonResult result = new CommonResult(200, "from mysql,serverPort:" + serverPort, payment);
        return result;
    }


}
