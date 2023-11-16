package com.stu.service;

import com.stu.bean.Person;
import com.stu.dao.ManageDao;
import com.stu.dao.ManageDaoImpl;

import java.util.List;

public class ManageServiceImpl implements  ManageService{
    ManageDao md = new ManageDaoImpl();
    @Override
    public List<Person> getAllPerson() {
    return md.getAllPerson();
    }
}
