package com.example.demo.Transactional;

import com.example.demo.service.imp.Transactional.yanshi5.Yanshi5;
import com.example.demo.service.imp.Transactional.yanshi6.Yanshi6;
import com.example.demo.service.imp.Transactional.yanshi6.Yanshi6_3;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

//事务的异步调用
@SpringBootTest
public class yanshi6 {
    @Autowired
    private Yanshi6 ys6;
    @Autowired
    private Yanshi6_3 ys6_3;

    @Test
    public void test1(){
        ys6.test1();
    }


    @Test
    public void test2(){
        ys6_3.A();
    }
}
