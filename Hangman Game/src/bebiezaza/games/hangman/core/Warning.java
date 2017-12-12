package bebiezaza.games.hangman.core;

import java.util.Scanner;

public class Warning
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		
		System.out.println("\n1.Don't type in more than 1 letter");
		System.out.println("or else it will break the game");
		System.out.println("and you need to restart this game");
		
		System.out.println("\nMore will come if bug is found");

		System.out.println("\nPress any key then enter to continue");
		
		String f_00001_a_ = input.next();

		HangmanCore.main(args);
	}
}
