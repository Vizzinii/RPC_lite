package com.vizzini.rpc_lite.server;

/**
 * HTTP 服务器接口
 */
public interface HttpServer {

    /**
     * 启动服务器
     *
     * @param port
     */
    void doStart(int port);
}
