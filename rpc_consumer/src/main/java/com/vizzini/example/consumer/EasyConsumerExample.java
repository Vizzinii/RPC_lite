package com.vizzini.example.consumer;

import com.vizzini.example.common.model.User;
import com.vizzini.example.common.service.UserService;
import com.vizzini.rpc_core.proxy.ServiceProxyFactory;
import lombok.extern.slf4j.Slf4j;

/**
 * 简易服务消费者示例
 */
@Slf4j
public class EasyConsumerExample {

    public static void main(String[] args) {
        // TODO 需要获取 UserService 的实现类对象
        // 已完成toodo:动态代理实现远程调用
//        UserService userService = new UserServiceProxy();
        UserService userService = ServiceProxyFactory.getProxy(UserService.class);
        User user = new User();
        user.setName("vizzini");
        // 调用
        User newUser = userService.getUser(user);
        if (newUser != null) {
            log.error(newUser.getName() + " as consumer");
        } else {
            log.error("user == null");
        }
        // 验证mock服务
        long number = userService.getNumber();
        System.out.println(number);
    }
}
