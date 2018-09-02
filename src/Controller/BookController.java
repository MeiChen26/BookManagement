package Controller;

import java.util.Scanner;

import Dao.BookDao;

public class BookController {
	Scanner sc = new Scanner(System.in);
	BookDao db = new BookDao();

	public void searchLogic() {
		System.out.println("请输入书名：");
		String bookname = sc.next();
		int i = db.selectBooknum(bookname);
		if (i > 0)
			System.out.println(bookname + "有" + i + "本可借");
		else
			System.out.println("该书没有库存，现不可借");
	}

	public void updateIncLogic() {
		int bookid = sc.nextInt();
		db.updateInc(bookid);
	}

	public void updateDecLogic() {
		int bookid = sc.nextInt();
		db.updateDec(bookid);
	}

}
