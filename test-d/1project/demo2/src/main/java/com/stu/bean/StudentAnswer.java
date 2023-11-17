package com.stu.bean;

public class StudentAnswer {
   private String taskAccount;
    // 学生账号
    private String studentAccount;
    // 学生答案
    private String studentAnswer;
    // 是否完成
    private int isFinish;
    // 是否正确
    private int isScore;
    // 用户名
    private String userName;
    // 任务名
    private String taskName;
   //获取任务账号
    public String getTaskAccount() {
        return taskAccount;
    }
    //设置任务账号
    public void setTaskAccount(String taskAccount) {
        this.taskAccount = taskAccount;
    }
    //获取学生账号
    public String getStudentAccount() {
        return studentAccount;
    }
    //设置学生账号
    public void setStudentAccount(String studentAccount) {
        this.studentAccount = studentAccount;
    }
    //获取学生答案
    public String getStudentAnswer() {
        return studentAnswer;
    }
    //设置学生答案
    public void setStudentAnswer(String studentAnswer) {
        this.studentAnswer = studentAnswer;
    }
    //获取是否完成
    public int getIsFinish() {
        return isFinish;
    }
    //设置是否完成
    public void setIsFinish(int isFinish) {
        this.isFinish = isFinish;
    }
    //获取是否评分
    public int getIsScore() {
        return isScore;
    }
    //设置是否评分
    public void setIsScore(int isScore) {
        this.isScore = isScore;
    }
    //获取用户名
    public String getUserName() {
        return userName;
    }
    //设置用户名
    public void setUserName(String userName) {
        this.userName = userName;
    }
    //获取任务名
    public String getTaskName() {
        return taskName;
    }
    //设置任务名
    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }
}