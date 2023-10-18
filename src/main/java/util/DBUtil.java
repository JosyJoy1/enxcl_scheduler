package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

public static Connection getconnection() throws SQLException

	{
	   	try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/training_scheduler","root","password");
		return conn;
	}


}
