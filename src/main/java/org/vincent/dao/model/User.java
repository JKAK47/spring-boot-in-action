package org.vincent.dao.model;

import java.util.Date;

/**
 * Created by PengRong on 2018/9/18.
 * 对应数据库中的表，类名不需要和表名一致
 */
public class User {

    private int id;
    private String username;
    private int age;
    private Date ctm;

    public User() {
    }

    public User(String username, int age) {
        this.username = username;
        this.age = age;
        this.ctm = new Date();
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", age=" + age +
                ", ctm=" + ctm +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getCtm() {
        return ctm;
    }

    public void setCtm(Date ctm) {
        this.ctm = ctm;
    }
}

