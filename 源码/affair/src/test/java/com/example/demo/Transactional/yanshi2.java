package com.example.demo.Transactional;

import com.example.demo.service.imp.Transactional.yanshi1.Yanshi1;
import com.example.demo.service.imp.Transactional.yanshi2.Yanshi2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

//演示②的相关例子
@SpringBootTest
public class yanshi2 {

    @Autowired
    private Yanshi2 ys2;

    @Test
    public void test1(){
        ys2.test1();
    }
}
