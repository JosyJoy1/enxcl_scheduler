package servlet;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.DBUtil;
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	 private static final long serialVersionUID = 1L;
	
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String Uemail = request.getParameter("username");
	        System.out.println("user"+Uemail);
	        String Upass = request.getParameter("password");
	        System.out.println("user"+Upass);
	        RequestDispatcher dispatcher = null;
	        try {
	            Connection con = DBUtil.getconnection();
	            PreparedStatement ps = con.prepareStatement("SELECT * FROM Registration WHERE Uemail = ? AND Upass = ? ");
	            ps.setString(1, Uemail);
	            ps.setString(2, Upass);
	            ResultSet rs = ps.executeQuery();
	            System.out.println("result:"+rs);
	           
	            if(rs.next()) {
	            	int value=rs.getInt(6);
	            	System.out.println("val"+value);
	            	if(value==1){
	                dispatcher = request.getRequestDispatcher("Home.jsp");
	                dispatcher.forward(request, response);
	            	}
	            	else if(value==2) {
                       dispatcher = request.getRequestDispatcher("Adminhome.jsp");
		               dispatcher.forward(request, response);
		            	}
	            else {
	                System.out.println("Login failed.Invalid credentials.");
	                request.setAttribute("Status", "failed");
	                dispatcher = request.getRequestDispatcher("Login.jsp");
	                dispatcher.forward(request, response);
	            }
	        }
	        }
	        catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
}



