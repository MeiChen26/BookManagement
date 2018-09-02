package db.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLTableCreation {
	public static void main(String[] args) {
		Connection conn = null;
		// 驱动类名
		String className = "com.mysql.cj.jdbc.Driver";
		// 连接数据库的字符串url
		String url = "jdbc:mysql://localhost:3306/booksys?useSSL=false&serverTimezone=UTC";
		// 数据库用户名
		String user = "root";
		// 连接数据库的密码
		String password = "Goodluck1234!";
		// Step 1 Connect to MySQL.
		try {
			Class.forName(className);
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (conn == null) {
			return;
		}

		Statement stmt;
		try {
			stmt = conn.createStatement();

			 String sql = "DROP TABLE IF EXISTS borrow";
			 stmt.executeUpdate(sql);	 
			 sql = "DROP TABLE IF EXISTS books";
			 stmt.executeUpdate(sql);
			 sql = "DROP TABLE IF EXISTS reader";
			 stmt.executeUpdate(sql);
			 
			 
			// Step2 Create new tables
			sql = "CREATE TABLE reader" 
			           + "(reader_id INT NOT NULL AUTO_INCREMENT," 
					   + "name VARCHAR(255) NOT NULL UNIQUE,"
					   + "password VARCHAR(255) NOT NULL," 
					   + "major VARCHAR(255)," 
					   + "email VARCHAR(255)," 
					   + "bookborrowed INT DEFAULT 0,"
					   + "PRIMARY KEY (reader_id))";
			stmt.executeUpdate(sql);
			
			sql = "CREATE TABLE books" 
			           + "(book_id INT NOT NULL AUTO_INCREMENT," 
					   + "book_name VARCHAR(255),"
					   + "author VARCHAR(255)," 
					   + "ISBN VARCHAR(255)," 
					   + "book_num INT," 
					   + "PRIMARY KEY (book_id))";
			stmt.executeUpdate(sql);
			
			sql = "CREATE TABLE borrow "
				+ "(reader_id INT NOT NULL,"
		    		+ "book_id INT NOT NULL,"
		    		+ "borrow_time timestamp default current_timestamp,"
		    		+ "deadline timestamp,"
		    		+ "PRIMARY KEY (reader_id, book_id),"
		    		+ "FOREIGN KEY (reader_id) REFERENCES reader(reader_id),"
		    		+ "FOREIGN KEY (book_id) REFERENCES books(book_id))";
			stmt.executeUpdate(sql);
			 // Step 4: insert data
		    sql = "INSERT INTO reader VALUES ("
		       	+ "1, 'meitong', '1234', 'cs', 'meitong@163.com', 0 )";
		    System.out.println("Executing query: " + sql); 
		    stmt.executeUpdate (sql);    
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		}

}
