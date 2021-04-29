package application;

public class Book {
	public String callNum;
	public String name;
	public String author;
	public String publisher;
	public int quantity;
	public Book(String callNum,String name,String author,String publisher,int quantity) {
		this.callNum=callNum;
		this.name=name;
		this.author=author;
		this.publisher=publisher;
		this.quantity=quantity;
	}
	public Object[] toArray() {
		Object[] objArr= new Object[] {callNum,name,author,publisher,quantity};
		return objArr;
	}
}
