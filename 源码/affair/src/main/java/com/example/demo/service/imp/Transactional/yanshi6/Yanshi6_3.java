package com.example.demo.service.imp.Transactional.yanshi6;

import com.example.demo.dao.UsersMapper;
import com.example.demo.model.Users;
import com.example.demo.word.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//异步的异调用会终止事务的传播
//异实例调用@async生效  AOP特性   所以我们使用 @async
@Service
public class Yanshi6_3 {

    @Autowired
    private UsersMapper usersMapper;


    @Autowired
    private Yanshi6_4 yanshi6_4;

    @Transactional
    public void A() {
        Users u = new Users();
        u.setId(UUIDUtils.getUUID());
        u.setUsername("peter");
        usersMapper.insert(u);
        System.out.println("A当前线程："+Thread.currentThread().getName());
        yanshi6_4.B();
        yanshi6_4.C();
    }


}
