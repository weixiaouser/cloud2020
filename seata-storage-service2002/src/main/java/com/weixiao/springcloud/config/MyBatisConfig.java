package com.weixiao.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author :weixiao
 * @description :
 * @date :2020/12/13 21:15
 */
@Configuration
@MapperScan({"com.weixiao.springcloud.dao"})
public class MyBatisConfig {
}
