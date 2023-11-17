package com.stu.servlet;

import com.stu.bean.Person;
import com.stu.service.ManageService;
import com.stu.service.ManageServiceImpl;
import com.stu.util.Test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/man.action")
public class ManageServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求编码
        req.setCharacterEncoding("UTF-8");
        //获取action参数
        String action = req.getParameter("action");
        //实例化ManageService
        ManageService ms = new ManageServiceImpl();
        //根据action参数进行不同的操作
        if (action.equals("list") || action.equals("search")||action.equals("delThisPerson")) {
            List<Person> arr;
            //根据action参数进行不同的操作
            if (action.equals("list")||action.equals("delThisPerson")) {
                //根据action参数进行不同的操作
                if(action.equals("delThisPerson")){
                    //获取要删除的账号和身份证号
                    String delAccount = req.getParameter("userAccount");
                    String userIdentify =  req.getParameter("userIdentify");
                    //根据账号和身份证号删除该用户
                    ms.delThisPerson(delAccount,userIdentify);
                }
                //获取所有用户
                arr = ms.getAllPerson();
            } else {
                //获取搜索文本
                String matchText = (req.getParameter("matchText")).trim();
                //根据搜索文本搜索用户
                arr = ms.getSearch(matchText);
            }
            //将搜索结果放入req中
            req.setAttribute("arr", arr);
            //设置页面跳转
            req.setAttribute("mainRight", "person.jsp");
            req.getRequestDispatcher("main.jsp").forward(req, resp);
        } else if (action.equals("goAddPerson")) {
            //设置页面跳转
            req.setAttribute("mainRight", "addPerson.jsp");
            req.getRequestDispatcher("main.jsp").forward(req, resp);
        } else if (action.equals("addThisPerson")) {
            //获取新用户账号
            String newUserAccount = Test.getPersonAccount();
            //获取用户信息
            String userName = req.getParameter("userName");
            String userSex = req.getParameter("userSex");
            String userBirthday = req.getParameter("userBirthday");
            String userIdCard = req.getParameter("userIdCard");
            String userPassword = req.getParameter("userPassword");
            int userIdentify = Integer.parseInt(req.getParameter("userIdentify"));
            String userOtherName = req.getParameter("userOtherName");
            //实例化新用户
            Person newPerson = new Person(newUserAccount, userName, userSex, userBirthday, userIdCard, userPassword, userIdentify, userOtherName);
            //添加新用户
            ms.addPerson(newPerson);
            //设置提示信息
            req.setAttribute("tip","添加完成");
            //设置页面跳转
            req.setAttribute("mainRight", "blank.jsp");
            req.getRequestDispatcher("main.jsp").forward(req, resp);

        }
    }
}
