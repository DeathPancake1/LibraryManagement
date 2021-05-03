package application;

public class Book {
	public String callNum;
	public String name;
	public String author;
	public String publisher;
	public int quantity;
	public int id;
	public Student student;
	public String date;
	public Book(String callNum,String name,String author,String publisher,int quantity) {
		this.callNum=callNum;
		this.name=name;
		this.author=author;
		this.publisher=publisher;
		this.quantity=quantity;
	}
	public Book(String callNum,int id,String date) {
		this.callNum=callNum;
		this.name=librarian.Librarian.checkBook(callNum).name;
		this.author=librarian.Librarian.checkBook(callNum).author;
		this.publisher=librarian.Librarian.checkBook(callNum).publisher;
		this.date=date;
		this.student=admin.Admin.checkStudent(id);
		student.issuedBooks.add(this);
	}
	public Object[] toArray() {
		Object[] objArr= new Object[] {id,callNum,name,author,publisher,quantity};
		return objArr;
	}
	public Object[] issuedBookToArray() {
		Object[] objArr= new Object[] {id,callNum,student.studentId,student.name,student.contact,date};
		return objArr;
	}
	public Object[] studentViewToArray() {
		Object[] objArr = new Object[] {id,callNum,name,author,publisher,date};
		return objArr;
	}
}
