package com.xeay.dto;

/**
 * 执行-修改用户信息
 * 此处dto与dao中的user基本相同，只是为了展示dto的作用
 */
public class ModifyUserTestExecution {

    private int userid;
    private String username;

    public ModifyUserTestExecution() {
    }

    // 修改的构造器
    public ModifyUserTestExecution(int userid, String username) {
        this.userid = userid;
        this.username=username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getUserid() {
        return userid;
    }
}
