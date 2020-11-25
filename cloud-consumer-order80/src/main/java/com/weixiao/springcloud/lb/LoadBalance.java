package com.weixiao.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author :weixiao
 * @description :
 * @date :2020/11/25 16:34
 */
public interface LoadBalance {

    ServiceInstance instance(List<ServiceInstance> instanceList);
}
