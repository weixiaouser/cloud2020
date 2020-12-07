package com.weixiao.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author :weixiao
 * @description :
 * @date :2020/12/3 16:16
 */
@RestController
public class ProviderController {
    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/getInfo/{name}")
    public String getInfo(@PathVariable("name") String name){
        return "Hello Nacos Discovery "+"serverPort:"+serverPort+name;
    }
}
