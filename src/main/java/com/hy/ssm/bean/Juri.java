package com.hy.ssm.bean;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 权限实体
 */
@TableName("juri")
public class Juri {
    @TableId(value = "id")
    private int id;
   private String menu;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    @Override
    public String toString() {
        return "Juri{" +
                "id=" + id +
                ", menu='" + menu + '\'' +
                '}';
    }
}
