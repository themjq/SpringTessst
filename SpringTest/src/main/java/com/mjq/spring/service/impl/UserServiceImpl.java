package com.mjq.spring.service.impl;

import com.mjq.spring.dao.UserDao;
import com.mjq.spring.service.UserService;

public class UserServiceImpl implements UserService {

    /**
     * 注意，set方法的命名有要求 必须以set开头，对应后缀要为property中ref的Bean的name
     */
    // 注入其它Bean: UserDao
    public void setUserDao(UserDao userDao){
        System.out.println("调用UserServiceImmpl中setUserDao方法:\t"+userDao);
    }

    public UserServiceImpl(){
        System.out.println("执行了UserServiceImmpl无参构造器");
    }
    public UserServiceImpl(String name){
        System.out.println("执行了UserServiceImmpl有参构造器:参数为: name="+name);
    }
    public UserServiceImpl(String name,Integer age){
        System.out.println("执行了UserServiceImmpl有参构造器:参数为: name="+name+" age="+age);
    }
}
