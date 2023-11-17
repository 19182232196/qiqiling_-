package com.stu.servlet;

import com.stu.bean.Person;
import com.stu.service.UserLoginService;
import com.stu.service.UserLoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/userLogin")
public class UserLoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码格式
        req.setCharacterEncoding("UTF-8");
        //首先去拿到前端传过来的信息
        String userAccount = req.getParameter("userAccount");
        String userPassword = req.getParameter("userPassword");
        Person person = new Person(userAccount,userPassword);
        //创建一个UserLoginService对象
        UserLoginService ul = new UserLoginServiceImpl();
        //调用UserLoginServiceImpl的getLogin方法
        Person newPerson = ul.getLogin(person);
        //如果获取到新的Person对象
        if(newPerson!=null){
            //创建一个session
            HttpSession session = req.getSession();
            //将新的Person对象放入session
            session.setAttribute("session_person",newPerson);
            //设置请求的属性
            req.setAttribute("mainRight","blank.jsp");
            //转发到main.jsp
            req.getRequestDispatcher("main.jsp").forward(req,resp);
        }else{
            //继续回到登陆注册界面
            req.setAttribute("tip","账户密码不一致");
            //转发到userLogin.jsp
            req.getRequestDispatcher("userLogin.jsp").forward(req,resp);
        }
    }
}