package com.wantoper.Servlet;

import com.wantoper.Dao.UserDao;
import com.wantoper.Util.UidUtil;
import com.wantoper.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/reg")
public class Reg extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user = UserDao.getuserbyname(username);
        if(null == user){
            UserDao.adduser(new User(UidUtil.getid(),username,password));
            req.setAttribute("erro","注册成功 请登录");
            req.getRequestDispatcher("/index.jsp").forward(req,resp);
        }else{
            req.setAttribute("erro","注册失败 用户已存在");
            req.getRequestDispatcher("/index.jsp").forward(req,resp);
        }
    }
}
