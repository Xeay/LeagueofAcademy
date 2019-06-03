package com.xeay.dao;

import com.xeay.dto.ModifyUserTestExecution;
import com.xeay.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {
    //根据id寻找User
    User searchUserById(@Param("userid")int userid);

    //查询所有用户
    List<User> getUserList(@Param("offset")int offset,@Param("num")int num);

    //修改用户名
    int modifyUserName(@Param("userid")int userid, @Param("username")String username);
}
