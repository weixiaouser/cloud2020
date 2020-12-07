package com.weixiao.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author :weixiao
 * @description :
 * @date :2020/12/7 21:45
 */
@RestController
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA(){
        return "Test A--------";
    }

    @GetMapping("/testB")
    public String testB(){
        return "Test B--------";
    }
}
