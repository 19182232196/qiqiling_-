package com.stu.dao;

import com.stu.bean.Person;

import java.sql.Connection;

public class Testdao {
    public static Person Login(Person p){
        String sql=
        "select * from person where userAccount='"+p.getUserAccount()+"' and userPassword='"+p.getUserPassword()+"'";
        Connection connection= ConnectionFactory.getConnection();

        return p;
    }
}
