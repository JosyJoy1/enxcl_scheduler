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


@WebServlet("/sourceviewbatch")
public class sourceviewbatch extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public sourceviewbatch() {
        super();
        
    }
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();  
		          
		
		          
		try{  
			Connection con = DBUtil.getconnection();

			PreparedStatement ps=con.prepareStatement("select * from batches");
		out.print("<table width=50% border=1>");  
		out.print("<caption>Existing Batches:</caption>");  
		  
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
			out.print("<tr><td>"+rs.getInt(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td><td>"+rs.getInt(5)+"</td><td>"+rs.getString(6)+"</td></tr>");  
		                  
		}  
		  
		out.print("</table>");  
		              
		}catch (Exception e2) {e2.printStackTrace();}  
		          
		finally{out.close();}  
		  
		}  
		}  