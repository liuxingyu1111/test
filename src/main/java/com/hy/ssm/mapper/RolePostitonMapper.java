package com.hy.ssm.mapper;

import com.hy.ssm.bean.Rolepostiton;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface RolePostitonMapper {
    /**
     * 根据职位id查职位
     * @param pid
     * @return
     */
    @Select("SELECT * FROM roleposition WHERE pid = #{pid}")
    @Results({
            @Result(property = "pid",  column = "pid"),
            @Result(property = "position",  column = "position")
    })
    Rolepostiton getPostitonById(int pid);
}
