package librarian;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import admin.Admin;

public class Librarian {
	public static ArrayList<application.Book> bookList=new ArrayList<application.Book>();
	public static ArrayList<application.Book> issuedBooks=new ArrayList<application.Book>();
	public int id;
	private String username, pass;
	public String email;
	public String address;
	public String city;
	public String contactNum;
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
		newEntry.id=bookList.indexOf(newEntry);
		application.Files.saveBooks();
	}
	Object[][] viewBooks() {
		Object[][] bookTable = new Object[bookList.size()][6];
		for(int i=0;i<bookList.size();i++) {
			bookTable[i]=bookList.get(i).toArray();
		}
		return bookTable;
	}
	boolean issueBook(application.Student student,application.Book book) {
		if(bookList.get(bookList.indexOf(book)).quantity>0&&student.issuedBooks.size()<3) {
			student.issuedBooks.add(book);
			issuedBooks.add(book);
			book.id=issuedBooks.indexOf(book);
			book.student=student;
			Date date = Calendar.getInstance().getTime();  
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");  
            String strDate = dateFormat.format(date);  
			book.date=strDate;
			book.quantity--;
			application.Files.saveBooks();
			application.Files.saveIssuedBooks();
			return true;
		}
		return false;
	}
	Object[][] viewIssuedBooks(){
		Object[][] issuedBookTable = new Object[issuedBooks.size()][6];
		for(int i=0;i<issuedBooks.size();i++) {
			issuedBookTable[i]=issuedBooks.get(i).issuedBookToArray();
		}
		return issuedBookTable;
	}
	boolean returnBook(application.Student student,application.Book returnedBook) {
		boolean flag=false;
		for(int i=0;i<issuedBooks.size();i++) {
			if(issuedBooks.get(i).callNum.equals(returnedBook.callNum)&&issuedBooks.get(i).student.studentId==student.studentId) {
				flag=true;
			}
		}
		for(int i=0;i<student.issuedBooks.size();i++) {
			if(student.issuedBooks.get(i).callNum.equals(returnedBook.callNum)&&flag) {
				issuedBooks.get(i).quantity++;
				issuedBooks.remove(i);
				application.Files.saveBooks();
				application.Files.saveIssuedBooks();
				return true;
			}
		}
		return false;
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
	public static application.Book checkBook(String callNum) {
		for(int i=0;i<bookList.size();i++) {
			if(bookList.get(i).callNum.equals(callNum)) {
				return bookList.get(i);
			}
		}
		return null;
	}
	public application.Student checkStudent(String studentId){
		for(int i=0;i<Admin.students.size();i++) {
			if(Integer.parseInt(studentId)==Admin.students.get(i).studentId) {
				return Admin.students.get(i);
			}
		}
		return null;
	}
}
