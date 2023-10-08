package java.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;

@WebServlet("/login")
public class Login extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{

        String username = request.getParameter("userName");
        String password = request.getParameter("password");

        if ("super".equals(userName)&&"123".equals(password)){
            response.sendRedirect("/demo/success.jsp");

        }else{
            response.sendRedirect("/demo/login.jsp");

        }
    }
}