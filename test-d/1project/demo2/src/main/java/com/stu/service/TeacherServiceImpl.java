package com.stu.service;

import com.stu.bean.StudentAnswer;
import com.stu.bean.Task;
import com.stu.dao.TeacherDao;
import com.stu.dao.TeacherDaoImpl;

import java.util.List;

public class TeacherServiceImpl implements TeacherService {
    // 创建一个TeacherDao对象
    TeacherDao td = new TeacherDaoImpl();
    // 重写AllStudentsByTeacherAccount方法，根据教师账号获取学生列表
    @Override
    public List AllStudentsByTeacherAccount(String userAccount) {
        // 调用TeacherDaoImpl的AllStudentsByTeacherAccount方法，根据教师账号获取学生列表
        return td.AllStudentsByTeacherAccount(userAccount);
    }
    // 重写getAllMyTask方法，根据教师账号获取任务列表
    @Override
    public List<Task> getAllMyTask(String userAccount) {
        // 调用TeacherDaoImpl的getAllMyTask方法，根据教师账号获取任务列表
        return td.getAllMyTask(userAccount);
    }
    // 重写getTaskDetail方法，根据任务账号获取任务详情
    @Override
    public List<StudentAnswer> getTaskDetail(String taskAccount) {
        // 调用TeacherDaoImpl的getTaskDetail方法，根据任务账号获取任务详情
        return td.getTaskDetail(taskAccount);
    }
    // 重写AddTask方法，添加任务
    @Override
    public void AddTask(Task task) {
        // 调用TeacherDaoImpl的AddTask方法，添加任务
        td.AddTask(task);
    }
    // 重写getSearchStudentByTeacherAccount方法，根据教师账号和匹配文本获取搜索学生列表
    @Override
    public List getSearchStudentByTeacherAccount(String userAccount,String matchText) {
        // 调用TeacherDaoImpl的getSearchStudentByTeacherAccount方法，根据教师账号和匹配文本获取搜索学生列表
        return td.getSearchStudentByTeacherAccount(userAccount,matchText);
    }
    // 重写goStudentTaskDetail方法，根据教师账号和学生账号获取学生任务详情
    @Override
    public List<StudentAnswer> goStudentTaskDetail(String userAccount, String studentAccount) {
        // 调用TeacherDaoImpl的goStudentTaskDetail方法，根据教师账号和学生账号获取学生任务详情
        return td.goStudentTaskDetail(userAccount,studentAccount);
    }
    // 重写deleteTask方法，根据任务账号、学生账号和是否完成状态删除任务
    @Override
    public void deleteTask(String taskAccount,String studentAccount, String isFinish) {
        // 调用TeacherDaoImpl的deleteTask方法，根据任务账号、学生账号和是否完成状态删除任务
        td.deleteTask(taskAccount, studentAccount, isFinish);
    }
    // 重写deleteThisTask方法，根据任务账号删除任务
    @Override
    public void deleteThisTask(String taskAccount) {
        // 调用TeacherDaoImpl的deleteThisTask方法，根据任务账号删除任务
        td.deleteThisTask(taskAccount);
    }
    // 重写deleteThisPersonByTeacher方法，根据学生账号和教师账号删除该学生
    @Override
    public void deleteThisPersonByTeacher(String studentAccount, String userAccount) {
        // 调用TeacherDaoImpl的deleteThisPersonByTeacher方法，根据学生账号和教师账号删除该学生
        td.deleteThisPersonByTeacher(studentAccount,userAccount);
    }
}