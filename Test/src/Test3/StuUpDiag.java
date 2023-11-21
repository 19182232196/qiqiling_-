package Test3;

import javax.swing.JDialog;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.*;

public class StuUpDiag extends JDialog implements ActionListener {
    //定义我需要的swing组件
    JLabel jl1,jl2,jl3,jl4,jl5,jl6,jl7;
    JTextField jf1,jf2,jf3,jf4,jf5,jf6,jf7;
    JPanel jp1,jp2,jp3;
    JButton jb1,jb2;
    //owner代笔父窗口,title是窗口的名字,modal指定是模式窗口()或者非模式窗口
    public StuUpDiag(Frame owner, String title, boolean modal, StuModel sm, int rowNum){
        //调用父类方法
        super(owner,title,modal);

        jl1 = new JLabel("学号");
        jl2 = new JLabel("名字");
        jl3 = new JLabel("性别");
        jl4 = new JLabel("年龄");
        jl5 = new JLabel("籍贯");
        jl6 = new JLabel("联系方式");
        jl7 = new JLabel("班级");



        jf1 = new JTextField(30);
        jf1.setText((sm.getValueAt(rowNum, 0)).toString());
        jf2 = new JTextField(30);
        jf2.setText((String)sm.getValueAt(rowNum, 1));
        jf3 = new JTextField(30);
        jf3.setText(sm.getValueAt(rowNum, 2).toString());
        jf4 = new JTextField(30);
        jf4.setText((sm.getValueAt(rowNum, 3)).toString());
        jf5 = new JTextField(30);
        jf5.setText((String)sm.getValueAt(rowNum, 4));
        jf6 = new JTextField(30);
        jf6.setText((String)sm.getValueAt(rowNum, 5));
        jf7 = new JTextField(30);
        jf7.setText((String)sm.getValueAt(rowNum, 6));

        jb1 = new JButton("修改");
        jb1.addActionListener(this::actionPerformed);
        jb2 = new JButton("取消");
        jb2.addActionListener(this::actionPerformed);

        jp1 = new JPanel();
        jp2 = new JPanel();
        jp3 = new JPanel();

        //设置布局
        jp1.setLayout(new GridLayout(7,1));
        jp2.setLayout(new GridLayout(7,1));

        jp3.add(jb1);
        jp3.add(jb2);

        jp1.add(jl1);
        jp1.add(jl2);
        jp1.add(jl3);
        jp1.add(jl4);
        jp1.add(jl5);
        jp1.add(jl6);
        jp1.add(jl7);

        jp2.add(jf1);
        jp2.add(jf2);
        jp2.add(jf3);
        jp2.add(jf4);
        jp2.add(jf5);
        jp2.add(jf6);
        jp2.add(jf7);

        this.add(jp1, BorderLayout.WEST);
        this.add(jp2, BorderLayout.CENTER);
        this.add(jp3, BorderLayout.SOUTH);
        this.setLocation(600, 350);
        this.setSize(300,200);
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == jb1){
            Connection ct = null;
            PreparedStatement pstmt = null;
            ResultSet rs = null;
            try{
                //1.加载驱动
                Class.forName("com.mysql.cj.jdbc.Driver");
                System.out.println("加载成功");
                //2.连接数据库
                //定义几个常量
                String url = "jdbc:mysql://localhost:3306/黄能2052231067";
                String user = "root";
                String passwd = "484110";
                ct = DriverManager.getConnection(url,user,passwd);
                //与编译语句对象
                String strsql = "update stu set stuName = '"+jf2.getText()+"',stuSex = '"+jf3.getText()+"',stuAge = '"+jf4.getText()+"',stuJG='"+jf5.getText()+"',stuLX='"+jf6.getText()+"',stuBJ='"+jf7.getText()+"' where stuId = '"+jf1.getText()+"'";
                pstmt = ct.prepareStatement(strsql);
                pstmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "修改成功", "修改情况",JOptionPane.PLAIN_MESSAGE);
                this.dispose();//关闭学生对话框
            }catch(Exception arg1){
                arg1.printStackTrace();
            }finally{
                try{
                    if(rs!=null){
                        rs.close();
                        rs = null;
                    }
                    if(pstmt != null){
                        pstmt.close();
                        pstmt = null;
                    }
                    if(ct != null){
                        ct.close();
                        ct = null;
                    }
                }catch(Exception arg2){
                    arg2.printStackTrace();
                }
            }
        }else{
            this.dispose();//关闭学生对话框
        }
    }
}