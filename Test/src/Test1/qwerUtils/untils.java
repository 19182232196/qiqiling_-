package Test1.qwerUtils;

import Test1.qwerBase.base;

import java.sql.*;

public class untils {
    public static void main(String[] args) {

        base dao =new base();
        System.out.println(dao.Login("25153352","123456"));
//        // 获取数据库连接
//        Connection conn=dao.getConn();
//        // 关闭数据库连接
//        dao.closeConn(conn);
    }
}