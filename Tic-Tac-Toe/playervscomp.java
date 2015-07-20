/*
 * This class helps the player to play first followed by the computer.
 * At every iteration, the above step is followed until the game ends.
 */

public class playervscomp extends tic_tac_toe 
{
	public static void play(int board[]) throws InterruptedException
	{
		int pos;
		for(int i = 1;i < 10;i++)
		{
			if(i % 2 != 0)
			{
				player.move(board, i);
			}
			else
			{
				Thread.sleep(2000);
				if(Posswin(board, 'O') == 1)
					go(board, winpos, i);
				else if(Posswin(board, 'X') == 1)
					go(board, winpos, i);
				else
					{	
					pos = comp.Make2(board);
					go(board, pos, i);
					}				
			}			
			display(board,i);		
			int val = win(board, i);
			if( val == 27 || val == 125)
			{
				System.out.println(val == 125 ? "Player O Wins": "Player X Wins");
				System.exit(0);
			}
		}
		System.out.println("Stalemate....!!!");
	}
}
