package com.hy.ssm.bean;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.List;

@TableName("role")
public class Role {
    @TableId(value = "id")
    private int id;

    private String rname;

    private String sex;

    private String file;

    private String pid;

    private String sid;

    private String card;

    private List<Rolepostiton> rolepostiton;
    private Rolesection rolesection;

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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public List<Rolepostiton> getRolepostiton() {
        return rolepostiton;
    }

    public void setRolepostiton(List<Rolepostiton> rolepostiton) {
        this.rolepostiton = rolepostiton;
    }

    public Rolesection getRolesection() {
        return rolesection;
    }

    public void setRolesection(Rolesection rolesection) {
        this.rolesection = rolesection;
    }
}
