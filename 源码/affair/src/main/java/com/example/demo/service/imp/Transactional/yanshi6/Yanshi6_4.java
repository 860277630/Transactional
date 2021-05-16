package com.example.demo.service.imp.Transactional.yanshi6;

import com.example.demo.dao.UsersMapper;
import com.example.demo.model.Users;
import com.example.demo.word.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class Yanshi6_4 {

    @Autowired
    private UsersMapper usersMapper;

    @Async
    public void B(){
        System.out.println("B当前线程："+Thread.currentThread().getName());
        throw new RuntimeException("error");
    }

    @Async
    @Transactional
    public void C() {
        Users u = new Users();
        u.setId(UUIDUtils.getUUID());
        u.setUsername("louis");
        usersMapper.insert(u);
        System.out.println("C当前线程："+Thread.currentThread().getName());
        D();
    }
    public void D(){
        System.out.println("D当前线程："+Thread.currentThread().getName());
        throw new RuntimeException("error");
    }
}
