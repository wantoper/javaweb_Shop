<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/4/19
  Time: 15:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>欢迎回来</title>
</head>
<body>
<div align="center">
    <h1>用户：<%=session.getAttribute("Username")%><a href="/Car/logout">注销</a></h1>

    <div>
        <a href="/Car/Shop">商城</a>
        <a href="/Car/ShopCar">购物车</a>
        <a href="/Car/Order">我的订单</a>
    </div>
</div>
</body>
</html>
