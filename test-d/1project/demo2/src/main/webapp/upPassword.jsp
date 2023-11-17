<%--
  Created by IntelliJ IDEA.
  User: 30890
  Date: 2023/4/24
  Time: 15:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<style>
    * {
        background-color: #9acfea;
    }
</style>

<div class="data_list">
    <h1>密码修改</h1>

    <div>
        <form method="post" action="common.action?action=sureUpPassword" onsubmit="return checkThisFile()">
            <table class="table table-striped table-bordered table-hover datatable">
                <thead>
                <tr height="15px">
                    <th style="text-align: center;">输入新密码：</th>
                    <th style="text-align: center;"><input name="userPassword" id="userPassword" type="password" width="400px"
                                                           height="26px"
                                                           style="border-bottom-right-radius: 3px"></th>
                </tr>
                <tr style="width: 500px">
                    <th style="text-align: center;">再次输入密码：</th>
                    <th style="text-align: center;width: 70%"><input id="a" type="password" width="400px" height="26px";style="border-bottom-right-radius: 3px">
                    </th>
                </tr>
                <tr style="width: 500px">
                    <td></td>
                    <td>
                        <input type="submit" value="提交">
                    </td>

                </tr>
                <tr style="width: 500px">
                    <td></td>
                    <td>
                        <span style="color: #dd1144" id="error"></span>
                    </td>

                </tr>
                </thead>
            </table>
        </form>

        <script>
            function checkThisFile() {
                let userPassword = document.getElementById("userPassword").value;
                let a = document.getElementById("a").value;
                // (stuCode == null || stuCode == "")
                if ((a==null||a.trim()=="")||(userPassword==null||userPassword.trim()=="")) {
                    document.getElementById("error").innerHTML = "请输入两次完整密码";
                    return false;
                } else if(a!=userPassword){
                    document.getElementById("error").innerHTML = "两次密码不一致";
                    return false;
                }else{
                    return true;
                }


            }
        </script>
    </div>
    <div align="center"><font color="red"></font></div>
</div>

