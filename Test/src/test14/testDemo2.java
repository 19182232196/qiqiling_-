package test14;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class testDemo2 {
    public static void main(String[] args) throws IOException {
        File file=new File("D:\\1project\\qiqiling\\Test\\src\\test14\\test.txt");
        writeFile(file);
        readFile(file);
    }

    public static void readFile(File file) throws IOException {
        FileReader fileReader=new FileReader(file);
        int ch;
        while ((ch=fileReader.read())!= -1){
            System.out.print((char)ch);
        }
    }

    public static void writeFile(File file) throws IOException {
        FileWriter writer=new FileWriter(file);

        String string="你好";

        writer.write(string);
        writer.write("\r\n");
        writer.close();
    }
}
