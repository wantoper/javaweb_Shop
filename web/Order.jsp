<%@ page import="com.wantoper.Dao.OrderDao" %>
<%@ page import="com.wantoper.pojo.Order" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/4/19
  Time: 19:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="homepage.jsp"%>
<html>
<head>
    <title>我的订单</title>
</head>
<body>

    <%
        List<Order> orders = OrderDao.getorderbyid((String) session.getAttribute("UUID"));
        request.setAttribute("orders",orders);
    %>
    <table width="800px" align="center" border="1" cellspacing="0">
        <tr><td colspan="4" align="center">我的订单</td></tr>
        <tr align="center">
            <td>订单编号</td>
            <td>创建时间</td>
            <td>订单金额</td>
            <td>查看详情</td>
        </tr>

        <c:forEach items="${orders}" var="order">
            <tr>
                <td>${order.getId()}</td>
                <td>${order.getCreatedate()}</td>
                <td>${order.getOrdermoney()}</td>
                <td align="center">
                    <form action="/Car/OrderVist" method="post">
                        <input type="hidden" name="oid" value="${order.getId()}">
                        <input type="submit" value="查看">
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>


</body>
</html>
