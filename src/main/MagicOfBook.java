package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class MagicOfBook {
	private List<User> users;
	private List<Book> books;
	
	User currUser;
	
	public MagicOfBook()
	{
		users = new ArrayList<>();
		books = new ArrayList<>();
		
		currUser = null;
		
	}
	
	public void listAllUsers()
	{
		System.out.println("List all users:");
		for (User u : users)
		{
			System.out.println(u);
		}
	}
	
	public void listAllBooks()
	{
		System.out.println("List all books:");
		for (Book b : books)
		{
			System.out.println(b);
		}
	}
	
	public void addUser(Scanner sc) {
		System.out.println("Please type in the username:");
		String username = sc.nextLine();
		System.out.println("Please type in the password:");
		String password = sc.nextLine();
		System.out.println("Please type in the email:");
		String email = sc.nextLine();
		User newUser = new User(username, password, email);
		users.add(newUser);
		System.out.println("New user added.");
	}
	
	public void addBook(Scanner sc) {
		System.out.println("Please type in the book name:");
		String name = sc.nextLine();
		System.out.println("Please type in the author:");
		String author = sc.nextLine();
		System.out.println("Please type in the description:");
		String description = sc.nextLine();
		Book newBook = new Book(name, author, description);
		books.add(newBook);
		System.out.println("New book added.");
	}
	
	public void login(Scanner sc)
	{
		System.out.println("Please type in the username:");
		String username = sc.nextLine();
		System.out.println("Please type in the password:");
		String password = sc.nextLine();
		for(User user : users)
		{
			if (user.verify(username, password))
			{
				currUser = user;
				System.out.println("log in success!");
				return;
			}
		}
		System.out.println("Login failed : wrong username or password.");
	}
	
	public void addBookToUser(Scanner sc, String type)
	{
		System.out.println("Please type in the book id:");
		int id = sc.nextInt();
		sc.nextLine();
		Book book = null;
		for (Book b : books)
		{
			if (b.getId() == id)
			{
				book = b;
			}
		}
		if (book != null)
		{
			if (Objects.equals(type, "new"))
			{
				currUser.getNews().add(book);
			}
			else if (Objects.equals(type, "favourite"))
			{
				currUser.getFavourite().add(book);
			}
			else if (Objects.equals(type, "completed"))
			{
				currUser.getCompleted().add(book);
			}
			System.out.println("Add success");
		}
		else {
			System.out.println("Add failed : cannot find the book");
		}
	}
	
	public void printBookByUser(String type)
	{
		List<Book> books = null;
		if (Objects.equals(type, "new"))
		{
			books = currUser.getNews();
		}
		else if (Objects.equals(type, "favourite"))
		{
			books = currUser.getFavourite();
		}
		else if (Objects.equals(type, "completed"))
		{
			books = currUser.getCompleted();
		}
		for (Book b : books)
		{
			System.out.println(b);
		}
	}
	
	public void printBookById(Scanner sc)
	{
		System.out.println("Please type in the book id:");
		int id = sc.nextInt();
		sc.nextLine();
		for (Book b : books)
		{
			if (b.getId() == id)
			{
				System.out.println(b);
				return;
			}
		}
		System.out.println("Cannot find that book.");
	}
	
	public void subOptions(Scanner sc)
	{
		while(true) {
			System.out.println(String.format("Welcome - %s:", currUser));
			System.out.println("---------------------------------------");
			System.out.println("1 - list my new books");
			System.out.println("2 - list my favourite books");
			System.out.println("3 - list my completed books");
			System.out.println("4 - add a new book");
			System.out.println("5 - add a book to favourite");
			System.out.println("6 - add a book to completed");
			System.out.println("7 - list all books");
			System.out.println("8 - logout");
			System.out.println("Please type in your instruction:");
			int instruction = sc.nextInt();
			sc.nextLine();
			if (instruction == 1)
			{
				printBookByUser("new");
			}
			else if (instruction == 2)
			{
				printBookByUser("favourite");
			}
			else if (instruction == 3)
			{
				printBookByUser("completed");
			}
			else if (instruction == 4)
			{
				addBookToUser(sc, "new");
			}
			else if (instruction == 5)
			{
				addBookToUser(sc, "favourite");
			}
			else if (instruction == 6)
			{
				addBookToUser(sc, "completed");
			}
			else if (instruction == 7)
			{
				listAllBooks();
			}
			else if (instruction == 8)
			{
				currUser = null;
				return;
			}
		}
	}
	
	
	public void mainOptions(Scanner sc)
	{	
		while (true)
		{
			System.out.println("---------------------------------------");
			System.out.println("Instructions : ");
			System.out.println("1 - login");
			System.out.println("2 - add new user");
			System.out.println("3 - add new book");
			System.out.println("4 - list all users");
			System.out.println("5 - list all books");
			System.out.println("6 - exit");
			System.out.println("Please type in your instruction:");
			int instruction = sc.nextInt();
			sc.nextLine();
			if (instruction == 1)
			{
				login(sc);
				if (currUser != null)
				{
					subOptions(sc);
				}
			}
			else if (instruction == 2)
			{
				addUser(sc);
			}
			else if (instruction == 3)
			{
				addBook(sc);
			}
			else if (instruction == 4)
			{
				listAllUsers();
			}
			else if (instruction == 5)
			{
				listAllBooks();
			}
			else if (instruction == 6)
			{
				return;
			}
		}
	}
	
}
