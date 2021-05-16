package com.example.demo.service;

import com.example.demo.model.User;

import java.util.List;

public interface UserService {
    public List<User> SelAll();

    public void InsertInto();

    public void sendMsg();

    public void sendMail();
}
