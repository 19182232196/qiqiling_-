package test14;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class testDemo {
    public  static void main(String[] args) throws IOException {
        File  file = new File("D:\\1project\\qiqiling\\Test\\src\\test14\\test.txt");
        readFile(file);
        writeFile(file);
    }

    public static void writeFile(File file) throws IOException{
        FileOutputStream outputStream = new FileOutputStream(file);
        String string = "hi hea";
        char[] carr=string.toCharArray();
        for (int i=0;i<carr.length;i++){
            outputStream.write(carr[i]);
        }
        outputStream.close();
    }

    public static void readFile(File file) throws IOException{
        FileInputStream inputStream = new FileInputStream(file);

        int b=0;
        while (true){
            b=inputStream.read();
            if (b==-1){
                break;
            }
            System.out.println((char)b);
        }
    }
}
