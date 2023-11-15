package com.stu.dao;

import com.stu.bean.Person;
import com.stu.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserLoginDaoImpl implements UserLoginDao{

    @Override
    public Person getLogin(Person p) {
        String sql="select * from person where userAccount='"+p.getUserAccount()+"'and userPassword='"+p.getUserPassword()+"'";
        Connection connection= ConnectionFactory.getConnection();
        PreparedStatement pre=null;
        ResultSet res=null;
        Person newPerson=new Person();;

        try {
            pre=connection.prepareStatement(sql);
            res=pre.executeQuery();
            while (res.next()){
                newPerson.setUserAccount(res.getString("userAccount"));
                newPerson.setUserName(res.getString("userName"));
                newPerson.setUserSex(res.getString("userSex"));
                newPerson.setUserBirthday(res.getString("userBirthday"));
                newPerson.setUserIdCard(res.getString("userIdCard"));
                newPerson.setUserPassword(res.getString("userPassword"));
                newPerson.setUserIdentify(res.getInt("userIdentify"));
                newPerson.setUserOtherName(res.getString("userOtherName"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  newPerson;
    }
}
