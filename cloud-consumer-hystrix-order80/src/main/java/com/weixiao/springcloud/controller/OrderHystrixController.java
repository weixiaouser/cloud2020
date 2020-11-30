package com.weixiao.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.weixiao.springcloud.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author :weixiao
 * @description :
 * @date :2020/11/28 8:38
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod") //全局异常或者超时兜底处理，
public class OrderHystrixController {
    @Autowired
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/consumer/payment/ok/{id}")
    public String payment_ok(@PathVariable("id") Integer id){
        String result = paymentHystrixService.payment_ok(id);
        return result;
    }

    @GetMapping("/consumer/payment/timeout/{id}")
    //当服务超时或者抛出异常都会触发兜底服务paymentTimeoutHandler显示系统信息
    /*@HystrixCommand(fallbackMethod = "paymentTimeoutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500")
    })*/
    @HystrixCommand
    public String payment_timeout(@PathVariable("id") Integer id){
        int age = 10/0;
        String result = paymentHystrixService.payment_timeout(id);
        return result;
    }


    public String paymentTimeoutHandler(@PathVariable("id") Integer id){
        return "我是消费者80，线程号："+Thread.currentThread().getName()+"id: "+id+" 系统繁忙，请稍后再试。。(╥╯^╰╥)";
    }

    /**
     * 配置全局兜底方案不能带参数
     * @return
     */
    public String payment_Global_FallbackMethod(){
        return "我是全局异常处理，线程号："+Thread.currentThread().getName()+" 系统繁忙，请稍后再试。。(╥╯^╰╥)";
    }
}
