package main;

import java.util.Scanner;

public class Main{
	static public void main(String[] args)
	{
		MagicOfBook mob = new MagicOfBook();
		Scanner sc = new Scanner(System.in);
		mob.mainOptions(sc);
		System.out.println("Program finishes");
	}
}
