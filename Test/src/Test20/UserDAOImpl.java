package Test20;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    // 驱动类
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    // 数据库连接地址
    static final String DB_URL = "jdbc:mysql://localhost/study?";
    // 用户名
    static final String USER = "root";
    // 密码
    static final String PASS = "484110";

    @Override
    public void addUser(String username, String email) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO users (username, email) VALUES (?, ?)")) {
            // 设置参数
            stmt.setString(1, username);
            stmt.setString(2, email);
            // 执行更新
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateUser(int userId, String newUsername, String newEmail) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement stmt = conn.prepareStatement("UPDATE users SET username = ?, email = ? WHERE id = ?")) {
            // 设置参数
            stmt.setString(1, newUsername);
            stmt.setString(2, newEmail);
            stmt.setInt(3, userId);
            // 执行更新
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteUser(int userId) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement stmt = conn.prepareStatement("DELETE FROM users WHERE id = ?")) {
            // 设置参数
            stmt.setInt(1, userId);
            // 执行更新
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT id, username, email FROM users")) {
            // 遍历结果集
            while (rs.next()) {
                User user = new User(rs.getInt("id"), rs.getString("username"), rs.getString("email"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
}