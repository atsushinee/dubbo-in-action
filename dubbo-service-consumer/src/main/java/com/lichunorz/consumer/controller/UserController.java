package com.lichunorz.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lichunorz.api.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Reference(version = "${provider.service.version}")
    private UserService userService;

    @GetMapping("hi")
    public String hi() {
        return userService.sayHi();
    }
}
