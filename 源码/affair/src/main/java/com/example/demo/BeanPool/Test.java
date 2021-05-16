package com.example.demo.BeanPool;


import com.example.demo.model.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//测试单例bean
public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Beans.class);
        User user1_1 = (User)context.getBean("user1");
        User user1_2 = (User)context.getBean("user1");
        User user2_1 = (User)context.getBean("user2");
        User user2_2 = (User)context.getBean("user2");
        System.out.println("user1_1:    "+user1_1.hashCode());
        System.out.println("user1_2:    "+user1_2.hashCode());
        System.out.println("user2_1:    "+user2_1.hashCode());
        System.out.println("user2_2:    "+user2_2.hashCode());
    }
}
