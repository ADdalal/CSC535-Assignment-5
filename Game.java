import java.util.Scanner;
public class Game 
{
	public static boolean putDisk(char[][] field, int column, char color)// put the disk of the given color in the given column.
	{
		// If the first disk is there, the column is filled, returning false.
		if (field[0][column] != ' ')
			return false;

		// Check all elements in the column.
		for (int row = 0; row < 7; ++row) {
			// If we found something, which means if the character is not
			// zero character
			if (field[row][column] != ' ') {
				// Put the disk on top of the current one.
				field[row-1][column] = color;
				return true;
			}
		}
		// If no other disks found, we place this disk at the bottom.
		field[6][column] = color;
		return true;
	}

	public void Play() 
	{
		Scanner input = new Scanner(System.in);
		// Declare field 2D array.
		char[][] field = new char[7][7];

		// Initialize with spaces
		for (int i = 0; i < 7; ++i)
			for (int j = 0; j < 7; ++j)
				field[i][j] = ' ';
		printField(field);

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
			
			
			if (!putDisk(field, column - 1, isRed ? 'R' : 'B')) {
				System.out.println("This column is filled! Choose another one.");
				continue;
			}

			printField(field);

			//this method to show who is the winner
			char result = getWinner(field);
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
	}

	public static void printField(char[][] field) {
		for (int row = 0; row < 7; ++row) {
			System.out.print("| ");
			for (int col = 0; col < 7; ++col)
				System.out.print(field[row][col] + "| ");
			System.out.println();
		}

		// Print bottom line
		for (int col = 0; col < 7; ++col)
			System.out.print("---");
		System.out.println();
	}
	public static char getWinner(char[][] field)
	{
		char winner = getWinnerInColumns(field);
		if (winner != ' ') return winner;

		// Now we need to check if there are empty positions, otherwise it is a draw
		for (int i = 0; i < field.length; ++i)
			for (int j = 0; j < field[i].length; ++j)
				if (field[i][j] == ' ') return ' ';

		return 'N';
	}
	// Check columns, if there are 4 or more disks of the same color - return winner color
	private static char getWinnerInColumns(char[][] field) {
		// Check rows and see if there are 4 disks of the same color
		for (int column = 0; column < 7; ++column) {
			int count = 0;
			// We will compare current element with the previous
			for (int row = 1; row < 7; ++row) {
				if (field[row][column] != ' ' &&
						field[row][column] == field[row-1][column])
					++count;
				else
					count = 1;

				// Check if there are 4 in a row.
				if (count >= 4) {
					// Return color of the winner
					return field[row][column];
				}
			}
		}
		// Otherwise return   character, which means nobody win in rows.
		return ' ';
	}

}

