package com.example.demo.service.imp;

import com.example.demo.dao.UserMapper;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    UserMapper userMapper;




    @Override
    public List<User> SelAll(){
        return userMapper.SelAll();
    }

    @Override
    @Transactional
    public void InsertInto() {
        User u = new User();
        List<User> users = userMapper.SelAll();
        User temp = users.get(users.size()-1);
        u.setId(temp.getId()+1);
        u.setPassWord("123456789");
        u.setRealName("tom");
        u.setUserName("Tom");
        userMapper.insert(u);
        throw new RuntimeException ("出错了！！！");
    }
    @Override
    @Async
    public void sendMsg() {
        System.out.println(Thread.currentThread().getName()+"========sendMsg=========");
        throw new RuntimeException("======this is a error!!!=======");
    }

    @Override
    @Async
    public void sendMail() {
        System.out.println(Thread.currentThread().getName()+"========sendMail==========");
    }
}
