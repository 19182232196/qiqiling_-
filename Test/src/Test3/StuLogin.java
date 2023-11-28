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
    private StuLogin self;
    private JTextField unField = new JTextField();
    private JPasswordField pwField = new JPasswordField();
    private JButton dl = new JButton("登录");
    private JButton d2 = new JButton("重置");

    public StuLogin() {
        this.self = this;
        this.setSize(350, 300);
        this.setLocation(600, 300);
        this.setResizable(false);
        this.setLayout(null);

        JPanel contentPane = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Image image = new ImageIcon("D:\\1project\\Test\\src\\Test3\\345.jpg").getImage();
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        };
        contentPane.setOpaque(false);
        setContentPane(contentPane);

        this.setTitle("学生信息管理系统");

        unField.setSize(150, 35);
        unField.setLocation(110, 35);

        pwField.setSize(150, 35);
        pwField.setLocation(110, 100);

        dl.setSize(80, 35);
        dl.setLocation(65, 175);
        dl.setBackground(Color.red);

        d2.setSize(80, 35);
        d2.setLocation(185, 175);
        d2.setBackground(Color.red);

        dl.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = unField.getText();
                String password = new String(pwField.getPassword());

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
                unField.setText("");
                pwField.setText("");
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
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/黄能2052231067";
            String user = "root";
            String passwd = "484110";

            try (Connection ct = DriverManager.getConnection(url, user, passwd)) {
                String sql = "SELECT * FROM login WHERE nameS=? AND pwdS=?";
                try (PreparedStatement pstmt = ct.prepareStatement(sql)) {
                    pstmt.setString(1, username);
                    pstmt.setString(2, password);

                    try (ResultSet rs = pstmt.executeQuery()) {
                        return rs.next();
                    }
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
