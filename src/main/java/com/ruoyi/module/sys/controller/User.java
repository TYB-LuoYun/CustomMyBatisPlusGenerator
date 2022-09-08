package com.ruoyi.module.sys.controller;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户实体类。测试用
 */
@Data
public class User implements Serializable {

    private String LoginName;

    private String nickName;

//    public String getLoginName() {
//        return loginName;
//    }
//
//    public void setLoginName(String loginName) {
//        this.loginName = loginName;
//    }
//
//    public String getNickName() {
//        return nickName;
//    }
//
//    public void setNickName(String nickName) {
//        this.nickName = nickName;
//    }
}