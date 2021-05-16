package com.example.demo.service.imp.Transactional.yanshi7;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class Yanshi7_2 {

    @Async
    public void test3(){
        System.out.println("test3 当前线程："+Thread.currentThread().getName());
    }
}
