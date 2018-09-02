package Controller;

import Dao.ReaderDao;
import Entity.Reader;
import View.InputCheck;

public class ReaderController {

	Reader reader = new Reader();
	ReaderDao db = new ReaderDao();
    InputCheck input = new InputCheck();
    
    /**
     * 注册用户信息
     */
	public void insertLogic() {
		
		// 把一个用户的信息封装到一个User对象中

		String name = input.nameCheck();
		String password = input.passwordCheck();	
		String email = input.emailCheck();
		String major = input.majorCheck();
	 
		reader.setName(name);
		reader.setPassword(password);
		reader.setEmail(email);
		reader.setMajor(major);	
		try {
			db.signUp(reader);
		} catch (Exception e) {
		}
	}
	
	/**
	 * 登录，查询密码是否正确
	 * @return
	 */
	public Reader searchPasswordLogic() {	
		String name = input.nameCheck();
		String password = input.passwordCheck();
		Reader reader = new Reader();
		
		reader.setName(name);
		reader.setPassword(password);
		if(password.equals(db.logIn(name)))		
				return reader;			
		else return null;

	}	
	/**
	 * 删除用户的逻辑，调用ReaderDao的deleterReader()
	 * @param reader
	 */
	public void deleteLogic(Reader reader) {
		String password = input.passwordCheck();
		if(password.equals(db.logIn(reader.getName())))	{
		db.deleteReader(reader);
		}
	}
	
	/**
	 * 修改密码
	 * @param reader
	 */
	public void updatePasswordLogic(Reader reader) {
		InputCheck input = new InputCheck();
		String nwpw = input.passwordCheck();	 //输入新密码
		db.changePassword(reader, nwpw);
		reader.setPassword(nwpw);
	}


	
}
