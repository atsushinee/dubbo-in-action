package com.lichunorz.provider.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.lichunorz.api.service.UserService;
import org.springframework.beans.factory.annotation.Value;

@Service(version = "${provider.service.version}")
public class UserServiceImpl implements UserService {

    @Value("${dubbo.protocol.port}")
    private int port;

    @Override
    public String sayHi() {
        return "hello," + port;
    }
}
