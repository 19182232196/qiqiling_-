package com.ydhl.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ydhl.entity.Source;
import com.ydhl.service.SourceService;

@WebServlet("/SourceServlet")
public class SourceServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 也是可以直接获取参数的
        // 设置编码字符集
        req.setCharacterEncoding("utf-8");
        // 假设我们的参数请求中都有一个标记
        String action = req.getParameter("action");
        if (action == null) {
            action = "";// 这是查询请求中没有action参数
        }
        switch (action) {
            case "":
                Query(req, resp);
                break;
            case "del":
                // 如果标记是del 代表删除
                del(req, resp);
                break;
            case "add":
                // 如果标记是add 代表新增
                add(req, resp);
                break;
            case "Modifysel":
                // 如果标记是Modifysel 代表根据id查询对应对象
                Modifysel(req, resp);
                break;
            case "modify":
                // 获取页面参数直接修改对应数据
                Modify(req, resp);
                break;
        }
    }

    protected void Query(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        SourceService service = new SourceService();// 创建业务逻辑层对象
        String name = request.getParameter("name");
        if (name == null) {
            name = "";
        }
        ArrayList<Source> list = (ArrayList<Source>) service.Query(name);// 调用业务逻辑层方法
        // 将数据保存到request作用域中 稍后配合转发请求携带数据到页面
        request.setAttribute("list", list);
        // 使用转发请求 携带查询到的数据到页面当中以方便获取
        request.getRequestDispatcher("/index.jsp").forward(request, response);// 转发跳转页面
    }

    // 根据id删除对应数据
    protected void del(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取唯一的id
        int id = Integer.parseInt(request.getParameter("id"));
        SourceService service = new SourceService();// 创建业务逻辑层对象
        // 执行删除方法
        service.del(id);
        // 重定向到对应查询工作 删除之后需要重新查询
        response.sendRedirect("source");
    }

    // 新增方法
    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取所有的参数
        String name = request.getParameter("name");
        String type = request.getParameter("type");
        String uploadDate = request.getParameter("uploadDate");
        // 将参数保存到对应person对象中
        Source person = new Source(0, name, type, uploadDate);
        SourceService service = new SourceService();// 创建业务逻辑层对象
        // 执行对应新增操作
        service.add(person);
        // 重定向 重新查询数据 并且跳转首页
        response.sendRedirect("source");
    }

    // 根据id查询对应数据
    protected void Modifysel(HttpServletRequest request, HttpServletResponse
            response)
            throws ServletException, IOException {
        // 获取所有的参数
        int id = Integer.parseInt(request.getParameter("id"));
        SourceService service = new SourceService();// 创建业务逻辑层对象
        // 根据id查询到单个对应数据
        Source sr = service.Modifysel(id);
        // 将数据保存到对应的request域中
        request.setAttribute("Source", sr);
        // 转发数据
        request.getRequestDispatcher("update.jsp").forward(request, response);//转发跳转页面
    }

    // 获取用户修改后的数据
    protected void Modify(HttpServletRequest request, HttpServletResponse
            response)
            throws ServletException, IOException {
        // 获取所有的参数 然后传入修改方法
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String type = request.getParameter("type");
        String uploadDate = request.getParameter("uploadDate");
        //和新增一样 保存到对应方法中
        Source sr = new Source(id, name, type, uploadDate);
        // 创建业务逻辑层对象
        SourceService service = new SourceService();
        // 调用修改方法
        service.Modify(sr);
        // 重定向 重新查询数据
        response.sendRedirect("source");
    }
}