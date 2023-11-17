<%--
  Created by IntelliJ IDEA.
  User: 30890
  Date: 2023/4/18
  Time: 18:45
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
            height: 40px;
        }

        table td{
            height: 60px;
            vertical-align: middle!important;  /*设置文字垂直居中*/
            text-align: center;
        }

        tr,td{border-right:1px solid #888;border-bottom:1px solid #888;padding:5px 15px;}

        th{font-weight:bold;background:#ccc;}

        .con-b .row .lf{
            width: 15%;
            text-align: center;
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
    <thead>
    <tr class="row" style="color: black;font-size: 25px">
        <td class="lf">任务账户</td>
        <td class="lf">任务名称</td>
        <td class="lf">任务时间</td>
        <td class="lf">删除题目</td>
        <td class="lf">查看详细</td>
    </tr>
    </thead>
    <tbody>

    <c:forEach items="${arr}" var="task">
        <tr>
            <td class="lf">${task.getTaskAccount()}</td>
            <td class="lf">${task.getTaskName()}</td>
            <td class="lf">${task.getTaskDate()}</td>
            <td class="lf"><img src="del.png" onclick="deleteTishTask('${task.getTaskAccount()}')"></td>
            <td class="lf"><img style="width: 40px;height: 40px" src="detail.jpg" onclick="skimDetail('${task.getTaskAccount()}')"></td>
        </tr>
    </c:forEach>

    </tbody>

</table>

</body>
</html>

<script>
    function deleteTishTask(taskAccount) {
        window.location.href = "tea.action?action=deleteTishTask&taskAccount="+taskAccount;
    }


    function skimDetail(taskAccount) {
        //查看这个任务的学生完成情况
        window.location.href = "tea.action?action=goSkimDetail&taskAccount="+taskAccount;
    }
</script>

