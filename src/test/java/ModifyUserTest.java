import com.xeay.dao.UserDao;
import com.xeay.dto.ModifyUserTestExecution;
import com.xeay.entity.User;
import com.xeay.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Iterator;
import java.util.List;

/**
 * UserDao 的测试类
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-dao.xml","classpath:spring-service.xml","classpath:spring-mvc.xml"})
public class ModifyUserTest {

    @Autowired
    private UserService userService;

    @Test
    @Transactional
    @Rollback
    public void testMedifyUser() {
        int userid0 = 1;
        User user = userService.searchUserById(userid0);
        System.out.println(user.getUserid() + ":" + user.getUsername());
        System.out.println("---------------");
        int userid1 = 2;
        String username = "咸鲲修改";
        ModifyUserTestExecution execution = userService.modifyUserName(userid1, username);
        System.out.println(execution.getUserid()+":"+execution.getUsername());
        System.out.println("---------------");
        List<User> userList=userService.getUserList();
        userList.forEach((n) -> System.out.println(n.getUserid()+":"+n.getUsername()));

    }
}