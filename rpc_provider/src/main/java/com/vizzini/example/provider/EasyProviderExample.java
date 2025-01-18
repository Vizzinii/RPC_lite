package com.vizzini.example.provider;

import com.vizzini.rpc_lite.server.HttpServer;
import com.vizzini.rpc_lite.server.VertxHttpServer;

/**
 * 简易服务提供者示例
 */
public class EasyProviderExample {

    public static void main(String[] args) {
        // 启动 web 服务
        HttpServer httpServer = new VertxHttpServer();
        httpServer.doStart(8081);
    }
}
