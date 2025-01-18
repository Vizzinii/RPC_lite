package com.vizzini.example.provider;

import com.vizzini.example.common.service.UserService;
import com.vizzini.rpc_lite.registry.LocalRegistry;
import com.vizzini.rpc_lite.server.HttpServer;
import com.vizzini.rpc_lite.server.VertxHttpServer;

/**
 * 简易服务提供者示例
 */
public class EasyProviderExample {

    public static void main(String[] args) {
        // 在注册中心注册服务
        LocalRegistry.register(UserService.class.getName(), UserServiceImpl.class);

        // 启动 web 服务
        HttpServer httpServer = new VertxHttpServer();
        httpServer.doStart(8081);
    }
}
