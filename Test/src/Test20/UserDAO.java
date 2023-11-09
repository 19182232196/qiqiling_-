package Test20;

import java.util.List;

public interface UserDAO {
    // 添加用户
    void addUser(String username, String email);
    // 更新用户
    void updateUser(int userId, String newUsername, String newEmail);
    // 删除用户
    void deleteUser(int userId);
    // 获取所有用户
    List<User> getAllUsers();
}
