/*
 * This class helps the computer to play first followed by the player.
 * At every iteration, the above step is followed until the game ends.
 */

public class compvsplayer extends tic_tac_toe
{
	public static void play(int board[]) throws InterruptedException
	{
		for(int i = 1;i < 10;i++)
		{
			if(i % 2 != 0)
			{
				Thread.sleep(2000);
				comp.move(board, i);
			}
			else
			{
				player.move(board, i);
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
