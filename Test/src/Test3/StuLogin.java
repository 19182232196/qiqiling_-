package Test3;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class StuLogin extends JFrame {
    private StuLogin self;
    private ImageIcon imageIcon;
    private Image image;
    private String userid;// 登陆用户名和密码
    private String password;
    private JLabel unLabel = new JLabel("账号：");// 登陆面板控件
    private JTextField unField = new JTextField();
    private JLabel pwLabel = new JLabel("密码：");
    private JPasswordField pwField = new JPasswordField();
    private JButton dl = new JButton("登录");
    private JButton d2 = new JButton("重置");
    public StuLogin() {

        this.self = this;
        this.setSize(350, 300);// 设置登陆面板
        ////设置窗口背景图
        //先将contentPane设置成透明的
        ((JPanel)getContentPane()).setOpaque(false);
        //再设置图片
        imageIcon = new ImageIcon("345.jpg");//图标组件
        image = imageIcon.getImage();
        JLabel imgLabel = new JLabel(imageIcon);
        getLayeredPane().add(imgLabel, JLayeredPane.DEFAULT_LAYER);
        imgLabel.setBounds(0,0,400,300); //背景图片的位置
        this.setIconImage(image);//设置窗口图像
        this.setLocation(600,300);
        this.setVisible(true);
        this.setResizable(false);
        this.setLayout(null);
        //设置窗口名称
        this.setTitle("学生信息管理系统");
        //设置用户名标签
        unLabel.setSize(50, 30);
        unLabel.setLocation(60, 40);
        unLabel.setForeground(Color.red);
        unLabel.setFont(new Font("楷体",Font.BOLD,15));
        //设置用户名输入框
        unField.setSize(150, 35);
        unField.setLocation(110, 35);
        //设置密码标签
        pwLabel.setSize(50, 30);
        pwLabel.setLocation(60, 100);
        pwLabel.setForeground(Color.red);
        pwLabel.setFont(new Font("楷体",Font.BOLD,15));
        //设置密码输入框
        pwField.setSize(150, 35);
        pwField.setLocation(110, 100);
        //设置登录按钮
        dl.setSize(80, 35);
        dl.setLocation(65, 175);
        dl.setBackground(Color.red);
        //设置注册按钮
        d2.setSize(80, 35);
        d2.setLocation(185, 175);
        d2.setBackground(Color.red);
        dl.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//获取用户输入的账号
                userid = unField.getText();
 //获取用户输入的密码
                password = pwField.getText();
 //判断用户输入的账号和密码是否正确
                if(userid.equals("1")&&password.equals("1")) {
 //如果正确，则隐藏当前窗口，并创建一个新的学生管理窗口
                    self.setVisible(false);
                    new StuManager();
                } else {
 //如果错误，则弹出提示框
                    JOptionPane.showMessageDialog(null, "账号或密码错误！", "登录情况",JOptionPane.PLAIN_MESSAGE);
                }
            }
        });
        d2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//将文本框中的内容清空
                unField.setText("");
                pwField.setText("");
            }
        });
//将unLabel添加到当前窗口
        this.add(unLabel);
 //将unField添加到当前窗口
        this.add(unField);
 //将pwLabel添加到当前窗口
        this.add(pwLabel);
 //将pwField添加到当前窗口
        this.add(pwField);
 //将dl添加到当前窗口
        this.add(dl);
 //将d2添加到当前窗口
        this.add(d2);
    }
}
