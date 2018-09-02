package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Entity.Book;
import db.mysql.DBHelper;

public class BookDao {
	Connection conn = null;
	DBHelper helper = new DBHelper();

	/**
	 * 添加图书
	 * @param book
	 */
	public void insertBook(Book book) {
		conn = helper.getConnection();
		String sql = "insert into books(book_name,author,ISBN,book_num) values(?,?,?,?)";
		PreparedStatement pst;
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, book.getBookname());
			pst.setString(2, book.getAuthor());
			pst.setString(3, book.getISBN());
			pst.setInt(4, book.getBooknum());
			pst.executeUpdate();

			System.out.println("添加图书" + book.getBookname());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			helper.close();
		}
	}

	/**
	 * 返回某一作者的书籍信息
	 * @param str作者名
	 * @return 书的数组
	 */
	public ArrayList<Book> selectBook(String str) {
		ResultSet rs;
		Book book = new Book();
		ArrayList<Book> booklist = new ArrayList<Book>();
	    conn = helper.getConnection();
	    String sql = "select * from books where author = ?";
	    PreparedStatement pst;
	    try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, str);
			rs = pst.executeQuery();
			while(rs.next()) {
				String bookname = rs.getString("book_name");
				int booknum = rs.getInt("book_num");
				book.setBookname(bookname);
				book.setBooknum(booknum);
				booklist.add(book);
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	    return booklist;
	}

	/**
	 * 根据书名查找书的可借的数量
	 * @param str
	 * @return 书的库存数量
	 */
	public int selectBooknum(String str) {
		conn = helper.getConnection();
		ResultSet rs = null;
		String sql = "select book_num from books where book_name=?";
		PreparedStatement pst;		
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, str);
			rs = pst.executeQuery();
			int booknum;
			while (rs.next()) {
				booknum = rs.getInt("book_num");
				return booknum;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	/**
	 * 更新书的数量
	 * @param bookid
	 */
	public void updateInc(int bookid) {
		Connection conn = null;
		String sql = "update books set book_num = book_num + 1 where book_id=?";
		try {
			conn = helper.getConnection();
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, bookid);
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			helper.close();
		}
	}
	
	/**
	 * 减少书的数量
	 * @param bookid
	 */
	public void updateDec(int bookid) {
		Connection conn = null;
		String sql = "update books set book_num = book_num - 1 where book_id=?";
		try {
			conn = helper.getConnection();
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, bookid);
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			helper.close();
		}
	}

}