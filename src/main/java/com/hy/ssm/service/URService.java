package com.hy.ssm.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hy.ssm.bean.Users;
import com.hy.ssm.mapper.URMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 用户角色Service
 */
@Service
@Transactional
public class URService extends ServiceImpl<URMapper, Users> implements IURService{
    @Autowired
    private URMapper urMapper;


}
