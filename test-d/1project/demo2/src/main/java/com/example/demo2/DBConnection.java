package com.example.demo2;

import java.io.*;

import jakarta.servlet.http.*;


public class DBConnection extends HttpServlet {
    public void loadDriversConfifInfo(){
        InputStream inputStream=DBConnection.class.getResourceAsStream("/db.properties");

        try{

        } catch (Exception e) {

        }
    }
}