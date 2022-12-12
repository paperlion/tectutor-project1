package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class User {
	private static int numUsers = 0;
	
	private int userId;
	private String userName;
	private String password;
	private String email;
	private List<Book> newBooks;
	private List<Book> favourite;
	private List<Book> completed;
	
	public User(String userName, String password, String email)
	{
		this.userId = numUsers++;
		this.userName = userName;
		this.password = password;
		this.email = email;
		newBooks = new ArrayList<>();
		favourite = new ArrayList<>();
		completed = new ArrayList<>();
	}
	
	public boolean verify(String username, String password)
	{
		if (Objects.equals(this.userName, username) && Objects.equals(this.password, password))
		{
			return true;
		}
		return false;
	}
	
	public List<Book> getNews()
	{
		return newBooks;
	}
	
	public List<Book> getFavourite()
	{
		return favourite;
	}
	
	public List<Book> getCompleted()
	{
		return completed;
	}
	
	public String toString()
	{
		return String.format("{userId:%d, userName:%s, email:%s, newBooksNumber:%d, favouriteNumber:%d, completedNumber:%d}", 
				userId, userName, email, newBooks.size(), favourite.size(), completed.size()); 
	}
}
