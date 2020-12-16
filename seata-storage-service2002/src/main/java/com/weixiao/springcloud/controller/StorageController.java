package com.weixiao.springcloud.controller;

import com.weixiao.springcloud.entity.CommonResult;
import com.weixiao.springcloud.service.StorageService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author :weixiao
 * @description :
 * @date :2020/12/14 11:04
 */
@RestController
public class StorageController {
    @Resource
    private StorageService storageService;

    @RequestMapping("/storage/decrease")
    public CommonResult decrease(Long productId,Integer count){
        storageService.decrease(productId,count);
        return new CommonResult(200,"扣减库存成功！");
    }
}
