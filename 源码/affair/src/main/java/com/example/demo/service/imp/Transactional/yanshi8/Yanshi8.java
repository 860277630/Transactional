package com.example.demo.service.imp.Transactional.yanshi8;

import com.example.demo.dao.UsersMapper;
import com.example.demo.model.Users;
import com.example.demo.word.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//用来演示CSDN  E到F的异常捕获问题
@Service
public class Yanshi8 {

    @Autowired
    private UsersMapper usersMapper;

    @Transactional
    public void E(){
        Users u = new Users();
        u.setId(UUIDUtils.getUUID());
        u.setUsername("peter");
        usersMapper.insert(u);
        try {
            C();
        }catch (Exception e){}
    }
    @Transactional
    public void C(){
        Users u = new Users();
        u.setId(UUIDUtils.getUUID());
        u.setUsername("zhangsan");
        usersMapper.insert(u);
        F();
    }
    public void F(){
        throw new RuntimeException("error demo");
    }
}
