package Entity;

public class Book {
    private String bookname;
    private String author;
    private String ISBN;
    private int booknum;
    
    public Book() {}
    
	public Book(String bookname, String author, String ISBN, int booknum) {
		super();
		this.bookname = bookname;
		this.author = author;
		this.ISBN = ISBN;
		this.booknum = booknum;
	}
	
	
	
	
	
	
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public void setISBN(String ISBN) {
		this.ISBN = ISBN;
	}
	public void setBooknum(int booknum) {
		this.booknum = booknum;
	}
	public String getBookname() {
		return bookname;
	}
	public String getAuthor() {
		return author;
	}
	public String getISBN() {
		return ISBN;
	}
	public int getBooknum() {
		return booknum;
	}
}
