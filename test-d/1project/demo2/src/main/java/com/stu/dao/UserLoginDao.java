package com.stu.dao;

import com.stu.bean.Person;

// 获取用户登录信息
public interface UserLoginDao {
    Person getLogin(Person person);
}