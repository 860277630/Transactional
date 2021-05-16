package com.example.demo.Transactional;

import com.example.demo.service.imp.Transactional.yanshi1.Yanshi1;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

//演示①的相关例子
@SpringBootTest
public class yanshi1 {
    @Autowired
    private Yanshi1 ys1;
    //正常抛异常  事务回滚
    @Test
    public void test1(){
        System.out.println("=========test1=============");
        ys1.test1();
    }
    //throw抛异常  事务回滚
    @Test
    public void test2() throws Exception {
        System.out.println("=========test2=============");
        ys1.test2();

    }
    //捕获异常  事务不回滚
    @Test
    public void test3(){
        System.out.println("=========test3=============");
        ys1.test3();
    }

}
