package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.DBUtil;

/**
 * Servlet implementation class ViewCourse
 */
@WebServlet("/ViewCourse")
public class ViewCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewCourse() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String course = request.getParameter("course");
		PrintWriter out = response.getWriter();  
        
		
        
		try{  
			Connection con = DBUtil.getconnection();

			PreparedStatement ps=con.prepareStatement("select * from topics where course=?");
			ps.setString(1, course);
		out.print("<table width=50% border=1>");  
		out.print("<caption>Topics:</caption>");  
		  
		ResultSet rs=ps.executeQuery();   
		ResultSetMetaData rsmd=rs.getMetaData();  
		int total=rsmd.getColumnCount();  
		out.print("<tr>");  
		for(int i=1;i<=total;i++)  
		{  
		out.print("<th>"+rsmd.getColumnName(i)+"</th>");  
		}  
		out.print("</tr>");  
		while(rs.next())  
		{  
			out.print("<tr><td>"+rs.getInt(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td></tr>");  
		                  
		}  
		  
		out.print("</table>");  
		              
		}catch (Exception e2) {e2.printStackTrace();}  
		          
		finally{out.close();}  
		  
		}  
		}  