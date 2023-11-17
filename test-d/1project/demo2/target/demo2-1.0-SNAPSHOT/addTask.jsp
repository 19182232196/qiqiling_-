<%--
  Created by IntelliJ IDEA.
  User: 30890
  Date: 2023/4/19
  Time: 10:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        #content{
            width: 1300px;
            height: 600px;
            float: right;
            margin-right: 40px;
            border: saddlebrown 1px solid;
        }
        #innerAddTaskFrame{
            width: 1000px;
            height: 400px;
            margin-left: 100px;
            color: mediumslateblue;
            margin-top: 50px;
            font-size: 20px;
        }

    </style>
</head>
<body>
<div id="content">

    <div id="innerAddTaskFrame">
        请添加题目：<br><br>
        <form action="tea.action?action=addTask" method="post">
            <textarea style="width: 800px;height: 160px;font-size: 25px;color: grey" rows="4" name="taskName">

            </textarea>
            <br> <br> <br>
            <input style="margin-left: 350px" type="submit" value="点击添加">

        </form>
        <span style="margin-left: 320px;font-size: 15px;color: red">${tip}</span>


    </div>

</div>


</body>
</html>
<script>
    function checkAddTask() {
        alert("hahah")
        return false;
    }

</script>
