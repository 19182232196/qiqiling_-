package Test1.qwerBase;

import java.sql.*;

public class db {
    private String Driver = "com.mysql.jdbc.Driver";//mysql驱动
    private String URL = "jdbc:mysql://localhost:3306/"
            + "黄能2052231067?"//数据库名
            + "";
    private String username = "root";//数据库账号
    private String password = "484110";//数据库密码

    public Connection getConn() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL,username,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public void closeConnection(Connection conn) {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("数据库连接已关闭");
    }
}
