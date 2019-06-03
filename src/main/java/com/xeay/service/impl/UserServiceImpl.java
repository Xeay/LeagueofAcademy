package com.xeay.service.impl;

import com.xeay.dao.UserDao;
import com.xeay.dto.ModifyUserTestExecution;
import com.xeay.entity.User;
import com.xeay.exception.ModifyUserFailException;
import com.xeay.exception.NoUserException;
import com.xeay.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * UserService 对应的实现类
 *
 */

@Service("userService")
public class UserServiceImpl implements UserService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserDao userDao;

    @Override
    //根据id查询用户
    public User searchUserById(int userid) {

        return userDao.searchUserById(userid);
    }
    @Override
    //查询所有用户
    public List<User> getUserList(){

        return userDao.getUserList(0, 1000);
    }
    @Override
    //修改用户名
    //@Transactional
    /**
     * 使用注解控制事务方法的优点：
     * 1.开发团队达成一致约定，明确标注事务方法的编程风格
     * 2.保证事务方法的执行时间尽可能短，不要穿插其他网络操作，RPC/HTTP请求或者剥离到事务方法外部
     * 3.不是所有的方法都需要事务，如只有一条修改操作，只读操作不需要事务控制
     */
    public ModifyUserTestExecution modifyUserName(int userid, String username){
        try {
            User user=userDao.searchUserById(userid);
            if (user==null) {// 未搜索到
                throw new NoUserException("user not exist");
            }else {
                // 执行修改操作
                int md = userDao.modifyUserName(userid,username);//修改的位置
                System.out.println(md);
                return new ModifyUserTestExecution(userid,username);
            }

        }catch (NoUserException e){
            throw e;
        }
        catch (Exception e) {
            logger.error(e.getMessage(), e);
            // 所有编译期异常转换为运行期异常
            throw new ModifyUserFailException("medify inner error:" + e.getMessage());
        }
    }
}
