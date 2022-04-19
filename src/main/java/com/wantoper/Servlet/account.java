package com.wantoper.Servlet;

import com.wantoper.Dao.OrderDao;
import com.wantoper.Dao.OrderItemDao;
import com.wantoper.Util.UidUtil;
import com.wantoper.pojo.Order;
import com.wantoper.pojo.OrderItem;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@WebServlet(value = "/account")
public class account extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uuid = (String) req.getSession().getAttribute("UUID");
        String money = (String) req.getParameter("money");
        Order order = new Order(UidUtil.getid(),uuid,LocalDateTime.now(),Float.parseFloat(money));
        OrderDao.addorder(order);
        List<OrderItem> car = (List<OrderItem>) req.getSession().getAttribute("Car");
        for (OrderItem orderItem : car) {
            orderItem.setOid(order.getId());
            OrderItemDao.addorderitem(orderItem);
        }
        req.getSession().removeAttribute("Car");
        resp.sendRedirect("/Car/ShoppingCar.jsp");
    }
}
