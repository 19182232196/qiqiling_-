<%--
  Created by IntelliJ IDEA.
  User: 30890
  Date: 2023/4/23
  Time: 14:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        table{
            width: 1300px;
        }
        tr,td{
            border: grey 1px ;
        }
        td{
            height: 20px;
        }

        table td{
            height: 20px;
            vertical-align: middle!important;  /*设置文字垂直居中*/
            /*text-align: center;*/
        }

        /*tr,td{border-right:1px solid #888;border-bottom:1px solid #888;padding:5px 15px;}*/

        th{font-weight:bold;background:#ccc;}

        .con-b .row .lf{
            width: 15%;
            /*text-align: center;*/
            padding: 10px;
        }
        .con-b .row .rg{
            width: 85%;
        }

        .con-b tr:nth-of-type(odd){
            background-color: #f2f2f2;
        }


    </style>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>
<table border="1" cellspacing="0" align="center" class="con-b">
    <tbody>
        <tr class="row" style="color: black;font-size: 25px">
            <td class="lf" >登录账户</td>
            <td class="lf">${session_person.getUserAccount()}</td>
        </tr>
        <tr class="row" style="color: black;font-size: 25px">
            <td class="lf">姓名</td>
            <td class="lf">${session_person.getUserName()}</td>
        </tr>
        <tr class="row" style="color: black;font-size: 25px">
            <td class="lf">性别</td>
            <td class="lf">${session_person.getUserSex()}</td>
        </tr>
        <tr class="row" style="color: black;font-size: 25px">
            <td class="lf">出生日期</td>
            <td class="lf">${session_person.getUserBirthday()}</td>
        </tr>
        <tr class="row" style="color: black;font-size: 25px">
            <td class="lf">身份证号码</td>
            <td class="lf">${session_person.getUserIdCard()}</td>
        </tr>
        <tr class="row" style="color: black;font-size: 25px">
            <td class="lf">

                <button onclick="upPassword()">修改密码</button>

            </td>
        </tr>
    </tbody>

</table>
</body>
</html>
<script>
    function upPassword() {
        window.open("common.action?action=upPassword", null,"width=700,height=400,left=400,top=150", true);
    }
</script>