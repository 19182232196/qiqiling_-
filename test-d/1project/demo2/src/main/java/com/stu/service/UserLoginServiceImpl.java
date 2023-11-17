package com.stu.service;

import com.stu.bean.Person;
import com.stu.dao.UserLoginDao;
import com.stu.dao.UserLoginDaoImpl;

public class UserLoginServiceImpl implements UserLoginService {
    // 创建UserLoginDaoImpl类的实例
    UserLoginDao ud = new UserLoginDaoImpl();
    // 重写getLogin方法，实现UserLoginService接口
    @Override
    public Person getLogin(Person person) {
        // 调用ud实例的getLogin方法，获取登录信息
        return ud.getLogin(person);
    }
}
