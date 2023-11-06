package com.ydhl.util;

import java.sql.*;

public class JDBCutil {
    private static final String QD="com.mysql.jdbc.Driver";
    private static final String URL="jdbc:mysql://127.0.0.1:3306/study?serverTimezone=GMT%2B8";
    private static final String USER="root";
    private static final String PAS="484110";

    static {
        try{
            Class.forName(QD);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        Connection con=null;
        try {
            con= DriverManager.getConnection(URL,USER,PAS);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return con;
    }

    public static void close(ResultSet rs, PreparedStatement st,Connection con){
        try{
            if (rs!=null){
                rs.close();
            }
            if (st!=null){
                st.cancel();
            }
            if (con!=null){
                con.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
