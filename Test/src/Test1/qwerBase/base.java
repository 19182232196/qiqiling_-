package Test1.qwerBase;

import Test1.qwerInterface.interf;
import Test1.qwerObj.obj;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class base implements interf{

   //定义一个静态变量dao，用于存储db类的实例
    final static db dao = new db();
    //定义一个静态变量o，用于存储obj类的实例
    final static obj o=new obj();
    //定义一个静态变量conn，用于存储连接对象
    final static Connection conn = dao.getConn();
    //定义一个静态变量list，用于存储obj类的实例的集合
    final static ArrayList<obj> list = new ArrayList<>();

    @Override
    public ArrayList<obj> show() {
        // 创建一个ArrayList对象
        try {
            // 创建一个PreparedStatement对象，用于执行SQL语句
            PreparedStatement pdst=conn.prepareStatement("select * from pop");
            // 执行查询语句，返回结果集
            ResultSet rs=pdst.executeQuery();
            // 遍历结果集
            while(rs.next()){
                // 创建一个obj对象
                obj o = new obj();
                // 设置obj对象的属性
                o.setId(rs.getString("id"));
                o.setPassword(rs.getString("password"));
                o.setName(rs.getString("name"));
                o.setEmail(rs.getString("email"));
                o.setBirthday(rs.getString("birthday"));
                // 将obj对象添加到ArrayList对象中
                list.add(o);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // 返回ArrayList对象
        return list;
    }

    @Override
    public obj Login(String id ,String password) {
        try {
            String sql = "select * from users where id = ? and password = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,id);
            pstmt.setString(2,password);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()){
                return searchUserById(id);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int signUp(String id, String name, String password, String email, String birthday) {
        return 0;
    }

    @Override
    public int delUser(String id) {
        return 0;
    }

    @Override
    public int updateUser(String comlue, String value, String id) {
        return 0;
    }

    @Override
    public obj searchUserById(String id) {
        try {
            // 根据id查询用户信息
            String sql = "select * from users where id = ? ";
            PreparedStatement pstmt  = conn.prepareStatement(sql);
            pstmt.setString(1,id);
            ResultSet rs = pstmt.executeQuery();
            if (o!=null) {
                if (rs.next()) {
                    o.setId(rs.getString("id"));
                    o.setName(rs.getString("name"));
                    o.setPassword(rs.getString("password"));
                    o.setEmail(rs.getString("email"));
                    o.setBirthday(rs.getString("birthday"));
                } else {
                    System.err.println("No user found for the ID: " + id);
                    return null;
                }
            }else {
                return o;
            }
        } catch (SQLException e) {
            System.err.println("An error occurred: " + e.getMessage());
            throw new RuntimeException(e);
        }
        return o;
    }
}