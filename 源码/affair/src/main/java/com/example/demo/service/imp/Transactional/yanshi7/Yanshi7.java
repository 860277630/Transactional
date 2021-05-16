package com.example.demo.service.imp.Transactional.yanshi7;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class Yanshi7 {

    @Autowired
    private Yanshi7_2 yanshi7_2;

    public void test1(){
        System.out.println("test1 当前线程："+Thread.currentThread().getName());
        test2();
        yanshi7_2.test3();
        new Thread(() ->{
            test4();
        }).start();
    }
    @Async
    public void test2(){
        System.out.println("test2 当前线程："+Thread.currentThread().getName());
    }
    public void test4(){
        System.out.println("test4 当前线程："+Thread.currentThread().getName());
    }
}
