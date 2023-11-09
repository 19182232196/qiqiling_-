package Test20;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("无法加载MySQL驱动程序", e);
        }

        String url = "jdbc:mysql://localhost:3306/study";
        String username = "root";
        String password = "484110";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            connection.setAutoCommit(false);  // 设置手动提交

            UserDAO userDAO = new UserDAOImpl();
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("选择操作:");
                System.out.println("1. 添加用户");
                System.out.println("2. 获取所有用户");
                System.out.println("3. 更新用户");
                System.out.println("4. 删除用户");
                System.out.println("0. 退出");

                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("输入用户名:");
                        String addUserUsername = scanner.next();
                        System.out.println("输入电子邮件:");
                        String addUserEmail = scanner.next();
                        userDAO.addUser(addUserUsername, addUserEmail);
                        break;

                    case 2:
                        List<User> users = userDAO.getAllUsers();
                        System.out.println("所有用户:");
                        for (User user : users) {
                            System.out.println("ID: " + user.getId() + ", 用户名: " + user.getUsername() + ", 电子邮件: " + user.getEmail());
                        }
                        break;

                    case 3:
                        System.out.println("输入要更新的用户ID:");
                        int updateUserId = scanner.nextInt();
                        System.out.println("输入新的用户名:");
                        String updateUsername = scanner.next();
                        System.out.println("输入新的电子邮件:");
                        String updateEmail = scanner.next();
                        userDAO.updateUser(updateUserId, updateUsername, updateEmail);
                        break;

                    case 4:
                        System.out.println("输入要删除的用户ID:");
                        int deleteUserId = scanner.nextInt();
                        userDAO.deleteUser(deleteUserId);
                        break;

                    case 0:
                        System.out.println("退出程序");
                        connection.commit();  // 手动提交事务
                        System.exit(0);

                    default:
                        System.out.println("无效的选择");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("建立数据库连接时发生错误", e);
        }
    }
}

