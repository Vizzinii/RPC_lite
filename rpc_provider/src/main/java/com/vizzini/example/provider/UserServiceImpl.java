package com.vizzini.example.provider;

import com.vizzini.example.common.model.User;
import com.vizzini.example.common.service.UserService;
import lombok.extern.slf4j.Slf4j;

/**
 * 用户服务实现类
 */
@Slf4j
public class UserServiceImpl implements UserService {

    public User getUser(User user) {
        log.error("用户名：" + user.getName()+" from provider");
        return user;
    }
}