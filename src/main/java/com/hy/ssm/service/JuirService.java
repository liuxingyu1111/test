package com.hy.ssm.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hy.ssm.bean.Juri;
import com.hy.ssm.mapper.JuriMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 权限service
 */
@Service
@Transactional
public class JuirService extends ServiceImpl<JuriMapper, Juri> implements IJuriService{
    @Autowired
    private JuriMapper juriMapper;


}
