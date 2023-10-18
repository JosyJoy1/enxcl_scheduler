package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.DBUtil;

/**
 * Servlet implementation class saveTopics
 */
@WebServlet("/saveTopics")
public class saveTopics extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public saveTopics() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String course=request.getParameter("course");
    	String duration=request.getParameter("duration");
    	String topic=request.getParameter("topic");
    	Connection con=null;
    	try {
    		con=DBUtil.getconnection();
    		PreparedStatement ps=con.prepareStatement("insert into topics(course,topic,duration) values(?,?,?)");
    		ps.setString(1, course);
    		ps.setString(2, topic);
    		ps.setString(3, duration);
    		int count=ps.executeUpdate();
    	
    		RequestDispatcher dispatcher=request.getRequestDispatcher("Registration.jsp");

			if(count>0) {
				request.setAttribute("Status","Success");
				dispatcher = request.getRequestDispatcher("Adminhome.jsp");
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

		