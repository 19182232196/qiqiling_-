package com.stu.dao;

import com.stu.bean.Person;

import java.util.List;

public interface ManageDao {
   //获取所有Person对象
    List<Person> getAllPerson();
    //根据文本搜索Person对象
    List<Person> getSearch(String matchText);
    //添加Person对象
    void addPerson(Person newPerson);
    //修改用户密码
    void sureUpPassword(String userAccount, String userPassword);
    //删除Person对象
    void delThisPerson(String delAccount, String userIdentify);
}