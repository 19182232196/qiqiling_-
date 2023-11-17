<%--
  Created by IntelliJ IDEA.
  User: 30890
  Date: 2023/4/17
  Time: 9:47
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
            #content{
                width: 1300px;
                height: 70px;
                float: right;
                border: grey 1px solid;
                margin-right: 40px;
                color: grey;
                font-size: 50px;
            }
        </style>
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    </head>
    <body>
    <%--<div style=" width:1300px;height:100px;margin-lef:450px;background-color: aliceblue;border: red 1px solid"></div>--%>
    <div id="content">
        <div  style="float: right;height: 70px">
            <c:if test="${session_person.getUserIdentify()==0}">
                <form action="student.action?action=searchTeacher"  method="post">
            </c:if>
            <c:if test="${session_person.getUserIdentify()==1}">
                <form action="tea.action?action=searchMyStudent"  method="post">
            </c:if>
            <c:if test="${session_person.getUserIdentify()==2}">
                <form action="man.action?action=search"  method="post">
            </c:if>
                <input type="text" name="matchText" style="height: 35px;width: 500px;font-size: 28px;color: darkslateblue;border: grey solid 1px;">
                <input type="submit" style="margin-left: 6px;margin-right: 30px" value="查询">
            </form>
        </div>
    </div>
    <br><br>
    <table border="1" cellspacing="0" align="center" class="con-b">
        <thead>
        <tr class="row" style="color: black;font-size: 25px" >
            <td class="lf">账户</td>
            <td class="lf">姓名</td>
            <td class="lf" style="width: 10%">性别</td>
            <c:if test="${session_person.getUserIdentify()!=0}">
                <td class="lf">生日</td>
                <td class="lf">身份证号码</td>
                <td class="lf">角色</td>
            </c:if>
            <td class="lf">其他名称</td>
            <c:if test="${session_person.getUserIdentify()!=0}">
                <td>删除</td>
            </c:if>
            <c:if test="${session_person.getUserIdentify()!=2}">
                <td style="width: 10%">操作</td>
            </c:if>
        </tr>
        </thead>
    <tbody>
        <c:forEach items="${arr}" var="person">
            <tr>
                <td class="lf">${person.getUserAccount()}</td>
                <td class="lf">${person.getUserName()}</td>
                <td class="lf">${person.getUserSex()}</td>
                <c:if test="${session_person.getUserIdentify()!=0}">
                    <td class="lf">${person.getUserBirthday()}</td>
                    <td class="lf">${person.getUserIdCard()}</td>
                    <td class="lf">
                        <c:if test="${person.getUserIdentify()==0}">
                            学生
                        </c:if>
                        <c:if test="${person.getUserIdentify()==1}">
                            老师
                        </c:if>
                    </td>
                </c:if>
                <td class="lf">${person.getUserOtherName()}</td>
                <c:if test="${session_person.getUserIdentify()==1}">
                    <td>
                        <img src="del.png" onclick="deleteThisPersonByTeacher('${person.getUserAccount()}')">
                    </td>
                </c:if>
                <c:if test="${session_person.getUserIdentify()==2}">
                    <td>
                        <img src="del.png" onclick="delThisPerson('${person.getUserAccount()}','${person.getUserIdentify()}')">
                    </td>
                </c:if>
                <c:if test="${session_person.getUserIdentify()!=0}">
                    <td>
                        <c:if test="${session_person.getUserIdentify()==1}">
                            <img style="width: 40px;height: 40px" src="detail.jpg" onclick="detailTask('${person.getUserAccount()}')">
                        </c:if>
                    </td>
                </c:if>
                <c:if test="${session_person.getUserIdentify()==0}">
                    <td><img style="width:40px;height: 40px" onclick="addTeacher('${person.getUserAccount()}')" src="addTeacher.png"></td>
                </c:if>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    </body>
    <script>
        function delThisPerson(userAccount,userIdentify) {
            window.location.href = "man.action?action=delThisPerson&userAccount="+userAccount+"&userIdentify="+userIdentify
        }
        function addTeacher(teacherAccount) {
            window.location.href = "student.action?action=addTeacher&teacherAccount=" + teacherAccount
        }
        function detailTask(studentAccount) {
            window.location.href = "tea.action?action=goStudentTaskDetail&studentAccount="+studentAccount;
        }
        function deleteThisPersonByTeacher(studentAccount) {
            alert(studentAccount)
            window.location.href = "tea.action?action=deleteThisPersonByTeacher&studentAccount="+studentAccount
        }
        function upThisPerson(userAccount) {
            alert("修改:"+userAccount)
        }
    </script>
</html>

