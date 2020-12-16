package com.weixiao.springcloud.service;

import com.weixiao.springcloud.entity.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author :weixiao
 * @description :
 * @date :2020/12/13 20:31
 */
@FeignClient(value = "seata-storage-service")
public interface StorageService {

    @PostMapping("/storage/decrease")
    CommonResult decrease(@RequestParam("productId") Integer productId,@RequestParam("count") Integer count);
}
