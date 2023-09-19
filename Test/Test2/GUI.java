package Test2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
public class GUI {
    private JFrame frame;
    private ArrayList<Student> list;
    public GUI(){
        frame=new JFrame("学生管理系统");
        list=new ArrayList<>();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setLayout(new BorderLayout());

        // 创建添加、减少、保存、退出按钮
        JButton addB=new JButton("添加");
        JButton removeB=new JButton("减少");
        JButton saveB=new JButton("保存");
        JButton exitB=new JButton("退出");

        // 添加按钮到界面
        JPanel Bpanel=new JPanel();
        Bpanel.add(addB);
        Bpanel.add(removeB);
        Bpanel.add(saveB);
        Bpanel.add(exitB);

        frame.add(Bpanel,BorderLayout.SOUTH);
    }
}