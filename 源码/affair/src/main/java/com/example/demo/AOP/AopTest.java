package com.example.demo.AOP;

import com.example.demo.BeanPool.Beans;
import org.springframework.beans.factory.annotation.Autowired;
//都是使用了不一样的实例
public class AopTest {
    //自注入
    @Autowired
    private AopTest aopTest;

    //注入其他类
    @Autowired
    private Beans beans;
}
