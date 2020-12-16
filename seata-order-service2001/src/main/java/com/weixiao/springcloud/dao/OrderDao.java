package com.weixiao.springcloud.dao;

import com.weixiao.springcloud.entity.Order;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author :weixiao
 * @description :
 * @date :2020/12/13 20:06
 */
@Mapper
public interface OrderDao {

    public void create(Order order);

    public void updateById(String userId,Integer status);
}
