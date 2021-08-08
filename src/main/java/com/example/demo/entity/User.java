package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @Author:wjup
 * @Date: 2018/9/26 0026
 * @Time: 14:39
 */
@Setter
@Getter
public class User implements Serializable {
    private Integer id;
    private String userName;
    private String passWord;
    private String realName;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", realName='" + realName + '\'' +
                '}';
    }
}