package com.stu.servlet;

import com.stu.bean.Person;
import com.stu.bean.StudentAnswer;
import com.stu.bean.Task;
import com.stu.service.TeacherService;
import com.stu.service.TeacherServiceImpl;
import com.stu.util.Test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/tea.action")
public class TeacherServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码格式
        req.setCharacterEncoding("UTF-8");
        //获取action参数
        String action = req.getParameter("action");
        //实例化TeacherService
        TeacherService ts = new TeacherServiceImpl();
        //获取session中的person对象
        Person person = (Person) req.getSession().getAttribute("session_person");
        //获取userAccount
        String userAccount = person.getUserAccount();
        //根据action参数进行不同的操作
        if(action.equals("list")||action.equals("searchMyStudent")||action.equals("deleteThisPersonByTeacher")){
            //获取所有学生的信息
            List arr = null;
            if(action.equals("searchMyStudent")){
                //获取搜索文本
                String matchText = req.getParameter("matchText");
                arr = ts.getSearchStudentByTeacherAccount(userAccount,matchText);
            }else {
                if(action.equals("deleteThisPersonByTeacher")){
                    //获取学生账号
                    String studentAccount = req.getParameter("studentAccount");
                    //删除该学生
                    ts.deleteThisPersonByTeacher(studentAccount,userAccount);
                }
                arr = ts.AllStudentsByTeacherAccount(userAccount);
            }
            //获取所有学生的信息
            //设置属性
            req.setAttribute("arr",arr);
            req.setAttribute("mainRight","person.jsp");
            //转发
            req.getRequestDispatcher("main.jsp").forward(req,resp);
        }else if(action.equals("goMyTask")||action.equals("deleteTishTask")){
            //获取所有任务
            if(action.equals("deleteTishTask")){
                //获取任务账号
                String taskAccount = req.getParameter("taskAccount");
                //删除该任务
                ts.deleteThisTask(taskAccount);
            }
            List<Task> arr = ts.getAllMyTask(userAccount);
            //设置属性
            req.setAttribute("arr",arr);
            req.setAttribute("mainRight","task.jsp");
            //转发
            req.getRequestDispatcher("main.jsp").forward(req,resp);
        }else if(action.equals("goSkimDetail")||action.equals("goStudentTaskDetail")){
            //获取任务详情
            List<StudentAnswer> arr;
            if(action.equals("goSkimDetail")){
                //获取任务账号
                String taskAccount = req.getParameter("taskAccount");
                arr = ts.getTaskDetail(taskAccount);
            }else {
                //设置属性
                req.setAttribute("sign","goStudentTaskDetail");
                //获取学生账号
                String studentAccount = req.getParameter("studentAccount");
                arr = ts.goStudentTaskDetail(userAccount,studentAccount);
            }
            //设置属性
            req.setAttribute("arr",arr);
            req.setAttribute("mainRight","studentTask.jsp");
            //转发
            req.getRequestDispatcher("main.jsp").forward(req,resp);
        }else if(action.equals("deleteTask")){
            //获取学生账号
            String studentAccount = req.getParameter("studentAccount");
            //获取任务账号
            String taskAccount = req.getParameter("taskAccount");
            //获取是否完成
            String isFinish = req.getParameter("isFinish");
            //删除任务
            ts.deleteTask(taskAccount,studentAccount,isFinish);
            //设置属性
            req.setAttribute("tip","删除成功");
            req.setAttribute("mainRight","blank.jsp");
            //转发
            req.getRequestDispatcher("main.jsp").forward(req,resp);
        }else if(action.equals("goAddTask")||action.equals("addTask")){
            //添加任务
            if(action.equals("addTask")){
                //获取任务名
                String taskName = req.getParameter("taskName");
                //去除前后空格
                taskName = taskName.trim();
                if(taskName.equals("")){
                    //设置属性
                    req.setAttribute("tip","添加失败");
                }else{
                    //朝着数据库存入
                    String date = Test.getDate();
                    String taskAccount =Test.getTaskAccount();
                    Task task = new Task(taskAccount,userAccount,date,taskName);
                    ts.AddTask(task);
                    //设置属性
                    req.setAttribute("tip","添加成功");
                }
            }
            //设置属性
            req.setAttribute("mainRight","addTask.jsp");
            //转发
            req.getRequestDispatcher("main.jsp").forward(req,resp);
        }else if(action.equals("addPerson")){
            //设置属性
            req.setAttribute("mainRight","addPerson.jsp");
            //转发
            req.getRequestDispatcher("main.jsp").forward(req,resp);
        }
    }
}
