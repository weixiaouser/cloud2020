package com.weixiao.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.weixiao.springcloud.entitys.CommonResult;
import com.weixiao.springcloud.entitys.Payment;
import com.weixiao.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author :weixiao
 * @description :
 * @date :2020/12/10 11:39
 */
@RestController
public class CircleBreakerController {

    public static final String SERVICE_URL = "http://nacos-payment-provider";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private PaymentService paymentService;

    @RequestMapping("/consumer/fallback/{id}")
    //@SentinelResource(value = "fallback")  //没有配置
    //@SentinelResource(value = "fallback",fallback = "handlerFallback") //fallback 只负责业务异常
    //@SentinelResource(value = "fallback",blockHandler = "blockHandler") //blockHandler 只负责sentinel控制台配置违规
    @SentinelResource(value = "fallback",fallback = "handlerFallback",blockHandler = "blockHandler"  //两个都配置，如果是业务异常fallback处理，是控制台违规blockHandler处理，如果两个都有，则控制台违规优先处理
            ,exceptionsToIgnore = {IllegalArgumentException.class}) //此处异常表示，假设报该异常，不再有fallback方法兜底，没有降级效果了

    public CommonResult<Payment> fallback(@PathVariable("id") Long id){

        CommonResult<Payment> result = restTemplate.getForObject(SERVICE_URL+"/paymentSQL/"+id,CommonResult.class,id);
        if(id == 4){
            throw new IllegalArgumentException("IllegalArgumentException...非法参数异常！");
        }else if(result.getData() == null){
            throw new NullPointerException("NullPointerException...该ID没有对应记录，空指针异常");
        }
        return result;
    }


    /**
     * fallback 兜底方法，处理业务业务异常
     * @param id
     * @param e
     * @return
     */
    public CommonResult handlerFallback(@PathVariable("id")Long id,Throwable e){
        Payment payment = new Payment(id,null);
        return new CommonResult(444,"兜底异常handlerFallBack ,exception内容："+e.getMessage(),payment);
    }


    /**
     * blockHander 只对sentinel控制台配置违规有效
     * @param id
     * @param blockException
     * @return
     */
    public CommonResult blockHandler(@PathVariable("id")Long id, BlockException blockException){
        Payment payment = new Payment(id,null);
        return new CommonResult(445,"blockHandler-sentinel限流，无此流水：blockException"+blockException.getMessage(),payment);
    }


    //===================OpenFeign============


    @GetMapping("/consumer/paymentSQL/openFeign/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id){
        return paymentService.paymentSQL(id);
    }

}
