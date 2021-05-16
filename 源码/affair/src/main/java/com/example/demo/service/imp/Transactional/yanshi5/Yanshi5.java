package com.example.demo.service.imp.Transactional.yanshi5;

import com.example.demo.dao.UserMapper;
import com.example.demo.dao.UsersMapper;
import com.example.demo.model.Users;
import com.example.demo.word.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//重注入  注入新实例  事务回退问题
@Service
public class Yanshi5 {
    //重注入一个本类
    @Autowired
    private Yanshi5 yanshi5;

    //注入一个新实例
    @Autowired
    private Yanshi5_2 yanshi5_2;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UsersMapper usersMapper;


    public void c() {
        Users u = new Users();
        u.setId(UUIDUtils.getUUID());
        u.setUsername("peter");
        usersMapper.insert(u);
        d();
    }
    @Transactional
    public void d() {
        Users u = new Users();
        u.setId(UUIDUtils.getUUID());
        u.setUsername("louis");
        usersMapper.insert(u);
        yanshi5_2.a();
    }
    @Transactional
    public void e() {
        Users u = new Users();
        u.setId(UUIDUtils.getUUID());
        u.setUsername("CAPCOM");
        usersMapper.insert(u);
        try {
            yanshi5_2.b();
        }catch (Exception e){}
    }


}
