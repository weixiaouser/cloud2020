package com.weixiao.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

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


    @GetMapping("/testD")
    public String testD(){
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Test  RT 秒级平均响应时间--------";
    }

    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey",blockHandler = "deal_testHotKey")
    public String testHotKey(@RequestParam(value="p1",required = false) String p1,
                             @RequestParam(value="p2",required = false) String p2){

        return "----------testHotKey";
    }

    public String deal_testHotKey(String p1, String p2, BlockException e){
        return "--------deal_testHotKey o(╥﹏╥)o";
    }
}
