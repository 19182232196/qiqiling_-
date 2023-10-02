package Test2;

import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class  Run extends Manager {
    //定义主界面
    public static void main(String[] args) {
        //创建学生管理界面
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GUI();
        }
    });
        //创建集合对象，用于储存学生数据
        ArrayList<Student> list = new ArrayList<>();
        while (true) {
            //用循环完成再次回到主界面,重复整个操作,但无法退出
            System.out.println("hello world");
            System.out.println("1.增加");
            System.out.println("2.减少");
            System.out.println("3.修改");
            System.out.println("4.查看");
            System.out.println("5.保存");
            System.out.println("6.退出");
            System.out.println("请输入你的选择：");
            //标准式输入
            Scanner sc = new Scanner(System.in);
            String i = sc.nextLine();
            //用switch语句完成操作的选择
            switch (i) {
                case "1" -> {
                    //增加
                    System.out.println("增加");
                    add(list);
                }
                case "2" -> {
                    //减少
                    System.out.println("减少");
                    remove(list);
                }
                case "3" -> {
                    //修改
                    System.out.println("修改");
                    introduce(list);
                }
                case "4" -> {
                    //查看
                    System.out.println("查看");
                    find(list);
                }
                case "5" -> {
                    System.out.println("保存");
                    save(list);
                }
                case "6" -> {
                    System.out.println("退出");
                    System.exit(0);
                }
                default -> System.out.println("输入错误，请重新输入");
            }
        }
    }
}