package com.vizzini.example.consumer;

import com.vizzini.example.common.model.User;
import com.vizzini.example.common.service.UserService;

/**
 * 简易服务消费者示例
 */
public class EasyConsumerExample {

    public static void main(String[] args) {
        // TODO 需要获取 UserService 的实现类对象
        UserService userService = null;
        User user = new User();
        user.setName("yupi");
        // 调用
        User newUser = userService.getUser(user);
        if (newUser != null) {
            System.out.println(newUser.getName());
        } else {
            System.out.println("user == null");
        }
    }
}
