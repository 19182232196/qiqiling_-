package test12;

import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeMap;

public class test {
    public static void main(String[] args){
        Box box=new Box();

        box.setQwer("123");
        box.setQwer(123);
        box.setQwer(true);

        box.qwe("123");
        box.qwe(123);

        System.out.println(box.getQwer().getClass());
    }
}
