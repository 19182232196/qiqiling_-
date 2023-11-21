package Test3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StuManager extends JFrame implements ActionListener {
    //定义一些控件
    private Object[] types = {"-请选择查询方式-", "按学号号查询", "姓名查询", "性别查询","按年龄查询", "按籍贯查询","按班级查询"};
    private JComboBox searchType = new JComboBox(types); //创建一个组合框用来选取查询不同的学生信息·
    JPanel jp1,jp2;
    JLabel jl1;
    JButton jb1,jb2,jb3,jb4;
    JTable jt;
    JScrollPane jsp;
    JTextField jtf1,jtf2;
    String strRS;
    StuModel sm;
    //定义连接数据库的变量
    PreparedStatement ps;
    Connection ct = null;
    ResultSet rs = null;
    //构造函数
    public StuManager(){
        jp1 = new JPanel();
        jp1.setBackground(Color.gray);
        jtf1 = new JTextField(15);
        jtf2 = new JTextField();
        jtf2.setEditable(false);
        jb1 = new JButton("查询");
        jb1.addActionListener(this);
        jl1 = new JLabel("总人数：");
        jp1.add(searchType);
        jp1.add(jtf1);
        jp1.add(jb1);
        jp1.add(jl1);
        jp1.add(jtf2);
        jb2 = new JButton("添加");
        jb2.setSize(100,500);
        jb2.addActionListener(this);
        jb3 = new JButton("修改");
        jb3.addActionListener(this);
        jb4 = new JButton("删除");
        jb4.addActionListener(this);
        jp2 = new JPanel();
        jp2.add(jb2);
        jp2.add(jb3);
        jp2.add(jb4);
        jp2.setBackground(Color.gray);
        //创建模型对象
        sm = new StuModel();
        //初始化总人数
        strRS=String.valueOf(sm.getRowCount());
        jtf2.setText(strRS);
        //初始化表和滚动面板
        jt = new JTable(sm);
        jsp = new JScrollPane(jt);
        //将jsp放入到jframe中
        this.add(jsp);
        this.add(jp1,BorderLayout.PAGE_START);
        this.add(jp2,BorderLayout.PAGE_END);
        this.setTitle("学生信息管理系统");
        this.setSize(600, 400);
        this.setLocation(500, 200);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    public void actionPerformed(ActionEvent arg0) {
        //判断是哪个按钮被点击
        if(arg0.getSource() == jb1){
            System.out.println("用户希望被查询...");
            int index = searchType.getSelectedIndex();
            String sql = new String();
            if(index == 0){
                sql = "select * from stu ";
            }
            else if(index == 1){
                //因为把对表的数据封装到StuModel中，可以比较简单的完成查询
                String Id =this.jtf1.getText().trim();
                //写一个sql语句
                sql = "select * from stu where stuId = '"+Id+"' ";
            }
            else if(index == 2){
                String name =this.jtf1.getText().trim();
                sql = "select * from stu where stuName = '"+name+"' ";
            }
            else if(index == 3){
                String sex =this.jtf1.getText().trim();
                sql = "select * from stu where stuSex = '"+sex+"' ";
            }
            else if(index == 4){
                String age =this.jtf1.getText().trim();
                sql = "select * from stu where stuAge = '"+age+"' ";
            }
            else if(index ==5){
                String jg =this.jtf1.getText().trim();
                sql = "select * from stu where stuJG= '"+jg+"' ";
            }
            else if(index ==6){
                String bj =this.jtf1.getText().trim();
                sql = "select * from stu where stuBJ= '"+bj+"' ";
            }
            //构建一个数据模型类，并更新
            sm = new StuModel(sql);
            strRS=String.valueOf(sm.getRowCount());
            jtf2.setText(strRS);
            //更新jtable
            jt.setModel(sm);
        }
        //一、弹出添加界面
        else if(arg0.getSource() == jb2){
            System.out.println("添加...");
            StuAddDiag sa = new StuAddDiag(this,"添加学生",true);
            //重新再获得新的数据模型,
            sm =  new StuModel();
            strRS=String.valueOf(sm.getRowCount());
            jtf2.setText(strRS);
            jt.setModel(sm);
        }else if(arg0.getSource() == jb4){
            //二、删除记录
            //1.得到学生的ID
            int rowNum = this.jt.getSelectedRow();//getSelectedRow会返回给用户点中的行
            //如果该用户一行都没有选，就返回-1
            if(rowNum == -1){
                //提示
                JOptionPane.showMessageDialog(this, "请选中一行");
                return ;
            }
            //得到学术ID
            String stuId = (String)sm.getValueAt(rowNum, 0);
            //连接数据库,完成删除任务
            try{
                //1.加载驱动
                Class.forName("com.mysql.cj.jdbc.Driver");
                //2.连接数据库
                String url = "jdbc:mysql://localhost:3306/黄能2052231067";
                String user = "root";
                String passwd = "484110";

                ct = DriverManager.getConnection(url, user, passwd);
//                System.out.println("连接成功");
                ps = ct.prepareStatement("delete from stu where stuId = ?");
                ps.setString(1,stuId);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "删除成功", "删除情况",JOptionPane.PLAIN_MESSAGE);
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                try{
                    if(rs!= null){
                        rs.close();
                        rs = null;

                    }
                    if(ps!= null){
                        ps.close();
                        ps = null;
                    }
                    if(ct != null){
                        ct.close();
                        ct = null;
                    }
                } catch(Exception e){
                    e.printStackTrace();
                }
            }
            sm = new StuModel();
            strRS=String.valueOf(sm.getRowCount());
            jtf2.setText(strRS);
            //更新jtable
            jt.setModel(sm);
        }else if(arg0.getSource() == jb3){
            //三、用户希望修改
            int rowNum = this.jt.getSelectedRow();
            if(rowNum == -1){
                //提示
                JOptionPane.showMessageDialog(this, "请选择一行");
                return ;
            }
            //显示对话框
            StuUpDiag su = new StuUpDiag(this, "修改学生信息", true, sm, rowNum);
            sm = new StuModel();
            jt.setModel(sm);
        }
    }
}