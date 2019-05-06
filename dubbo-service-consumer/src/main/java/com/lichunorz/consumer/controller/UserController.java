package com.lichunorz.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lichunorz.api.service.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Reference(version = "${provider.service.version}")
    private UserService userService;

    @HystrixCommand(fallbackMethod = "hiError")
    @GetMapping("hi")
    public String hi() {
        return userService.sayHi();
    }

    public String hiError() {
        return "hystrix hiError";
    }
}
