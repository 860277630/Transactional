package com.example.demo.Transactional;

import com.example.demo.service.imp.Transactional.yanshi2.Yanshi2;
import com.example.demo.service.imp.Transactional.yanshi3.Yanshi3;
import com.example.demo.service.imp.Transactional.yanshi3.Yanshi3_2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

//演示③相关例子
@SpringBootTest
public class yanshi3 {
    @Autowired
    private Yanshi3 ys3;
    @Autowired
    private Yanshi3_2 ys3_2;

    @Test
    public void test1(){
        ys3.test1();
    }

    @Test
    public void test2(){
        ys3_2.test1();
    }
}
