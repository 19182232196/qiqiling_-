package Test20.Dao;

import Test20.interfaceQ.baseIMP;
import Test20.modle.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class baseDao implements baseIMP {
    final static dbDao dbDao=new dbDao();
    @Override
    public ArrayList<User> show() {
        ArrayList<User> arrayList= new ArrayList<>();
        Connection connection=dbDao.getConnection();
        try {
            PreparedStatement preparedStatement=connection.prepareStatement("select * from user");
            ResultSet resultSet =preparedStatement.executeQuery();
            while (resultSet.next()){
                User user=new User();
                user.getId(resultSet.getString("id"));
                user.getName(resultSet.getString("name"));
                user.getPassword(resultSet.getString("password"));
                user.getEmail(resultSet.getString("email"));
                user.getBirthday(resultSet.getString("birthday"));
                arrayList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User Login() {
        return null;
    }

    @Override
    public int signUp() {
        return 0;
    }

    @Override
    public int delUser() {
        return 0;
    }

    @Override
    public int updateUser() {
        return 0;
    }

    @Override
    public User searchUserById(String id) {
        return null;
    }
}
