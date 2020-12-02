package com.weixiao.springcloud.controller;

import com.weixiao.springcloud.service.IMessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author :weixiao
 * @description :
 * @date :2020/12/2 14:22
 */
@RestController
public class MessageProviderController {
    @Autowired
    private IMessageProvider messageProvider;

    @GetMapping("/provider/send")
    public String send(){
        return messageProvider.send();
    }
}
