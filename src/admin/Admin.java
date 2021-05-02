package admin;

import java.util.ArrayList;

import librarian.Librarian;

public class Admin {
	static ArrayList <Librarian> librarians = new ArrayList <Librarian>(0);
	public static ArrayList <application.Student> students = new ArrayList <application.Student>(0);
	static final String password = "password";
	static final String username="admin"; 
	
	static void addLib(Librarian newEntry) {
		librarians.add(newEntry);
		newEntry.id=librarians.indexOf(newEntry);
	}
	static void addStudent(application.Student newEntry) {
		students.add(newEntry);
		newEntry.id=students.indexOf(newEntry);
	}
	static Object[][] view() {
		Object[][] libTable = new Object[librarians.size()][7];
		for(int i=0;i<librarians.size();i++) {
			libTable[i]=librarians.get(i).toArray();
		}
		return libTable;
	}
	static boolean delete(int id) {
		for(int i=0;i<librarians.size();i++) {
			if(librarians.get(i).id==id) {
				librarians.remove(i);
				return true;
			}
		}
		return false;
	}
	public static Librarian checkUser(String user,String pass) {
		for(int i=0;i<librarians.size();i++) {
			if(librarians.get(i).getUsername().equals(user)&&librarians.get(i).getPass().equals(pass)){
				return librarians.get(i);
			}
		}
		return null;
	}
}
