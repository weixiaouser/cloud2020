package com.weixiao.springcloud.entitys;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author :weixiao
 * @description :
 * @date :2020/11/7 21:37
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment implements Serializable {

    private Long id;

    private String serial;



}
