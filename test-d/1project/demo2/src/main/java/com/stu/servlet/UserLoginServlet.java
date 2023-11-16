package com.stu.servlet;

import com.stu.bean.Person;
import com.stu.dao.UserLoginDao;
import com.stu.service.UserLoginService;
import com.stu.service.UserLoginServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/userLogin")
public class UserLoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userAccount=req.getParameter("userAccount");
        String userPassword=req.getParameter("userPassword");
        Person person=new Person(userAccount,userPassword);
        UserLoginService ul =new UserLoginServiceImpl();
        Person newPerson=ul.getLogin(person);
        if (newPerson!=null){
//            req.getSession().setAttribute("session-person",newPerson);
            HttpSession session=req.getSession();
            session.setAttribute("session_person",newPerson);

            req.setAttribute("mainRight","blank.jsp");
            req.getRequestDispatcher("main.jsp").forward(req,resp);
        }else {
            req.setAttribute("tip","用户名或密码错误");
            req.getRequestDispatcher("userLogin.jsp").forward(req,resp);
        }
    }
}
