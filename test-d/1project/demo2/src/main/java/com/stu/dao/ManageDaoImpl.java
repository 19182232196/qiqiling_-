package com.stu.dao;

import com.stu.bean.Person;

import java.util.List;

// 获取所有普通用户
public class ManageDaoImpl implements ManageDao {
    @Override
    public List<Person> getAllPerson() {
        String sql = "select * from person where userIdentify!=2";
        return Deal.getAllPerson(sql);
    }
    // 根据关键字搜索普通用户
    @Override
    public List<Person> getSearch(String matchText) {
        String sql = "select * from person where userIdentify!=2 and (userAccount='' or userName like '%"+matchText+"%' or userIdCard='"+matchText+"')";
        return Deal.getAllPerson(sql);
    }
    // 添加普通用户
    @Override
    public void addPerson(Person newPerson) {
        String sql = "insert into person values('"+newPerson.getUserAccount()+"','"+newPerson.getUserName()+"','"+newPerson.getUserSex()+"','"+newPerson.getUserBirthday()+"','"+newPerson.getUserIdCard()+"','"+newPerson.getUserPassword()+"',"+newPerson.getUserIdentify()+",'"+newPerson.getUserOtherName()+"')";
        Deal.deal(sql);
    }
    // 修改普通用户密码
    @Override
    public void sureUpPassword(String userAccount, String userPassword) {
        String sql = "update person set userPassword = '"+userPassword+"' where userAccount='"+userAccount+"'";
        Deal.deal(sql);
    }
    // 删除普通用户
   @Override
    public void delThisPerson(String delAccount, String userIdentify) {
        if(Integer.parseInt(userIdentify)==0){
            //删除学生
            String sql = "DELETE FROM userteacher WHERE `userAccount` = '"+delAccount+"'";
            Deal.deal(sql);
            sql = "DELETE FROM studenttask WHERE studentAccount = '"+delAccount+"'";
            Deal.deal(sql);
        }else{
            //删除老师
            String sql = "DELETE FROM `studenttask` WHERE taskAccount IN (SELECT taskAccount FROM task WHERE teacherAccount='"+delAccount+"')";
            Deal.deal(sql);
            sql = "DELETE FROM task WHERE teacherAccount = '"+delAccount+"'";
            Deal.deal(sql);
            sql = "DELETE FROM userteacher WHERE teacherAccount = '"+delAccount+"'";
            Deal.deal(sql);
        }
        String sql = "DELETE FROM person WHERE userAccount = '"+delAccount+"'";
        Deal.deal(sql);
    }
}