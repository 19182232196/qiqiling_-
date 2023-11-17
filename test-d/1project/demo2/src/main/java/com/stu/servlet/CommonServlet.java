package com.stu.servlet;

import com.stu.bean.Person;
import com.stu.service.ManageService;
import com.stu.service.ManageServiceImpl;
import com.stu.service.StudentService;
import com.stu.service.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/common.action")
public class CommonServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求编码
        req.setCharacterEncoding("UTF-8");
        //获取action参数
        String action = req.getParameter("action");
        //实例化服务层
        StudentService ss = new StudentServiceImpl();
        //获取session中的person对象
        Person person = (Person) req.getSession().getAttribute("session_person");
        //获取用户账号
        String userAccount = person.getUserAccount();
        //实例化管理层
        ManageService ms = new ManageServiceImpl();
        //判断action参数
        if(action.equals("index")){
            //跳转到首页
            req.setAttribute("mainRight","blank.jsp");
            req.getRequestDispatcher("main.jsp").forward(req,resp);
        }else if(action.equals("goMyDetail")){
            //跳转到详情页
            req.setAttribute("mainRight","detail.jsp");
            req.getRequestDispatcher("main.jsp").forward(req,resp);
        }else if(action.equals("upPassword")){
            //upPassword

            //跳转到修改密码页面
            req.getRequestDispatcher("upPassword.jsp").forward(req,resp);
        }else if(action.equals("sureUpPassword")){
            //获取用户密码
            String userPassword = req.getParameter("userPassword");
            //调用修改密码方法
            ms.sureUpPassword(userAccount,userPassword);
            //设置提示信息
            req.setAttribute("tip","修改成功，请关闭此页面");
            req.getRequestDispatcher("success.jsp").forward(req,resp);
        }
    }
}
