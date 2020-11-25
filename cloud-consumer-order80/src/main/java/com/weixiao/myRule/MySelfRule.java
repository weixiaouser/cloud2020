package com.weixiao.myRule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author :weixiao
 * @description : 负载均衡切换为随机模式
 * @date :2020/11/25 14:49
 */
@Configuration
public class MySelfRule {

    @Bean
    public IRule getRandomRule(){
        return new RandomRule();
    }
}
