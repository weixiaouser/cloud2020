package com.weixiao.springcloud.entitys;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author :weixiao
 * @description :
 * @date :2020/11/7 22:11
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResult<T> {

    private Integer code;

    private String msg;

    private T data;

    public CommonResult(Integer code,String msg){
        this(code,msg,null);
    }

}
