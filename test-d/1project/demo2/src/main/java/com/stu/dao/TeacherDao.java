package com.stu.dao;

import com.stu.bean.StudentAnswer;
import com.stu.bean.Task;

import java.util.List;

public interface TeacherDao {
    // 根据教师账号获取所有学生
    List AllStudentsByTeacherAccount(String userAccount);
    // 获取所有任务
    List<Task> getAllMyTask(String userAccount);
    // 获取任务详情
    List<StudentAnswer> getTaskDetail(String taskAccount);
    // 添加任务
    void AddTask(Task task);
    // 根据教师账号搜索学生
    List getSearchStudentByTeacherAccount(String userAccount,String matchText);
    // 获取学生任务详情
    List<StudentAnswer> goStudentTaskDetail(String userAccount, String studentAccount);
    // 删除任务
    void deleteTask(String taskAccount,String studentAccount, String isFinish);
    // 删除任务
    void deleteThisTask(String taskAccount);
    // 删除学生
    void deleteThisPersonByTeacher(String studentAccount, String userAccount);
}
