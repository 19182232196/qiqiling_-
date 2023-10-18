<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2023/10/8
  Time: 10:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="login" method="post">
        <font color="red">${message}</font><br/><br/>
        用户名:<input type="text" name="userName"/><br/><br/>
        密码:<input type="password" name="password"/><br/><br/>
        <input type="submit" value="登录"/>
    </form>
</body>
</html>
