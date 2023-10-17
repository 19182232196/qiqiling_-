package test13;

import java.io.File;
import java.io.IOException;

public class testDemoFile {
    public static void main(String[] args) throws IOException {
        File path= new File("D:\\test\\");
        File file=new File(path,"text.xlsx");

//        if (file.exists()){
//            file.createNewFile();
//        }else {
//            file.getParentFile().mkdirs();
//            file.createNewFile();
//        }
        show(path);
    }
    public static void show(File file) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (int i=0;i<files.length;i++){
                if (files[i].isDirectory()){
                    show(files[i]);
                }
                System.out.println(files[i].getAbsolutePath());
            }
        }
    }
}
