package com.keepal.demo.service;

import com.keepal.demo.dao.UserDao;
import com.keepal.demo.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.LinkedList;
import java.util.List;

// 导入静态包
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

/**
 * 这个注解是在执行单元测试的时候，不是去直接执行里面的方法
 * 因为在方法执行之前，还需要做一些准备工作，去找SpringRunner这个类
 * 去将spring容器准备好，再执行各个测试函数
 */
@RunWith(SpringRunner.class)

/**
 * 这是从顶层的包结构开始找：com.keepal.demo
 * 找到@SpringBootApplication注解的一个类，算是启动类
 * 然后执行其中的main方法，为后面的单元测试运行准备好springboot所需的环境
 */
@SpringBootTest

/**
 * 加上下面的两个，就是为了数据回滚
 */
//@Transactional
//@Rollback(true)
public class UserServiceImplTest {


    @Autowired
    private UserService userService;

    /**
     * 这里相当于我们创建了一个userDao的替身
     * 这里springboot整合mockito框架，然后创建出来userDao的匿名实现类
     * 然后将这个替身bean放入spring容器中，替代我们自己的那个userDao
     */
    @MockBean
    private UserDao userDao;

    @Test
    public void testListUsers() {
        // 准备好预制数据
        List<User> users = new LinkedList<>();
        User u = new User();
        u.setId(1L);
        u.setAge(18);
        u.setName("ww");
        users.add(u);
        // 对userDao进行mock逻辑设置
        when(userDao.listUsers()).thenReturn(users);
        // 断言校验
        List<User> resultUsers = userService.listUsers();
        assertEquals(resultUsers, users);
    }

    @Test
    public void testGetUser() {
        User u = new User();
        u.setId(1L);
        u.setAge(18);
        u.setName("ww");

        when(userDao.getUserById(1L)).thenReturn(u);

        User resultUser = userService.getUserById(1L);
        assertEquals(resultUser, u);
    }

    @Test
    public void testUpdateUser() {
        User u = new User();
        u.setId(1L);
        u.setAge(18);
        u.setName("ww");

        when(userDao.updateUser(u)).thenReturn(true);
        // 对于boolean类型校验，注意用封装类型
        Boolean result = userService.updateUser(u);
        assertTrue(result);
    }

    @Test
    public void testDeleteUser() {
        when(userDao.removeUser(1L)).thenReturn(true);

        Boolean result = userService.removeUser(1L);
        assertTrue(result);
    }

}
