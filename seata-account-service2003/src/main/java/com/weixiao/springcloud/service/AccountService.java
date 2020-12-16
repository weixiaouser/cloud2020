package com.weixiao.springcloud.service;

import java.math.BigDecimal;

/**
 * @author :weixiao
 * @description :
 * @date :2020/12/14 13:50
 */
public interface AccountService {

    public void decrease(Long userId, BigDecimal money);
}
