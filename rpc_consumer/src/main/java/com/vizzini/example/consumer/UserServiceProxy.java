package com.vizzini.example.consumer;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import com.vizzini.example.common.model.User;
import com.vizzini.example.common.service.UserService;
import com.vizzini.rpc_core.model.RpcRequest;
import com.vizzini.rpc_core.model.RpcResponse;
import com.vizzini.rpc_core.serializer.JdkSerializer;
import com.vizzini.rpc_core.serializer.Serializer;

import java.io.IOException;

/**
 * 静态代理
 * 实现 getUser 方法时，不是复制粘贴服务提供者 UserServiceImpl 中的代码，而是要构造 HTTP 请求去调用服务提供者。
 */
public class UserServiceProxy implements UserService {

    public User getUser(User user) {
        // 指定序列化器
        Serializer serializer = new JdkSerializer();

        // 发送请求
        RpcRequest rpcRequest = RpcRequest.builder()
                .serviceName(UserService.class.getName())
                .methodName("getUser")
                .parameterTypes(new Class[]{User.class})
                .args(new Object[]{user})
                .build();
        try {
            byte[] bodyBytes = serializer.serialize(rpcRequest);
            byte[] result;
            try (HttpResponse httpResponse = HttpRequest.post("http://localhost:8080")
                    .body(bodyBytes)
                    .execute()) {
                result = httpResponse.bodyBytes();
            }
            RpcResponse rpcResponse = serializer.deserialize(result, RpcResponse.class);
            return (User) rpcResponse.getData();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
