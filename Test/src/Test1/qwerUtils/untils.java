package Test1.qwerUtils;

import Test1.qwerDao.daoQ;

import java.sql.*;

public class untils {
    public static void main(String[] args) {
        // 创建一个daoQ对象
        daoQ dao =new daoQ();
        // 获取数据库连接
        Connection conn=dao.getConn();
        // 关闭数据库连接
        dao.closeConn(conn);
    }
}