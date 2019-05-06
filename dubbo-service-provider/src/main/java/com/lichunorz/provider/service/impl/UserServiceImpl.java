package com.lichunorz.provider.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.lichunorz.api.service.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Value;

import java.util.Random;

@Service(version = "${provider.service.version}")
public class UserServiceImpl implements UserService {

    @Value("${dubbo.protocol.port}")
    private int port;

    @HystrixCommand
    @Override
    public String sayHi() {
        int v = new Random().nextInt(2);
        System.out.println(v);
        int error = 1 / v;
        return "hello," + port + ",random:" + v;
    }
}
