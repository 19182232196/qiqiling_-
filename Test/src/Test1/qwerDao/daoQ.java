package Test1.qwerDao;

import java.sql.*;

public class daoQ {
    // 驱动
    private String Driver="com.mysql.jdbc.Driver";
    // 连接地址
    private String URL = "jdbc:mysql://localhost:3306/"
            + "黄能2052231067"//数据库名
            + "";
    private String user = "root";
    private String pwd = "484110";

    // 获取连接
    public Connection getConn(){
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, user, pwd);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    // 关闭连接
    public void closeConn(Connection conn){
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("关闭连接");
    }
}