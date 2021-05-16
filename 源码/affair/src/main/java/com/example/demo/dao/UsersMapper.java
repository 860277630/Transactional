package com.example.demo.dao;


import com.example.demo.model.Users;

public interface UsersMapper {

    int insert(Users record);

    int insertSelective(Users record);
}