/*
 * This class simply asks the player for an input and places the corresponding
 * character at the specified position.
 * If the position opted by the player is not empty, the player is again asked for the position
 */

import java.util.Scanner;
public class player extends tic_tac_toe
{ 
	public static void move(int board[], int i)
	{
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		boolean flag = false;
		int n;
		do
		{
		System.out.println("Enter a Position to Play");
		n = sc.nextInt();
		if(board[n] == 2)
		{
			go(board, n, i);
			flag = false;
		}
		else
			flag = true;
		}while(flag == true);
	}
}
