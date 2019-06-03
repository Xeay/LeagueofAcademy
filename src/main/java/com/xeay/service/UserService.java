package com.xeay.service;

import com.xeay.dto.ModifyUserTestExecution;
import com.xeay.entity.User;

import java.util.List;

public interface UserService {
    //根据id寻找User
    User searchUserById(int userid);

    //查询所有用户
    List<User> getUserList();

    //修改用户名
    ModifyUserTestExecution modifyUserName(int userid,String username);
}
