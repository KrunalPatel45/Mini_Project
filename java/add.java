
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.*;


public class add extends HttpServlet {


     
   
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        
          res.setContentType("text/html");
          PrintWriter out = res.getWriter();
          int r = Integer.parseInt(req.getParameter("rn"));
          String nm = req.getParameter("nm");
          String g = req.getParameter("gen");
          String d = req.getParameter("dropdown");
          String[] s = req.getParameterValues("c1");
          int a= Integer.parseInt(req.getParameter("ag"));
          String ad = req.getParameter("ad");
          String p = req.getParameter("pn");
          String sk="";
          for(int i=0;i<s.length;i++)
          {
              sk+=s[i]+" ";
          }
         
          try { 
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","krunu2025");
            String sql = "INSERT INTO stud values (?, ?, ?, ?, ?, ?, ?,?)";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, r);
            st.setString(2, nm);
            st.setString(3, g);
            st.setString(4, d);
            st.setString(5,sk);
            st.setInt(6, a);
            st.setString(7, ad);
            st.setString(8,p);
            st.executeUpdate();  
            out.println("<html><head> <style>\n" +
                        "div{\n" +
                        "width: 50%;\n" +
                        "height: 500px;\n" +
                        "border-style: solid;\n" +
                        "border-color: black;\n" +
                        "}\n" +
                        "\n" +
                        "</style></head><body><center><br><div><h1>Recored Inserted....</h1><br><a href='add.html'>OK</a></div></center></body></html>");
                
          }catch(Exception e)
          {
              e.printStackTrace();
          }
             
    }

}
