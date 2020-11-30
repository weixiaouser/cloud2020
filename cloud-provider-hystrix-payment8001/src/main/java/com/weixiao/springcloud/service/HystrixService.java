package com.weixiao.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @author :weixiao
 * @description : 服务降级，当一个方法出现超时，或者抛出异常时会调用fallback方法执行这个方法的内容
 * @date :2020/11/27 13:38
 */
@Service
public class HystrixService {

    public String payment_ok(Integer id){
        return "线程号："+Thread.currentThread().getName()+" id:"+id+" payment_ok ,o(*￣︶￣*)o";
    }

    //当服务超时或者抛出异常都会触发兜底服务paymentTimeoutHandler显示系统信息
    @HystrixCommand(fallbackMethod = "paymentTimeoutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")
    })
    public String paymentTimeout(Integer id){
        //int age = 10/0;
        int timeoutNum=3;
        try {
            TimeUnit.SECONDS.sleep(timeoutNum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程号："+Thread.currentThread().getName()+" id:"+id+" paymentTimeout ,o(*￣︶￣*)o，线程超时(秒)："/*+timeoutNum*/;
    }

    public String paymentTimeoutHandler(Integer id){
        return "线程号："+Thread.currentThread().getName()+"id: "+id+" 系统繁忙，请稍后再试。。(╥╯^╰╥)";
    }

    //---------------------------------服务熔断------------------------------
    //先进行服务降级处理，然后服务熔断，最后慢慢恢复链路
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name="circuitBreaker.enabled" ,value = "true"),//是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),//请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),//时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60")//失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        if(id <0){
            throw new RuntimeException("********id 不能为负数！");
        }
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName()+"\t"+" 调用成功，流水号："+serialNumber;
    }

    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id){
        return " id 不能为负数，请稍后再试，o(*￣︶￣*)o id:"+id;
    }
}
