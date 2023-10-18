package servlet;

import java.io.IOException;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.DBUtil;

@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RegistrationServlet() {
        super();
    }
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname=request.getParameter("name");
		String uemail=request.getParameter("email");
		String upass=request.getParameter("pass");
		String umobile=request.getParameter("contact");
		RequestDispatcher dispatcher=null;
		Connection con=null;
		try {
			   con = DBUtil.getconnection();

				PreparedStatement ps=con.prepareStatement("insert into Registration(Uname,Uemail,Upass,Ucontact) values (?,?,?,?)");
				ps.setString(1, uname);
				ps.setString(2, uemail);
				ps.setString(3, upass);
				ps.setString(4, umobile);


			int count=ps.executeUpdate();
			System.out.println(count);
			dispatcher=request.getRequestDispatcher("Registration.jsp");

			if(count>0) {
				request.setAttribute("Status","Success");
				
				dispatcher = request.getRequestDispatcher("Login.jsp");
			}
			dispatcher.forward(request, response);


		} catch (Exception e) {

			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}



	}

}
