package com.ydhl.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ydhl.entity.Source;
import com.ydhl.util.JDBCutil;

public class SourceDao {

    // 创建connection对象
    private Connection con = null;
    // 创建PreparedStatement对象
    private PreparedStatement st = null;
    // 创建resultSet对象
    private ResultSet rs = null;

    //查询
    public List<Source> Query(String name) {
        // 创建一个arraylist集合 填充数据库表数据
        ArrayList<Source> list = new ArrayList<>();
        try {
            // 获取数据库连接对象
            con = JDBCutil.getConnection();
            String sq = "SELECT * FROM tb_source WHERE name LIKE ?";
            st = con.prepareStatement(sq);// 将sql存放入小汽车中搬运
            st.setString(1, "%" + name + "%");
            rs = st.executeQuery();// 获取结果
            // 使用while循环读取resultset数据
            while (rs.next()) {
                Source sr = new Source();
                sr.setId(rs.getInt("id"));
                sr.setName(rs.getString("name"));
                sr.setType(rs.getString("type"));
                sr.setUploadDate(rs.getString("uploadDate"));
                // 将对象保存到对应arraylist
                list.add(sr);
            }
        } catch (SQLException e) {
            // 异常抛出
            e.printStackTrace();
        } finally {
            // 使用之后关闭连接
            JDBCutil.close(rs, st, con);
        }
        // 返回最终结果
        return list;
    }

    // 删除
    public boolean del(int id) {
        try {
            // 获取对应数据库connection对象
            con = JDBCutil.getConnection();
            // 删除数据库sql
            String sql = "delete from tb_source where id=?";
            st = con.prepareStatement(sql);
            // 设置删除ID
            st.setInt(1, id);
            // 执行sql 并且返回结果
            return st.executeUpdate() > 0;
        } catch (SQLException e) {
            // 抛出异常
            e.printStackTrace();
        } finally {
            // 关闭连接
            JDBCutil.close(rs, st, con);
        }
        // 如果异常默认返回false
        return false;
    }

    // 添加
    public boolean add(Source source) {
        try {
            // 根据对应数据库获取对应连接
            con = JDBCutil.getConnection();
            // 新增sql
            String sql = "INSERT INTO tb_source(name, type, uploadDate) VALUES (?, ?, ?)";
            // 传入sql值
            st = con.prepareStatement(sql);
            st.setString(1, source.getName());
            st.setString(2, source.getType());
            st.setString(3, source.getUploadDate());
            // 执行sql并且返回结果
            return st.executeUpdate() > 0;
        } catch (SQLException e) {
            // 抛出异常
            e.printStackTrace();
        } finally {
            // 关闭连接
            JDBCutil.close(rs, st, con);
        }
        // 如果异常则默认返回false
        return false;
    }

    // 根据id查询对应数据
    public Source Modifysel(int id) {
        try {
            con = JDBCutil.getConnection();
            // 根据id查询sql
            String sql = "SELECT * FROM tb_source where id=?";
            st = con.prepareStatement(sql);// 将sql存放入小汽车中搬运
            // 替换？值
            st.setInt(1, id);
            // 执行查询结果
            rs = st.executeQuery();// 获取结果
            // 绑定对象
            while (rs.next()) {
                Source sr = new Source();
                sr.setId(rs.getInt("id"));
                sr.setName(rs.getString("name"));
                sr.setType(rs.getString("type"));
                sr.setUploadDate(rs.getString("uploadDate"));
                return sr;
            }
        } catch (SQLException e) {
            // 抛出异常
            e.printStackTrace();
        } finally {
            // 关闭连接
            JDBCutil.close(rs, st, con);
        }
        // 如果出现异常则默认抛出null
        return null;
    }

    // 修改方法
    public boolean modify(Source source) {
        try {
            con = JDBCutil.getConnection();
            // 修改sql
            String sql = "UPDATE tb_source SET name=?, type=?, uploadDate=? WHERE id=?";
            // 填充sql
            st = con.prepareStatement(sql);
            // 替换参数
            st.setString(1, source.getName());
            st.setString(2, source.getType());
            st.setString(3, source.getUploadDate());
            st.setInt(4, source.getId());
            // 返回结果
            return st.executeUpdate() > 0;
        } catch (SQLException e) {
            // 抛出异常
            e.printStackTrace();
        } finally {
            // 关闭连接
            JDBCutil.close(rs, st, con);
        }
        // 如果异常则默认返回false
        return false;
    }

}