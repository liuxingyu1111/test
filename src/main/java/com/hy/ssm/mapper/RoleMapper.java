package com.hy.ssm.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hy.ssm.bean.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface RoleMapper extends BaseMapper<Role> {
    @Select("select * from role where id=#{id}")
    Role update(@Param("id") Integer id);

    @Select("SELECT * FROM role")
    @Results({
            @Result(property = "id", column = "id"),//加此行，否则id值为空
            @Result(property = "rolepostiton", column = "pid",many =@Many(select =
                    "com.hy.ssm.mapper.RolePostitonMapper.getPostitonById")),
            @Result(property = "rolesection", column = "sid", one =@One(select = "com.hy.ssm.mapper.RoleSectionMapper.getAccountByUserId"))
    })
    List<Role> getUserWithAccount();

}
