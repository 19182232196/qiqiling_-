package test15;

import java.awt.color.ProfileDataException;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class demo {
    static Scanner scanner=new Scanner(System.in);

    static File file=new File("D:\\1project\\Test\\src\\test15\\购货记录.txt");

    public static void main(String[] args) throws IOException {

        int id;
        String string = "1.显示订单记录\n"+"2.购买物品\n"+"3.保存\n"+"0.退出";
        System.out.println(string);
        System.out.println("请输入:");

        while ((id=scanner.nextInt())!=0){
            System.out.println(string);
            System.out.println("请输入:");
            switch (id){
                case 1:
                    read(file);
                    break;
                case 2:

                    break;
                case 3:

                    break;
                default:

                    break;
            }
        }
    }
    public static void read(File file) throws IOException {
        FileReader fileReader=new FileReader(file);
        int ch;
        while ((ch=fileReader.read())!=-1){
            if ((char)ch=='\n'){
                continue;
            }
            String string=" ";
            string+=(char)ch;
            String[] arr=string.split(" ");
            System.out.println(Arrays.toString(arr));
        }
    }
}
