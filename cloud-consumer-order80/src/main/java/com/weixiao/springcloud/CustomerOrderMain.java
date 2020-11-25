package com.weixiao.springcloud;

import com.weixiao.myRule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;

/**
 * @author :weixiao
 * @description :  Ribbon默认的负载均衡策略是轮询
 * @date :2020/11/9 10:49
 */
@SpringBootApplication
@EnableEurekaClient
//@RibbonClient(name ="PROVIDER-PAYMENT",configuration= MySelfRule.class) //切换为负载均衡策略为随机
public class CustomerOrderMain {

    public static void main(String[] args) {
        SpringApplication.run(CustomerOrderMain.class,args);
    }
}
