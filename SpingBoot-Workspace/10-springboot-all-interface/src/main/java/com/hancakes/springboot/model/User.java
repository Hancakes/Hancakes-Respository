package com.hancakes.springboot.model;

import java.io.Serializable;

public class User implements Serializable {


    private static final long serialVersionUID = -5574970084244780907L;

    private Integer id;

    private String nick;

    private String phone;

    private String address;

    private String email;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User(Integer id, String nick, String phone, String address, String email) {
        this.id = id;
        this.nick = nick;
        this.phone = phone;
        this.address = address;
        this.email = email;
    }
}