package Test1.qwerGui;

import Test1.qwerBase.base;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class gui extends JFrame{
    // 创建文本框
    private JTextField jtfq = new JTextField(20);
    private JTextField jtfw = new JTextField(20);
    // 创建按钮
    private JButton jbq = new JButton("测试");
    // 创建标签
    private JLabel lbq = new JLabel();
    // 创建对话框
    private JDialog win = new JDialog();

    // 创建base对象
    private base b = new base();

    public gui(){
        // 设置窗口大小
        setSize(300,300);
        // 设置窗口位置
        setLocationRelativeTo(null);//默认生成在桌面中心的位置
        // 设置布局
        setLayout(new FlowLayout());
        // 添加文本框
        add(jtfq);
        add(jtfw);
        add(jbq);
        // 为按钮添加监听器
        jbq.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 获取文本框内容
                String username = jtfq.getText();
                // 调用base的searchUserById方法
                jtfq_apf(b.searchUserById(username).getName());
            }
        });
    }

    // 设置标签文本
    public void jtfq_apf(String vl){
        // 设置对话框位置
        win.setLocationRelativeTo(null);
        // 设置对话框大小
        win.setSize(1000,1000);
        // 设置对话框布局
        win.setLayout(new FlowLayout());
        // 设置标签文本
        lbq.setText(vl);
        // 添加标签
        win.add(lbq);
        // 设置对话框可见
        win.setVisible(true);
    }

    public static void main(String[] args) {
        // 创建gui对象
        new gui().setVisible(true);//显示窗体
    }
}
