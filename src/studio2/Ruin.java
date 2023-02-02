package studio2;

import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
		
		
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("What is your start amount?");
		int startAmount = in.nextInt();
	
		System.out.println("What is your chance of winning?");
		double winChance = in.nextDouble();
		
		System.out.println("What is your win limit?");
		int winLimit = in.nextInt();
		
		System.out.println("How many days are you going to the casino?");
		int days = in.nextInt();
		int winCount = 0;
		
		for (int j = 0; j < days; j++)
		{
			int currentBalance = startAmount;
			int i = 0;
			
			while ((currentBalance < winLimit) && (currentBalance > 0))
			{
			
				double wonLost = Math.random();
				
				if (wonLost > winChance)
				{
					currentBalance--;
					i++;
				}
				else 
				{
					currentBalance++;
					i++;
				}
			}
			
			if (currentBalance == winLimit)
			{
				winCount ++;
				System.out.println("Day " + j + ": " + i + " rounds. Success!");
			}
			else
			{
				System.out.println("Day " + j + ": " + i + " rounds. Ruin!");
			}
		}
		System.out.println("Number of days: " + days + ".");
		System.out.println("Win count: " + winCount + ".");
		
		double ruinRate = 1.0 - ((double)(winCount) / (double)(days));
		System.out.println("Aggregate ruin rate: " + ruinRate * 100 + "%.");
		
		
		double alpha = (1 - winChance)/winChance;
		double expectedRuin;
		
		if (winChance == 0.5)
		{
			expectedRuin = 1 - (double)(startAmount) / (double)(winLimit);
		}
		else
		{
			expectedRuin = (Math.pow(alpha, startAmount) - Math.pow(alpha, winLimit)) / (1.0 - Math.pow(alpha, winChance));
		}
		System.out.println("Your expected ruin rate is : " + expectedRuin * 100.0 + "%.");
		
		
		/*
		int currentBalance = startAmount;
		int i = 0;
		
		while ((currentBalance < winLimit) && (currentBalance > 0))
		{
		
			double wonLost = Math.random();
			
			if (wonLost > winChance)
			{
				currentBalance--;
				i++;
				System.out.println("Round " + i + ":");
				System.out.println("You lost! You now have $" + currentBalance + ".");
				System.out.println();
			}
			else 
			{
				currentBalance++;
				i++;
				System.out.println("Round " + i + ":");
				System.out.println("You won! You now have $" + currentBalance + ".");
				System.out.println();
			}
		}
		
		if (currentBalance == winLimit)
		{
			System.out.println("It was a successful day! You made $" + (winLimit - startAmount) + "!" );
		}
		else
		{
			System.out.println("It was a ruin! You lost $" + startAmount +"!");
		}
		*/
	}

}
