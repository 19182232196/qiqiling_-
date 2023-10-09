package com.example.demo1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/time")
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DateFormat dtFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = dtFormat.format(new Date());

        req.setAttribute("currentTime", currentTime);
        req.getRequestDispatcher("demo1/src/main/web/hello.jsp").forward(req, resp);
    }
}
