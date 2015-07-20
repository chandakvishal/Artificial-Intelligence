/*
 * The main function:
 * 1. Asks the User to define the second player.
 * 2. Asks the user which chance it wants to play (i.e even or odd)
 * 3. Uses Switch Case to redirect the input provided to the respective functions.
 * 4. In case of a wrong input, exits the program.
 */

import java.util.Scanner;
public class tic_tac_toe 
{
	static int winpos = 0;
	public static void main(String args[]) throws InterruptedException
	{
		Scanner sc = new Scanner(System.in);
		int board[] = new int[10];
		int i, choice;
		for(i = 1;i < 10;i++)
			board[i] = 2;
		System.out.println("Enter 1 to Play with Player");
		System.out.println("Enter 2 to Play with Computer");
		choice = sc.nextInt();
		switch(choice)
		{
		case 1: playervsplayer.play(board);
			break;
		case 2:
			System.out.println("Press 1 for Computer to Play First");
			System.out.println("Press 2 for Player to Play First");
			int ch = sc.nextInt();
				if(ch == 1)
					compvsplayer.play(board);
				else
					playervscomp.play(board);
			break;
		default: System.out.println("Program exiting due to wrong choice");
				 System.exit(0);
		}
		sc.close();
	}
	/*
	 * Displays the tic-tac-toe board after every move
	 */
	protected static void display(int board[], int j) throws InterruptedException
	{
		System.out.println();
		System.out.println("After Player " + j % 2);
		System.out.println();
		for(int i = 1;i < 10;i++)
		{
			System.out.print((board[i] == 2?' ':board[i] == 3?'X':'O') + "|");
			if(i % 3 == 0)
				System.out.println();
		}
	}
	/*
	 * Calculates the possible winning position of the other player and blocks it.
	 * If no winning or vulnerable position found return 0.
	 * For details about the algorithm to calculate the winning position,refer "algorithm.txt".
	 */
	protected static int Posswin(int board[],char c)
	{
		int val = 0;
		winpos = 0;
		if(c == 'X')
			val = 18;
		else
			val = 50;		
		for(int i = 1;i < 8;i+=3)
		{
			if(board[i]*board[i+1]*board[i+2] == val)
			{	
				if(board[i] == 2)
					winpos = i;
				else if(board[i+1] == 2)
					winpos = i+1;
				else if(board[i+2] == 2)
					winpos = i+2;
				return 1;
			}
		}
		for(int i = 1;i < 4;i++)
		{
			if(board[i]*board[i+3]*board[i+6] == val)
			{
				if(board[i] == 2)
					winpos = i;
				else if(board[i+3] == 2)
					winpos = i+3;
				else if(board[i+6] == 2)
					winpos = i+6;
				return 1;
			}
		}				
		if(board[1]*board[5]*board[9] == val)	
		{
			if(board[1] == 2)
				winpos = 1;
			else if(board[5] == 2)
				winpos = 5;
			else if(board[9] == 2)
				winpos = 9;
			return 1;
		}
		else if(board[7]*board[5]*board[3] == val)	
		{
			if(board[7] == 2)
				winpos = 7;
			else if(board[5] == 2)
				winpos = 5;
			else if(board[3] == 2)
				winpos = 3;
			return 1;
		}
		return 0;		
	}
	/*
	 * Places the requred move at the specified position
	 */
	protected static void go(int board[], int n, int turn)
	{
		if(turn % 2 ==0)
			board[n] = 5;
		else
			board[n] = 3;
	}
	/*
	 * Checks for winning position.
	 */
	protected static int win(int board[], int turn)
	{
		int val = (turn % 2 != 0) ? 27 : 125;
		if(board[1]*board[2]*board[3] == val || board[4]*board[5]*board[6] == val || board[7]*board[8]*board[9] == val)
			return val;
		if(board[1]*board[4]*board[7] == val || board[2]*board[5]*board[8] == val || board[3]*board[6]*board[9] == val)
			return val;
		if(board[1]*board[5]*board[9] == val || board[3]*board[5]*board[7] == val)
			return val;
		return 0;	
	}
}