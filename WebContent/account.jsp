<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/9/2
  Time: 15:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/account" method="post">
    <table>
        <tr>
            <td>转出方</td>
            <td><input type="text" name="fromUser"></td>
        </tr>
        <tr>
            <td>转入方</td>
            <td><input type="text" name="toUser"></td>
        </tr>
        <tr>
            <td>转账金额</td>
            <td><input type="number" name="money"></td>
        </tr>
    </table>
    <button type="submit">提交</button>
</form>
</body>
</html>
