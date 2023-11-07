package Test20.Dao;
import java.sql.*;

public class dbDao {
    private String Driver="com.mysql.jdbc.Driver";
    private String URL="jdbc:mysql://localhost:3306/study?";
    private String username="root";
    private String password="484110";

    public Connection getConnection() {
        Connection connection=null;
        try {
            connection=DriverManager.getConnection(URL,username,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
    public void closeConnection(Connection connection){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("关闭数据库连接");
    }
}
