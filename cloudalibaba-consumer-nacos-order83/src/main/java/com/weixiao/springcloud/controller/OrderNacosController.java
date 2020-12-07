package com.weixiao.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author :weixiao
 * @description :
 * @date :2020/12/5 14:01
 */
@RestController
public class OrderNacosController {
    @Resource
    private RestTemplate restTemplate;
    @Value("${service-url.nacos-user-service}")
    private String serviceUrl;


    @GetMapping("/consumer/payment/getInfo/{name}")
    public String getInfo(@PathVariable("name") String name){
        return restTemplate.getForObject(serviceUrl+"/payment/getInfo/"+name,String.class);
    }
}
