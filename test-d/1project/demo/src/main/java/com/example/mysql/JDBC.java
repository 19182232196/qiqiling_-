package com.example.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBC {
    public  static Connection getConnection() throws ClassNotFoundException, SQLException {
    Class.forName("com.mysql.jdbc.Driver");

    String url="jdbc:mysql://localhost:3306/test?serverTimezone=Asia/Shanghai";
    String user="root";
    String password="123456";
    Connection Connection= DriverManager.getConnection(url);
    return Connection;
    }
}
