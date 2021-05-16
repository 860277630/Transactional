package com.example.demo.service.imp.Transactional.yanshi3;

import com.example.demo.dao.UserMapper;
import com.example.demo.dao.UsersMapper;
import com.example.demo.model.User;
import com.example.demo.model.Users;
import com.example.demo.word.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//事务调用链路捕获异常演示
@Service
public class Yanshi3_2 {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UsersMapper usersMapper;

    //具有事务特性的调用头
    @Transactional
    public void test1(){
        Users u = new Users();
        u.setId(UUIDUtils.getUUID());
        u.setUsername("peter");
        int num =  usersMapper.insert(u);
        try {
            test2();
        }catch (Exception e){e.printStackTrace();}
    }
    //不具有事务特性的被调用对象
    public void test2(){
        test3();
        throw new RuntimeException("error!!");
    }
    //具有事务特性的被调用对象
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
    }
}
