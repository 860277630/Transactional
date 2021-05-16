package com.example.demo.service.imp.Transactional.yanshi4;

import com.example.demo.service.imp.Transactional.yanshi3.Yanshi3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//重新注入和注入其他类的实例
//因为异步的重注入会报错  所以先注销掉
@Service
public class Yanshi4 {

/*    @Autowired
    private Yanshi4 yanshi4;

    @Autowired
    private Yanshi3 yanshi3;

    @Async
    public void test1(){
        System.out.println("异步调用！！！");
    }

    @Transactional
    public void test2(){
        System.out.println("同步调用！！！");
    }*/
}
