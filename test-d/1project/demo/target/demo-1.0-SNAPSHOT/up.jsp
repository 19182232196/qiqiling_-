<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>update</title>
</head>
<body>
<form action="source" method="post">
    <table>
        <tr>
            <td>名称:</td>
            <td><input type="text" name="name" value=${Source.name }></td>
        </tr>
        <tr>
            <td>类型:</td>
            <td><input type="text" name="type" value=${Source.type }>
            </td>
        </tr>
        <tr>
            <td>上传时间:</td>
            <td><input type="date" name="uploadDate"
                       value=${Source.uploadDate }></td>
        </tr>
        <tr>
            <td><input type="submit" value="修改"/></td>
            <td><input type="reset" value="删除"/></td>
            <td><input type="hidden" value="modify" name="action">
                <input type="hidden" value="${Source.id}" name="id"></td>
        </tr>
    </table>
</form>
</body>
</html>
