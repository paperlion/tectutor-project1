package main;

import java.util.Scanner;

public class Book {
	private static int numBooks = 0;
	
	private int id;
	private String name;
	private String author;
	private String description;
	
	public Book(String name, String author, String description)
	{
		this.id = numBooks ++;
		this.name = name;
		this.author = author;
		this.description = description;
	}
	
	public static Book input(Scanner sc)
	{
		System.out.println("Please type in the book name:");
		String name = sc.next();
		System.out.println("Please type in the author:");
		String author = sc.next();
		System.out.println("Please type in the description:");
		String description = sc.next();
		return new Book(name, author, description);
		
	}
	
	public int getId()
	{
		return id;
	}
	
	public String toString()
	{
		return String.format("{id:%d, name:%s, author:%s, description:%s}", id, name, author, description);
	}
}
