package com.wantoper.Servlet;

import com.wantoper.Dao.OrderMapper;
import com.wantoper.Util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(value = "/OrderVist")
public class OrderVist extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String oid = req.getParameter("oid");
        SqlSession getsqlseesion = MybatisUtil.getsqlseesion();
        OrderMapper mapper1 = getsqlseesion.getMapper(OrderMapper.class);
        List<Map<String, Object>> str = mapper1.getorderbyoid(oid);
        req.setAttribute("orderinfo",str);

        req.getRequestDispatcher("/OrderVist.jsp").forward(req,resp);
        getsqlseesion.close();
    }
}
