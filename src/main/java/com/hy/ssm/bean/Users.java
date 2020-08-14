package com.hy.ssm.bean;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 用户角色关系实体类
 */
@TableName("ur")
public class Users {
    @TableId(value = "id")
    private int id;
    private int uid;
    private int rid;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", uid=" + uid +
                ", rid=" + rid +
                '}';
    }
}
