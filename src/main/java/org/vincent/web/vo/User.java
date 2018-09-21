package org.vincent.web.vo;

import java.util.Date;

/**
 * Created by PengRong on 2018/9/21.
 */
public class User {
    private  int age;
    private  Date ctm;
    private  String username;
    public void setAge(int age) {
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }

    public void setCtm(Date ctm) {
        this.ctm = ctm;
    }

    public Date getCtm() {
        return ctm;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
