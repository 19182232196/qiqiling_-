package com.stu.service;

import com.stu.bean.Person;
import com.stu.dao.UserLoginDao;
import com.stu.dao.UserLoginDaoImpl;

public class UserLoginServiceImpl implements  UserLoginService{
    UserLoginDao ud=new UserLoginDaoImpl();
    @Override
    public Person getLogin(Person person) {
        return ud.getLogin(person);
    }
}
