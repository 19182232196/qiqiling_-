package test8;

//package LuckyDaw;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
/**
 * @author
 * user:
 * LuckyDraw.java
 * time:2018年10月25日
 *
 *   项目介绍： 一共有三个类 --> 用户类，管理类，测试类(含主方法)
 *   功能介绍 ：
 *   1.注册
 *   2.登陆
 *   3.抽奖
 *   4.查询
 *   5.修改密码
 *   6.删除用户
 *   7.退出
 *
 * 	类介绍：
 * 用户类：  有账号，密码，会员号 三个私有属性
 * 		    有构造方法，getter and setter方法    输出打印信息的方法
 * 管理类：有自定义数组大小的构造方法
 * 		添加、注册方法，  实现 动态数组
 * 	          登陆方法(规定出错次数),
 * 		抽奖方法，只有登陆过的人才能抽奖
 * 		查询方法
 * 		修改密码方法，两个  ，第一个方法匹配账号密码 ，成功的话返回用户对象的下标，失败的话返回-1
 * 					如果但会下标，第二个方法传入下标和新密码，进行修改 密码操作
 * 		删除用户的方法 ，把删除位置以后的元素 往前挪一位，最后的元素释放
 * 		打印输出所有的方法
 * 测试类：实例化对象的准备幸运数字  ，死循环，保持可以 一直在主菜单状态
 * 		用switch  进入不同的 功能
 */
public class LuckyDraw {

    public static void main(String[] args) {
        Operation o = new Operation(10);    //实例化一个 管理的对象，定义数组的大小
        Scanner input = new Scanner(System.in);
        Random ran = new Random();
        int num = ran.nextInt(8999)+1000;   //生成系统的幸运数字
        o.printMenu();     					// 打印 菜单
        System.out.print("请输入你的选择:");
        int n = input.nextInt();  			 //选择
        User userLanding = null;
        int lodNum = 0;
        flog:
        while(n!=0) {
            switch(n) {
                case 1:
                    String str = "y";        //定义一个字符串，进入循环，一直判断 是不是要继续注册
                    while ("y".equals(str)) {
                        System.out.println("大富翁系统 ->注册");
                        System.out.print("请输入账号:");
                        String name = input.next();
                        System.out.print("请输入密码:");
                        String pasword = input.next();          //生成会员号
                        int nums = ran.nextInt(8999)+1000;
                        User u = new User(name,pasword,nums);   //实例化一个用户对象
                        o.add(u);							    //添加到数组中
                        System.out.println("还需要继续注册吗？(y/n)");
                        str = input.next();
                    }
                    break;
                case 2:
                    /*
                     *  登陆成功 返回一个用户对象 userLanding
                     *  登陆胜败返回 null
                     *  如果登录失败三次 则结束程序
                     */
                    System.out.println("大富翁系统 ->登陆");
                    System.out.print("请输入账号:");
                    String name = input.next();
                    System.out.print("请输入密码:");
                    String pasword = input.next();
                    userLanding = o.landing(new User(name,pasword,0));   //登陆成功，返回对象，不成功返回空
                    lodNum++;
                    if (lodNum>=3) {
                        break flog;
                    }
                    break;
                case 3:
                    /*
                     * 抽奖功能，判断用户是不是为空
                     * 不为空 才可以抽奖
                     */
                    System.out.println("大富翁系统 ->抽奖");
                    if (userLanding != null) {
                        o.extract(userLanding, num);    //抽奖的方法
                    }else {
                        System.out.println("请登陆后再抽奖");
                    }
                    break;
                case 4:
                    System.out.println("大富翁系统 ->查询");
                    o.print();    //打印所有信息
                    break;
                case 5:
                    /*
                     *  修改密码功能 ，一共用到了两个方法
                     *  Modify1: 查看账号密码是否匹配 ，成功的话返回下标，失败返回-1
                     *  Modify2: 匹配成功后带着下标和新密码 去找 用户对象
                     */
                    String str2 = "y";
                    while("y".equals(str2)) {
                        System.out.println("大富翁系统 ->修改密码");
                        System.out.println("请输入账号:");
                        String name1 = input.next();
                        System.out.println("请输入密码:");
                        String password1 = input.next();
                        int passwordIndex = o.Modify1(name1, password1);  //匹配账号密码，成功返回下标，失败返回-1
                        if (passwordIndex>=0) {
                            while(true) {       //循环判断两次新密码是否匹配
                                System.out.println("请输入新密码:");
                                String password3 = input.next();
                                System.out.println("请再次输入新密码:");
                                String password4 = input.next();
                                if (password3.equals(password4)) {      //账号密码相同，
                                    o.Modify2(passwordIndex, password4);  //调用第二个方法
                                    break;
                                }else {
                                    System.out.println("两次密码不相同");
                                }
                                System.out.println("是否要重新输入新密码(y/n)");
                                String str3 = input.next();
                                if("y".equals(str3)) {              //判断是否重新输入新密码
                                    continue;
                                }else {
                                    break;
                                }
                            }
                        }
                        System.out.println("是否继续修改密码:(y/n)");
                        str2 = input.next();
                    }
                    break;
                case 6:
                    /*
                     * 删除账号
                     */
                    String str1 = "y";
                    while("y".equals(str1)) {
                        System.out.println("大富翁系统 ->删除账号");
                        System.out.println("请输入账号:");
                        String name1 = input.next();
                        System.out.println("请输入密码:");
                        String password1 = input.next();
                        o.delete(name1, password1);        //删除的方法
                        System.out.println("是否继续删除用户:(y/n)");
                        str1 = input.next();
                    }
                    break;
                default:
                    /*
                     * 其他数字退出程序
                     */
                    n = 0;
                    break flog;
            }

            o.printMenu();    // 在 大循环里 一直显示 的菜单
            System.out.print("请输入你的选择:");
            n = input.nextInt();   //菜单选项
        }
        System.out.println("程序结束");

    }
}

