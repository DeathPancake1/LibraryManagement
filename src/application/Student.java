package application;

import java.util.ArrayList;
import java.util.Date;

public class Student {
	public int id;
	public int studentId;
	public String name;
	public String contact;
	public ArrayList <Book> issuedBooks=new ArrayList<Book>();
	public ArrayList <Date> issuedBooksDates = new ArrayList<Date>();
	public Student(int studentid,String name,String contact){
		this.studentId=studentid;
		this.name=name;
		this.contact=contact;
	}
}
