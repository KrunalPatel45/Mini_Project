/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author kruna
 */
public class search extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        
           res.setContentType("text/html");
          PrintWriter out = res.getWriter();
          int r = Integer.parseInt(req.getParameter("rn"));
         
          try { 
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","krunu2025");
            String sql = "SELECT * FROM stud WHERE rno=?";
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery("select * from stud where rno="+r+"");  
             if(rs.next()==false)
             {    
                        out.println("<html><head> <style>\n" +
                        "div{\n" +
                        "width: 50%;\n" +
                        "height: 500px;\n" +
                        "border-style: solid;\n" +
                        "border-color: black;\n" +
                        "}\n" +
                        "\n" +
                        "</style></head><body><center><br><div><h1>Recored Not Found....</h1><br><a href='delete.html'>OK</a></div></center></body></html>");
              
             } 
             else
             {
                        out.println("<html><head> <style>\n" +
                        "div{\n" +
                        "width: 50%;\n" +
                        "height: 500px;\n" +
                        "border-style: solid;\n" +
                        "border-color: black;\n" +
                        "}\n" +
                        "\n" +
                        "</style></head><body><center><br><div><br><br><table border='1'><tr><td><b>Roll No :</b></td><td>"+rs.getInt(1)+"</td></tr><tr><td><b>Name :</b></td><td>"+rs.getString(2)+"</td></tr><tr><td><b>Age :</b></td><td>"+rs.getInt(3)+"</td></tr><tr><td><b>Address :</b></td><td>"+rs.getString(4)+"</td></tr><tr><td><b>Phone No :</b></td><td>"+rs.getString(5)+"</td></tr></table><br><a href='search.html'>OK</a></div></center></body></html>");
              
             }
          }catch(Exception e)
          {
              e.printStackTrace();
          }
          
        
    }

    

}
