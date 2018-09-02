package Test;

import java.util.Scanner;

import Dao.BorrowDao;

public class BorrowDaoTest {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	BorrowDao db = new BorrowDao();
		System.out.println("输入读者ID：");
		int readerid = sc.nextInt();
		System.out.println("请输入图书ID：");
		int bookid = sc.nextInt();
		db.delete(readerid, bookid);
		System.out.println("您已借书成功");		
		db.searchBorrowInfo(readerid);
	}
}
