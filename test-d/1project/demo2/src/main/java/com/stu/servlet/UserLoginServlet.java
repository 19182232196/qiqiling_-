package com.stu.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/userLogin")
public class UserLoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userAccount=req.getParameter("userAccount");
        String userPassword=req.getParameter("userPassword");
        if (userAccount.equals("admin")&&userPassword.equals("123456")){
            req.setAttribute("mainRight","blank.jsp");
            req.getRequestDispatcher("main.jsp").forward(req,resp);
        }else {
            req.setAttribute("tip","用户名或密码错误");
            req.getRequestDispatcher("userLogin.jsp").forward(req,resp);
        }
    }
}
