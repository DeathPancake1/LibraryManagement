package application;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class Student {
	public int id;
	public int studentId;
	public String name;
	public String contact;
	public String pass;
	public ArrayList <Book> issuedBooks=new ArrayList<Book>();
	static Student me;
	public Student(int studentid,String name,String contact,String pass){
		this.studentId=studentid;
		this.name=name;
		this.contact=contact;
		this.pass=pass;
	}
	public Student(int studentid,String name,String contact) {
		this.studentId=studentid;
		this.name=name;
		this.contact=contact;
	}
	public static void login() {
		JFrame frame=new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel=new JPanel();
		panel.setLayout(null);
		JLabel title=new JLabel("Student Login Form");
		title.setBounds(100,0,120,20);
		JLabel userLbl=new JLabel("Enter Name");
		userLbl.setBounds(5, 60, 100, 20);
		JLabel passLbl=new JLabel("Enter Password");
		passLbl.setBounds(5, 130, 100, 20);
		JTextField user=new JTextField();
		user.setBounds(90,60,120,20);
		JPasswordField pass=new JPasswordField();
		pass.setBounds(100,130,120,20);
		JButton login=new JButton("Login");
		login.setBounds(100,210,100,30);
		JLabel incorrect =new JLabel("Name or Password is incorrect");
		incorrect.setBounds(70,160,180,20);
		incorrect.setVisible(false);
		login.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
				me=admin.Admin.checkStudent(user.getText(), pass.getText());
			    if(me !=null) {
			        	frame.setVisible(false);
			        	frame.dispose();
			        	String[] st = null;
		           		Library.main(st);
			        	view();
			        }
			    else {
			        incorrect.setForeground(Color.red);
		        	incorrect.setVisible(true);}
			        }  
			    }); 
		panel.add(title);panel.add(userLbl);panel.add(passLbl);panel.add(user);panel.add(pass);panel.add(login);panel.add(incorrect);
		frame.add(panel);
		frame.setSize(300,300);
		frame.setVisible(true);
	}
	public static void view() {
		JFrame frame=new JFrame();
		String [] columns = new String[] {
			"id","Call Num", "Name", "Author", "Publisher" ,"Date" 
		};
		JTable table = new JTable(me.viewBooks(),columns);
		frame.add(new JScrollPane(table));
		frame.setSize(500,500);
		frame.setVisible(true);
	}
	public Object[][] viewBooks() {
		Object[][] bookTable = new Object[issuedBooks.size()][6];
		for(int i=0;i<issuedBooks.size();i++) {
			bookTable[i]=issuedBooks.get(i).studentViewToArray();
		}
		return bookTable;
	}
}

