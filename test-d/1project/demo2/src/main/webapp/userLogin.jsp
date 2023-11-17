<%--
  Created by IntelliJ IDEA.
  User: 30890
  Date: 2023/4/16
  Time: 21:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录界面</title>
    <style>
        #outerLoginFrame{
            width: 500px;
            height: 400px;
            margin-left: 600px;
            margin-top: 260px;
        }
        #innerLoginFrame{
            width: 360px;
            margin-left: 100px;
            margin-top: 45px;
            color: grey;
            font-size: 25px;
        }
        input{
            width: 220px;
            height: 30px;
        }
    </style>
</head>
<body>
<div id="outerLoginFrame" style="border: grey 2px solid">
<%--    <span style="position: center"></span>--%>
    <h1 style="margin-top: 40px;margin-left: 130px;">教&nbsp;务&nbsp;管&nbsp;理&nbsp;系&nbsp;统</h1>
    <div id="innerLoginFrame" style="font-size: 30px">
        <form action="userLogin" method="post" onsubmit="return checkLogin()">
            账户：<input type="text" style="font-size: 28px" id="userAccount" name="userAccount" class="myText"><br><br>
            密码：<input type="password" style="font-size: 28px" id="userPassword" name="userPassword" class="myText"><br><br>
            <input style="width: 140px;margin-left: 20px" type="submit" value="登录">
            <span style="color: red;font-size: 15px" id="tip">${tip}</span>
        </form>
    </div>
</div>
</body>
</html>
<script>
    function checkLogin() {
        let userAccount = document.getElementById("userAccount").value;
        let userPassword = document.getElementById("userPassword").value;
        if(userAccount==null||userAccount.trim()==""){
            document.getElementById("tip").innerHTML = "账户不能为空";
            return false;
        }
        if(userPassword==null||userPassword.trim()==""){
            document.getElementById("tip").innerHTML = "密码不能为空";
            return false;
        }
        return true;
    }
</script>
