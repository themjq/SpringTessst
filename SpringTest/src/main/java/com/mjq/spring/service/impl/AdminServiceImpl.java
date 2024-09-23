package com.mjq.spring.service.impl;

import com.mjq.spring.dao.AdminDao;
import com.mjq.spring.dao.UserDao;
import com.mjq.spring.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("adminService")
public class AdminServiceImpl implements AdminService {
    //@Autowired
    private AdminDao adminDao;
    @Autowired
    public void setAdminDao(AdminDao adminDao){
        this.adminDao=adminDao;
    }
    @Override
    public void test(){
        System.out.println(adminDao);
    }
}
