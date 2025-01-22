package com.vizzini.rpc_core.serializer;

/**
 * 序列化器键名（默认使用JDK序列化器）
 */
public interface SerializerKeys {

    String JDK = "jdk";
    String JSON = "json";
    String KRYO = "kryo";
    String HESSIAN = "hessian";

}
