package com.mjq.spring.factory;


import com.mjq.spring.dao.UserDao;
import com.mjq.spring.dao.impl.UserDaoImpl;

public class StaticFactory{

    public static UserDao userDao() {
        //TODO 可以在此添加一些的操作
        System.out.println("静态工厂创建对象");
        return new UserDaoImpl();
    }
}
