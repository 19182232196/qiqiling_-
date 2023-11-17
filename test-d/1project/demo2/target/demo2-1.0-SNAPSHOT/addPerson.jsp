<%--
  Created by IntelliJ IDEA.
  User: 30890
  Date: 2023/4/24
  Time: 14:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">

</script>
<div class="data_list">
</div>

<form method="post" action="man.action?action=addThisPerson" onsubmit="return checkThis()">

    <div class="data_form">
        <table align="center">
            <tr>
                <td><font color="red">*</font>姓名：</td>

                <td><input type="text" id="userName" name="userName"
                           style="margin-top:5px;height:30px;"/></td>


            </tr>
            <tr>
                <td><font color="red">*</font>性别：</td>
                <td>&nbsp;<input  type="radio" name="userSex" value="男" checked="checked">&nbsp;男&nbsp;&nbsp;
                    <input type="radio" name="userSex" value="女">女<br>


            </tr>

            <tr>
                <td><font color="red">*</font>出生日期：</td>
                <td><input type="date" id="userBirthday" name="userBirthday"
                           style="margin-top:5px;height:30px;"/></td>
            </tr>

            <tr>
                <td><font color="red">*</font>身份证号码：</td>
                <td><input type="text" id="userIdCard" name="userIdCard" style="margin-top:5px;height:30px;"/>
                </td>
            </tr>

            <tr>
                <td><font color="red">*</font>手机号码：</td>
                <td><input type="number" id="userPhone" name="userPhone" style="margin-top:5px;height:30px;"/>
                </td>
            </tr>

            <tr>
                <td><font color="red">*</font>角色：</td>

                <td>
                    <select id="userIdentify" name="userIdentify" style="width: 205px" ;>
                        <%--                                绝密、机密、秘密、非秘级--%>
                        <option id="a" value="0">学生</option>
                        <option id="b" value="1">老师</option>
                    </select>
                </td>
            </tr>


            <tr>
                <td><font color="red">*</font>职务：</td>
                <td><input type="text" id="nikeName" name="userOtherName" placeholder="某科老师/学生"
                           style="margin-top:5px;height:30px;"/></td>

            </tr>


            <tr>
                <td><font color="red">*</font>输入密码：</td>
                <td><input type="password" id="userPassword" name="userPassword"
                           style="margin-top:5px;height:30px;"/></td>
            </tr>

            <tr>
                <td><font color="red">*</font>再次密码：</td>
                <td><input type="password" id="rUserPassword" name="rUserPassword"
                           style="margin-top:5px;height:30px;"/></td>
            </tr>


            <script>

                function checkThis() {
                    let userName = document.getElementById("userName").value;
                    let userIdCard = document.getElementById("userIdCard").value;
                    let nikeName = document.getElementById("nikeName").value;
                    let userPassword = document.getElementById("userPassword").value;
                    let userPhone = document.getElementById("userPhone").value;
                    let rUserPassword = document.getElementById("rUserPassword").value;
                    if (userName.trim() == null || userName.trim() == "") {
                        document.getElementById("error").innerHTML = "姓名不能为空";
                        return false;
                    }

                    if (userIdCard.trim() == null || userIdCard.trim() == "") {
                        document.getElementById("error").innerHTML = "身份证号码不能为空";
                        return false;
                    }

                    if (userPhone.trim() == null || userPhone.trim() == "") {
                        document.getElementById("error").innerHTML = "手机号码不能为空";
                        return false;
                    }

                    if (nikeName.trim() == null || nikeName.trim() == "") {
                        document.getElementById("error").innerHTML = "职称不能为空";
                        return false;
                    }


                    if (userPassword == null || userPassword.trim() == "") {
                        document.getElementById("error").innerHTML = "密码不能为空";
                        return false;
                    }


                    if (rUserPassword.trim() == null || rUserPassword.trim() == "") {
                        document.getElementById("error").innerHTML = "密码不能为空";
                        return false;
                    }
                    let reg1 = /(^\d{18}$)||(^\d{17}(\d|X|x)$)/;
                    let reg2 = /(^\d{11}$)/;
                    if(reg1.test(userIdCard) === false){
                        alert("身份证输入不合法");
                        return false;
                    }
                    if(reg2.test(userPhone) === false){
                        alert("手机号输入不合法");
                        return false;
                    }
                    if (rUserPassword != userPassword) {
                        document.getElementById("error").innerHTML = "两次密码不相同";
                        return false;
                    }

                    return true;


                }


            </script>


        </table>
        <div align="center">
            <input type="submit" class="btn btn-primary" value="保存"/>
            <span style="color: #dd1144" id="error">${tip}</span>
        </div>
    </div>
</form>
</div>

