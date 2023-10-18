<%@ page contentType="text/html; charset=UTF-8" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<br>
    <!--jstl的core标签库的使用-->
    <%
      String message = "jstl的out标签的使用";
      request.setAttribute("msg",message);

      String sex = "男";
      request.setAttribute("sex",sex);

      int score = 80;
      request.setAttribute("score",score);

      String[] names = {"zhangSan", "liSi", "wangWu", "zhaoLiu"};
      request.setAttribute("ns", names);

      List<String> nameList = new ArrayList<String>();
      nameList.add("zhangSan");
      nameList.add("liSi");
      nameList.add("wangWu");
      nameList.add("zhaoLiu");
      request.setAttribute("nList", nameList);

      Map<String,String> studentMap = new HashMap<String,String>();
      studentMap.put("number", "N_1001");
      studentMap.put("name", "zhangSan");
      studentMap.put("age", "23");
      studentMap.put("sex", "male");
      request.setAttribute("studentMap", studentMap);

      Date date = new Date();
      request.setAttribute("date", date);
    %>
    <!--out标签的使用-->
    <h3><c:out value="${msg}"/></h3></br></br>

    <!--if标签的使用-->
    <input type="radio" name="sex" <c:if test="${sex=='男'}">checked</c:if><c:if test="${sex=='女'}"></c:if>/>男</br></br>

    <!--choose标签的使用-->
     <h3>
        使用c:choose判断条件是否满足：
        <font color="red">
            <c:choose>
                <c:when test="${score > 100 || score < 0}">错误的分数：${score }</c:when>
                <c:when test="${score >= 90 }">A级</c:when>
                <c:when test="${score >= 80 }">B级</c:when>
                <c:when test="${score >= 70 }">C级</c:when>
                <c:when test="${score >= 60 }">D级</c:when>
                <c:otherwise>E级</c:otherwise>
            </c:choose>
        </font>
     </h3><br/><br/>

    <!-- c:forEach循环遍历集合或数组 -->
    <h3>使用c:foreach循环遍历集合或数组：<br/>
        <font color="red">
            <c:forEach var="item" items="${ns}">
                <c:out value="name: ${item}"/><br/>
            </c:forEach>
        </font>
    </h3><br/><br/>

    <!-- c:forEach循环遍历列表 -->
    <h3>使用c:foreach循环遍历列表：<br/>
        <font color="red">
            <c:forEach var="item" items="${nList}">
                <c:out value="name: ${item }"/><br/>
            </c:forEach>
        </font>
    </h3><hr><br/>

    <!-- c:forEach循环遍历Map -->
    <h3>使用c:foreach循环遍历MAP：<br/>
        <font color="red">
            <c:forEach var="item" items="${studentMap}">
                <c:out value="${item.key}: ${item.value}"/><br/>
            </c:forEach>
        </font>
    </h3><hr><br/>

    <!-- fmt:dateFormat格式化日期 -->
    <h3>使用fmt:dateFormat格式化日期：
        <font color="red">
            <fmt:formatDate value="${date}" pattern="yyyy-MM-dd HH:mm:ss"/>
        </font>
    </h3><hr><br/>

    <!-- fmt:message实现国际化 -->
    <h3>使用fmt:message获取属性文件中的参数：<br/>
        <!-- 设置当前语言环境为中文 -->
        <fmt:setLocale value="zh_CN"/>
        <!--<fmt:setLocale value="en_US"/>-->

        <!-- 从资源文件路径获取属性文件 -->
        <fmt:bundle basename="message/message_en_US">
            <span>从属性文件中读取简单数据:</span>
            <font color="red">
                <fmt:message key="user.operation.add"></fmt:message><br/>
            </font>

            <span>从属性文件中读取数据的同时注入参数:</span>
            <font color="red">
                <fmt:message key="user.operation.addUser">
                    <fmt:param value="张三"></fmt:param>
                </fmt:message><br/>
            </font>
        </fmt:bundle>
    </h3>
</body>
</html>