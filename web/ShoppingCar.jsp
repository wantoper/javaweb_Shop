<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/4/19
  Time: 16:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="homepage.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
    <title>我的购物车</title>
</head>
<body>


<table width="500px" align="center" border="1" cellspacing="0">
    <tr><td colspan="5" align="center">我的购物车</td></tr>
    <tr align="center">
        <td>名称</td>
        <td>单价</td>
        <td>数量</td>
        <td>总价</td>
        <td>移出购物车</td>
    </tr>
    <c:set var="sum" value="0" />
    <c:forEach items="${Car}" var="car">
        <tr>
            <td>${car.getP().getName()}</td>
            <td>${car.getP().getPrice()}</td>
            <td>${car.getNum()}</td>
            <td><fmt:formatNumber type="number" value="${(car.getNum() * car.getP().getPrice())}" pattern="0.0"/></td>
            <c:set var="sum" value="${sum+(car.getNum() * car.getP().getPrice())}" />
            <td align="center">
                <form action="/CAR/add" method="post">
                    <input type="text" name="num" value="1" style="width: 50px">
                    <input type="hidden" name="pid" value="${car.getId()}">
                    <input type="submit" value="移出">
                </form>
            </td>
        </tr>
    </c:forEach>
    <tr>
        <form action="/Car/account" method="post">
            <td colspan="4" align="center">总价：<fmt:formatNumber type="number" value="${sum}" pattern="0.0"/></td>
            <input type="hidden" name="money" value="<fmt:formatNumber type="number" value="${sum}" pattern="0.0"/>">
            <td colspan="4" align="center"> <input type="submit" value="结算"></td>
        </form>
    </tr>
</table>

</body>
</html>
