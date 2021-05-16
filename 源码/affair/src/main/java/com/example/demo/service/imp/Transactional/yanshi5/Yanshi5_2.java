package com.example.demo.service.imp.Transactional.yanshi5;

import com.example.demo.dao.UserMapper;
import com.example.demo.dao.UsersMapper;
import com.example.demo.model.User;
import com.example.demo.model.Users;
import com.example.demo.word.UUIDUtils;
import com.sun.javafx.scene.control.skin.TableHeaderRow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class Yanshi5_2 {
    //注入一个新实例
    @Autowired
    private Yanshi5 yanshi5;

    //重注入一个本类
    @Autowired
    private Yanshi5_2 yanshi5_2;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UsersMapper usersMapper;

    @Transactional
    public void a() {
        Users u = new Users();
        u.setId(UUIDUtils.getUUID());
        u.setUsername("Charles");
        usersMapper.insert(u);
        yanshi5.e();
    }

    public void b() {
        throw new RuntimeException("error");
    }
}
