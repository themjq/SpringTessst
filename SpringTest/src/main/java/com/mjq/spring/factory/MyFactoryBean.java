package com.mjq.spring.factory;

import com.mjq.spring.dao.UserDao;
import com.mjq.spring.dao.impl.UserDaoImpl;
import org.springframework.beans.factory.FactoryBean;

public class MyFactoryBean implements FactoryBean<UserDao> {
    @Override
    public UserDao getObject() throws Exception {
        System.out.println("FactoryBean方式创建对象");
        return new UserDaoImpl();
    }

    @Override
    public Class<?> getObjectType() {
        return UserDao.class;
    }
}
