package com.lichunorz.provider.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.lichunorz.api.service.UserService;

@Service(version = "${provider.service.version}")
public class UserServiceImpl implements UserService {

    @Override
    public String sayHi() {
        return "hello";
    }
}
