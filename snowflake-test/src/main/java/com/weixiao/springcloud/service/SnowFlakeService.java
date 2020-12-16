package com.weixiao.springcloud.service;

import com.weixiao.springcloud.util.IdGeneratorSnowFlake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author :weixiao
 * @description :
 * @date :2020/12/16 11:10
 */
@Service
public class SnowFlakeService {
    @Autowired
    private IdGeneratorSnowFlake snowFlake;


    public String  snowTest(){
        ExecutorService threadPool = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 20; i++) {
            threadPool.submit(()->{
                System.out.println(snowFlake.snowflakeId());
            });
        }
        threadPool.shutdown();


        return "hello snowflake ";
    }
}
