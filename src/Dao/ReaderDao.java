package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Entity.Reader;
import db.mysql.DBHelper;

public class ReaderDao {
	DBHelper db = new DBHelper();

	/**
	 * 用户注册，添加用户在reader表中插入行
	 * 
	 * @param reader
	 * @throws Exception
	 */
	public void signUp(Reader reader) {
		Connection connection = null;
		String sql = "insert into reader(name,password,major,email) values (?,?,?,?)";

		try {
			connection = db.getConnection();
			PreparedStatement pst = connection.prepareStatement(sql);
	
			pst.setString(1, reader.getName());
			pst.setString(2, reader.getPassword());
			pst.setString(3, reader.getMajor());
			pst.setString(4, reader.getEmail());
			pst.executeUpdate();
			System.out.println(reader.getName() + "注册成功");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close();
		}
	}

	/**
	 * 用户登录，在reader表中查找
	 * 
	 * @param str
	 * @return
	 */
	public String logIn(String str) {
		Connection conn = null;
		String sql = "select password from reader where name= ?";
		ResultSet rs = null;
		try {
			conn = db.getConnection();
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, str);
			rs = pst.executeQuery();
			String password = "";
			while (rs.next()) {
				password = rs.getString("password");
			}
			return password;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.close();
		}
		return null;
	}

	/**
	 * 修改密码，update reader表的密码
	 * 
	 * @param str
	 * @param password
	 */
	public void changePassword(Reader reader, String str) {
		Connection conn = null;
		String sql = "update reader set password = ? where name = ?";
		try {
			conn = db.getConnection();
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, str);
			pst.setString(2, reader.getName());
			pst.executeUpdate();
			System.out.println("修改密码成功");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.close();
		}
	}

	/**
	 * 注销用户，删除reader表中的行
	 * 
	 * @param readerid
	 */
	public void deleteReader(Reader reader) {
	    Connection conn = null;
	    String sql ="delete from reader where name =?";
	    conn = db.getConnection();
	    try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, reader.getName());
			pst.executeUpdate();
			System.out.println("====该用户注销成功====");
		} catch (SQLException e) {		
			e.printStackTrace();
		}
	    finally {
			db.close();
		}
	}
	
    /**
     * 查看读者已借阅书的数量
     * @param name
     * @return
     */
	public int searchBook(int readerid) {
		Connection conn = null;
		String sql = "select bookborrowed from reader where reader_id=?";
		ResultSet rs = null;
		try {
			conn = db.getConnection();
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, readerid);
			rs = pst.executeQuery();
			int bookborrowed = 0;
			while (rs.next()) {
				bookborrowed = rs.getInt("bookborrowed");
			}
			return bookborrowed;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.close();
		}
		return -1;
	}
	
	public void updateBookInc(int readerid) {
		Connection conn = null;
		String sql = "update reader set bookborrowed = bookborrowed + 1"
				+ "where reader_id =?" ;
		try {
			conn = db.getConnection();
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, readerid);
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.close();
		}
	}
	
	public void updateBookDec() {
		
	}
	

}
