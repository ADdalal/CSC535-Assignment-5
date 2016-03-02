


public class GameBoard2 
{
	private char[][] theBoard;
	
public GameBoard2()
    {
		this.theBoard = new char [7][7];
		this.ClearBoard();
	}

//put the disk of the given color in the given column.
public boolean putDisk(char moveChar, int column, char color)
{
	if (this.theBoard[0][column] != ' ')
		return false;

	// Check all elements in the column.
	for (int row = 0; row < 7; ++row) 
	{
		// If we found something, which means if the character is not
		// zero character
		if (this.theBoard[row][column] != ' ')
		{
			// Put the disk on top of the current one.
			this.theBoard[row-1][column] = color;
			return true;
		}
	}
	// If no other disks found, we place this disk at the bottom.
	this.theBoard[6][column] = color;
	return true;
}

private void ClearBoard()
{
	for (int i = 0; i < this.theBoard.length; ++i)
	   {
		 for (int j = 0; j < this.theBoard[i].length; ++j)
		    {
			  this.theBoard[i][j] = ' ';
	         }
	   }
	this.display();
}
public void display()
{
	//draw a board
	for (int i = 0; i < this.theBoard.length; ++i)
	   {
		System.out.print("| ");
		 for (int j = 0; j < this.theBoard[i].length; ++j)
		    
			 System.out.print(this.theBoard[i][j] + "| ");
		        System.out.println();         
       }
    // Print bottom line
    for (int j= 0; j < this.theBoard[j].length; ++j)
		System.out.print("---");
		   System.out.println();
}

		
}//end Class
