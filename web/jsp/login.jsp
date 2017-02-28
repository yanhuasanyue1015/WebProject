<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <link href="../css/base.css" rel="stylesheet">
    <link href="../css/app.css" rel="stylesheet">
</head>
<body>
<form action="${pageContext.servletContext.contextPath}/login">
    <ul>
        <li>
            <label>
                <span>用户名:</span>
                <input name="username">
            </label>
        </li>
        <li>
            <label>
                <span>密码:</span>
                <input type="password">
            </label>
        </li>
        <li>
            <label>
                <span>记住用户:</span>
                <input type="checkbox" name="remember">
            </label>
        </li>
        <li>
            <input type="submit" value="登录">
            <a href="${pageContext.servletContext.contextPath}/jsp/regist.jsp">注册</a>
        </li>
    </ul>
</form>
<script>
</script>
</body>
</html>
