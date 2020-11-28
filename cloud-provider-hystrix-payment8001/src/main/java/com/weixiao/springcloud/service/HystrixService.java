package com.weixiao.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @author :weixiao
 * @description :
 * @date :2020/11/27 13:38
 */
@Service
public class HystrixService {

    public String payment_ok(Integer id){
        return "线程号："+Thread.currentThread().getName()+" id:"+id+" payment_ok ,o(*￣︶￣*)o";
    }

    //当服务超时或者抛出异常都会触发兜底服务paymentTimeoutHandler显示系统信息
    @HystrixCommand(fallbackMethod = "paymentTimeoutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    public String paymentTimeout(Integer id){
        int age = 10/0;
        /*int timeoutNum=5;
        try {
            TimeUnit.SECONDS.sleep(timeoutNum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        return "线程号："+Thread.currentThread().getName()+" id:"+id+" paymentTimeout ,o(*￣︶￣*)o，线程超时(秒)："/*+timeoutNum*/;
    }

    public String paymentTimeoutHandler(Integer id){
        return "线程号："+Thread.currentThread().getName()+"id: "+id+" 系统繁忙，请稍后再试。。(╥╯^╰╥)";
    }
}
