package librarian;

import java.util.ArrayList;

public class Librarian {
	private static ArrayList<application.Book> bookList=new ArrayList<application.Book>();
	private static ArrayList<application.Student> issuedBookList = new ArrayList<application.Student>();
	public int id;
	private String username, pass,email,address,city,contactNum;
	public Librarian(String username,String pass,String email,String address,String city,String contactNum) {
		this.username=username;
		this.pass=pass;
		this.email=email;
		this.address=address;
		this.city=city;
		this.contactNum=contactNum;
	}
	void addBook(application.Book newEntry) {
		bookList.add(newEntry);
	}
	Object[][] viewBooks() {
		Object[][] bookTable = new Object[bookList.size()][5];
		for(int i=0;i<bookList.size();i++) {
			bookTable[i]=bookList.get(i).toArray();
		}
		return bookTable;
	}
	boolean issueBook(application.Student newEntry) {
		if(newEntry.issuedBook.quantity>0) {
			issuedBookList.add(newEntry);
			newEntry.id=issuedBookList.indexOf(newEntry);
			newEntry.issuedBook.quantity--;
			return true;
		}
		return false;
	}
	Object[][] viewIssuedBooks() {
		Object[][] issuedBookTable = new Object[issuedBookList.size()][6];
		for(int i=0;i<issuedBookList.size();i++) {
			issuedBookTable[i]=issuedBookList.get(i).toArray();
		}
		return issuedBookTable;
	}
	void returnBook(application.Student returnedBook) {
		returnedBook.issuedBook.quantity++;
		issuedBookList.remove(returnedBook);
	}
	public String getUsername() {
		return username;
	}
	public String getPass() {
		return pass;
	}
	public Object[] toArray() {
		Object[] objArr= new Object[] {id,username,pass,email,address,city,contactNum};
		return objArr;
	}
	public application.Book checkBook(String callNum) {
		for(int i=0;i<bookList.size();i++) {
			if(bookList.get(i).callNum.equals(callNum)) {
				return bookList.get(i);
			}
		}
		return null;
	}
	public application.Student checkIssuedBook(String callNum, int id){
		for(int i=0;i<issuedBookList.size();i++) {
			if(issuedBookList.get(i).issuedBook.callNum.equals(callNum)&&issuedBookList.get(i).id==id) {
				return issuedBookList.get(i);
			}
		}
		return null;
	}
}
