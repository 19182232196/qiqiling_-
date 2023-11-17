package com.stu.service;

import com.stu.bean.Person;
import com.stu.dao.ManageDao;
import com.stu.dao.ManageDaoImpl;

import java.util.List;


public class ManageServiceImpl implements ManageService {
    // 创建ManageDao对象
    ManageDao md = new ManageDaoImpl();
    // 重写getAllPerson()方法，返回所有Person对象
    @Override
    public List<Person> getAllPerson() {
        return md.getAllPerson();
    }

    // 重写getSearch()方法，根据传入的matchText参数，返回所有Person对象
    @Override
    public List<Person> getSearch(String matchText) {
        return md.getSearch(matchText);
    }

    // 重写addPerson()方法，添加Person对象
    @Override
    public void addPerson(Person newPerson) {
        md.addPerson(newPerson);
    }

    // 重写sureUpPassword()方法，修改用户密码
    @Override
    public void sureUpPassword(String userAccount, String userPassword) {
        md.sureUpPassword(userAccount,userPassword);
    }

    // 重写delThisPerson()方法，根据传入的delAccount和userIdentify参数，删除Person对象
    @Override
    public void delThisPerson(String delAccount, String userIdentify) {
        md.delThisPerson(delAccount,userIdentify);
    }
}
