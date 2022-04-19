package com.wantoper.Servlet.Filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebFilter("/*")
public class PageFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        req.setCharacterEncoding("utf-8");
        res.setContentType("text/html");
        res.setCharacterEncoding("utf-8");
        ArrayList allowPathList = new ArrayList();
        allowPathList.add("/index.jsp");
        allowPathList.add("/login");
        allowPathList.add("/reg");
        if(req.getSession().getAttribute("Username") == null && !allowPathList.contains(req.getServletPath())){
            req.setAttribute("erro","请先登录！");
            req.getRequestDispatcher("/index.jsp").forward(req,res);
        }

        chain.doFilter(req,res);
    }
}
