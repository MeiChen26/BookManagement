package Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import db.mysql.DBHelper;

public class BorrowDao {
	Connection conn = null;
	DBHelper helper = new DBHelper();  
	/**
	 * 借书时更新borrow表
	 * @param readerid
	 * @param bookid
	 */
	public void insert(int readerid, int bookid) {
		conn = helper.getConnection();
		String sql = "insert into borrow values(?,?,now()," 
		+ "date_add(borrow_time,interval 3 month))";
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, readerid);
			pst.setInt(2, bookid);
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 读者查看借阅的信息
	 * @param str 读者id
	 */
	public void searchBorrowInfo(int str) {
		conn = helper.getConnection();
		String sql = "select book_name,deadline,name "
				+ "from reader,books,borrow "
				+ "where reader.reader_id=borrow.reader_id "
				+ "and borrow.book_id=books.book_id "
				+ "and reader.reader_id=?";
		ResultSet rs = null;
		PreparedStatement pst;
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, str);
		    rs = pst.executeQuery();
		    while(rs.next()) {
		    	    String bookname = rs.getString("book_name");
		    	    String deadline = rs.getString("deadline");
		    	    String name = rs.getString("name");
		    	    System.out.println(name+" 您借阅的 "+bookname+" 到期时间为 "+deadline);
		    }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	/**
	 * 还书
	 * @param readerid
	 * @param bookid
	 */
	public void delete(int readerid, int bookid) {	
		conn = helper.getConnection();
	String sql = "delete from borrow where reader_id = ? "
			+ "and book_id = ?";
	try {
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setInt(1, readerid);
		pst.setInt(2, bookid);
		pst.executeUpdate();
	} catch (SQLException e) {
		e.printStackTrace();
	}	
}
	
	/**
	 * 删除用户
	 * @param readerid
	 * @param bookid
	 */
	public void deleteUser(int readerid) {	
		conn = helper.getConnection();
	String sql = "delete from borrow where reader_id = ?";
	try {
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setInt(1, readerid);
		pst.executeUpdate();
	} catch (SQLException e) {
		e.printStackTrace();
	}	
	}
	
}
