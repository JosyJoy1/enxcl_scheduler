package servlet;
import java.util.Calendar;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.io.IOException;
import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.DBUtil;
@WebServlet("/Saveservlet")
public class Saveservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Saveservlet() {
        super();       
    }
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String courseName = request.getParameter("courseName");
        String startDateStr = request.getParameter("startDate");
        int duration = Integer.parseInt(request.getParameter("duration"));
        String batchType = request.getParameter("batchType");
        int hoursPerDay = Integer.parseInt(request.getParameter("hoursPerDay"));

        // Parse the start date (you may want to use a date library for this)
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = null;
        try {
            startDate = sdf.parse(startDateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // Calculate the end date based on the batch type and hours per day
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);
        if (batchType != null && batchType.equals("weekend")) {
            // Calculate end date for weekend batch
            calendar.add(Calendar.DATE, duration  / hoursPerDay);
        } else {
            // Calculate end date for weekday batch
            calendar.add(Calendar.DATE, duration / hoursPerDay);
        }
        Date endDate = calendar.getTime();

        // Pass the input values and end date back to the JSP
        request.setAttribute("courseName", courseName);
        request.setAttribute("startDate", startDateStr);
        request.setAttribute("endDate", sdf.format(endDate));
        request.getRequestDispatcher("result.jsp").forward(request, response);
       
        	Connection con;
			try {
				con = DBUtil.getconnection();
        	PreparedStatement ps=con.prepareStatement("insert into batches(courseName,startDate,duration,batchType,hoursPerDay,endDate) values (?,?,?,?,?,?)");
			ps.setString(1, courseName);
			java.sql.Date sqlStartDate = new java.sql.Date(startDate.getTime());
            ps.setDate(2, sqlStartDate);
			ps.setInt(3, duration);
			ps.setString(4, batchType);
			ps.setInt(5, hoursPerDay);
			java.sql.Date sqlendDate = new java.sql.Date(endDate.getTime());
            ps.setDate(6, sqlendDate);
            int count=ps.executeUpdate();
			System.out.println(count);
            

			} catch (SQLException e) {
				
				e.printStackTrace();
			}	
    }
    
}
    


