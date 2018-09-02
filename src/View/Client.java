package View;

import java.util.Scanner;

import Controller.BookController;
import Controller.BorrowController;
import Controller.ReaderController;
import Entity.Reader;

public class Client { 
	public static final String password = "583aa400af464c76d";
    
	public static void main(String[] args) {
		Client client = new Client();
		Menu menu = new Menu();
		Scanner sc = new Scanner(System.in);
		menu.startMenu(); // 显示主菜单
		InputCheck input = new InputCheck();
		int key = input.menuCheck(1, 2);	
		if (key == 1) {
			System.out.println("请输入密码：");
			if (sc.next().equals(password))
				client.processManag(); // 以管理员身份登录
		} else if (key == 2)
			client.processReader(); // 以读者身份登录
	}

	/**
	 * 管理员实现借书还书
	 */
	public void processManag() {
		Menu menu = new Menu();
		InputCheck input = new InputCheck();
		menu.managMenu(); // 显示管理员菜单
		
		
		int key = input.menuCheck(1, 2);
		if (key == 1)
			processBorrow(); // 处理借书
		else if (key == 2)
			processReturn(); // 处理还书
	}

	/**
	 * 读者的注册和登录
	 */
	public void processReader() {
		ReaderController controller = new ReaderController(); // 读者控制器
		InputCheck input = new InputCheck();
		Menu menu = new Menu();
		Reader reader = new Reader();
		while (true) {
			menu.readerMenu(); // 显示读者菜单
			int key = input.menuCheck(0, 2);
			switch (key) {
			case 1: // 登录
				if ((reader = controller.searchPasswordLogic()) != null) {
					System.out.println("登录成功");
					processLogin(reader); // 处理登录成功
					return;
				} else
					System.out.println("登录失败");
				break;
			case 2: // 注册
				controller.insertLogic();
				break;
			case 0:
				System.exit(0);
			}
		}
	}

	/**
	 * 读者登录成功后
	 * 
	 * @param reader
	 */
	public void processLogin(Reader reader) {
		Menu menu = new Menu();
		InputCheck input = new InputCheck();
		// 实例化读者控制器的对象
		ReaderController rcontroller = new ReaderController();
		// 实例化书控制器的对象
		BookController bkcontroller = new BookController();
		// 实例化借阅控制器的对象
		BorrowController bcontroller = new BorrowController();
		while (true) {
			menu.myMenu(); // 显示读者登录成功后的菜单
			int key = input.menuCheck(0, 4);
			switch (key) {
			case 1: // 搜索书是否在架上可借，是对book表的查询
				bkcontroller.searchLogic();
				break;
			case 2:
				bcontroller.searchLogic(); // 搜索读者的借阅信息，是多表的联合查询
				break;
			case 3:
				rcontroller.updatePasswordLogic(reader); // 读者修改密码
				break;
			case 4:
				bcontroller.deleteUserLogic();
				rcontroller.deleteLogic(reader); // 注销读者账户
				break;
			case 0:
				System.exit(0);
			}
		}
	}

	/**
	 * 处理借书
	 */
	public void processBorrow() {	
		// 实例化书控制器的对象
		BookController bkcontroller = new BookController();
		// 实例化借阅控制器的对象
		BorrowController bcontroller = new BorrowController();
		bcontroller.insertLogic(); // 借书表里添加进借书的信息
		bkcontroller.updateDecLogic(); // 书表中书的库存减一
	}

	/**
	 * 处理还书
	 */
	public void processReturn() {
		// 实例化书控制器的对象
		BookController bkcontroller = new BookController();
		// 实例化借阅控制器的对象
		BorrowController bcontroller = new BorrowController();
		bcontroller.deleteLogic(); // 借书表里删除借书的信息
		bkcontroller.updateDecLogic(); // 书表中书的库存加一
	}
}
