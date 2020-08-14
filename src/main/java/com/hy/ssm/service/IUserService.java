package com.hy.ssm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hy.ssm.bean.User;

public interface IUserService extends IService<User> {
     int adduser(User user);
}
