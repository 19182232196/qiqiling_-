package com.login;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        //先要接受浏览器传过来的用户名和密码
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");

        //判断用户名和密码是否合法
        if("super".equals(userName) && "123456".equals(password)){
            //若合法，跳转到登录成功页面
            response.sendRedirect("/firstWeb/success.jsp");

        }else{
            //若不合法，跳转到登录页面，提示用户名错误或是密码错误。请重新登录
            //给浏览器提示信息
            //response.setContentType("text/html; charset=UTF-8");
            //PrintWriter writer = response.getWriter();
            //writer.println("用户名或密码错误，重新输入");
            //response.sendRedirect("/firstWeb/login.jsp");

            //往request变量开辟的内存空间放数据
            request.setAttribute("message","用户名或密码错误，请重新输入！");

            //页面跳转的方式：请求转发
            RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");

            //将请求交给login.jsp处理，即login.jsp给浏览器回馈
            dispatcher.forward(request,response);
        }
    }

}
