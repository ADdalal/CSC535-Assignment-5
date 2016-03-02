import java.util.Scanner;
import java.util.function.Predicate;




public class Game2 
{
 public GameBoard2 board;
 private Player player1;
 private Player player2;
 private Scanner input;
 
   public Game2()
     {
	  input = new Scanner(System.in);
	  this.board = new GameBoard2();
	  this.player1 = new Player("player1", 'R');
	  this.player2 = new Player("player2", 'B');
     }
   public void Play()
   {
	// This variable will alternate and mean whose turn is it. It is Red's turn now.
			boolean isRed = true;
			while (true) {
				if (isRed)
					System.out.println("Red's turn!");            
				else 
					System.out.println("Blue's turn!");
				System.out.print("Choose column (1-7) for a disk:");
				// Read the position of turn and check if value is correct.
				int column = input.nextInt();
				if (column < 1 || column > 7) {
					System.out.println("Column should be from 1 to 7");
					continue;
				}
				
				
				/*if (this.board.!putDisk('y', column - 1, isRed ? 'R' : 'B')) 
				{
					System.out.println("This column is filled! Choose another one.");
					continue;
				}*/

				this.board.display();

				//this method to show who is the winner
				char result = getWinner(board);
				if (result == 'N') {
					System.out.println("Soory, No winner this time!");
					break;
				}
				else if (result == 'R') {
					System.out.println("Red win!");
					break;
				}
				else if (result == 'B') {
					System.out.println("Blue win!");
					break;
				}
				// Otherwise we just proceed to the next turn, we need to invert isRed 
				// to alternate turns.
				isRed = !isRed;
			
   }
   public  char getWinner(this.theBoard)
	{
		char winner = getWinnerInColumns();
		if (winner != ' ') return winner;

		// Now we need to check if there are empty positions, otherwise it is a draw
		for (int i = 0; i < this.theBoard.length; ++i)
			for (int j = 0; j < board2[i].length; ++j)
				if (board2[i][j] == ' ') return ' ';

		return 'N';
	}
// Check columns, if there are 4 or more disks of the same color - return winner color
	private  char getWinnerInColumns(char board) 
	{
		// Check rows and see if there are 4 disks of the same color
		for (int column = 0; column < 7; ++column) {
			int count = 0;
			// We will compare current element with the previous
			for (int row = 1; row < 7; ++row) 
			{
				if (board [row][column] != ' ' &&
					 board[row][column] == board[row-1][column])
					++count;
				else
					count = 1;

				// Check if there are 4 in a row.
				if (count >= 4)
				{
					// Return color of the winner
					return board[row][column];
				 }
			}
		}
		// Otherwise return   character, which means nobody win in rows.
		return ' ';
	}
   }
