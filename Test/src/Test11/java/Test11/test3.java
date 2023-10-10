package Test11;

import java.util.TreeMap;

public class test3 {
    public  static void main(String[] args) {
        TreeMap<String,String> map = new TreeMap<>();

        map.put("1","张三");
        map.put("2","李四");
        map.put("3","王五");
        map.put("4","赵六");

        System.out.println(map);
    }
}
