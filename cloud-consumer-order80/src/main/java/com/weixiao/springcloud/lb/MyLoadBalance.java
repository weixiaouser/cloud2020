package com.weixiao.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author :weixiao
 * @description :
 * @date :2020/11/25 16:34
 */
@Component
public class MyLoadBalance implements LoadBalance {

    private AtomicInteger automaticInteger = new AtomicInteger(0);

    //获取当前请求的次数
    public final int getAntIncrement(){
        int current;
        int next;
        do{
            current = automaticInteger.get();
            next = current >2147483647 ? 0:current+1;
            //自旋锁  当前值this.automaticInteger 如果和期望值current相同则更新成新值 next
        }while (!this.automaticInteger.compareAndSet(current,next));
        System.out.println("****第几次访问，next:"+next);
        return next;
    }

    /**
     *
     * @param instanceList  服务器总数量
     * @return
     */
    @Override
    public ServiceInstance instance(List<ServiceInstance> instanceList) {
        int index= getAntIncrement() % instanceList.size();
        return instanceList.get(index);
    }
}
