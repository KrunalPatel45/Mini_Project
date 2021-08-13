import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class edit extends HttpServlet {



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
         
        res.setContentType("text/html");
          PrintWriter out = res.getWriter();
          int r = Integer.parseInt(req.getParameter("rn"));
          String nm = req.getParameter("nm");
          String g = req.getParameter("gen");
          String d = req.getParameter("dropdown");
          String s = req.getParameter("c1");
          int a= Integer.parseInt(req.getParameter("ag"));
          String ad = req.getParameter("ad");
          String p = req.getParameter("pn");
          try { 
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","krunu2025");
            String sql = "UPDATE stud SET nm=?,gen=?,dept=?,skill=?,ag=?,ad=?,pno=? where rno=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, nm);
            st.setInt(2, a);
            st.setString(3, g);
            st.setString(4, d);
            st.setString(5,s);
            st.setString(6, ad);
            st.setString(7,p);
            st.setInt(8, r);
            st.executeUpdate();  
            out.println("<html><head> <style>\n" +
                        "div{\n" +
                        "width: 50%;\n" +
                        "height: 500px;\n" +
                        "border-style: solid;\n" +
                        "border-color: black;\n" +
                        "}\n" +
                        "\n" +
                        "</style></head><body><center><br><div><h1>Recored Updated....</h1><br><a href='edit.html'>OK</a></div></center></body></html>");
                
          }catch(Exception e)
          {
              e.printStackTrace();
          }
          
        
    }

    
}
