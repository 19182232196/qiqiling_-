<%--
  Created by IntelliJ IDEA.
  User: 30890
  Date: 2023/4/26
  Time: 21:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="student.action?action=getFenshu&taskAccount=${taskAccount}&studentAccount=${studentAccount}" method="post" onsubmit="return checkFenshu()">
        分数:<input type="number" style="width: 150px;height: 20px" id="fenshu" name="fenshu"><br>
        <input style="position: center" type="submit" value="确认">
    </form>
</body>
</html>

<script>
    function getFenshu() {
        let fenshu = document.getElementById("fenshu").value;
        if(fenshu==null||fenshu.trim()==""){
            alert("请输入分数！")
            return false;
        }

        if(fenshu<0||fenshu>100){
            alert("分数不合法")
            return false;
        }

        return true;

    }
</script>
