<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>前端素材管理系统</title>
</head>
<body>
<form style="padding-bottom: 10px;">
    <fieldset>
        <legend>搜索</legend>
        名称：<input type="text" name="name" id="">
        <input type="submit" value="搜索">
    </fieldset>
</form>
<table border="1" style="width: 100%;">
    <tr style="text-align: center; background-color:#ffaa00;">
        <th>编号</th>
        <th>名称</th>
        <th>类型</th>
        <th>上传时间</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${list}" var="Source">
        <tr>
            <td>${Source.id }</td>
            <td>${Source.name }</td>
            <td>${Source.type }</td>
            <td>${Source.uploadDate }</td>
            <td>
                <a href="/Source/SourceServlet?action=del&id=${Source.id}"
                   onclick="return confirm('您确定删除该人员信息')">删除</a>
                <a href="/Source/SourceServlet?action=Modifysel&id=${Source.id}">修改</a>
            </td>
        </tr>
    </c:forEach>
</table>
<div style="float: right;">
    <a href="add.jsp">新增</a>
    <span>共
			<c:out value="${list.size()}"/>
			条数据</span>
</div>
</body>
</html>
