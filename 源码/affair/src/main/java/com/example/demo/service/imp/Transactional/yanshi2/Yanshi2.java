package com.example.demo.service.imp.Transactional.yanshi2;

import com.example.demo.dao.UserMapper;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class Yanshi2 {

    @Autowired
    private UserMapper userMapper;

    //没有事务的普通方法
    public void test1(){
        test2();
    }
    //有事务的被调用方法
    @Transactional
    public void test2(){
        User u = new User();
        List<User> users = userMapper.SelAll();
        User temp = users.get(users.size()-1);
        u.setId(temp.getId()+1);
        u.setPassWord("123456789");
        u.setRealName("xiaoli");
        u.setUserName("xiaoli");
        userMapper.insert(u);
        throw new RuntimeException("a error!");
    }
}
