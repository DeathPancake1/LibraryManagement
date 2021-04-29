package application;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import admin.AdminUI;
import librarian.LibrarianUI;

public class Library {

	public static void main(String[] args) {
		JFrame frame=new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel=new JPanel();
		panel.setLayout(null);
		JButton adminLogin=new JButton("Admin Login");
		adminLogin.setBounds(80,100,150,50);
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
		librarianLogin.setBounds(80, 200, 150, 50);
		JLabel title=new JLabel("Library Management");
		title.setBounds(90, 0, 150, 50);
		panel.add(title);panel.add(adminLogin);panel.add(librarianLogin);
		frame.add(panel);
		frame.setSize(300,300);
		frame.setVisible(true);
	}

}
