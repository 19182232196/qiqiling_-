package com.stu.service;

import com.stu.bean.Person;
import com.stu.bean.StudentAnswer;
import com.stu.dao.StudentDao;
import com.stu.dao.StudentDaoImpl;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    // 创建一个StudentDao对象
    StudentDao sd = new StudentDaoImpl();
    // 重写getAllTeacher()方法，获取所有教师信息
    @Override
    public List<Person> getAllTeacher() {
        return sd.getAllTeacher();
    }
    // 重写getSearchTeacher()方法，根据教师账号搜索教师信息
    @Override
    public List<Person> getSearchTeacher(String matchText) {
        return sd.getSearchTeacher(matchText);
    }
    // 重写getMyTeacher()方法，根据用户账号获取教师信息
    @Override
    public List<Person> getMyTeacher(String userAccount) {
        return sd.getMyTeacher(userAccount);
    }
    // 重写addTeacher()方法，添加教师信息
    @Override
    public void addTeacher(String userAccount, String teacherAccount) {
        sd.addTeacher(userAccount,teacherAccount);
    }
    // 重写goMyTeaTask()方法，根据用户账号和教师账号获取教师任务
    @Override
    public List<StudentAnswer> goMyTeaTask(String userAccount, String teacherAccount) {
        return sd.goMyTeaTask(userAccount,teacherAccount);
    }
    // 重写deleteMyTeacher()方法，根据用户账号和教师账号删除教师信息
    @Override
    public void deleteMyTeacher(String userAccount, String teacherAccount) {
        sd.deleteMyTeacher(userAccount,teacherAccount);
    }
    // 重写doAnswer()方法，根据用户账号、任务账号和答案提交答案
    @Override
    public void doAnswer(String userAccount, String taskAccount, String answer) {
        sd.doAnswer(userAccount,taskAccount,answer);
    }
    // 重写dealFenshu()方法，根据任务账号、学生账号和分值处理分值
    @Override
    public void dealFenshu(String taskAccount, String studentAccount, String fenshu) {
        sd.dealFenshu(taskAccount,studentAccount,fenshu);
    }
}
