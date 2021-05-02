package librarian;

import java.util.ArrayList;
import java.util.Date;

import admin.Admin;

public class Librarian {
	private static ArrayList<application.Book> bookList=new ArrayList<application.Book>();
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
	boolean issueBook(application.Student student,application.Book book) {
		if(bookList.get(bookList.indexOf(book)).quantity>0&&student.issuedBooks.size()<3) {
			Date date = new Date();
			student.issuedBooks.add(book);
			student.issuedBooksDates.add(date);
			book.quantity--;
			return true;
		}
		return false;
	}
	Object[][] viewIssuedBooks(){
		int k=0;
		for(int i=0;i<Admin.students.size();i++) {
			for(int j=0;j<Admin.students.get(i).issuedBooks.size();j++) {
				k++;
			}
		}
		Object[][] issuedBookTable = new Object[k][6];
		k=0;
		for(int i=0;i<Admin.students.size();i++) {
			for(int j=0;j<Admin.students.get(i).issuedBooks.size();j++) {
				Object[] temp = new Object[]{Admin.students.get(i).id,Admin.students.get(i).issuedBooks.get(j).callNum,Admin.students.get(i).studentId,Admin.students.get(i).name,Admin.students.get(i).contact,Admin.students.get(i).issuedBooksDates.get(j)};
				issuedBookTable[k]=temp;
				k++;
			}
		}
		return issuedBookTable;
	}
	boolean returnBook(application.Student student,application.Book returnedBook) {
		for(int i=0;i<student.issuedBooks.size();i++) {
			if(student.issuedBooks.get(i).equals(returnedBook)) {
				student.issuedBooks.remove(i);
				student.issuedBooksDates.remove(i);
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
	public application.Book checkBook(String callNum) {
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
	public Object checkIssuedBook(application.Student student, application.Book book){
		for(int i=0;i<student.issuedBooks.size();i++) {
			if(student.issuedBooks.get(i).equals(book)) {
				return student.issuedBooks.get(i);
			}
		}
		return null;
	}
}
