package com.stu.service;

import com.stu.bean.Person;

// 定义一个接口，用于获取登录信息
public interface UserLoginService {
    // 获取登录信息
    Person getLogin(Person person);
}
