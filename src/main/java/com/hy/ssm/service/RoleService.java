package com.hy.ssm.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hy.ssm.bean.Role;
import com.hy.ssm.bean.Rolepostiton;
import com.hy.ssm.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleService extends ServiceImpl<RoleMapper, Role> implements IRoleService {
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public Role update(Integer id) {
        return null;
    }

    @Override
    public List<Role> getUserWithAccount() {
        List<Role> list=roleMapper.getUserWithAccount();
        for (Role roles:list){
            StringBuffer buffer=new StringBuffer();
            for (Rolepostiton ro:roles.getRolepostiton()){
                buffer.append(ro.getPosition()+",");
            }
            roles.setPid(buffer.substring(0,buffer.lastIndexOf(",")).toString());
        }
        return list;
    }


}
