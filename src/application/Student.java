package application;

import java.util.Date;

public class Student {
	public int id;
	public int studentId;
	String name, contact;
	public Book issuedBook;
	Date dateIssued;
	public Student(int id,String name,String contact, Book issuedBook){
		this.id=id;
		this.name=name;
		this.contact=contact;
		this.issuedBook=issuedBook;
		dateIssued = new Date();
	}
	public Object[] toArray() {
		Object[] array=new Object[] {id,issuedBook.callNum,studentId,name,contact,dateIssued};
		return array;
	}
}
