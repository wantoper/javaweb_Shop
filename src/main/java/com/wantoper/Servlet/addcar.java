package com.wantoper.Servlet;

import com.wantoper.Dao.ProduceDao;
import com.wantoper.Util.UidUtil;
import com.wantoper.pojo.OrderItem;
import com.wantoper.pojo.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(value = "/addcar")
public class addcar extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pid = Integer.parseInt((String) req.getParameter("pid"));
        int num = Integer.parseInt((String) req.getParameter("num"));
        List<OrderItem> orderItems = (List<OrderItem>) req.getSession().getAttribute("Car");
        if(null == orderItems){
            orderItems = new ArrayList<>();
            req.getSession().setAttribute("Car",orderItems);
        }
        Product pruduct = ProduceDao.gerproduct(pid);

        boolean is=true;
        for (OrderItem orderItem : orderItems) {
            if(orderItem.getP().getId() == pid){
                orderItem.setNum(orderItem.getNum()+num);
                is=false;
                break;
            }
        }
        if(is){
            OrderItem orderItem1 = new OrderItem(UidUtil.getid(), pid, null,num,pruduct);
            orderItems.add(orderItem1);
        }
        resp.sendRedirect("/Car/Shop.jsp");
    }
}
