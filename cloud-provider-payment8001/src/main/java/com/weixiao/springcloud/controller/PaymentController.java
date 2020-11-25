package com.weixiao.springcloud.controller;

import com.weixiao.springcloud.entitys.CommonResult;
import com.weixiao.springcloud.entitys.Payment;
import com.weixiao.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author :weixiao
 * @description :
 * @date :2020/11/7 21:50
 */
@RestController
@Slf4j
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    //服务发现，可以通过它来获取服务信息
    @Autowired
    private DiscoveryClient discoveryClient;

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("插入数据返回结果：",result);
        if(result>0){
            return  new CommonResult(200,"数据插入成功！serverport:"+serverPort,payment);
        }else{
            return new CommonResult(444,"数据插入失败!",null);
        }

    }

    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable Long id){
        Payment payment = paymentService.getPaymentById(id);
        if(null != payment){
            return new CommonResult(200,"查询成功！serverport:"+serverPort,payment);
        }else {
            return new CommonResult(444,"查询失败，id:"+id,null);
        }
    }

    @GetMapping(value = "/payment/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("*************"+service);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("PROVIDER-PAYMENT");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }
        return  this.discoveryClient;
    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB(){
        return serverPort;
    }

}
