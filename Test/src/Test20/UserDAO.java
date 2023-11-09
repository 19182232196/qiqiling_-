package Test20;

import java.util.List;

public interface UserDAO {
    void addUser(String username, String email);
    void updateUser(int userId, String newUsername, String newEmail);
    void deleteUser(int userId);
    List<User> getAllUsers();
}
