package com.stu.dao;

public class Generate {
   // 判断任务账号是否存在
    public static int isExistTaskAccount(String taskAccount) {
        // 查询任务表中任务账号的数量
        String sql = "select count(*) num from task where taskAccount='"+taskAccount+"'";
        // 返回查询结果
        return Deal.isExist(sql);
    }

    // 判断用户账号和教师账号是否存在
    public static int IsExistStuTea(String userAccount, String teacherAccount) {
        // 查询用户教师表中用户账号和教师账号的数量
        String sql = "select count(*) num from userteacher where userAccount='"+userAccount+"' and teacherAccount='"+teacherAccount+"'";
        // 返回查询结果
        return Deal.isExist(sql);
    }

    // 判断用户账号是否存在
    public static int isExistPersonAccount(String userAccount) {
        // 查询用户表中用户账号的数量
        String sql = "select count(*) num from person where userAccount='"+userAccount+"'";
        // 返回查询结果
        return Deal.isExist(sql);
    }
}