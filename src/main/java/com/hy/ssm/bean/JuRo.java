package com.hy.ssm.bean;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 角色权限实体类
 */
@TableName("rolejuri")
public class JuRo {
    @TableId(value = "id")
    private int id;
    private int rid;
    private int jid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public int getJid() {
        return jid;
    }

    public void setJid(int jid) {
        this.jid = jid;
    }

    @Override
    public String toString() {
        return "JuRo{" +
                "id=" + id +
                ", rid=" + rid +
                ", jid=" + jid +
                '}';
    }
}
