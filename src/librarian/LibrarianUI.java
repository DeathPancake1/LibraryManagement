package librarian;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class LibrarianUI {
	static Librarian me;
	public static void login() {
		JFrame frame=new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel=new JPanel();
		panel.setLayout(null);
		JLabel title=new JLabel("Librarian Login Form");
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
				me=admin.Admin.checkUser(user.getText(), pass.getText());
			        if(me !=null) {
			        	frame.setVisible(false);
			        	frame.dispose();
			        	librarianSection();
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
	private static void librarianSection() {
		JFrame frame=new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel=new JPanel();
		panel.setLayout(null);
		JLabel title=new JLabel("Librarian Section");
		title.setBounds(100,0,120,20);
		JButton addBook=new JButton("Add Books");
		addBook.setBounds(70, 30, 160, 40);
		JButton viewBook=new JButton("View Books");
		viewBook.setBounds(70, 90, 160, 40);
		JButton issueBook=new JButton("Issue Book");
		issueBook.setBounds(70, 150, 160, 40);
		JButton viewIssuedBooks=new JButton("View Issued Book");
		viewIssuedBooks.setBounds(70, 200, 160, 40);
		JButton returnBook=new JButton("Return Book");
		returnBook.setBounds(70, 250, 160, 40);
		JButton logout=new JButton("Logout");
		logout.setBounds(70, 300, 160, 40);
		addBook.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
				frame.setVisible(false);
            	frame.dispose();
            	addBook();
		        }  
		    });
		viewBook.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
            	viewBook();
		        }  
		    });
		issueBook.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
            	frame.dispose();
				issueBook();
			}
		});
		viewIssuedBooks.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				viewIssuedBooks();
			}
		});
		returnBook.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
            	frame.dispose();
				returnBook();
			}
		});
		logout.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
					frame.setVisible(false);
	            	frame.dispose();
	            	String[] st = null;
	           		application.Library.main(st);
			        }  
			    });
		panel.add(logout);panel.add(addBook);panel.add(title);panel.add(viewBook);panel.add(issueBook);panel.add(viewIssuedBooks);panel.add(returnBook);
		frame.setSize(350,400);
		frame.add(panel);
		frame.setVisible(true);
	}
	private static void addBook() {
		JFrame frame=new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel=new JPanel();
		panel.setLayout(null);
		JLabel title=new JLabel("Add Book");
		title.setBounds(175,0,150,30);
		JLabel callNumLbl=new JLabel("Call No.");
		callNumLbl.setBounds(80,50,150,30);
		JTextField callNum=new JTextField();
		callNum.setBounds(150,50,150,30);
		JLabel nameLbl=new JLabel("Name");
		nameLbl.setBounds(80,100,150,30);
		JTextField name = new JTextField();
		name.setBounds(150,100,150,30);
		JLabel authorLbl=new JLabel("Author");
		authorLbl.setBounds(80,150,150,30);
		JTextField author=new JTextField();
		author.setBounds(150,150,150,30);
		JLabel publisherLbl=new JLabel("Publisher");
		publisherLbl.setBounds(80,200,150,30);
		JTextField publisher=new JTextField();
		publisher.setBounds(150,200,150,30);
		JLabel quantityLbl=new JLabel("Quantity");
		quantityLbl.setBounds(80,250,150,30);
		JTextField quantity=new JTextField();
		quantity.setBounds(150,250,150,30);
		JLabel error = new JLabel("Insert correct information");
		error.setBounds(300,400,150,30);
		error.setVisible(false);
		JButton add = new JButton("Add Book");
		add.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
				boolean success;
				try {
					Integer.parseInt(quantity.getText());
					success=true;
				}
				catch(Exception e1){
					success=false;
				}
				if(!(callNum.getText().equals("")||name.getText().equals("")||author.getText().equals("")||publisher.getText().equals("")||quantity.getText().equals(""))&&success) {
					application.Book entry = new application.Book(callNum.getText(),name.getText(),author.getText(),publisher.getText(),Integer.parseInt(quantity.getText()));
	           		me.addBook(entry);
	           		JOptionPane.showMessageDialog(frame, "Book Added Successfully");
	           		frame.setVisible(false);
	            	frame.dispose();
	           		librarianSection();
				}
				else {
					error.setVisible(true);
					error.setForeground(Color.red);
				}
		        }  
		    });
		add.setBounds(150,350,130,30);
		JButton back = new JButton("Back");
		back.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
				frame.setVisible(false);
            	frame.dispose();
           		librarianSection();
		        }  
		    });
		back.setBounds(80,400,100,30);
		panel.add(title);panel.add(callNum);panel.add(name);panel.add(author);panel.add(publisher);panel.add(quantity);panel.add(add);panel.add(back);panel.add(callNumLbl);panel.add(nameLbl);panel.add(authorLbl);panel.add(publisherLbl);panel.add(quantityLbl);panel.add(error);
		frame.add(panel);
		frame.setSize(500,500);
		frame.setVisible(true);
	}
	private static void viewBook() {
		JFrame frame=new JFrame();
		String [] columns = new String[] {
			"call No", "Name", "Author", "Publisher" , "Quantity" 
		};
		JTable table = new JTable(me.viewBooks(),columns);
		frame.add(new JScrollPane(table));
		frame.setSize(500,500);
		frame.setVisible(true);
	}
	private static void issueBook() {
		JFrame frame=new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel=new JPanel();
		panel.setLayout(null);
		JLabel title=new JLabel("Issue Book");
		title.setBounds(175,0,150,30);
		JLabel callNumLbl=new JLabel("Call No.");
		callNumLbl.setBounds(40,50,150,30);
		JTextField callNum=new JTextField();
		callNum.setBounds(150,50,150,30);
		JLabel studentIdLbl=new JLabel("Student ID");
		studentIdLbl.setBounds(40,100,150,30);
		JTextField studentId = new JTextField();
		studentId.setBounds(150,100,150,30);
		JLabel studentNameLbl=new JLabel("Student Name");
		studentNameLbl.setBounds(40,150,150,30);
		JTextField studentName=new JTextField();
		studentName.setBounds(150,150,150,30);
		JLabel studentContactLbl=new JLabel("Student Contact");
		studentContactLbl.setBounds(40,200,150,30);
		JTextField studentContact=new JTextField();
		studentContact.setBounds(150,200,150,30);
		JLabel error = new JLabel("Insert correct information");
		error.setBounds(300,400,150,30);
		error.setVisible(false);
		JButton add = new JButton("Issue Book");
		add.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
				boolean success;
				try {
					Integer.parseInt(studentContact.getText());
					Integer.parseInt(studentId.getText());
					success=true;
				}
				catch(Exception e1){
					success=false;
				}
				if(!(callNum.getText().equals("")||studentId.getText().equals("")||studentName.getText().equals("")||studentContact.getText().equals(""))&&success) {
					application.Book issuedBook= me.checkBook(callNum.getText());
					if(issuedBook!=null) {
						application.Student entry = new application.Student(Integer.parseInt(studentId.getText()),studentName.getText(),studentContact.getText(),issuedBook);
		           		if(me.issueBook(entry)) {
		           			JOptionPane.showMessageDialog(frame, "Book Issued Successfully");
			           		frame.setVisible(false);
			            	frame.dispose();
			           		librarianSection();	
		           		}
		           		else {
		           			error.setVisible(true);
							error.setForeground(Color.red);
							error.setText("The Book is sold out");
		           		}
					}
					else {
						error.setVisible(true);
						error.setForeground(Color.red);
						error.setText("No Book with that call number");
					}
				}
				else {
					error.setVisible(true);
					error.setForeground(Color.red);
				}
		        }  
		    });
		JButton back = new JButton("Back");
		back.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
				frame.setVisible(false);
            	frame.dispose();
           		librarianSection();
		        }  
		    });
		back.setBounds(80,400,100,30);
		add.setBounds(150,350,130,30);
		panel.add(add);panel.add(error);panel.add(studentContact);panel.add(studentContactLbl);panel.add(studentName);panel.add(studentNameLbl);panel.add(studentId);panel.add(studentIdLbl);
		panel.add(callNum);panel.add(callNumLbl);panel.add(title);panel.add(back);
		frame.add(panel);
		frame.setSize(500,500);
		frame.setVisible(true);
	}
	private static void viewIssuedBooks() {
		JFrame frame=new JFrame();
		String [] columns = new String[] {
			"id", "Book Call No", "Student ID", "Student Name" , "Student Contact", "Issue Date" 
		};
		JTable table = new JTable(me.viewIssuedBooks(),columns);
		frame.add(new JScrollPane(table));
		frame.setSize(500,500);
		frame.setVisible(true);
	}
	private static void returnBook() {
		JFrame frame=new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel=new JPanel();
		panel.setLayout(null);
		JLabel title=new JLabel("Issue Book");
		title.setBounds(175,0,150,30);
		JLabel callNumLbl=new JLabel("Call No.");
		callNumLbl.setBounds(40,50,150,30);
		JTextField callNum=new JTextField();
		callNum.setBounds(150,50,150,30);
		JLabel idLbl=new JLabel("ID");
		idLbl.setBounds(40,100,150,30);
		JTextField id = new JTextField();
		id.setBounds(150,100,150,30);
		JLabel error = new JLabel("Insert correct information");
		error.setBounds(300,200,150,30);
		error.setVisible(false);
		JButton add = new JButton("Issue Book");
		add.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
				boolean success;
				try {
					Integer.parseInt(id.getText());
					success=true;
				}
				catch(Exception e1){
					success=false;
				}
				if(!(callNum.getText().equals("")||id.getText().equals(""))&&success) {
					application.Student returnedBook= me.checkIssuedBook(callNum.getText(),Integer.parseInt(id.getText()));
					if(returnedBook!=null) {
						me.returnBook(returnedBook);
						JOptionPane.showMessageDialog(frame, "Book returned Successfully");
		           		frame.setVisible(false);
		            	frame.dispose();
		           		librarianSection();	
					}
					else {
						error.setVisible(true);
						error.setForeground(Color.red);
						error.setText("No Book with that call number");
					}
				}
				else {
					error.setVisible(true);
					error.setForeground(Color.red);
				}
		        }  
		    });
		JButton back = new JButton("Back");
		back.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
				frame.setVisible(false);
            	frame.dispose();
           		librarianSection();
		        }  
		    });
		back.setBounds(80,200,100,30);
		add.setBounds(150,150,130,30);
		panel.add(add);panel.add(error);panel.add(id);panel.add(idLbl);panel.add(callNum);panel.add(callNumLbl);panel.add(title);panel.add(back);
		frame.add(panel);
		frame.setSize(500,500);
		frame.setVisible(true);
	}
}
