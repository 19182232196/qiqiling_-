<%--
  Created by IntelliJ IDEA.
  User: h1918
  Date: 2023/11/13
  Time: 22:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=utf-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        #outerLoginFrame{
            width: 500px;
            height: 400px;
            margin-left: 500px;
            margin-top: 260px
        }
        #innerLoginFrame{
            width: 360px;
            margin-left: 90px;
            margin-top: 40px;
            color: grey;
            font-size:25px
        }
        input{
            width: 230px;
            height: 30px
        }
    </style>
</head>
<body>
<div id="outerLoginFrame" style="border: grey ">
    <h1 style="margin-top: 40px;margin-left: 200px;color: grey">登&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;录</h1>
    <div id="innerLoginFrame" style="font-size:30px ">
        <form action="userLogin" method="post" onclick="return checkLogin()" >
            账户:<input type="text" style="font-size: 28px" id="userAccount" name="userAccount" class="myTest"><br><br>
            密码:<input type="text" style="font-size: 28px" id="userPassword" name="userPassword" class="myTest"><br><br>
            <input style="width: 140px ;margin-left: 20px" type="submit" value="登录">
            <a href="register.jsp" style="width: 140px ;margin-left: 20px">|&nbsp;注册</a><br>
            <span style="color: red;font-size: 10px" id="tip">${tip}</span>
        </form>
    </div>
</div>
  </body>
</html>
<script>
    function checkLogin(){
        let userAccount=document.getElementById("userAccount").value
        let userPassword=document.getElementById("userPassword").value
        if (userAccount==null||userAccount.trim()==""){
            document.getElementById("tip").innerHTML="请输入账户"
            return false
        }
        if (userPassword==null||userPassword.trim()==""){
            document.getElementById("tip").innerHTML="请输入密码"
            return false
        }
        return true
    }
</script>
