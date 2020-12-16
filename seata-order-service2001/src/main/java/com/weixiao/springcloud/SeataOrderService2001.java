package com.weixiao.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author :weixiao
 * @description :
 * @date :2020/12/11 16:11
 */

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableFeignClients
@EnableDiscoveryClient
public class SeataOrderService2001 {

    public static void main(String[] args) {
        //try {
            SpringApplication.run(SeataOrderService2001.class, args);
       /* }catch (Throwable e){
            e.printStackTrace();
        }*/
    }
}
