package com.stu.dao;

import com.stu.bean.Person;
import com.stu.bean.StudentAnswer;
import com.stu.bean.Task;
import com.stu.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Deal {
    public static List<Person> getAllPerson(String sql) {
        //获取数据库连接
        Connection connection = ConnectionFactory.getConnection();
        //创建预处理语句
        PreparedStatement pre = null;
        //创建结果集
        ResultSet res = null;
        //创建一个存放Person对象的List
        List<Person> list = new ArrayList<>();
        try {
            //根据sql语句创建预处理语句
            pre =connection.prepareStatement(sql);
            //执行预处理语句
            res = pre.executeQuery();
            //遍历结果集
            while(res.next()){
                //创建一个新的Person对象
                Person newPerson = new Person();
                //设置Person对象的属性
                newPerson.setUserAccount(res.getString("userAccount"));
                newPerson.setUserName(res.getString("userName"));
                newPerson.setUserSex(res.getString("userSex"));
                newPerson.setUserBirthday(res.getString("userBirthday"));
                newPerson.setUserIdCard(res.getString("userIdCard"));
                newPerson.setUserPassword(res.getString("userPassword"));
                newPerson.setUserIdentify(res.getInt("userIdentify"));
                newPerson.setUserOtherName(res.getString("userOtherName"));
                //将Person对象添加到List中
                list.add(newPerson);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {

        }
        //返回存放Person对象的List
        return list;
    }
    public static List<Task> getAllMyTask(String sql) {
        //获取数据库连接
        Connection connection = ConnectionFactory.getConnection();
        //创建预处理语句
        PreparedStatement pre = null;
        //创建结果集
        ResultSet res = null;
        //创建任务列表
        List<Task> list = new ArrayList<>();
        try {
            //预处理语句
            pre =connection.prepareStatement(sql);
            //执行查询
            res = pre.executeQuery();
            //遍历查询结果
            while(res.next()){
                //创建任务
                Task task = new Task();
                task.setTaskAccount(res.getString("taskAccount"));
                task.setTaskDate(res.getString("taskDate"));
                task.setTaskName(res.getString("taskName"));
                task.setTeacherAccount(res.getString("teacherAccount"));
                //将任务添加到任务列表
                list.add(task);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            //关闭资源
        }
        return list;
    }
    public static List<StudentAnswer> getTaskDetail(String sql) {
        //获取数据库连接
        Connection connection = ConnectionFactory.getConnection();
        //创建预处理语句
        PreparedStatement pre = null;
        //创建结果集
        ResultSet res = null;
        //创建存储结果的列表
        List<StudentAnswer> list = new ArrayList<>();
        try {
            //预处理语句
            pre =connection.prepareStatement(sql);
            //执行查询
            res = pre.executeQuery();
            //遍历结果集
            while(res.next()){
                //创建存储结果的对象
                StudentAnswer sa = new StudentAnswer();
                //设置任务账号
                sa.setTaskAccount(res.getString("taskAccount"));
                //设置学生账号
                sa.setStudentAccount(res.getString("studentAccount"));
                //设置学生答案
                sa.setStudentAnswer(res.getString("studentAnswer"));
                //设置是否完成
                sa.setIsFinish(res.getInt("isFinish"));
                //设置是否得分
                sa.setIsScore(res.getInt("isScore"));
                //设置用户名
                sa.setUserName(res.getString("userName"));
                //设置任务名
                sa.setTaskName(res.getString("taskName"));
                //将结果添加到列表中
                list.add(sa);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            //关闭资源
        }
        //返回结果列表
        return list;
    }
    public static int isExist(String sql) {
        //获取数据库连接
        Connection connection = ConnectionFactory.getConnection();
        //创建预处理语句
        PreparedStatement pre = null;
        //创建结果集
        ResultSet res = null;
        int num=0;
        try {
            //预处理语句
            pre =connection.prepareStatement(sql);
            //执行查询
            res = pre.executeQuery();
            //遍历结果集
            while(res.next()){
                //获取num
                num = res.getInt("num");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {

        }
        return num;
    }
    public static void deal(String sql) {
        //获取数据库连接
        Connection connection = ConnectionFactory.getConnection();
        //创建预处理语句
        PreparedStatement pre = null;
        //创建结果集
        ResultSet res = null;
        try {
            //预处理语句
            pre =connection.prepareStatement(sql);
            //执行查询
            pre.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {

        }
    }
}
