package com.stu.util;

import com.stu.dao.Deal;
import com.stu.dao.Generate;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
    public static void main(String[] args) {
        // 调用Deal类中的deal方法，传入参数为插入任务表的sql语句
        Deal.deal("INSERT INTO task VALUES('11','11','11','11')");

    }
    // 获取当前时间
    public static String getDate() {
        // 创建一个Date对象，参数为当前时间戳
        Date date = new Date(System.currentTimeMillis());
        // 创建一个SimpleDateFormat对象，参数为时间格式
        SimpleDateFormat sdt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 返回当前时间
        return sdt.format(date);
    }
    // 获取任务账号
    public static String getTaskAccount() {
        // 初始化任务账号
        String taskAccount ="";
        // 循环8次，每次循环生成一个8位数的任务账号
        while (true){
            for(int i=0;i<8;i++){
                taskAccount = taskAccount+Integer.toString((int)(1+Math.random()*(10-1+1)));
            }
            // 调用Generate类中的isExistTaskAccount方法，传入参数为当前任务账号
            int num = Generate.isExistTaskAccount(taskAccount);
            // 如果任务账号不存在，则跳出循环
            if(num==0){
                break;
            }else {
                // 如果任务账号存在，则重新生成任务账号
                taskAccount="";
            }
        }
        // 返回任务账号
        return taskAccount;
    }
    // 获取个人账号
    public static String getPersonAccount() {
        // 初始化个人账号
        String userAccount ="";
        // 循环8次，每次循环生成一个8位数的个人账号
        while (true){
            for(int i=0;i<8;i++){
                userAccount = userAccount+Integer.toString((int)(1+Math.random()*(10-1+1)));
            }
            // 调用Generate类中的isExistPersonAccount方法，传入参数为当前个人账号
            int num = Generate.isExistPersonAccount(userAccount);
            // 如果个人账号不存在，则跳出循环
            if(num==0){
                break;
            }else {
                // 如果个人账号存在，则重新生成个人账号
                userAccount="";
            }
        }
        // 返回个人账号
        return userAccount;
    }
}