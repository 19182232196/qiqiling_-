<%@ page language="java" import="java.util.*" import="java.sql.*" pageEncoding="gb2312"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
  <title></title>
</head>
<body>
<%
//1.加载驱动
Class.forName("com.mysql.jdbc.Driver");
//2.创建连接
Connection conn =
DriverManager.getConnection("jdbc:mysql://localhost:3306/test?characterEncoding=UTF-8",
"root","root");
//3.使用statement创建一个会话，运行SQL语句
Statement stat = conn.createStatement();
//定义SQL语句，我这里写的是，将刘平的性别修改成nv
String sql = "update t_student set stusex='女' where stuno='0007'";
//4.将查询的结果返回过来，这里使用的是修改语句，返回的结果是一个整型数值
int i = stat.executeUpdate(sql);
//打印结果到页面
String string = "成功修改"+i+"行";
//5.关闭连接
stat.close();
conn.close();
%>
</body>
</html>
