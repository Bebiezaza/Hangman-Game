/******************************************************************************
 * Copyright 2017 Bebiezaza - Hangman
 *
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/license/by-nc-nd/4.0/
******************************************************************************/

package bebiezaza.games.hangman.client;

import java.util.Random;
import java.util.Scanner;

public class Play
{
	public Play()
	{
	}
	
	public void Start(int diff)
	{
		String words[] = new String [2];
		String hints[] = new String [2];
		
			switch(diff)
			{
				case 1:
					words[0] = "cat";
					hints[0] = "Animal.";
					words[1] = "breakfast";
					hints[1] = "Meals.";
					break;
				case 2:
					words[0] = "president";
					hints[0] = "Leader.";
					words[1] = "exclamation";
					hints[1] = "Shoutout.";
					break;
				case 3:
					words[0] = "rehabilitation";
					hints[0] = "Reform.";
					words[1] = "establishment";
					hints[1] = "Founding.";
			}
			
		String word;
		Random rand = new Random();
		int w1 = rand.nextInt(2);
		word = words[w1];
		String hint = hints[w1];
		String guess = "";
		int wl = word.length() +1;
			for(int i=1; i<wl; i++)
			{
				guess += "_";
			}
		
			String lu = "";
			int tt = 0;
			boolean canPlay = true;
			Main(guess, tt, canPlay, lu, word, hint);
	}

	private void Main(String guess, int tt, boolean canPlay, String lu, String word, String hint)
	{
		if(tt==6)
		{
			canPlay = false;
			Lose();
		}
		else
		{
			String man[] = new String[7];
			man[0] = " --\n   |\n   |\n   |\n_____\n";
			man[1] = " --\n o |\n   |\n   |\n_____\n";
			man[2] = " --\n o |\n/  |\n   |\n_____\n";
			man[3] = " --\n o |\n/| |\n   |\n_____\n";
			man[4] = " --\n o |\n/|\\|\n   |\n_____\n";
			man[5] = " --\n o |\n/|\\|\n/  |\n_____\n";
			man[6] = " --\n o |\n/|\\|\n/ \\|\n_____\n";
			char g1[] = guess.toCharArray();
			char w2[] = word.toCharArray();
			System.out.println(man[0]);
		
			for(int x=0; x<g1.length; x++)
			{
				System.out.print(g1[x]);
			}
			
			System.out.println();
			Guess(guess, tt, canPlay, lu, word, g1, w2, man, hint);
		}
	}

	private void Guess(String guess, int tt, boolean canPlay, String lu, String word, char[] g1, char[] w2, String[] man, String hint) 
	{
		String tg1 = new String(g1);
		String tg2 = new String(w2);
		
		if(tg1.equalsIgnoreCase(tg2))
		{
			Win();
		}
		else
		{
		
			if(tt == 6)
			{
				System.out.println("\n\nYou Lost! The word was : " + word);
				Lose();
			}
			else
			{
				Scanner input = new Scanner(System.in);
				System.out.println("Guess(" + hint + "): ");
				String letter = input.next();
				
				if(word.contains(letter))
				{
					if(lu.contains(letter))
					{
						tt +=1;
						System.out.println("Wrong!");
					}
					else
					{
						int wl = word.length();
						
						for(int i=0; i<wl; i++)
						{
							char aChar = letter.charAt(0);
							char bChar = w2[i];
							
							if(bChar==aChar)
							{
								g1[i] = aChar;
							}
						}
					}
				}
				else
				{
					tt +=1;
					System.out.println();
					System.out.println(man[tt]);
				}
				
				for(int x=0; x<g1.length; x++)
				{
					System.out.print(g1[x]);
				}
				
				System.out.println("\n\n");
				lu += letter;
				Guess(guess, tt, canPlay, lu, word,g1, w2, man, hint);
			}
		}
	}
	
	public void Lose()
	{
		Scanner input1 = new Scanner(System.in);
		System.out.print("\nPlay Again?(Y/N): ");
		String pa1 = input1.next();
		
		if(pa1.contains("y") || pa1.contains("Y"))
		{
			System.out.print("\nDifficulty(1-3) >>> ");
			int diff1 = input1.nextInt();
			Start(diff1);
		}
		else
		{
			
		}
	}
	
	public void Win()
	{
		System.out.println("\n\n\\o/\n | \n/ \\");
		System.out.println("You Won!\n");
		Scanner input2 = new Scanner(System.in);
		System.out.print("\nPlay Again?(Y/N): ");
		String pa = input2.next();
		if(pa.contains("y") || pa.contains("Y"))
		{
			System.out.print("\nDifficulty(1-3): ");
			int diff2 = input2.nextInt();
			Start(diff2);
		}
		else
		{
		}
	}
}
