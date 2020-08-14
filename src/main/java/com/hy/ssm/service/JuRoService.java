package com.hy.ssm.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hy.ssm.bean.JuRo;
import com.hy.ssm.mapper.JuRoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 角色权限service
 */
@Service
@Transactional
public class JuRoService extends ServiceImpl<JuRoMapper, JuRo> implements IJuRoService {
    @Autowired
    private JuRoMapper juRoMapper;


}
