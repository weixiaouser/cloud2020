package com.weixiao.springcloud.controller;

import com.weixiao.springcloud.service.SnowFlakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author :weixiao
 * @description :
 * @date :2020/12/16 11:40
 */
@RestController
public class SnowFlakeController {
    @Autowired
    private SnowFlakeService snowFlakeService;

    @GetMapping("/snowFlake")
    public String getSnowFlakeId(){
        snowFlakeService.snowTest();

        return "hhh";

    }
}
