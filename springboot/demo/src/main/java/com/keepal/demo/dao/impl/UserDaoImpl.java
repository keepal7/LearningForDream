package com.keepal.demo.dao.impl;

import com.keepal.demo.dao.UserDao;
import com.keepal.demo.domain.User;
import com.keepal.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    /**
     * 用户管理模块的mapper组件
     */
    @Autowired
    private UserMapper userMapper;

    /**
     * 查询所有用户
     * @return 用户信息
     */
    public List<User> listUsers() {
        return userMapper.listUsers();
    }

    /**
     * 根据ID查询用户
     * @param id 用户ID
     * @return 用户信息
     */
    public User getUserById(Long id) {
        return userMapper.getUserById(id);
    }

    /**
     * 新增用户
     * @param user 用户信息
     */
    public Long saveUser(User user) {
        userMapper.saveUser(user);
        return user.getId();
    }

    /**
     * 更新用户
     * @param user 用户信息
     */
    public Boolean updateUser(User user) {
        userMapper.updateUser(user);
        return true;
    }

    /**
     * 删除用户
     * @param id 用户ID
     */
    public Boolean removeUser(Long id) {
        userMapper.removeUser(id);
        return true;
    }

}
