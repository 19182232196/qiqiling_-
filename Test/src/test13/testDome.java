package test13;

import javax.swing.*;
import java.util.ArrayList;

public class testDome {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();

        arrayList.add(1);

        Box<Integer> box=new Box<Integer>();
        Box<String> box2=new Box<String>();
        Box<Boolean> box3=new Box<Boolean>();

        box.setValue(12);
        box2.setValue("123");
        box3.setValue(true);

        show(123);

        name(box2);
        name(box3);
    }

    private static <T> void show(T t) {
        System.out.println(t.getClass());
    }

    public static void name(Box<?> box){

    }
}
