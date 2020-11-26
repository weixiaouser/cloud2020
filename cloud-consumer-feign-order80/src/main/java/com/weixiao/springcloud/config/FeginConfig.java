package com.weixiao.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author :weixiao
 * @description :
 * @date :2020/11/26 16:39
 */
@Configuration
public class FeginConfig {

    @Bean
    public Logger.Level  getfeginConfig(){
        return Logger.Level.FULL;
    }
}
