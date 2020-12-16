package com.weixiao.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author :weixiao
 * @description :
 * @date :2020/12/13 20:20
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {

    private Integer code;

    private String msg;

    private T data;

    public CommonResult(Integer code, String msg) {
        this(code,msg,null);
    }
}
