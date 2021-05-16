package com.example.demo.service.imp.Transactional.yanshi6;

import com.example.demo.dao.UserMapper;
import com.example.demo.dao.UsersMapper;
import com.example.demo.model.Users;
import com.example.demo.word.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//事务的异步特性演示
//异步的自调用会让事务失效
//异步的异调用会终止事务的传播
@Service
public class Yanshi6 {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UsersMapper usersMapper;

    @Transactional
    public void test1() {
        Users u = new Users();
        u.setId(UUIDUtils.getUUID());
        u.setUsername("peter");
        usersMapper.insert(u);
        System.out.println("test1当前线程："+Thread.currentThread().getName());
        new Thread(() -> {
            this.test2();
        }).start();
    }
    @Transactional
    public void test2() {
        Users u = new Users();
        u.setId(UUIDUtils.getUUID());
        u.setUsername("CAPCOM");
        usersMapper.insert(u);
        System.out.println("test1当前线程："+ Thread.currentThread().getName());
        this.test3();
    }
    public void test3() {
        System.out.println("ssssssss" + Thread.currentThread().getName());
        throw new RuntimeException("error!!!");
    }
}
