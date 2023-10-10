package Test11;

import java.util.*;

public class test2 {
    public static void main(String[] args){
        HashMap<String,Integer> hashMap=new HashMap<String,Integer>();
        hashMap.put("font",14);
        hashMap.put("color",16777215);
        hashMap.put("size",16);

        System.out.println(hashMap.get("font"));

        System.out.println(hashMap.size());

        hashMap.remove("font");

        Set<String> KeySet=hashMap.keySet();
        System.out.println(KeySet);

//        Collection<Integer> value=hashMap.values();

        Set<Map.Entry<String,Integer>> entries=hashMap.entrySet();
        System.out.println(entries);
        for (Map.Entry<String,Integer> entry:entries){
            System.out.println(entry);
        }

        Iterator<String> it =KeySet.iterator();
        while(it.hasNext()){
            String Key=it.next();
            Integer value=hashMap.get(Key);
            System.out.println(Key+"="+value);
        }


        System.out.println(hashMap);
    }
}
