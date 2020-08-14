package com.hy.ssm.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hy.ssm.bean.User;
import com.hy.ssm.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 用户Service
 */
@Service
@Transactional
public class UserService extends ServiceImpl<UserMapper, User> implements IUserService {
 @Autowired
    private UserMapper userMapper;

    @Override
    public int adduser(User user) {
        System.out.println("进来");
       return userMapper.insert(user);
    }
}

