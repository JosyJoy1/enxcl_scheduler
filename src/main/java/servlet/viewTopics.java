package servlet;

import java.io.IOException;
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
 * Servlet implementation class viewTopics
 */
@WebServlet("/viewTopics")
public class viewTopics extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewTopics() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{
			Connection con = DBUtil.getconnection();
			PreparedStatement ps=con.prepareStatement("select * from topics");
			System.out.print("<table width=50% border=1>");  
			System.out.print("<caption>Result:</caption>");  
			  
			ResultSet rs=ps.executeQuery();  
			              /* Printing column names */  
			ResultSetMetaData rsmd=rs.getMetaData();  
			int total=rsmd.getColumnCount();  
			System.out.print("<tr>");  
			for(int i=1;i<=total;i++)  
			{  
			System.out.print("<th>"+rsmd.getColumnName(i)+"</th>");  
			}  
			  
			System.out.print("</tr>");  
			              
			/* Printing result */  
			  
			while(rs.next())  
			{  
			System.out.print("<tr><td>"+rs.getInt(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td></tr>");  
			                  
			}  
			  
			System.out.print("</table>");  
			              
			}catch (Exception e2) {e2.printStackTrace();}  
			          
			finally{System.out.close();}  
			  
			}
}
	


