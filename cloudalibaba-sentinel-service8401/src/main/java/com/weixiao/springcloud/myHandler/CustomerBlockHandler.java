package com.weixiao.springcloud.myHandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.weixiao.springcloud.entitys.CommonResult;
import org.springframework.stereotype.Component;

/**
 * @author :weixiao
 * @description :
 * @date :2020/12/9 14:29
 */
@Component
public class CustomerBlockHandler {

    public static CommonResult exceptionHandler(BlockException exception){
        return new CommonResult(4444,"按客户自定义-------1");
    }
    public static CommonResult exceptionHandler2(BlockException exception){
        return new CommonResult(4444,"按客户自定义-------2");
    }
}
