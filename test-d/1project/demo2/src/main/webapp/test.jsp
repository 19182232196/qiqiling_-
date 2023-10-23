<%--
  Created by IntelliJ IDEA.
  User: h1918
  Date: 2023/10/23
  Time: 10:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" import="java.util.*"  language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        String name = "out标签输出";
        request.setAttribute("name", name);

        String sex = "男";
        request.setAttribute("sex", sex);

        int cod=80;
        request.setAttribute("cod", cod);

        String[] str ={"1","2","3"};
        request.setAttribute("str", str);


    %>

    <h3>out标签:<font color="#7fffd4"><c:out value="取数据:${name}"></c:out></font></h3><br/><br/>

    <h3>if标签<input type="radio" name="sex" <c:if test="${sex}">checked</c:if>>man</h3>
    <h3>if标签<input type="radio" name="sex" <c:if test="${sex}">checked</c:if>>woman</h3><br/><br/>

    <h3>choose标签
        <font color="#7fffd4">
            <c:choose>
                <c:when test="${cod>100||cod<0}">erorr</c:when>
                <c:when test="${cod>=90}">A</c:when>
                <c:when test="${cod>=80}">B</c:when>
                <c:when test="${cod>=70}">C</c:when>
                <c:when test="${cod>=60}">D</c:when>
                <c:otherwise>E</c:otherwise>
            </c:choose>
        </font>
    </h3><br/><br/>

    <h3>forEach标签
        <font color="#7fffd4">
            <c:forEach var="str" items="${str}">
                <c:out value="${str}"></c:out><br/>
            </c:forEach>
        </font>
    </h3>
  </body>
</html>
