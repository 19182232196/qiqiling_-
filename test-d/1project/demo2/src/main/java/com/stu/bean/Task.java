package com.stu.bean;

public class Task {
    private String taskAccount;
    // 任务创建者账号
    private String teacherAccount;
    // 任务创建者账号
    private String taskDate;
    // 任务创建时间
    private String taskName;
    // 任务名称
    public Task() {
    }
    // 构造函数，用于初始化Task对象
    public Task(String taskAccount, String teacherAccount, String taskDate, String taskName) {
        this.taskAccount = taskAccount;
        this.teacherAccount = teacherAccount;
        this.taskDate = taskDate;
        this.taskName = taskName;
    }
    // 获取任务账号
    public String getTaskAccount() {
        return taskAccount;
    }
    // 设置任务账号
    public void setTaskAccount(String taskAccount) {
        this.taskAccount = taskAccount;
    }
    // 获取教师账号
    public String getTeacherAccount() {
        return teacherAccount;
    }
    // 设置教师账号
    public void setTeacherAccount(String teacherAccount) {
        this.teacherAccount = teacherAccount;
    }
    // 获取任务日期
    public String getTaskDate() {
        return taskDate;
    }
    // 设置任务日期
    public void setTaskDate(String taskDate) {
        this.taskDate = taskDate;
    }
    // 获取任务名称
    public String getTaskName() {
        return taskName;
    }
    // 设置任务名称
    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }
    // 重写toString方法，用于返回Task对象的字符串表示
    @Override
    public String toString() {
        return "Task{" +
                "taskAccount='" + taskAccount + '\'' +
                ", teacherAccount='" + teacherAccount + '\'' +
                ", taskDate='" + taskDate + '\'' +
                ", taskName='" + taskName + '\'' +
                '}';
    }
}
