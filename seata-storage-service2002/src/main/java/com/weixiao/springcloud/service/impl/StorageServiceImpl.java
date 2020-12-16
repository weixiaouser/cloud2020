package com.weixiao.springcloud.service.impl;

import com.weixiao.springcloud.dao.StorageDao;
import com.weixiao.springcloud.service.StorageService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author :weixiao
 * @description :
 * @date :2020/12/14 10:59
 */
@Service
public class StorageServiceImpl implements StorageService {

    @Resource
    private StorageDao storageDao;
    @Override
    public void decrease(Long productId, Integer count) {
        storageDao.decrease(productId,count);
    }
}
