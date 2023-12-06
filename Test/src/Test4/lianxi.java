/*
 * Created by JFormDesigner on Thu Nov 30 16:21:29 CST 2023
 */

package Test4;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import org.jdesktop.beansbinding.*;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.swingbinding.*;

/**
 * @author h1918
 */
public class lianxi extends JFrame {
    public lianxi() {
        initComponents();
    }

    private void thisWindowStateChanged(WindowEvent e) {
        // TODO add your code here
    }

    private void denlu(ActionEvent e) {
        // 获取用户名和密码
        String username = textField1.getText();
        String password = textField2.getText();

        // 构建查询 SQL
        String sql = "SELECT * FROM login WHERE nameS = ? AND pwdS = ?";

        try {
            // 获取数据库连接
            Connection connection = null;
            try {
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/黄能2052231067", "root",
                        "484110");
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }

            // 创建 PreparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            // 执行查询
            ResultSet resultSet = preparedStatement.executeQuery();

            // 判断是否存在匹配的用户
            if (resultSet.next()) {
                // 如果存在匹配用户，显示 denluq 窗口
                denluq.setVisible(true);
            } else {
                // 如果不存在匹配用户，弹出提示框
                JOptionPane.showMessageDialog(this, "用户名或密码错误", "登录失败", JOptionPane.ERROR_MESSAGE);
            }

            // 关闭资源
            resultSet.close();
            preparedStatement.close();
            connection.close();

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    private void zhuce(ActionEvent e) {
        // TODO add your code here

    }

    private void comboBox1(ActionEvent e) {
        String selectedValue = (String) comboBox1.getSelectedItem();

        if ("qwer".equals(selectedValue)) {
            // 显示 denluq 窗口
            denluq.setVisible(true);
        } else if ("qwe1".equals(selectedValue)) {
            // 显示 zhuceq 窗口
            zhuceq.setVisible(true);
        }
        // 可以根据其他选项添加更多的条件判断
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        zhuce = new JButton();
        denlu = new JButton();
        label1 = new JLabel();
        label2 = new JLabel();
        textField1 = new JTextField();
        textField2 = new JTextField();
        comboBox1 = new JComboBox<>();
        denluq = new JFrame();
        textField3 = new JTextField();
        zhuceq = new JFrame();
        textField4 = new JTextField();

        //======== this ========
        addWindowStateListener(e -> thisWindowStateChanged(e));
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- zhuce ----
        zhuce.setText("\u6ce8\u518c");
        zhuce.addActionListener(e -> zhuce(e));
        contentPane.add(zhuce);
        zhuce.setBounds(new Rectangle(new Point(345, 260), zhuce.getPreferredSize()));

        //---- denlu ----
        denlu.setText("\u767b\u5f55");
        denlu.addActionListener(e -> denlu(e));
        contentPane.add(denlu);
        denlu.setBounds(new Rectangle(new Point(170, 260), denlu.getPreferredSize()));

        //---- label1 ----
        label1.setText("\u7528\u6237");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 6f));
        contentPane.add(label1);
        label1.setBounds(95, 110, 55, 30);

        //---- label2 ----
        label2.setText("\u5bc6\u7801");
        label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 6f));
        contentPane.add(label2);
        label2.setBounds(95, 170, 60, 30);
        contentPane.add(textField1);
        textField1.setBounds(160, 115, 255, textField1.getPreferredSize().height);
        contentPane.add(textField2);
        textField2.setBounds(160, 175, 255, textField2.getPreferredSize().height);

        //---- comboBox1 ----
        comboBox1.setAction(null);
        comboBox1.setFont(new Font("JetBrains Mono ExtraBold", Font.BOLD | Font.ITALIC, 12));
        comboBox1.setModel(new DefaultComboBoxModel<>(new String[] {
            "qwer",
            "qwe1"
        }));
        comboBox1.setName("qwer");
        comboBox1.setNextFocusableComponent(zhuceq);
        comboBox1.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        comboBox1.setInheritsPopupMenu(true);
        comboBox1.setFocusTraversalPolicyProvider(true);
        comboBox1.setFocusCycleRoot(true);
        comboBox1.addActionListener(e -> comboBox1(e));
        contentPane.add(comboBox1);
        comboBox1.setBounds(new Rectangle(new Point(145, 35), comboBox1.getPreferredSize()));

        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        setSize(575, 430);
        setLocationRelativeTo(null);

        //======== denluq ========
        {
            var denluqContentPane = denluq.getContentPane();
            denluqContentPane.setLayout(null);

            //---- textField3 ----
            textField3.setText("\u767b\u5f55");
            denluqContentPane.add(textField3);
            textField3.setBounds(new Rectangle(new Point(135, 100), textField3.getPreferredSize()));

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < denluqContentPane.getComponentCount(); i++) {
                    Rectangle bounds = denluqContentPane.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = denluqContentPane.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                denluqContentPane.setMinimumSize(preferredSize);
                denluqContentPane.setPreferredSize(preferredSize);
            }
            denluq.setSize(330, 255);
            denluq.setLocationRelativeTo(null);
        }

        //======== zhuceq ========
        {
            var zhuceqContentPane = zhuceq.getContentPane();
            zhuceqContentPane.setLayout(null);

            //---- textField4 ----
            textField4.setText("\u6ce8\u518c");
            zhuceqContentPane.add(textField4);
            textField4.setBounds(75, 60, 49, 30);

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < zhuceqContentPane.getComponentCount(); i++) {
                    Rectangle bounds = zhuceqContentPane.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = zhuceqContentPane.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                zhuceqContentPane.setMinimumSize(preferredSize);
                zhuceqContentPane.setPreferredSize(preferredSize);
            }
            zhuceq.setSize(200, 200);
            zhuceq.setLocationRelativeTo(null);
        }

        //---- bindings ----
        bindingGroup = new BindingGroup();
        bindingGroup.addBinding(SwingBindings.createJComboBoxBinding(UpdateStrategy.READ_WRITE,
            comboBox1, (BeanProperty) BeanProperty.create("action"), comboBox1));
        bindingGroup.bind();
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JButton zhuce;
    private JButton denlu;
    private JLabel label1;
    private JLabel label2;
    private JTextField textField1;
    private JTextField textField2;
    private JComboBox<String> comboBox1;
    private JFrame denluq;
    private JTextField textField3;
    private JFrame zhuceq;
    private JTextField textField4;
    private BindingGroup bindingGroup;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
    public static void main(String[] args) {
        new lianxi().setVisible(true);
    }
}
