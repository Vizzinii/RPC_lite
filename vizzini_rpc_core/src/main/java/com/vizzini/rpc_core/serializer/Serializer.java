package com.vizzini.rpc_core.serializer;

import java.io.IOException;

/**
 * 序列化器接口
 * 参数需要传输，但是Java对象是存活在JVM虚拟机中的。若想在网络中传输在其它位置存储并访问，就需要进行序列化和反序列化。
 */
public interface Serializer {

    /**
     * 序列化
     *
     * @param object
     * @param <T>
     * @return
     * @throws IOException
     */
    <T> byte[] serialize(T object) throws IOException;

    /**
     * 反序列化
     *
     * @param bytes
     * @param type
     * @param <T>
     * @return
     * @throws IOException
     */
    <T> T deserialize(byte[] bytes, Class<T> type) throws IOException;
}
