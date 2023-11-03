package Test19.Demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class Demo {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");

        String url="jdbc:mysql://localhost:3306/study?";
        String user="root";
        String password="484110";

        Connection connection= DriverManager.getConnection(url,user,password);

        Statement stmt=connection.createStatement();
        String sql="select * from pop";

        ResultSet rs=stmt.executeQuery(sql);

        while (rs.next()){
            String id=rs.getString("id");
            String name=rs.getString("name");
            String pw=rs.getString("pw");
            String email=rs.getString("email");
            String bir=rs.getString("bir");
            System.out.println(id+" "+name+" "+pw+" "+email+" "+bir);
        }
    }
}
