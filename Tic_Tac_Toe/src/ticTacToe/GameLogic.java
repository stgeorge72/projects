package ticTacToe;

/**
 * This class provides the game logic for a standard Tic Tac Toe game.
 */

public class GameLogic

{
	
	/**
	 * The gameBoard variable is a two dimensional array that represents the rows and columns of a Tic Tac Toe board.
	 * This variable is declared as public so all classes have access to changing the status of the game based on each move inputed.
	 */
	
	public String[][] gameBoard = { {" ", " ", " "},  {" ", " ", " "}, {" ", " ", " "} };
	
	/**
	 * Returns who's turn it is currently.
	 * 
	 * @param turn The current turn of the either the computer or the player.
	 * 
	 * @return Returns the current turn of the either the computer or the player.
	 */
	
	public String currentTurn(String turn)
	
	{
		
		return turn;
		
	}
	
	/**
	 * Changes the turn based on the given argument. 
	 * 
	 * @param turn The current turn needing to be changed.
	 * 
	 * @return Returns the opposite turn of the given parameter.
	 */
	
	public String changeTurn(String turn)
	
	{
		
		String changeTurn;
		
		if (turn.equals("O"))
			
		{
			
			changeTurn = "X";
			return changeTurn;
			
		}
		
		else
			
		{
			
			changeTurn = "O";
			return changeTurn;
					
		}
		
	}
	
	/**
	 * Checks if either X or O has won the game by checking every possible win direction.
	 * 
	 * @return Returns if "X" or "O" won (by returning true) or if the game is still active (by returning false).
	 */
	
	public boolean didXorOWin()
	
	{
		
		boolean isOver = false;
		
	// Checking if X Won
		
		// Checking Left Diagonal
		
		if (gameBoard[0][0].equals("X") && gameBoard[1][1].equals("X") && gameBoard[2][2].equals("X"))
			
		{
			
			isOver = true;
			return isOver;
			
		}
		
		// Checking Right Diagonal
		
		if (gameBoard[0][2].equals("X") && gameBoard[1][1].equals("X") && gameBoard[2][0].equals("X"))
			
		{
			
			isOver = true;
			return isOver;
			
		}
		
		// Checking 1st Horizontal
		
		if (gameBoard[0][0].equals("X") && gameBoard[0][1].equals("X") && gameBoard[0][2].equals("X"))
			
		{
			
			isOver = true;
			return isOver;
			
		}
		
		// Checking 2nd Horizontal
		
		if (gameBoard[1][0].equals("X") && gameBoard[1][1].equals("X") && gameBoard[1][2].equals("X"))
			
		{
			
			isOver = true;
			return isOver;
			
		}
		
		// Checking 3rd Horizontal
		
		if (gameBoard[2][0].equals("X") && gameBoard[2][1].equals("X") && gameBoard[2][2].equals("X"))
			
		{
			
			isOver = true;
			return isOver;
			
		}
		
		// Checking 1st Vertical
		
		if (gameBoard[0][0].equals("X") && gameBoard[1][0].equals("X") && gameBoard[2][0].equals("X"))
			
		{
			
			isOver = true;
			return isOver;
			
		}
		
		// Checking 2nd Vertical
		
		if (gameBoard[0][1].equals("X") && gameBoard[1][1].equals("X") && gameBoard[2][1].equals("X"))
			
		{
			
			isOver = true;
			return isOver;
			
		}
		
		// Checking 3rd Vertical
		
		if (gameBoard[0][2].equals("X") && gameBoard[1][2].equals("X") && gameBoard[2][2].equals("X"))
			
		{
			
			isOver = true;
			return isOver;
			
		}
		
	// Checking if O Won
		
		// Checking Left Diagonal
		
		if (gameBoard[0][0].equals("O") && gameBoard[1][1].equals("O") && gameBoard[2][2].equals("O"))
			
		{
			
			isOver = true;
			return isOver;
			
		}
		
		// Checking Right Diagonal
		
		if (gameBoard[0][2].equals("O") && gameBoard[1][1].equals("O") && gameBoard[2][0].equals("O"))
			
		{
			
			isOver = true;
			return isOver;
			
		}
		
		// Checking 1st Horizontal
		
		if (gameBoard[0][0].equals("O") && gameBoard[0][1].equals("O") && gameBoard[0][2].equals("O"))
			
		{
			
			isOver = true;
			return isOver;
			
		}
		
		// Checking 2nd Horizontal
		
		if (gameBoard[1][0].equals("O") && gameBoard[1][1].equals("O") && gameBoard[1][2].equals("O"))
			
		{
			
			isOver = true;
			return isOver;
			
		}
		
		// Checking 3rd Horizontal
		
		if (gameBoard[2][0].equals("O") && gameBoard[2][1].equals("O") && gameBoard[2][2].equals("O"))
			
		{
			
			isOver = true;
			return isOver;
			
		}
		
		// Checking 1st Vertical
		
		if (gameBoard[0][0].equals("O") && gameBoard[1][0].equals("O") && gameBoard[2][0].equals("O"))
			
		{
			
			isOver = true;
			return isOver;
			
		}
		
		// Checking 2nd Vertical
		
		if (gameBoard[0][1].equals("O") && gameBoard[1][1].equals("O") && gameBoard[2][1].equals("O"))
			
		{
			
			isOver = true;
			return isOver;
			
		}
		
		// Checking 3rd Vertical
		
		if (gameBoard[0][2].equals("O") && gameBoard[1][2].equals("O") && gameBoard[2][2].equals("O"))
			
		{
			
			isOver = true;
			return isOver;
			
		}
		
		return isOver;
		
	}
	
	/**
	 * Checks if the game is tied.
	 * 
	 * @return Returns true if the game is tied and returns false if the game is still active.
	 */
	
	public boolean isGameTied()
	
	{
		
		boolean isTied = false;

		int spaceCount = 0;
		
		for (String[] row : gameBoard)
			
		{
			
			for (String col : row)
				
			{
				
				if (col.equals(" "))
					
				{
				
					spaceCount += 1;
					
				}
				
			}
			
		}
		
		if (spaceCount == 0)
			
		{
			
			isTied = true;
			return isTied;
			
		}
		
		return isTied;
		
	}
	
}
