package com.weixiao.springcloud.service;

/**
 * @author :weixiao
 * @description :
 * @date :2020/12/14 10:41
 */
public interface StorageService {

    /**
     * 扣减库存
     * @param productId
     * @param count
     */
    public void  decrease(Long productId,Integer count);
}
