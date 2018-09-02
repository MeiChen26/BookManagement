package View;

import java.util.Scanner;

/**
 * 输入的合法性检查
 * @author meitong
 *
 */
public class InputCheck {
	public int menuCheck(int min, int max) {
		while (true) {
			System.out.println("请输入正确的数字,最小是: " + min + "\t" + "最大是: " + max);
			String inputStr = getInput();
			int i = Integer.parseInt(inputStr);
			if (i <= max && i >= min)
				return i;
			else
				System.err.println("没有该选项号！请重新输入");
		}
	}
	   public String majorCheck() {
  	     return getInput();
  }
  
	public String nameCheck() {
		while (true) {
			System.out.println("输入用户名：");
			String inputStr = getInput().trim();
			if (!"".equals(inputStr) && inputStr.length() <= 20) {
				return inputStr;
			} else {
				System.err.println("输入姓名错误，请重新输入！");
			}
		}
	}
	public String passwordCheck() {
		while (true) {
			System.out.println("输入密码：");
			String password = getInput();
			if (password.matches("[a-zA-Z0-9]{1,8}")) 
				return password;
			 else 
				System.out.println("密码格式输入错误,请重新输入!");
			
		}
	}
	

	public String emailCheck() {
		while (true) {
			System.out.println("输入邮箱：");
			String email = getInput();
			if (email.matches("^[a-zA-Z0-9]+@[a-zA-Z0-9]+[\\.][a-zA-Z0-9]+$"))
				return email;
			 else 
				System.out.println("邮箱格式输入错误,请重新输入!");
				
		}
}

  
	
	public String getInput() {
		return new Scanner(System.in).next();
	}

}
