package com.wantoper.Servlet;

import com.wantoper.Dao.UserDao;
import com.wantoper.Util.MybatisUtil;
import com.wantoper.pojo.User;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/login")
public class Login extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user = UserDao.userlogin(username, password);
        if(null != user){
            req.getSession().setAttribute("Username",user.getName());
            req.getSession().setAttribute("UUID",user.getId());
            resp.sendRedirect("/Car/homepage.jsp");
        }else{
            req.setAttribute("erro","账号或密码错误！");
            req.getRequestDispatcher("/index.jsp").forward(req,resp);
        }
    }
}
