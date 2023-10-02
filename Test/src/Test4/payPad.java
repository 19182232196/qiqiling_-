package Test4;

import java.util.Scanner;

public class payPad {
    public static void main(String[] args){
        String a="Y";
        double sum=0.0;
        do{
            System.out.println("请输入购买的编号：");
            Scanner sc=new Scanner(System.in);
            int num=sc.nextInt();
            switch(num){

                case (1):
                    System.out.println("请输入购买牙刷的数量:");
                    int num1 = sc.nextInt();
                    sum += num1 * 8.8;
                    System.out.println("是否继续购物:");
                    a = sc.next();
                    break;
                case (2):
                    System.out.println("请输入购买毛巾的数量:");
                    int num2 = sc.nextInt();
                    sum += num2 * 10;
                    System.out.println("是否继续购物:");
                    a = sc.next();
                    break;
                case (3):
                    System.out.println("请输入购买水杯的数量:");
                    int num3 = sc.nextInt();
                    sum += num3 * 18.8;
                    System.out.println("是否继续购物:");
                    a = sc.next();
                    break;
                case (4):
                    System.out.println("请输入购买苹果的数量:");
                    int num4 = sc.nextInt();
                    sum += num4 * 12.5;
                    System.out.println("是否继续购物:");
                    a = sc.next();
                    break;
                case (5):
                    System.out.println("请输入购买香蕉的数量:");
                    int num5 = sc.nextInt();
                    sum += num5 * 15.5;
                    System.out.println("是否继续购物:");
                    a = sc.next();
                    break;
            }
        }
        while (a.equals("Y"));
        System.out.println("购物总金额为:" + sum);
    }
}
