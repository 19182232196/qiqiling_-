<%@ page import="jakarta.servlet.jsp.PageContext" %><%--
  Created by IntelliJ IDEA.
  User: h1918
  Date: 2023/10/16
  Time: 10:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>
        <%
            String name = "123";
        PageContext pageContext1 = pageContext;
        pageContext.setAttribute("name", name, PageContext.SESSION_SCOPE);
        %>
        <%

        %>
    </body>
</html>
