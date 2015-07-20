/*
 * This Class extends the functionality of "tic_tac_toe" class and plays the chance where the
 * computer has a winning move thus this makes the computer unbeatable.
 */
public class comp extends tic_tac_toe
{
	/*
	 * This position checks the number of the move computer is playing and plays according to 
	 * the algorithm in the most efficient way.
	 * For deatils, read algorithm.txt
	 */
	public static void move(int board[], int turn)
	{
		int i;
		if(turn == 1)
			go(board, 5, turn);
		if(turn == 3)
		{
			if(board[3] != 2)
				go(board, 1, turn);
			else
				go(board, 3, turn);
		}
		if(turn == 5)
		{
			if(Posswin(board, 'X') == 1)
				go(board, winpos, turn);
			else if(Posswin(board, 'O') == 1)
				go(board, winpos, turn);
			else if(board[7] != 2)
			{	
				if(board[9] == 2)
					go(board, 9, turn);
				else
					go(board, 1, turn);
			}
			else
				go(board, 7, turn);
		}
		if(turn == 7)
		{
			if(Posswin(board, 'X') == 1)
				go(board, winpos, turn);
			else if(Posswin(board, 'O') == 1)
				go(board, winpos, turn);
			else if(board[7] != 2)
			{	if(board[9] == 2)
					go(board, 9, turn);
				else
					go(board, 1, turn);
			}
			else
				go(board, 7, turn);
		}
		if(turn == 9)
		{
			for(i = 1; i < 10;i++)
				if(board[i] == 2)
					go(board, i, turn);
		}
	}
	/*
	 * This function is used in computer vs computer simulation.
	 * For details, read algorithm.txt
	 */
	protected static int Make2(int board[])
	{
		int i = 1;
		if(board[5] == 2)
			return 5;
		else 
			while(i <= 8)
			{
				if(board[i] == 2)
					return i;
				i+=2;
			}
		return 0;
		
	}
}
