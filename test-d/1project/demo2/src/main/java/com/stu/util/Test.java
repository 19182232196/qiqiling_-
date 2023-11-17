package com.stu.util;

import com.stu.dao.Deal;
import com.stu.dao.Generate;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {




    public static void main(String[] args) {
        Deal.deal("INSERT INTO task VALUES('11','11','11','11')");

    }

    public static String getDate() {
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat sdt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdt.format(date);
    }

    public static String getTaskAccount() {
        String taskAccount ="";
        while (true){
            for(int i=0;i<8;i++){
                taskAccount = taskAccount+Integer.toString((int)(1+Math.random()*(10-1+1)));
            }
            int num = Generate.isExistTaskAccount(taskAccount);
            if(num==0){
                break;
            }else {
                taskAccount="";
            }
        }
        return taskAccount;
    }

    public static String getPersonAccount() {
        String userAccount ="";
        while (true){
            for(int i=0;i<8;i++){
                userAccount = userAccount+Integer.toString((int)(1+Math.random()*(10-1+1)));
            }
            int num = Generate.isExistPersonAccount(userAccount);
            if(num==0){
                break;
            }else {
                userAccount="";
            }
        }
        return userAccount;
    }
}
