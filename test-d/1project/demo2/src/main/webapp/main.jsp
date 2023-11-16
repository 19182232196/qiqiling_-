<%--
  Created by IntelliJ IDEA.
  User: h1918
  Date: 2023/11/14
  Time: 17:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        #BigBodyFrame{
            width: 1400px;
            height: 120px;
            margin-left: 66px;
            border: grey 0.01px solid;
            background-image: url("head.png");
        }
        #navigation{
            width: 250px;
            margin-left: 66px;
            float: left;
        }
        #file{
            width: 230px;
            height: 50px;
            margin-left: 15px;
            margin-top: 11px;
            background-color: mediumaquamarine;
        }
        a{
            color: white;
            font-size: 26px;
            margin-left: 40px;
            margin-top: 26px;
        }
    </style>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <link href="WEB-INF/css/css.css" rel="stylesheet" media="screen">
    </head>
    <body>
        <div id="BigBodyFrame">

        </div>
        <br>
        <span style="float: left;color: grey">当前用户:${session_person.userName}</span><br>
        <a href="#">修改密码</a>
        <br>
        <div id="navigation">
            <c:if test="${session_person.getUserIdentify()==0}">
                <li id="file"><a href="common.action?action=index">查看首页</a></li>
                <li id="file"><a href="common">选择老师</a></li>
                <li id="file"><a href="common">我的任务</a></li>
                <li id="file"><a href="common">我的信息</a></li>
                <li id="file"><a href="common">退出系统</a></li>
            </c:if>
            <c:if test="${session_person.getUserIdentify()==1}">
                <li id="file"><a href="common.action?action=index">查看首页</a></li>
                <li id="file"><a href="tea.action?action=list">学生管理</a></li>
                <li id="file"><a href="common">任务系统</a></li>
                <li id="file"><a href="common">我的信息</a></li>
                <li id="file"><a href="common">退出系统</a></li>
            </c:if>
            <c:if test="${session_person.getUserIdentify()==2}">
                <li id="file"><a href="common.action?action=index">查看首页</a></li>
                <li id="file"><a href="man.action?action=list">人员管理</a></li>
                <li id="file"><a href="common">课程管理</a></li>
                <li id="file"><a href="common">我的信息</a></li>
                <li id="file"><a href="common">退出系统</a></li>
            </c:if>
        </div>
    <jsp:include page="${mainRight=null?'blank.jsp':mainRight}"></jsp:include>
    </body>
</html>
