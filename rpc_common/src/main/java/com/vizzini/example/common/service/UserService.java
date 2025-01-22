package com.vizzini.example.common.service;

import com.vizzini.example.common.model.User;

/**
 * 用户服务
 */
public interface UserService {

    /**
     * 获取用户
     * @param user
     * @return
     */
    User getUser(User user);

    /**
     * 新方法 - 获取数字
     */
    default long getNumber() {
        return 938;
    }
}
