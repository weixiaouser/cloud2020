package com.weixiao.springcloud.service;

import com.weixiao.springcloud.entity.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @author :weixiao
 * @description :
 * @date :2020/12/13 20:37
 */
@FeignClient(value = "seata-account-service")
public interface AccountService {

    @PostMapping("/account/decrease")
    CommonResult decrease(@RequestParam("userId") String userId, @RequestParam("money")BigDecimal money);
}
