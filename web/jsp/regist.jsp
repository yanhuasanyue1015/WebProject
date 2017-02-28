<%--
  Created by IntelliJ IDEA.
  User: zhanglei-account
  Date: 2017/2/28
  Time: 11:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
    <link href="../css/base.css" rel="stylesheet">
    <link href="../css/app.css" rel="stylesheet">
</head>
<body>
<form method="post" action="${pageContext.servletContext.contextPath}/regist">
    <span>注册</span>
    <ul>
        <li>
            <label>
                <span>用户名:</span>
                <input name="name">
            </label>
        </li>
        <li>
            <label>
                <span>密码:</span>
                <input name="password">
            </label>
        </li>
        <li>

            <label>
                <span>确认密码:</span>
                <input name="repassword">
            </label>
        </li>
        <li>

            <label>
                <span>年龄:</span>
                <input name="age">
            </label>
        </li>
        <li>
            <label>
                <span>性别:</span>
                <input type="radio" name="sex" value="man">男
                <input type="radio" name="sex" value="woman">女
            </label>
        </li>
        <li>
            <label>
                <span>邮箱:</span>
                <input type="email" name="email">
            </label>
        </li>
        <li>
            <label>
                <span>生日:</span>
                <input type="date" name="birthday">
            </label>
        </li>
        <li>
            <label>
                <span>擅长的技术:</span>
                <input type="checkbox" name="hobby" value="C">C
                <input type="checkbox" name="hobby" value="C++">C++
                <input type="checkbox" name="hobby" value="Java">Java
                <input type="checkbox" name="hobby" value="IOS">IOS
                <input type="checkbox" name="hobby" value="PHP">PHP
                <input type="checkbox" name="hobby" value="Android">Android

            </label>
        </li>
        <li>
            <label>
                <span>地址:</span>
                <select name="address">
                    <option value="none">--请选择地址--</option>
                    <option value="北京">北京</option>
                    <option value="上海">上海</option>
                    <option value="南京">南京</option>
                    <option value="广州">广州</option>
                    <option value="深圳">深圳</option>
                </select>
            </label>
        </li>
        <li>
            <label>
                <span>自我描述:</span>
                <textarea name="description"></textarea>
            </label>
        </li>
        <li>

            <label>
                <span>验证码:</span>
                <input>

                <a href="#">看不清楚,换一张</a>
            </label>
        </li>
        <li>
            <input type="submit" value="注册">
            <a href="${pageContext.servletContext.contextPath}/jsp/login.jsp">登录</a>
        </li>
    </ul>
</form>
</body>
</html>
