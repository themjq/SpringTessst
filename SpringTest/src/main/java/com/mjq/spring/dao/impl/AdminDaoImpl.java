package com.mjq.spring.dao.impl;

import com.mjq.spring.dao.AdminDao;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 等价替换
 * <bean id="userDaoBean" class="com.mjq.spring.dao.impl.UserDaoImpl"></bean>
 */
@Component(value = "adminDaoBean")
/**
 * 如果不指定value,则默认为类名首字母小写
 */
public class AdminDaoImpl implements AdminDao {

    @Value("${my.test}")
    private String test;
    @Override
    public void test() {
        System.out.println(test);
    }
}
