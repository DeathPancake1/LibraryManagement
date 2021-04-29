# LibraryManagement
## Problem Statement:
It is required to write a Java program with Swing interface to perform all the functions of the library system of an educational educational institute (e.g. university). The library has an admin and librarian.
## Implementation:
The program has 3 packages, we needed to slice up the classes into multiple packages so we can hide the vital information from other classes and methods so the system can be secure and only the admin or librarian can make vital changes that can influence how the database and the stored information in it. We are going to go throw each one of the packages to understand how each class inside them is implemented.
### Application packages:
This is the package that has the main method of the program and has the public classes that do not have critical information and every class in the program can access.
  1. Library Class:
    This class has the main method, in the main method we initialize a new frame, 2 buttons and a title label. These buttons allow us to either login to the admin panel or the librarian panel. It works by adding action listener to the buttons and access the login methods from admin.AdminUI and librarian.LibrarianUI.
  2. Student Class:
    This is the class that holds the information about the students like the id, name, contact and the book that is issued to him.
    There is also a toArray method that returns the information about the student and the book issued to him and the issued date in an array.
  3. Book Class:
    This is the class that holds information about each book in the program like the call number, name, author, publisher, and the available quantity of the book.
    It also has a method called toArray, this method returns an object array that has all the data items in the object, this is useful in creating the table to view all the books in the program.

### Admin package:
This package holds all the classes that are useful for the admin UI and the actions that the admin can do.
1. AdminUI Class:
This is the class that has all the UI methods.

    i) Login method:
    This method is the only public method in the package, this way the only way the main method could access the admin actions is if the user got the right username and password in the login methods so it can call the Admin Section method.
    
    ii) Admin Section method:
    This method when called initializes a frame that holds buttons for every action the admin can make and a logout button. When one of these buttons is pressed it shows a window for the action.
    
    iii) Add Librarian method:
    This method shows text boxes for every data that is necessary to be collected to create a new Librarian class instance. It checks if all the text boxes are not empty, and the contact number box only has numbers in it. Then it sends this data to the add method in the Admin class.
    
    iv) View Librarians method:
    This method displays a table that has the information about all the librarians in the data base.

    v) Delete Librarian method:
    This method asks the admin for the id for the librarian he wants to delete. He checks the table in the view librarian tab.
    
2. Admin Class:
This is the class that holds the information about the admin and the methods for the admin actions.

    i) Array of librarians:
    This array holds the information about the librarians in the program.
    
    ii) Static username and password:
    These Strings hold the login information for the admin, the username and password are static and are “admin” and “password” (Shhh! don’t tell anyone).

    iii) Static username and password:
    These Strings hold the login information for the admin.

    iv) Add method:
    This method gets a Librarian class as an argument, adds it to the librarians array and sets the id to the index of the librarian in the array.

    v) View method:
    This method calls the toArray method in the librarian class for every class in the array, then it puts this array in a row in a 2d object array and returns it. This is because the JTable only accepts 2d object arrays.

    vi) Delete method:
    This method takes the id that the user inputs as an argument is searches through the loop and if it finds a librarian with the same id it deletes it. If it does not find it, it returns false, so the user knows he did not delete a librarian.

    vii) Check User method:
    This method gets a username and a password as an argument, it checks the librarian array if there is a librarian with the same username and password it returns it. If not, it returns null. It is also public so it can be used from the LibrarianUI Class while not allowing it to access the librarians array.
  
### Librarian package:
This package holds all the classes that are useful for the librarian UI and the actions the librarian can do.
1. LibrarianUI Class:
This is the class that has all the UI methods.
    
    i) Login method:
    When you press the button, it gets the username and password from the text fields and sends them to the check user method in admin.
    
    ii) Librarian Section method:
    This method when called initializes a frame that holds buttons for every action the librarian can make and a logout button. When one of these buttons is pressed it shows a window for the action.
    
    iii) Add Book method:
    This method shows text boxes for every data that is necessary to be collected to create a new Book class instance. It checks if all the text boxes are not empty, and the quantity box only has numbers in it. Then it sends this data to the add method in the Librarian class.

    iv) View Books method:
    This method displays a table that has the information about all the Books in the data base.
    
    v) Issue Book method:
    This method asks the user for the information about the student the is renting the book and the book itself.

    vi) View Issued Books method:
    This method views all the issued books and puts them in a table.

    vii) Return Book method:
    This method asks the user for the id of the issued book and the call number of it and calls the return book method from the librarian class.

2. Librarian Class:
This is the class that holds the information about the librarian and the methods for the librarian actions.
    
    i) Array of books:
    This array holds the information about the books in the program.
    
    ii) Array of issued books:
    This array holds the data about the books that are issued in the program.

    iii) Id, username, password, email, address, city, contact number:
    This is all the information we need to know about the librarian, it is all private but the id is public so the admin can refer to it.
    
    iv) Librarian Constructor:
    This method gets the information about the Librarian and sets the values to these values.

    v) Add Book method:
    This method gets a Book class as an argument and adds it to the books array.

    vi) View Books method:
    This method uses the toArray method for every book class in the array that returns an array of all the information of the book class, it puts each array in a row in the 2d array of objects so it can be used in the JTable.

    vii) Issue Books:
    This method gets information about the book and the student that wants it as arguments and add this book to the list of issued books.

    viii) View Issued Books:
    This method when called returns a 2d object array of all the issued books in the issued books array.

    ix) Return Book:
    This method gets the student id and the book call number as arguments and deletes the book with this information from the issued books array.

    x) Get Username:
    This method returns the username String.

    xi) Get Pass:
    This method returns the password String.
    
    xii) To Array method:
    This method returns an array with all the information from the Librarian.

    xiii) Check Book method:
    This method checks if there is a book with the information provided by the user and if it has any quantity left and returns the book.
