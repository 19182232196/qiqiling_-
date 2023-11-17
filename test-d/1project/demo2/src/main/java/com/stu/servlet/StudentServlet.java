package com.stu.servlet;

import com.stu.bean.Person;
import com.stu.bean.StudentAnswer;
import com.stu.dao.Generate;
import com.stu.service.StudentService;
import com.stu.service.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/student.action")
public class StudentServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码格式
        req.setCharacterEncoding("UTF-8");
        //获取action参数
        String action = req.getParameter("action");
        //实例化服务层
        StudentService ss = new StudentServiceImpl();
        //获取session中的person对象
        Person person = (Person) req.getSession().getAttribute("session_person");
        //获取用户账号
        String userAccount = person.getUserAccount();
        if(action.equals("list")||action.equals("searchTeacher")){
            List<Person> arr ;
            if(action.equals("list")){
                arr = ss.getAllTeacher();
            }else {
                //获取搜索文本
                String matchText = req.getParameter("matchText");
                arr = ss.getSearchTeacher(matchText);
            }
            //将搜索结果放入req中
            req.setAttribute("arr",arr);
            //设置页面跳转
            req.setAttribute("mainRight","person.jsp");
            req.getRequestDispatcher("main.jsp").forward(req,resp);
        }else if(action.equals("goMyTeacher")||action.equals("deleteMyTeacher")){
            if(action.equals("deleteMyTeacher")){
                //获取老师账号
                String teacherAccount = req.getParameter("teacherAccount");
                //调用服务层删除
                ss.deleteMyTeacher(userAccount,teacherAccount);
            }
            //获取我的老师
            List<Person> arr = ss.getMyTeacher(userAccount);
            //将搜索结果放入req中
            req.setAttribute("arr",arr);
            //设置页面跳转
            req.setAttribute("mainRight","myTeacher.jsp");
            req.getRequestDispatcher("main.jsp").forward(req,resp);
        }else if(action.equals("addTeacher")){
            //获取老师账号
            String teacherAccount = req.getParameter("teacherAccount");
            //调用服务层判断
            int flag = Generate.IsExistStuTea(userAccount,teacherAccount);
            if(flag==0){
                //调用服务层添加
                ss.addTeacher(userAccount,teacherAccount);
                //设置提示信息
                req.setAttribute("tip","添加成功");
            }else {
                //设置提示信息
                req.setAttribute("tip","你已经选择这个老师，本次选择失败！");
            }
            //设置页面跳转
            req.setAttribute("mainRight","blank.jsp");
            req.getRequestDispatcher("main.jsp").forward(req,resp);
        }else if(action.equals("goMyTeaTask")){
            //获取老师账号
            String teacherAccount = req.getParameter("teacherAccount");
            //调用服务层获取
            List<StudentAnswer> arr = ss.goMyTeaTask(userAccount,teacherAccount);
            //将搜索结果放入req中
            req.setAttribute("arr",arr);
            //设置页面跳转
            req.setAttribute("mainRight","studentTask.jsp");
            req.getRequestDispatcher("main.jsp").forward(req,resp);
        }else if(action.equals("doAnswer")){
            //获取任务账号
            String taskAccount = req.getParameter("taskAccount");
            //设置任务账号
            req.setAttribute("taskAccount",taskAccount);
            //设置页面跳转
            req.getRequestDispatcher("doAnswer.jsp").forward(req,resp);
        }else if(action.equals("dealAnswer")){
            //获取任务账号
            String taskAccount = req.getParameter("taskAccount");
            //获取答案
            String answer = (req.getParameter("answer")).trim();
            System.out.println(taskAccount+"     "+answer);
            //调用服务层处理
            ss.doAnswer(userAccount,taskAccount,answer);
            //设置提示信息
            req.setAttribute("tip","恭喜答题完成，请关闭页面等待老师的更改！");
            //设置页面跳转
            req.getRequestDispatcher("success.jsp").forward(req,resp);
        }else if(action.equals("doFenshu")){
            //获取任务账号
            String taskAccount = req.getParameter("taskAccount");
            //获取学生账号
            String studentAccount = req.getParameter("studentAccount");
            //设置任务账号
            req.setAttribute("taskAccount",taskAccount);
            //设置学生账号
            req.setAttribute("studentAccount",studentAccount);
            //设置页面跳转
            req.getRequestDispatcher("getFenshu.jsp").forward(req,resp);
        }else if(action.equals("getFenshu")){
            //获取任务账号
            String taskAccount = req.getParameter("taskAccount");
            //获取学生账号
            String studentAccount = req.getParameter("studentAccount");
            //获取分数
            String fenshu = req.getParameter("fenshu");
            //调用服务层处理
            ss.dealFenshu(taskAccount,studentAccount,fenshu);
            //设置提示信息
            req.setAttribute("tip","已修改分数！");
            //设置页面跳转
            req.getRequestDispatcher("success.jsp").forward(req,resp);
        }
    }
}