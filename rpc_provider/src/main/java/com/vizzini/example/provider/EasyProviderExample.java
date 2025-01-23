package com.vizzini.example.provider;

import com.vizzini.example.common.service.UserService;
import com.vizzini.rpc_core.RpcApplication;
import com.vizzini.rpc_core.config.RegistryConfig;
import com.vizzini.rpc_core.config.RpcConfig;
import com.vizzini.rpc_core.model.ServiceMetaInfo;
import com.vizzini.rpc_core.registry.LocalRegistry;
import com.vizzini.rpc_core.registry.Registry;
import com.vizzini.rpc_core.registry.RegistryFactory;
import com.vizzini.rpc_core.server.HttpServer;
import com.vizzini.rpc_core.server.VertxHttpServer;

/**
 * 简易服务提供者示例
 */
//public class EasyProviderExample {
//
//    public static void main(String[] args) {
//        // 在注册中心注册服务
//        LocalRegistry.register(UserService.class.getName(), UserServiceImpl.class);
//
//        // 启动 web 服务
//        HttpServer httpServer = new VertxHttpServer();
//        httpServer.doStart(8081);
//    }
//}

public class EasyProviderExample {

    public static void main(String[] args) {
        // RPC 框架初始化
        RpcApplication.init();

        // 注册服务
        String serviceName = UserService.class.getName();
        LocalRegistry.register(serviceName, UserServiceImpl.class);

        // 注册服务到注册中心
        RpcConfig rpcConfig = RpcApplication.getRpcConfig();
        RegistryConfig registryConfig = rpcConfig.getRegistryConfig();
        Registry registry = RegistryFactory.getInstance(registryConfig.getRegistry());
        ServiceMetaInfo serviceMetaInfo = new ServiceMetaInfo();
        serviceMetaInfo.setServiceName(serviceName);
        serviceMetaInfo.setServiceHost(rpcConfig.getServerHost());
        serviceMetaInfo.setServicePort(rpcConfig.getServerPort());
        try {
            registry.register(serviceMetaInfo);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        
        // 启动 web 服务
        HttpServer httpServer = new VertxHttpServer();
        httpServer.doStart(RpcApplication.getRpcConfig().getServerPort());
    }
}