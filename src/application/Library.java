package application;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Files;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import admin.AdminUI;
import librarian.LibrarianUI;

public class Library {

	public static void main(String[] args) {
		application.Files.readLibrarians();
		application.Files.readStudents();
		application.Files.readBooks();
		application.Files.readIssuedBooks();
		JFrame frame=new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel=new JPanel();
		panel.setLayout(null);
		JButton adminLogin=new JButton("Admin Login");
		adminLogin.setBounds(80,50,200,70);
		adminLogin.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
			            frame.setVisible(false);
			            frame.dispose();
			            AdminUI.login();
			        }  
			    }); 
		JButton librarianLogin=new JButton("Librarian Login");
		librarianLogin.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
			            frame.setVisible(false);
			            frame.dispose();
			            LibrarianUI.login();
			        }  
			    });
		librarianLogin.setBounds(80, 150, 200, 70);
		JButton studentLogin=new JButton("Student Login");
		studentLogin.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
			            frame.setVisible(false);
			            frame.dispose();
			            Student.login();
			        }  
			    });
		studentLogin.setBounds(80, 250, 200, 70);
		JLabel title=new JLabel("Library Management");
		title.setBounds(125, 0, 150, 50);
		panel.add(title);panel.add(adminLogin);panel.add(librarianLogin);panel.add(studentLogin);
		frame.add(panel);
		frame.setSize(400,380);
		frame.setVisible(true);
	}

}
