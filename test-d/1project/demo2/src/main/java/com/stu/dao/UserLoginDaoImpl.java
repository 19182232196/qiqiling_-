package com.stu.dao;

import com.stu.bean.Person;
import com.stu.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserLoginDaoImpl implements UserLoginDao {
    @Override
    public Person getLogin(Person person) {
        // 定义sql语句
        String sql = "select * from person where userAccount='"+person.getUserAccount()+"' and userPassword='"+person.getUserPassword()+"'";
        // 获取数据库连接
        Connection connection = ConnectionFactory.getConnection();
        // 创建预处理语句
        PreparedStatement pre = null;
        // 创建结果集
        ResultSet res = null;
        // 定义新的Person对象
        Person newPerson = null;
        try {
            // 预处理语句
            pre =connection.prepareStatement(sql);
            // 执行查询
            res = pre.executeQuery();
            // 遍历结果集
            while(res.next()){
                // 创建新的Person对象
                newPerson = new Person();
                // 设置Person对象属性
                newPerson.setUserAccount(res.getString("userAccount"));
                newPerson.setUserName(res.getString("userName"));
                newPerson.setUserSex(res.getString("userSex"));
                newPerson.setUserBirthday(res.getString("userBirthday"));
                newPerson.setUserIdCard(res.getString("userIdCard"));
                newPerson.setUserPassword(res.getString("userPassword"));
                newPerson.setUserIdentify(res.getInt("userIdentify"));
                newPerson.setUserOtherName(res.getString("userOtherName"));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {

        }


        return newPerson;
    }
}
