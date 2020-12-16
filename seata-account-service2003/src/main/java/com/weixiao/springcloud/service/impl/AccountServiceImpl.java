package com.weixiao.springcloud.service.impl;

import com.weixiao.springcloud.dao.AccountDao;
import com.weixiao.springcloud.service.AccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author :weixiao
 * @description :
 * @date :2020/12/14 13:51
 */
@Service
public class AccountServiceImpl implements AccountService {
    @Resource
    private AccountDao accountDao;
    @Override
    public void decrease(Long userId, BigDecimal money) {
        accountDao.decrease(userId,money);
    }
}
