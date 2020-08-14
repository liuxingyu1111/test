package com.hy.ssm.mapper;

import com.hy.ssm.bean.Rolesection;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RoleSectionMapper {
    /**
     * 根据用户id查部门信息
     * @param id
     * @return
     */
    @Select("SELECT * FROM `rolesection` WHERE sid = #{sid}")
    @Results({
            @Result(property = "sid",  column = "sid"),
            @Result(property = "section",  column = "section")
    })
    List<Rolesection> getAccountByUserId(int id);
}
