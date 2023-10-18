<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>JSP - Scope</title>
</head>
<body>
    <%
        //往Page域中放数据
        pageContext.setAttribute("pageMsg","页面域中放置的数据，只能当前页面获取！");
        //当前页获取page域中的数据
        String pageMsg = (String) pageContext.getAttribute("pageMsg");

        //往request域中放数据
        request.setAttribute("requestMsg","请求域中放置的数据，当前页面和请求转发的页面都可以获取，但重定向的页面无法获取！");
        //当前页获取request域中的数据
        String requestMsg = (String) request.getAttribute("requestMsg");

        //往Session域中放数据
        session.setAttribute("sessionMsg","会话域中放置的数据，跳转的页面都可以获取到，但浏览器重启或用户退出后会话结束则取不到数据。");
        //当前页获取session域中的数据
        String sessionMsg = (String) pageContext.getAttribute("sessionMsg");

        //往Application域中放数据
        //把<Manager+pathname/>"和<Valve className="org.apache.catalina.valves.CometConnectionManagerValve"/>外的注释去掉，
        // 然后删除work文件夹，再重启服务器的时候，就会不保留数据
        application.setAttribute("applicationMsg","应用域中放置的数据，跳转的页面都可以获取到，但tomcat重启后则无法获取。");
        //当前页获取application域中的数据
        String applicationMsg = (String) application.getAttribute("applicationMsg");

    %>

    <!---当前页面获取page域中的数据-->
    当前页获取page域中的数据：<font color="red"><%=pageMsg%></font><hr><br/>

    <!--请求转发的页面获取数据-->
    <%--<jsp:forward page="forward.jsp"></jsp:forward>--%>
    <jsp:forward page="forward.jsp"></jsp:forward>

    <!--重定向的页面中获取数据-->
    <a href="redirect.jsp">重定向到其他页面获取数据</a>
</body>
</html>