package Test20.Util;

import Test20.Dao.dbDao;

import java.sql.Connection;

public class test {
    public static void main(String[] args) {
        dbDao dbDao= new dbDao();
        dbDao.getConnection();
    }
}
