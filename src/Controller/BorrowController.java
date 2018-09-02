package Controller;

import java.util.Scanner;

import Dao.BorrowDao;

public class BorrowController {
	Scanner sc = new Scanner(System.in);
	BorrowDao db = new BorrowDao();
	
	/**
	 * 搜索读者的借阅信息
	 */
    public void searchLogic() {
    	    System.out.println("请输入读者ID：");
    	    int i = sc.nextInt();
    	    db.searchBorrowInfo(i);
    }
    
    /**
     * 调用BookDao的insert方法，在借阅表中添加信息，
     * 实现借阅
     */
    public void insertLogic() {
    	    System.out.println("请输入读者ID：");
    	    int readerid = sc.nextInt();
    	    System.out.println("请输入书的ID：");
    	    int bookid = sc.nextInt();
    	    db.insert(readerid, bookid);
    	    System.out.println("借阅成功");
    }
     
    public void deleteLogic() {
    	    System.out.println("请输入读者ID：");
  	    int readerid = sc.nextInt();
  	    System.out.println("请输入书的ID：");
  	    int bookid = sc.nextInt();
  	    db.delete(readerid, bookid);
  	    System.out.println("还书成功");
    }
    
    public void deleteUserLogic() {
	    System.out.println("请输入要注销的读者ID：");
	    int readerid = sc.nextInt();
	    db.deleteUser(readerid);
}
}
