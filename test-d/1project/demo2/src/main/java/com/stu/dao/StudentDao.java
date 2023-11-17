package com.stu.dao;

import com.stu.bean.Person;
import com.stu.bean.StudentAnswer;

import java.util.List;
public interface StudentDao {
    // 获取所有教师
    List<Person> getAllTeacher();

    // 搜索教师
    List<Person> getSearchTeacher(String matchText);

    // 获取我的教师
    List<Person> getMyTeacher(String userAccount);

    // 添加教师
    void addTeacher(String userAccount, String teacherAccount);

    // 获取教师任务
    List<StudentAnswer> goMyTeaTask(String userAccount, String teacherAccount);

    // 删除教师
    void deleteMyTeacher(String userAccount, String teacherAccount);

    // 做答案
    void doAnswer(String userAccount, String taskAccount, String answer);

    // 处理分数
    void dealFenshu(String taskAccount, String studentAccount, String fenshu);
}
