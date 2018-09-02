package Test;

import java.util.ArrayList;
import java.util.Scanner;

import Dao.BookDao;
import Entity.Book;

public class BookDaoTest {
    public static void main(String[] args) {
		
    	    Scanner sc = new Scanner(System.in);
    	    BookDao db = new BookDao();
    	    
    	    System.out.println("请输入书的名字：");
    	    String bookname = sc.next();  
    	    System.out.println("请输入库存数量：");
    	    int booknum = sc.nextInt();
    	    System.out.println("请输入ISBN：");
    	    String ISBN = sc.next();
    	    System.out.println("请输入作者：");
    	    String author = sc.next();
    	    Book book = new Book(bookname,author,ISBN,booknum);
    	    db.insertBook(book);
    	   
    	    ArrayList<Book> booklist = new ArrayList<>();
    	    System.out.println("请输入要查询的作者名：");
    	    String str = sc.next();
    	   booklist = db.selectBook(str);
    	   
    	   for(Book a:booklist) {
    		   System.out.println(a.getBookname()+"现在有"+a.getBooknum()+"本可借");
    	   }
//    	   for(int i = 0; i<booklist.size(); i++) {
//    		   Book bk = booklist.get(i);
//    	   }
    	   
    	   System.out.println("请输入书的ID：");
   	    int bookid = sc.nextInt();
   	    db.updateInc(bookid);
   	  System.out.println("请输入书名：");
 	     bookname = sc.next();
 	    System.out.println(db.selectBooknum(bookname));
    }
}
