package Test;

import java.util.Arrays;

public class ZiFuChuan {
    public static void main(String[] args) {
    String str="A 1234weaSAWF ds@#";
    String str1="123-456-789";
    System.out.println(str.charAt(0));
    System.out.println(str.length());
    System.out.println(str.charAt(str.length()-1));
    System.out.println(str.equals(str));
    System.out.println(Arrays.toString(str.toCharArray()));
    System.out.println(str.replace("A","B"));
    System.out.println(Arrays.toString(str1.split("-")));
    System.out.println(str.substring(9));
    System.out.println(str.substring(2, 4));
        }
    }