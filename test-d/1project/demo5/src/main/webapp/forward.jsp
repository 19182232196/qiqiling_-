<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2023/9/21
  Time: 11:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <%
        //获取Page域中的数据
        String pageMsg = (String)pageContext.getAttribute("pageMsg");

        //获取Request域中的数据
        String requestMsg = (String)request.getAttribute("requestMsg");

        //获取Session域中的数据
        String sessionMsg = (String)session.getAttribute("sessionMsg");

        //获取Application域中的数据
        String applicationMsg = (String)application.getAttribute("applicationMsg");

    %>

    <!--打印取到的数据-->
    请求转发的页面取page域中的数据：<font color="red"><%=pageMsg%></font><hr><br/>

    请求转发的页面取request域中的数据：<font color="red"><%=requestMsg%></font><hr><br/>

    请求转发的页面取session域中的数据：<font color="red"><%=sessionMsg%></font><hr><br/>

    请求转发的页面取application域中的数据：<font color="red"><%=applicationMsg%></font><hr><br/>
</body>
</html>
