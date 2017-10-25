package com.ht.bean;

import java.io.Serializable;


public class UserVo implements Serializable {

    private String id;
    private String username;
    private String password;
    private String phone;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "UserVo{" + "id='" + id + '\'' + ", username='" + username + '\'' + ", phone='" + phone + '\'' + ", password='" + password + '\'' + '}';
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
