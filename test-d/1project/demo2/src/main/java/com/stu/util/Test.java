package com.stu.util;

import com.stu.bean.Person;
import com.stu.dao.TestDao;

public class Test {
    public static void main(String[] args) {
        Person p=new Person();
        p.setUserAccount("12345678");
        p.setUserPassword("1");
        Person person = TestDao.Login(p);

        if (person==null){
            System.out.println("登录失败");
        }else {
            System.out.println("登录成功"+person);
        }
    }
}
