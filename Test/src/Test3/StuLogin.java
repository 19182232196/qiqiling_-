package Test3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StuLogin extends JFrame {
   //创建一个StuLogin类型的变量
    private StuLogin self;
    //创建一个JTextField类型的变量
    private JTextField unField = new JTextField();
    //创建一个JPasswordField类型的变量
    private JPasswordField pwField = new JPasswordField();
    //创建一个JButton类型的变量
    private JButton dl = new JButton("登录");
    //创建一个JButton类型的变量
    private JButton d2 = new JButton("注册");
    public StuLogin() {
        // 初始化
        this.self = this;
        // 设置窗口大小
        this.setSize(350, 300);
        // 设置窗口位置
        this.setLocation(600, 300);
        // 设置窗口大小不可改变
        this.setResizable(false);
        // 设置布局
        this.setLayout(null);
        // 创建内容面板
        JPanel contentPane = new JPanel() {
            // 重写绘制方法
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // 加载图片
                Image image = new ImageIcon("D:\\1project\\Test\\src\\Test3\\345.jpg").getImage();
                // 绘制图片
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        };
//设置内容面板不透明
        contentPane.setOpaque(false);
 //设置内容面板
        setContentPane(contentPane);
 //设置标题
        this.setTitle("学生信息管理系统");
 //创建用户名标签
        JLabel unLabel = new JLabel("用户名：");
 //设置标签大小
        unLabel.setSize(80, 35);
 //设置标签位置
        unLabel.setLocation(30, 35);
 //设置标签颜色
        unLabel.setForeground(Color.white);
 //添加标签到内容面板
        contentPane.add(unLabel);
 //创建用户名输入框
        unField.setSize(150, 35);
 //设置输入框位置
        unField.setLocation(110, 35);
 //创建密码标签
        JLabel pwLabel = new JLabel("密码：");
 //设置标签大小
        pwLabel.setSize(80, 35);
 //设置标签位置
        pwLabel.setLocation(30, 100);
 //设置标签颜色
        pwLabel.setForeground(Color.white);
 //添加标签到内容面板
        contentPane.add(pwLabel);
 //设置密码输入框的大小和位置
        pwField.setSize(150, 35);
        pwField.setLocation(110, 100);
 //设置登录按钮的大小和位置，并设置背景颜色为红色
        dl.setSize(80, 35);
        dl.setLocation(65, 175);
        dl.setBackground(Color.red);
//设置重置按钮的大小和位置，并设置背景颜色为红色
        d2.setSize(80, 35);
        d2.setLocation(185, 175);
        d2.setBackground(Color.red);
        dl.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 登录功能
                String username = unField.getText();
                String password = new String(pwField.getPassword());
                if (username.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "用户名和密码不能为空！", "提示", JOptionPane.PLAIN_MESSAGE);
                    return;
                }
                if (validateLogin(username, password)) {
                    self.setVisible(false);
                    new StuManager();
                } else {
                    JOptionPane.showMessageDialog(null, "账号或密码错误！", "登录情况", JOptionPane.PLAIN_MESSAGE);
                }
            }
        });
        d2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 注册功能
                String username = unField.getText();
                String password = new String(pwField.getPassword());
                if (username.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "用户名和密码不能为空！", "提示", JOptionPane.PLAIN_MESSAGE);
                    return;
                }
                if (registerUser(username, password)) {
                    JOptionPane.showMessageDialog(null, "注册成功！", "提示", JOptionPane.PLAIN_MESSAGE);
                    // 注册成功后清空输入框
                    unField.setText("");
                    pwField.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "注册失败，请重试！", "提示", JOptionPane.PLAIN_MESSAGE);
                }
            }
        });
        contentPane.setLayout(null);
        contentPane.add(unField);
        contentPane.add(pwField);
        contentPane.add(dl);
        contentPane.add(d2);
    }
   private boolean validateLogin(String username, String password) {
        try {
            // 加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 连接数据库
            String url = "jdbc:mysql://localhost:3306/黄能2052231067";
            String user = "root";
            String passwd = "484110";
            try (Connection ct = DriverManager.getConnection(url, user, passwd)) {
                // 创建SQL语句
                String sql = "SELECT * FROM login WHERE nameS=? AND pwdS=?";
                try (PreparedStatement pstmt = ct.prepareStatement(sql)) {
                    // 设置参数
                    pstmt.setString(1, username);
                    pstmt.setString(2, password);
                    try (ResultSet rs = pstmt.executeQuery()) {
                        // 返回结果
                        return rs.next();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    private boolean registerUser(String username, String password) {
        try {
            // 加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 连接数据库
            String url = "jdbc:mysql://localhost:3306/黄能2052231067";
            String user = "root";
            String passwd = "484110";
            try (Connection ct = DriverManager.getConnection(url, user, passwd)) {
                // 创建SQL语句
                String sql = "INSERT INTO login (nameS, pwdS) VALUES (?, ?)";
                try (PreparedStatement pstmt = ct.prepareStatement(sql)) {
                    // 设置参数
                    pstmt.setString(1, username);
                    pstmt.setString(2, password);
                    // 执行SQL语句
                    int affectedRows = pstmt.executeUpdate();
                    // 返回受影响的行数
                    return affectedRows > 0;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new StuLogin().setVisible(true));
    }
}
