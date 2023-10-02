package Test6;

import java.util.Scanner;
import java.util.Random;

public class payPad {
    public static void main(String[] args) {
        int a = 0;
        int b = 0;
        System.out.println("程序已启动");
        System.out.println("剪刀  石头  布");
        Scanner sc = new Scanner(System.in);
        boolean inputCorrect = false;
        while (!inputCorrect) {
            System.out.print("请输入您的出拳（剪刀、石头、布）：");
            String enter = sc.next();
            inputCorrect = enter.equals("剪刀") || enter.equals("石头") || enter.equals("布");
            if (!inputCorrect) {
                System.out.println("输入错误");
                System.exit(0);
            }
        }

        for (int i = 1; i <= 5; i++) {
            System.out.println("第" + i + "局");
            String enter = sc.next();
            int random = new Random().nextInt(3) + 1;
            if (enter.equals("剪刀")) {
                if (random == 1) {
                    System.out.println("电脑出了剪刀");
                    System.out.println("平");
                    b++;
                } else if (random == 2) {
                    System.out.println("电脑出了石头");
                    System.out.println("输");
                } else if (random == 3) {
                    System.out.println("电脑出了布");
                    System.out.println("赢");
                    a++;
                }
            }
            if (enter.equals("石头")) {
                if (random == 1) {
                    System.out.println("电脑出了剪刀");
                    System.out.println("赢");
                    a++;
                } else if (random == 2) {
                    System.out.println("电脑出了石头");
                    System.out.println("平");
                } else if (random == 3) {
                    System.out.println("电脑出了布");
                    System.out.println("输");
                    b++;
                }
            }
            if (enter.equals("布")) {
                if (random == 1) {
                    System.out.println("电脑出了剪刀");
                    System.out.println("输");
                    b++;
                } else if (random == 2) {
                    System.out.println("电脑出了石头");
                    System.out.println("赢");
                    a++;
                } else  if (random == 3){
                    System.out.println("电脑出了布");
                    System.out.println("平");
                }
            }
        }
        System.out.println("电脑赢了"+b+"次");
        System.out.println("玩家赢了"+a+"次");
        int c = a-b;
        if (c == 0) {
            System.out.println("平局");
        }else if (c > 0) {
            System.out.println("玩家赢了");
        } else if (c < 0) {
            System.out.println("电脑赢了");
        }
    }
}
