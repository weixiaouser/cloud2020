package com.weixiao.springcloud.dao;

import java.math.BigDecimal;

/**
 * @author :weixiao
 * @description :
 * @date :2020/12/14 13:48
 */
public interface AccountDao {

    public void decrease(Long userId, BigDecimal money);
}
