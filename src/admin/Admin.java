package admin;

import java.util.ArrayList;

import librarian.Librarian;

public class Admin {
	public static ArrayList <Librarian> librarians = new ArrayList <Librarian>(0);
	public static ArrayList <application.Student> students = new ArrayList <application.Student>(0);
	static final String password = "password";
	static final String username="admin"; 
	
	static void addLib(Librarian newEntry) {
		librarians.add(newEntry);
		newEntry.id=librarians.indexOf(newEntry);
		application.Files.saveLibrarians();
	}
	static void addStudent(application.Student newEntry) {
		students.add(newEntry);
		newEntry.id=students.indexOf(newEntry);
		application.Files.saveStudents();
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
				application.Files.saveLibrarians();
				return true;
			}
		}
		return false;
	}
	public static Librarian checkLibrarian(String user,String pass) {
		for(int i=0;i<librarians.size();i++) {
			if(librarians.get(i).getUsername().equals(user)&&librarians.get(i).getPass().equals(pass)){
				return librarians.get(i);
			}
		}
		return null;
	}
	public static application.Student checkStudent(String user,String pass) {
		for(int i=0;i<students.size();i++) {
			if(students.get(i).name.equals(user)&&students.get(i).pass.equals(pass)){
				return students.get(i);
			}
		}
		return null;
	}
	public static application.Student checkStudent(int id){
		for(int i=0;i<students.size();i++) {
			if(students.get(i).studentId==id) {
				return students.get(i);
			}
		}
		return null;
	}
}
