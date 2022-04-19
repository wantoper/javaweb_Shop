<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/4/19
  Time: 14:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
  <head>
    <title>用户登陆</title>
  </head>
  <body>
    <%
      String username = (String) session.getAttribute("Username");
      if(username != null){
        response.sendRedirect("/Car/homepage.jsp");
      }
    %>

    <c:if test="${erro != null}">
      <script type="text/javascript" language="javascript">
        alert("${erro}");
      </script>
    </c:if>

    <form action="/Car/login" method="post">
      用户名:<input type="text" name="username"> <br>
      密码:<input type="text" name="password">  <br>
      <input type="submit" value="登录">
      <input type="submit" value="注册" formaction="/Car/reg">
    </form>
  </body>

</html>
