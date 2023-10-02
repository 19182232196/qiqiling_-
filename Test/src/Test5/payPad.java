package Test5;

import java.util.Scanner;

public class payPad {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入新员工姓名：");
        String name=sc.nextLine();
        System.out.println("请输入新员工应聘的编程语言：");
        String language=sc.nextLine();
        switch (language) {
            case "java":
                System.out.println(name + "被分配到java程序开发部门");
                break;
            case "C#":
                System.out.println(name + "被分配到C#程序开发部门");
                break;
            case "asp.net":
                System.out.println(name + "被分配到asp.net程序测试部门");
                break;
            case "前端":
                System.out.println(name + "被分配到前端程序开发部门");
                break;
            default:
                System.out.println("该岗位不需要人了！");
                break;
        }
    }
}
