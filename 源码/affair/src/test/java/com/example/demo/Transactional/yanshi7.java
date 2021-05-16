package com.example.demo.Transactional;

import com.example.demo.service.imp.Transactional.yanshi7.Yanshi7;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

//@async   AOP特性
@SpringBootTest
public class yanshi7 {
    @Autowired
    private Yanshi7 yanshi7;

    @Test
    public void test1(){
        yanshi7.test1();
    }
}
