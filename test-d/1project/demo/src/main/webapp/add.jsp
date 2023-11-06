<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>add</title>
</head>
<body>
<form action="source" method="post">
    <table>
        <tr>
            <td>名称</td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td>类型</td>
            <td><input type="text" name="type"></td>
        </tr>
        <tr>
            <td>上传时间</td>
            <td><input type="date" name="uploadDate"></td>
        </tr>
        <tr>
            <td><input type="submit" value="添加"></td>
            <td><input type="reset" value="重置"></td>
            <td><input type="hidden" value="add" name="action"></td>
        </tr>
    </table>
</form>
</body>
</html>
