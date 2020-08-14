package com.hy.ssm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hy.ssm.bean.Role;

import java.util.List;

public interface IRoleService extends IService<Role> {
    Role update(Integer id);

    List<Role> getUserWithAccount();
}
