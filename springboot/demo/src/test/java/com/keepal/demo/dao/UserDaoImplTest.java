package com.keepal.demo.dao;

import com.keepal.demo.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.hamcrest.Matchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Rollback(true)
public class UserDaoImplTest {

    @Autowired
    private UserDao userDao;


    @Test
    public void testListUsers() {
        // 准备好mock userMapper的返回数据
        User user = new User();
        user.setName("测试用户");
        user.setAge(20);
        userDao.saveUser(user);

        List<User> users = new ArrayList<User>();
        users.add(user);

        // 测试UserSerivce的listUsers()方法
        List<User> resultUsers = userDao.listUsers();

        // 对测试结果进行断言
        // 这里要求DB中没有干扰数据，否则size比对会失败
        assertEquals(users.size(), resultUsers.size());
    }

    @Test
    public void testGetUserById() {
        User user = new User();
        user.setName("测试用户");
        user.setAge(20);
        userDao.saveUser(user);

        Long userId = user.getId();

        User resultUser = userDao.getUserById(userId);

        assertEquals(user.toString(), resultUser.toString());
    }


    @Test
    public void testSaveUser() {
        User user = new User();
        user.setName("测试用户");
        user.setAge(20);

        Long resultUserId = userDao.saveUser(user);

        assertThat(resultUserId, is(greaterThan(0L)));
    }

    /**
     * 测试用例：修改用户
     */
    @Test
    public void testUpdateUser() {
        Integer oldAge = 20;
        Integer newAge = 21;

        User user = new User();
        user.setName("测试用户");
        user.setAge(oldAge);
        userDao.saveUser(user);

        user.setAge(newAge);
        Boolean updateResult = userDao.updateUser(user);

        assertTrue(updateResult);

        User updatedUser = userDao.getUserById(user.getId());

        assertEquals(newAge, updatedUser.getAge());
    }

    /**
     * 测试用例：删除用户
     */
    @Test
    public void testRemoveUser() {
        User user = new User();
        user.setName("测试用户");
        user.setAge(20);
        userDao.saveUser(user);

        Boolean removeResult = userDao.removeUser(user.getId());

        assertTrue(removeResult);
    }

}
