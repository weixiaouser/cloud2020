package com.weixiao.springcloud.controller;

import com.sun.jndi.toolkit.url.Uri;
import com.weixiao.springcloud.entitys.CommonResult;
import com.weixiao.springcloud.entitys.Payment;
import com.weixiao.springcloud.lb.LoadBalance;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * @author :weixiao
 * @description :
 * @date :2020/11/9 11:07
 */
@RestController
@Slf4j
public class OrderController {

    //public static final String PAYMENT_URL="http://localhost:8001";//单机版
    public static final String PAYMENT_URL="http://PROVIDER-PAYMENT";//集群版

    @Resource
    private RestTemplate restTemplate;
    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private LoadBalance loadBalance;

    @GetMapping("/customer/payment/create")
    public CommonResult create(Payment payment){

       return  restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment,CommonResult.class);
    }

    @GetMapping("/customer/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
    }

    @GetMapping("/customer/payment/createforEntity")
    public CommonResult create2(Payment payment){
        ResponseEntity<CommonResult> entity = restTemplate.postForEntity(PAYMENT_URL + "/payment/create", payment, CommonResult.class);

        if(entity.getStatusCode().is2xxSuccessful()){
            log.info(entity.getStatusCodeValue()+"\t"+entity.getHeaders());
            return entity.getBody();
        }else{
            return new CommonResult(444,"插入失败！",null);
        }
       // return  restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment,CommonResult.class);
    }

    @GetMapping("/customer/payment/getForEntity/{id}")
    public CommonResult getPaymentById2(@PathVariable("id") Long id){
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
        if(entity.getStatusCode().is2xxSuccessful()){
            log.info(entity.getStatusCode()+"\t"+entity.getHeaders());
            return entity.getBody();
        }else{
            return new CommonResult(444,"查询失败！",null);
        }
    }

    @GetMapping("/customer/payment/lb")
    public String serverPort(){
        List<ServiceInstance> services = discoveryClient.getInstances("PROVIDER-PAYMENT");
        if(null == services && services.size()<=0){
            return null;
        }
        ServiceInstance instance = loadBalance.instance(services);
        URI uri = instance.getUri();

        return restTemplate.getForObject(uri+"/payment/lb",String.class);
    }

    @GetMapping("/customer/payment/zipkin")
    public String getZipKin(){
        return restTemplate.getForObject("http://localhost:8001/payment/zipkin",String.class);
    }
}
