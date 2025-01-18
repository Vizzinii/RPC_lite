package com.vizzini.example.common.model;

import java.io.Serializable;

/**
 * 用户类
 * 对象需要实现序列化接口，为后续网络传输序列化提供支持。（因为Java对象不能进行网络传输）
 */
public class User implements Serializable {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
