package com.example.demo.service.imp.Transactional.yanshi1;

import com.example.demo.dao.UserMapper;
import com.example.demo.dao.UsersMapper;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class Yanshi1 {
    @Autowired
    private UserMapper userMapper;

    //正常抛异常  事务回滚
    @Transactional
    public void test1(){
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

    //throws出异常  事务回滚
    @Transactional
    public void test2() throws Exception{
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

    //捕获异常  事务不回滚
    @Transactional
    public void test3(){
        User u = new User();
        List<User> users = userMapper.SelAll();
        User temp = users.get(users.size()-1);
        u.setId(temp.getId()+1);
        u.setPassWord("123456789");
        u.setRealName("xiaoli");
        u.setUserName("xiaoli");
        userMapper.insert(u);
        try {
            throw new RuntimeException("a error!");
        }catch (Exception e){e.printStackTrace();}
    }

}
