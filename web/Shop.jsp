<%@ page import="com.wantoper.Dao.ProduceDao" %>
<%@ page import="com.wantoper.pojo.Product" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/4/19
  Time: 16:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="homepage.jsp"%>
<html>
<head>
    <title>商城</title>
</head>
<body>

    <%
        List<Product> getproduct = ProduceDao.getproduct();
        request.setAttribute("products",getproduct);
    %>

    <table width="500px" align="center" border="1" cellspacing="0">
        <tr><td colspan="4" align="center">商城</td></tr>
        <tr align="center">
            <td>编号</td>
            <td>名称</td>
            <td>价格</td>
            <td>加入购物车</td>
        </tr>

        <c:forEach items="${products}" var="product">
            <tr>
                <td>${product.getId()}</td>
                <td>${product.getName()}</td>
                <td>${product.getPrice()}</td>
                <td align="center">
                    <form action="/Car/addcar" method="post">
                        数量：<input type="text" name="num" value="1" style="width: 50px">
                        <input type="hidden" name="pid" value="${product.getId()}">
                        <input type="submit" value="添加">
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>

</body>
</html>
