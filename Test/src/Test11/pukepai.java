package Test11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class pukepai {
    public static void main(String[] args){
        ArrayList<Integer> num=new ArrayList<>();
        HashMap<String,ArrayList<Integer>> puke=new HashMap<>();

        for (int i = 0; i<=13; i++){
            num.add(i);
        }

        puke.put("♣",num);
        puke.put("♦",num);
        puke.put("♥",num);
        puke.put("♠",num);

        Iterator<String> it=puke.keySet().iterator();
        while (it.hasNext()){
            String key= it.next();
            for (Integer number:num){
                num=r
            }
        }
    }
}
