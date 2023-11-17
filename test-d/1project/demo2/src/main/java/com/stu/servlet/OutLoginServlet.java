package com.stu.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/outLogin")
public class OutLoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 从请求中获取session
        HttpSession session = req.getSession();
        // 从session中移除session_person属性
        session.removeAttribute("session_person");
        // 将请求转发到userLogin.jsp页面
        req.getRequestDispatcher("userLogin.jsp").forward(req,resp);
    }
}