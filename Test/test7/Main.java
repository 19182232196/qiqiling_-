import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        HashSet ha=new HashSet();
        ha.add("1");
        ha.add("2");
        ha.add("3");
        ArrayList arr=new ArrayList(ha);
        System.out.println(arr.get(0));
        System.out.println(ha);
//取出
//
//        for (int i=0;i<arr.size();i++){
//            System.out.println((i+1)+"次"+arr.get(i));
//        }
//遍历
//
//        for (Object obj:arr){
//            System.out.println((String) obj);
//        }
//迭代器遍历
//
//        Iterator it=arr.iterator();
//        int i=0;
//        while (it.hasNext()){
//            Object next=it.next();
//            System.out.println((++i)+"次"+next);
//        }
    }
}