package admin;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import application.Library;

public class AdminUI {
	public static void login() {
		JFrame frame=new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel=new JPanel();
		panel.setLayout(null);
		JLabel title=new JLabel("Admin Login Form");
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
		login.setBounds(100,180,100,30);
		JLabel incorrect =new JLabel("Name or Password is incorrect");
		incorrect.setBounds(10, 150, 190, 30);
		incorrect.setVisible(false);
		login.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
			        if(user.getText().equals(Admin.username) && pass.getText().equals(Admin.password)) {
			        	frame.setVisible(false);
			            frame.dispose();
			            adminSection();
			        }
			        else {
			        	incorrect.setForeground(Color.red);
			        	incorrect.setVisible(true);
			        }
			        }  
			    }); 
		panel.add(title);panel.add(userLbl);panel.add(passLbl);panel.add(user);panel.add(pass);panel.add(login);panel.add(incorrect);
		frame.add(panel);
		frame.setSize(300,300);
		frame.setVisible(true);
	}
	private static void adminSection() {
		JFrame frame=new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel=new JPanel();
		panel.setLayout(null);
		JLabel title=new JLabel("Admin Section");
		title.setBounds(100,0,120,20);
		JButton addLib=new JButton("Add Librarian");
		addLib.setBounds(70, 30, 160, 40);
		JButton viewLib=new JButton("View Librarian");
		viewLib.setBounds(70, 90, 160, 40);
		JButton delLib=new JButton("Delete Librarian");
		delLib.setBounds(70, 210, 160, 40);
		JButton addStudent=new JButton("Add Student");
		addStudent.setBounds(70, 150, 160, 40);
		JButton logout=new JButton("Logout");
		logout.setBounds(70, 270, 160, 40);
		addLib.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
				frame.setVisible(false);
            	frame.dispose();
           		addLib();
		        }  
		    });
		viewLib.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
           		viewLib();
		        }  
		    });
		delLib.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
				frame.setVisible(false);
            	frame.dispose();
           		delLib();
		        }  
		    });
		addStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				frame.dispose();
				addStudent();
			}
		});
		logout.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
					frame.setVisible(false);
	            	frame.dispose();
	            	String[] st = null;
	           		Library.main(st);
			        }  
			    });
		panel.add(logout);panel.add(addLib);panel.add(title);panel.add(viewLib);panel.add(delLib);panel.add(addStudent);
		frame.setSize(300,400);
		frame.add(panel);
		frame.setVisible(true);
	}
	private static void addLib() {
		JFrame frame=new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel=new JPanel();
		panel.setLayout(null);
		JLabel title=new JLabel("Add Librarian");
		title.setBounds(175,0,150,30);
		JLabel userLbl=new JLabel("Username");
		userLbl.setBounds(80,50,150,30);
		JTextField user=new JTextField();
		user.setBounds(150,50,150,30);
		JLabel passLbl=new JLabel("Password");
		passLbl.setBounds(80,100,150,30);
		JPasswordField pass = new JPasswordField();
		pass.setBounds(150,100,150,30);
		JLabel emailLbl=new JLabel("E-mail");
		emailLbl.setBounds(80,150,150,30);
		JTextField email=new JTextField();
		email.setBounds(150,150,150,30);
		JLabel addressLbl=new JLabel("Address");
		addressLbl.setBounds(80,200,150,30);
		JTextField address=new JTextField();
		address.setBounds(150,200,150,30);
		JLabel cityLbl=new JLabel("City");
		cityLbl.setBounds(80,250,150,30);
		JTextField city=new JTextField();
		city.setBounds(150,250,150,30);
		JLabel contactNumLbl=new JLabel("Contact Number");
		contactNumLbl.setBounds(50,300,150,30);
		JLabel error = new JLabel("Insert correct information");
		error.setBounds(300,400,150,30);
		error.setVisible(false);
        JTextField contactNum = new JTextField();
		contactNum.setBounds(150,300,150,30);
		JButton add = new JButton("Add Librarian");
		add.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
				boolean success;
				try {
					Integer.parseInt(contactNum.getText());
					success=true;
				}
				catch(Exception e1){
					success=false;
				}
				if(!(user.getText().equals("")||pass.getText().equals("")||email.getText().equals("")||address.getText().equals("")||city.getText().equals("")||contactNum.getText().equals(""))&&success) {
					librarian.Librarian entry = new librarian.Librarian(user.getText(),pass.getText(),email.getText(),address.getText(),city.getText(),contactNum.getText());
	           		Admin.addLib(entry);
	           		JOptionPane.showMessageDialog(frame, "Librarian Added Successfully");
	           		frame.setVisible(false);
	            	frame.dispose();
	           		AdminUI.adminSection();
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
           		adminSection();
		        }  
		    });
		back.setBounds(80,400,100,30);
		panel.add(title);panel.add(user);panel.add(pass);panel.add(email);panel.add(address);panel.add(city);panel.add(contactNum);panel.add(add);panel.add(back);panel.add(userLbl);panel.add(passLbl);panel.add(emailLbl);panel.add(addressLbl);panel.add(cityLbl);panel.add(contactNumLbl);panel.add(error);
		frame.add(panel);
		frame.setSize(500,500);
		frame.setVisible(true);
	}
	private static void viewLib() {
		JFrame frame=new JFrame();
		String [] columns = new String[] {
			"id", "Name", "Password", "Email" , "Address" , "City" , "Contact"
		};
		JTable table = new JTable(Admin.view(),columns);
		frame.add(new JScrollPane(table));
		frame.setSize(500,500);
		frame.setVisible(true);
	}
	private static void delLib() {
		JFrame frame=new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel=new JPanel();
		panel.setLayout(null);
		JLabel title=new JLabel("Delete Librarian");
		title.setBounds(175,0,150,30);
		JLabel idLbl = new JLabel("Enter id");
		idLbl.setBounds(80,50,150,30);
		JTextField id = new JTextField();
		id.setBounds(150, 50, 150, 30);
		JButton confirm = new JButton("Confirm");
		confirm.setBounds(150, 100, 100, 50);
		JButton back = new JButton("Back");
		back.setBounds(200, 160, 90, 40);
		JLabel error = new JLabel("Check id properly");
		error.setBounds(50, 160, 90, 40);
		error.setVisible(false);
		panel.add(title);panel.add(idLbl);panel.add(id);panel.add(confirm);panel.add(back);panel.add(error);
		frame.add(panel);
		frame.setSize(500,300);
		frame.setVisible(true);
		confirm.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
				boolean success;
				try {
					Integer.parseInt(id.getText());
					success=true;
				}
				catch(Exception e1){
					success=false;
				}
           		if(success&&Admin.delete(Integer.parseInt(id.getText()))) {
           			JOptionPane.showMessageDialog(frame, "Librarian Deleted Successfully");
           			frame.setVisible(false);
                	frame.dispose();
               		AdminUI.adminSection();
           		}
           		else {
           			error.setVisible(true);
           			error.setForeground(Color.red);
           		}
		        }  
		    });
		back.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
				frame.setVisible(false);
            	frame.dispose();
           		AdminUI.adminSection();
		        }  
		    });
	}
	private static void addStudent() {
		JFrame frame=new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel=new JPanel();
		panel.setLayout(null);
		JLabel title=new JLabel("Add Student");
		title.setBounds(175,0,150,30);
		JLabel idLbl=new JLabel("Student ID");
		idLbl.setBounds(30,50,150,30);
		JTextField id=new JTextField();
		id.setBounds(150,50,150,30);
		JLabel nameLbl=new JLabel("Student Name");
		nameLbl.setBounds(30,100,150,30);
		JTextField name = new JTextField();
		name.setBounds(150,100,150,30);
		JLabel contactLbl=new JLabel("Student Contact");
		contactLbl.setBounds(30,150,150,30);
		JTextField contact=new JTextField();
		contact.setBounds(150,150,150,30);
		JLabel passLbl=new JLabel("Student Password");
		passLbl.setBounds(30,200,150,30);
		JPasswordField pass=new JPasswordField();
		pass.setBounds(150,200,150,30);
		JLabel error = new JLabel("Insert correct information");
		error.setBounds(300,250,150,30);
		error.setVisible(false);
		JButton add = new JButton("Add Student");
		add.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
				boolean success;
				try {
					Integer.parseInt(id.getText());
					Integer.parseInt(contact.getText());
					success=true;
				}
				catch(Exception e1){
					success=false;
				}
				if(!(name.getText().equals("")||id.getText().equals("")||contact.getText().equals("")||pass.getText().equals(""))&&success) {
					application.Student entry = new application.Student(Integer.parseInt(id.getText()),name.getText(),contact.getText(),pass.getText());
	           		Admin.addStudent(entry);
	           		JOptionPane.showMessageDialog(frame, "Student Added Successfully");
	           		frame.setVisible(false);
	            	frame.dispose();
	           		AdminUI.adminSection();
				}
				else {
					error.setVisible(true);
					error.setForeground(Color.red);
				}
		        }  
		    });
		add.setBounds(150,250,130,30);
		JButton back = new JButton("Back");
		back.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
				frame.setVisible(false);
            	frame.dispose();
           		adminSection();
		        }  
		    });
		back.setBounds(80,300,100,30);
		panel.add(title);panel.add(name);panel.add(contact);panel.add(id);panel.add(nameLbl);panel.add(contactLbl);panel.add(idLbl);panel.add(add);panel.add(back);panel.add(passLbl);panel.add(pass);
		panel.add(error);frame.add(panel);
		frame.setSize(400,400);
		frame.setVisible(true);
	}
}
