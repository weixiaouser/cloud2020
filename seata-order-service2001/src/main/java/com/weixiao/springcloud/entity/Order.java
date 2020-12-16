package com.weixiao.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author :weixiao
 * @description :
 * @date :2020/12/13 20:03
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    private Integer id;

    private String userId;

    private Integer productId;

    private String commodityCode;

    private Integer count;

    private BigDecimal money;

    private Integer status;


}
