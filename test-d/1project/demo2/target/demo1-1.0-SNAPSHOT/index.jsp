<%@ page language="java" import="java.util.*,com.el.javaBean.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>My JSP 'index.jsp' starting page</title>
</head>
<body>

        <!-- 使用el表达式输出字符串 -->
        <%
            request.setAttribute("message","EL表达式输出字符串");
        %>
        <%--${name}等同于pageContext.findAttribute("message") --%>
        <h3> 使用EL表达式获取数据：<font color="red"> ${message} </font> </h3><hr><br/>


        <!-- 使用el表达式可以获取bean的属性 -->
        <%
            Person p = new Person();
            request.setAttribute("person",p);
        %>
        <h3> 使用EL表达式获取获取bean的属性：<font color="red"> ${person.name} </font> </h3><hr><br/>


        <!-- 使用el表达式可以获取bean中的其他对象的的属性 -->
        <%
            Person pe = new Person();
            Child c = new Child();
            pe.setChild(c);
            request.setAttribute("person",pe);
        %>
        <h3> 使用EL表达式获取bean中的其他对象的的属性：<font color="red"> ${person.child.name} </font> </h3><hr><br/>


        <!-- 使用el表达式获取list集合中指定位置的数据 -->
        <%
            Person p1 = new Person();
            p1.setName("张三");

            Person p2 = new Person();
            p2.setName("李四");

            List<Person> list = new ArrayList<Person>();
            list.add(p1);
            list.add(p2);

            request.setAttribute("personList",list);
        %>


        <!-- EL表达式获取list指定位置的数据 -->
        <h3> 使用EL表达式获取list指定位置的数据：<font color="red"> ${personList[1].name}  </font> </h3><hr><br/>


        <h3>el表达式进行四则运算：</h3>
        <font color="red">
            加法运算：${365+24}<br/>
            减法运算：${365-24}<br/>
            乘法运算：${365*24}<br/>
            除法运算：${365/24}<br/>
        </font><hr><br/>


        <h3>el表达式判断对象是否为空：</h3>
        <font color="red">
            <%
                Person person = new Person();
            %>
            ${person eq null}<br/>
            ${person == null}<br/>
            ${empty person}<br/>
        </font><hr><br/>


        <h3>el表达式进行二次元运算：</h3>
        <font color="red">
            ${person == null? "对不起，您没有登陆 " : person.name}<br/>
        </font><hr><br/>


        <h3>EL表达式数据回显</h3>
        <%
            //性别设置为男性
            person.setGender("male");
            //数据回显
            request.setAttribute("person",person);
        %>
        <input type="radio" name="gender" value="male" ${person.gender=='male'?'checked':''}>男
        <input type="radio" name="gender" value="female" ${person.gender=='female'?'checked':''}>女

</body>
</html>
