package com.weixiao.springcloud.service.impl;

import com.weixiao.springcloud.dao.OrderDao;
import com.weixiao.springcloud.entity.Order;
import com.weixiao.springcloud.service.AccountService;
import com.weixiao.springcloud.service.OrderService;
import com.weixiao.springcloud.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author :weixiao
 * @description :
 * @date :2020/12/13 20:26
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private StorageService storageService;
    @Resource
    private AccountService accountService;


    /**
     * 创建订单->调用库存服务扣减库存->调用账户服务扣减账户余额->修改订单状态
     * 简单说：下订单->扣库存->减余额->改状态
     */

    @Override
    public void createOrder(Order order) {
        //1.创建订单
        log.info("创建订单start...");
        orderDao.create(order);
        log.info("创建订单end....");
        //2.扣减库存
        log.info("扣减库存start。。。");
        storageService.decrease(order.getProductId(),order.getCount());
        log.info("扣减库存end...");
        //3.扣减账户
        log.info("扣减账户start...");
        accountService.decrease(order.getUserId(),order.getMoney());
        log.info("扣减账户end....");
        //4.更新订单状态
        log.info("更新订单状态start...");
        orderDao.updateById(order.getUserId(),0);
        log.info("更新订单状态end...");

        log.info("下单结束了，o(*￣︶￣*)o");
    }
}
