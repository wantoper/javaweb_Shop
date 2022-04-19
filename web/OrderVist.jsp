<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/4/19
  Time: 19:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="homepage.jsp"%>
<html>
<head>
    <title>订单详情</title>
</head>
<body>
<div align="center">
    <h3>订单编号: ${orderinfo.get(0).get("id")}</h3>
    <h3>下单日期: ${orderinfo.get(0).get("createdata")}</h3>
    <h3>订单总金额: ${orderinfo.get(0).get("OrderMoney")} </h3>
    <h3></h3>
</div>
<table width="600px" align="center" border="1" cellspacing="0">
    <tr><td colspan="5" align="center">订单详情</td></tr>
    <tr align="center">
        <td>编号</td>
        <td>名称</td>
        <td>价格</td>
        <td>数量</td>
        <td>总价</td>
    </tr>

    <c:forEach items="${orderinfo}" var="orderitem">
        <tr>
            <td>${orderitem.get("oiid")}</td>
            <td>${orderitem.get("pname")}</td>
            <td>${orderitem.get("price")}</td>
            <td>${orderitem.get("num")}</td>
            <td><fmt:formatNumber type="number" value='${orderitem.get("num") * orderitem.get("price")}' pattern="0.0"/></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
