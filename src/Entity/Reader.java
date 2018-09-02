package Entity;

public class Reader {
    private String name;
    private String password;
    private String readerid;
    private String major;
    private String email;
    private int bookborrowed;
    
    public Reader() {}
	public String getReaderid() {
		return readerid;
	}
	public void setReaderid(String readerid) {
		this.readerid = readerid;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getBookborrowed() {
		return bookborrowed;
	}
	public void setBookborrowed(int bookborrowed) {
		this.bookborrowed = bookborrowed;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public String getPassword() {
		return password;
	}
    
}
