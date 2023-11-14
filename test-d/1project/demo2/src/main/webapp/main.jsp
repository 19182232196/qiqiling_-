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
    </head>
    <body>
        <div id="BigBodyFrame">

        </div>
        <br><br>
        <div id="navigation">
            <li id="file"><a href="common">查看首页</a></li>
            <li id="file"><a href="common">学生管理</a></li>
            <li id="file"><a href="common">任务系统</a></li>
            <li id="file"><a href="common">我的信息</a></li>
            <li id="file"><a href="common">退出系统</a></li>
        </div>
    <jsp:include page="${mainRight=null?'blank.jsp':mainRight}"></jsp:include>
    </body>
</html>
