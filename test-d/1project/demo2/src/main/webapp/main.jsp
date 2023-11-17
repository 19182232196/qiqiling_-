<%--
  Created by IntelliJ IDEA.
  User: 30890
  Date: 2023/4/17
  Time: 19:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        #BigBodyFrame{
            width: 1600px;
            height: 120px;
            border: grey 2px solid;
            background-image: url("head.png");
        }

        #daohang{
            width: 250px;
            /*height: 100%;*/
            float: left;
            border: grey 1px solid;
        }

        #file{
            width: 230px;
            height: 50px;
            margin-left: 11px;
            margin-top: 10px;
            border: grey 1px solid;
            background-color: mediumslateblue;
        }
        a{
            color: white;
            font-size: 26px;
            margin-left: 30px;
            margin-top: 25px;
        }

    </style>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <link href="${pageContext.request.contextPath}/css/css.css" rel="stylesheet" media="screen">
</head>
<body>
<div id="BigBodyFrame"></div>
<br>
<span style="float: right;color: grey;margin-right: 120px"> 当前用户：${session_person.userName}</span><br>
<c:if test="${session_person.userName=='李四'}">hahha</c:if>  
<br>
<div id="daohang">
    <c:if test="${session_person.userIdentify == 0}">
        <li id="file"><a href="common.action?action=index">查看首页</a></li>
        <li id="file"><a href="student.action?action=list">选择老师</a></li>
        <li id="file"><a href="student.action?action=goMyTeacher">我的老师</a></li>
        <li id="file"><a href="common.action?action=goMyDetail">我的信息</a></li>
        <li id="file"><a href="outLogin">退出系统</a></li>
    </c:if>
    <c:if test="${session_person.userIdentify == 1}">
        <li id="file"><a href="common.action?action=index">查看首页</a></li>
        <li id="file"><a href="tea.action?action=list">学生管理</a></li>

        <li id="file"><a href="tea.action?action=goMyTask">任务管理</a></li>
        <li id="file"><a href="tea.action?action=goAddTask">添加任务</a></li>
        <li id="file"><a href="common.action?action=goMyDetail">我的信息</a></li>
        <li id="file"><a href="outLogin">退出系统</a></li>
    </c:if>

    <c:if test="${session_person.userIdentify == 2}">
        <li id="file"><a href="common.action?action=index">查看首页</a></li>
        <li id="file"><a href="man.action?action=list">人员管理</a></li>
        <li id="file"><a href="man.action?action=goAddPerson">人员添加</a></li>
        <li id="file"><a href="common.action?action=goMyDetail">我的信息</a></li>
        <li id="file"><a href="outLogin">退出系统</a></li>
    </c:if>
    <%--    <div id="file" onclick="clickThis()"></div>--%>


</div>

<jsp:include page="${mainRignt=null?'blank.jsp':mainRight}"></jsp:include>


</body>
</html>
