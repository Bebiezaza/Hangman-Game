package bebiezaza.games.hangman.core;

import java.util.Scanner;

import bebiezaza.games.hangman.client.Play;

public class HangmanCore
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Welcome to Hangman (Version " + Reference.Version + ")");
		
		System.out.println("Select difficulty(1 - 3) / see warning press (0): ");
		int diff = scan.nextInt();
		
		if(diff==0)
		{
			Warning.main(args);
		}
		
		else if(diff==1)
		{
			System.out.println("You choose EASY mode");
			Play obj = new Play();
			obj.Start(diff);
		}
		
		else if(diff==2)
		{
			System.out.println("You choose MEDIUM mode");
			Play obj = new Play();
			obj.Start(diff);
		}
		
		else if(diff==3)
		{
			System.out.println("You choose HARD mode");
			Play obj = new Play();
			obj.Start(diff);
		}
		
		else
		{
			System.out.println("Input Failed!\n\n\n\n\n");
			HangmanCore.main(args);
		}
	}
}
