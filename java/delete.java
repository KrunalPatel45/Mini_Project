import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class delete extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        
          res.setContentType("text/html");
          PrintWriter out = res.getWriter();
          int r = Integer.parseInt(req.getParameter("rn"));
         
          try { 
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","krunu2025");
            String sql = "DELETE FROM stud WHERE rno=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, r);
            st.executeUpdate();  
            out.println("<html><head> <style>\n" +
                        "div{\n" +
                        "width: 50%;\n" +
                        "height: 500px;\n" +
                        "border-style: solid;\n" +
                        "border-color: black;\n" +
                        "}\n" +
                        "\n" +
                        "</style></head><body><center><br><div><h1>Recored DELETED....</h1><br><a href='delete.html'>OK</a></div></center></body></html>");
                
          }catch(Exception e)
          {
              e.printStackTrace();
          }
          
    }

   
}
