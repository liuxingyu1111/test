package com.hy.ssm.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hy.ssm.bean.Roles;
import com.hy.ssm.mapper.RolesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 权限service
 */
@Service
@Transactional
public class RolesService extends ServiceImpl<RolesMapper, Roles> implements IRolesService {
    @Autowired
    private RolesMapper rolesMapper;


}
