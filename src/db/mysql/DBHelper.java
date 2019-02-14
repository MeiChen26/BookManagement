package db.mysql;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBHelper {
	private Connection conn = null;
	// 驱动类名
	private static final String className = "com.mysql.cj.jdbc.Driver";
	// 连接数据库的字符串url
	private static final String url = "jdbc:mysql://localhost:3306/booksys?useSSL=false";
	// 数据库用户名
	private static final String user = "root";
	// 连接数据库的密码
	private static final String password = "1234!";

	// Step 1 Connect to MySQL.
	public Connection getConnection() {
		try {
			Class.forName(className);
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public void close() {
		if (conn != null) {
			try {
				conn.close(); 
		}
		catch (Exception e) {
		e.printStackTrace();
		} 
  }
}
}
