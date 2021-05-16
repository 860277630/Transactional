package com.example.demo.Transactional;

import com.example.demo.service.imp.Transactional.yanshi3.Yanshi3;
import com.example.demo.service.imp.Transactional.yanshi5.Yanshi5;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

//演示⑤相关例子
@SpringBootTest
public class yanshi5 {
    @Autowired
    private Yanshi5 ys5;

    @Test
    public void test1(){
        ys5.c();
    }

}
