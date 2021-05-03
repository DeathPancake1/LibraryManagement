package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Files {
	public static void readLibrarians() {
		admin.Admin.librarians.removeAll(admin.Admin.librarians);
		File libFile = new File("Librarians.txt");
		try {
			libFile.createNewFile();
		} catch (IOException e1) {
			System.out.println("An error occurred.");
			e1.printStackTrace();
		}
		try {
		      Scanner myReader = new Scanner(libFile);
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine(),username = null,pass = null,email = null,address = null,city = null,contactNum = null;
		        StringTokenizer token = new StringTokenizer(data,"/");  
		        int j=0;
		        while (token.hasMoreTokens()) {  
		            switch(j) {
		            case 0:
		            	username = token.nextToken();
		            	break;
		            case 1:
		            	pass = token.nextToken();
		            	break;
		            case 2:
		            	email = token.nextToken();
		            	break;
		            case 3:
		            	address = token.nextToken();
		            	break;
		            case 4:
		            	city = token.nextToken();
		            	break;
		            case 6:
		            	contactNum = token.nextToken();
		            	j=0;
		            	break;
		            }
		            j++;
		        } 
		        librarian.Librarian newEntry = new librarian.Librarian(username, pass, email, address, city, contactNum);
		        admin.Admin.librarians.add(newEntry);
		        newEntry.id=admin.Admin.librarians.indexOf(newEntry);
		      }
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
	public static void saveLibrarians() {
		try {
		      FileWriter myWriter = new FileWriter("Librarians.txt");
		      for(int i=0;i<admin.Admin.librarians.size();i++) {
		    	  myWriter.write(admin.Admin.librarians.get(i).getUsername()+"/"+admin.Admin.librarians.get(i).getPass()+"/"+admin.Admin.librarians.get(i).email+"/"+admin.Admin.librarians.get(i).address+"/"+admin.Admin.librarians.get(i).city+"/"+admin.Admin.librarians.get(i).contactNum+"\n");
		      }
		      myWriter.close();
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
	public static void readStudents() {
		admin.Admin.students.removeAll(admin.Admin.students);
		File studentFile = new File("Students.txt");
		try {
			studentFile.createNewFile();
		} catch (IOException e1) {
			System.out.println("An error occurred.");
			e1.printStackTrace();
		}
		try {
		      Scanner myReader = new Scanner(studentFile);
		      while (myReader.hasNextLine()) {
		    	int studentid = 0;
		        String data = myReader.nextLine(),name = null,contact = null,pass = null;
		        StringTokenizer token = new StringTokenizer(data,"/");  
		        int j=0;
		        while (token.hasMoreTokens()) {  
		            switch(j) {
		            case 0:
		            	studentid = Integer.parseInt(token.nextToken());
		            	break;
		            case 1:
		            	name = token.nextToken();
		            	break;
		            case 2:
		            	contact = token.nextToken();
		            	break;
		            case 3:
		            	pass = token.nextToken();
		            	j=0;
		            	break;
		            }
		            j++;
		        } 
		        Student newEntry = new Student(studentid,name,contact,pass);
		        admin.Admin.students.add(newEntry);
		        newEntry.id=admin.Admin.students.indexOf(newEntry);
		      }
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
	public static void saveStudents() {
		try {
		      FileWriter myWriter = new FileWriter("Students.txt");
		      for(int i=0;i<admin.Admin.students.size();i++) {
		    	  myWriter.write(admin.Admin.students.get(i).studentId+"/"+admin.Admin.students.get(i).name+"/"+admin.Admin.students.get(i).contact+"/"+admin.Admin.students.get(i).pass+"\n");
		      }
		      myWriter.close();
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
	public static void readBooks() {
		librarian.Librarian.bookList.removeAll(librarian.Librarian.bookList);
		File bookFile = new File("Books.txt");
		try {
			bookFile.createNewFile();
		} catch (IOException e1) {
			System.out.println("An error occurred.");
			e1.printStackTrace();
		}
		try {
		      Scanner myReader = new Scanner(bookFile);
		      while (myReader.hasNextLine()) {
		    	  int quantity =0;
		        String data = myReader.nextLine(),callNum = null,name = null,author = null,publisher = null;
		        StringTokenizer token = new StringTokenizer(data,"/");  
		        int j=0;
		        while (token.hasMoreTokens()) {  
		            switch(j) {
		            case 0:
		            	callNum = token.nextToken();
		            	break;
		            case 1:
		            	name = token.nextToken();
		            	break;
		            case 2:
		            	author = token.nextToken();
		            	break;
		            case 3:
		            	publisher = token.nextToken();
		            	break;
		            case 4:
		            	quantity = Integer.parseInt(token.nextToken());
		            	j=0;
		            	break;
		            }
		            j++;
		        } 
		        Book newEntry = new Book(callNum,name,author,publisher,quantity);
		        librarian.Librarian.bookList.add(newEntry);
		        newEntry.id=librarian.Librarian.bookList.indexOf(newEntry);
		      }
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
	public static void saveBooks() {
		try {
		      FileWriter myWriter = new FileWriter("Books.txt");
		      for(int i=0;i<librarian.Librarian.bookList.size();i++) {
		    	  myWriter.write(librarian.Librarian.bookList.get(i).callNum+"/"+librarian.Librarian.bookList.get(i).name+"/"+librarian.Librarian.bookList.get(i).author+"/"+librarian.Librarian.bookList.get(i).publisher+"/"+librarian.Librarian.bookList.get(i).quantity+"\n");
		      }
		      myWriter.close();
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
	public static void readIssuedBooks() {
		librarian.Librarian.issuedBooks.removeAll(librarian.Librarian.issuedBooks);
		File issuedBooksFile = new File("Issued Books.txt");
		try {
			issuedBooksFile.createNewFile();
		} catch (IOException e1) {
			System.out.println("An error occurred.");
			e1.printStackTrace();
		}
		try {
		      Scanner myReader = new Scanner(issuedBooksFile);
		      while (myReader.hasNextLine()) {
		    	  int studentId=0;
		    	  String data = myReader.nextLine(),callNum = null,name = null,contact = null,date = null;
		    	  StringTokenizer token = new StringTokenizer(data,"/");  
		    	  int j=0;
		    	  while (token.hasMoreTokens()) {  
		    		  switch(j) {
		    		  case 0:
		    			  callNum = token.nextToken();
		    			  break;
		    		  case 1:
		    			  studentId = Integer.parseInt(token.nextToken());
		    			  break;
		    		  case 2:
		    			  name = token.nextToken();
		    			  break;
		    		  case 3:
		    			  contact = token.nextToken();
		    			  break;
		    		  case 4:
		    			  date = token.nextToken();
		    			  j=0;
		    			  break;
		            }
		            j++;
		        } 
		        Book newEntry = new Book(callNum,studentId,date);
		        librarian.Librarian.issuedBooks.add(newEntry);
		        newEntry.id=librarian.Librarian.issuedBooks.indexOf(newEntry);
		      }
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
	public static void saveIssuedBooks() {
		try {
			FileWriter myWriter = new FileWriter("Issued Books.txt");
			for(int i=0;i<librarian.Librarian.issuedBooks.size();i++) {
				myWriter.write(librarian.Librarian.issuedBooks.get(i).callNum+"/"+librarian.Librarian.issuedBooks.get(i).student.studentId+"/"+librarian.Librarian.issuedBooks.get(i).student.name+"/"+librarian.Librarian.issuedBooks.get(i).student.contact+"/"+librarian.Librarian.issuedBooks.get(i).date+"\n");
		    }
			myWriter.close();
		}
		catch(IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
}
