package com.example.demo.BeanPool;

import com.example.demo.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Beans {

    @Bean
    public User user1(){
        return new User();
    }
    @Bean
    public User user2(){
        return new User();
    }
}
