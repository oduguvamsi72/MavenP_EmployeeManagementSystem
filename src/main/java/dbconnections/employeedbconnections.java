package dbconnections;

import java.sql.Connection;
import java.sql.DriverManager;

public class employeedbconnections {
	private static String Driver = "com.mysql.cj.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/employee";
	private static String user = "root";
	private static String pass = "root";
	private static Connection conn = null;

	public static Connection getConnection() {
		try {
			Class.forName(Driver);
			conn = DriverManager.getConnection(url, user, pass);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
