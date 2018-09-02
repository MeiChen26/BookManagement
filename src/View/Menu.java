package View;

public class Menu {
	public void managMenu() {
		System.out.println("****管理员系统****");
		System.out.println("1.借书");
		System.out.println("2.还书");
	}
	public void myMenu() {
		System.out.println("请输入您想进行的操作是：");
		System.out.println("1.搜索图书是否架上可借");
		System.out.println("2.查看我的借阅");
		System.out.println("3.修改密码");
		System.out.println("4.注销账户");
		System.out.println("0.退出系统");
	}
	public void readerMenu() {
   	    System.out.println("======登录系统=======");
		System.out.println("1.登录");
		System.out.println("2.注册");
		System.out.println("0.退出系统");
   }   
   
	public void startMenu() {
		System.out.println("1.以管理员身份登录");
		System.out.println("2.以读者身份登录");
	}
	
}
