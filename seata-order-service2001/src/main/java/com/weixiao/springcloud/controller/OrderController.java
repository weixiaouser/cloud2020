package com.weixiao.springcloud.controller;

import com.weixiao.springcloud.entity.CommonResult;
import com.weixiao.springcloud.entity.Order;
import com.weixiao.springcloud.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author :weixiao
 * @description :
 * @date :2020/12/13 20:44
 */
@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/order/save")
    public CommonResult saveOrder(Order order){
        orderService.createOrder(order);
        return new CommonResult(200,"订单创建成功！",order);
    }
}
