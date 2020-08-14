package com.hy.ssm.bean;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 角色实体类
 */

@TableName("roles")
public class Roles {
    @TableId(value = "id")
    int id;
    String rname;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }
    @Override
    public String toString() {
        return "Roles{" +
                "id=" + id +
                ", rname='" + rname + '\'' +
                '}';
    }
}
