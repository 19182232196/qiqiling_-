package com.stu.util;

import com.stu.bean.Person;
import com.stu.bean.Person;
import com.stu.dao.Testdao;
import com.stu.util.Test;

public class Test {
    public static void main(String[] args) {
    Person p = new Person();
    p.setUserAccount("");
    p.setUserPassword("");
        Person p1 = Testdao.Login(p);
    }
}
