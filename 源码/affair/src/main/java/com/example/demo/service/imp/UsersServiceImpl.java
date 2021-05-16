package com.example.demo.service.imp;

import com.example.demo.dao.UserMapper;
import com.example.demo.dao.UsersMapper;
import com.example.demo.model.User;
import com.example.demo.model.Users;
import com.example.demo.service.UserService;
import com.example.demo.service.UsersService;
import com.example.demo.word.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersMapper usersMapper;

    @Autowired
    private UserService userService;

    //@Autowired
   // private UsersService usersService;

    @Autowired
    private UserMapper userMapper;


    @Override
    @Transactional
    public int insertInto(Users u) {
        u.setId(UUIDUtils.getUUID());
        u.setUsername("peter");
        int num =  usersMapper.insert(u);
//        System.out.println(1/0);

        //自调用(或使用this)    捕获异常     全部不会回滚
        //自调用(或使用this)    不捕获异常   全部回滚

        //重新注入  捕获不捕获   全部回滚
     //  try{
           // userService.InsertInto();
        this.MessageInsert();
     //  } catch (Exception e){System.out.println("捕获一个异常");}
        return num;
    }
    @Override
    @Transactional
    public void MessageInsert() {
        User u = new User();
        List<User> users = userMapper.SelAll();
        User temp = users.get(users.size()-1);
        u.setId(temp.getId()+1);
        u.setPassWord("123456789");
        u.setRealName("xiaoli");
        u.setUserName("xiaoli");
        userMapper.insert(u);
        comMeth();
 /*       throw new RuntimeException ("出错了！！！");
        try {
            int num = 1/0;
        }catch (Exception e){
            System.out.println("异常被吃掉了");
            e.printStackTrace();
        }*/
    }

    public void comMeth(){
        throw new RuntimeException("this is a error!!!");
    }
    @Override
    public void insertInto1() {
        Users u = new Users();
        u.setId(UUIDUtils.getUUID());
        u.setUsername("peter");
        usersMapper.insert(u);
        System.out.println(Thread.currentThread().getName()+"========insertInto1==========");
    }

    @Override
    public void MessageInsert1() {
        User u = new User();
        List<User> users = userMapper.SelAll();
        User temp = users.get(users.size()-1);
        u.setId(temp.getId()+1);
        u.setPassWord("123456789");
        u.setRealName("tom");
        u.setUserName("Tom");
        userMapper.insert(u);
        System.out.println(Thread.currentThread().getName()+"========MessageInsert1==========");
    }

    @Override
    @Async
    public void sendMsg() {
        System.out.println(Thread.currentThread().getName()+"========sendMsg=========");
        throw new RuntimeException("======this is a error!!!=======");
    }

    @Override
    @Async
    public void sendMail() {
        System.out.println(Thread.currentThread().getName()+"========sendMail==========");
    }

    //进行事务的装填   自调用@Async  失效  即使重新注入也会报错
    @Override
    @Transactional
    public void orderTicket() {
        System.out.println("==============事务的传播=================");
        insertInto1();
        MessageInsert1();
        //userService.sendMsg();
        //userService.sendMail();
        sendMsg();
        sendMail();
    }




}
