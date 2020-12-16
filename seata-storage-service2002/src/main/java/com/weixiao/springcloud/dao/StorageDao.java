package com.weixiao.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;

/**
 * @author :weixiao
 * @description :
 * @date :2020/12/14 10:44
 */
@Mapper
public interface StorageDao {

    public void decrease(Long productId,Integer count);
}
