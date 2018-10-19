package ticTacToe;

/**
 * This class counts all the possible win directions for "O" to be used to determine the best move.
 */

public class AI_Win

{

	/**
	 * The gameLogic variable is created to gain access to the public methods in the GameLogic class.
	 */
	
	private GameLogic gameLogic;
	
	/**
	 * The winDir variable represents the Tic Tac Toe game board that stores the count of every possible win direction for "O"
	 * currently available on the board.
	 */
	
	public int[][] winDir = { {0, 0, 0}, {0, 0, 0}, {0, 0, 0} };
	
	/**
	 * This constructor initializes the GameLogic class to gain access to their public methods.
	 * 
	 * @param gameLogicInit Initializes the GameLogic class.
	 */
	
	public AI_Win(GameLogic gameLogicInit)
	
	{
		
		gameLogic = gameLogicInit;
		
	}
	
	/**
	 * Checks how many win directions are available at point (1,1), or at the game board index of [0][0].
	 * If a win direction is found, a count is incremented. Once all counts have been determined, the winDir00 integer
	 * is added to the winDir board at the index [0][0]. If that point is taken, then the winDir board at index [0][0] is set to
	 * -1 to represent that there are no win directions possible.
	 */
	
	private void checkWinDirection00()
	
	{
		
		int winDir00 = 0;
		
		// Checking if point (1,1), or gameLogic.gameBoard[0][0], is taken with an "O" or an "X"
		
		if ( ! gameLogic.gameBoard[0][0].equals("O") && ! gameLogic.gameBoard[0][0].equals("X") )
			
		{
			
			// Checking the Diagonal Win Direction of point (1,1)
			
			if (gameLogic.gameBoard[1][1].equals(" ") || gameLogic.gameBoard[1][1].equals("O"))
				
			{
				
				if (gameLogic.gameBoard[2][2].equals(" ") || gameLogic.gameBoard[2][2].equals("O"))
					
				{
				
					winDir00++;
					
				}
				
			}
			
			// Checking the Horizontal Win Direction of point (1,1)
			
			if (gameLogic.gameBoard[0][1].equals(" ") || gameLogic.gameBoard[0][1].equals("O"))
					
			{
				
				if (gameLogic.gameBoard[0][2].equals(" ") || gameLogic.gameBoard[0][2].equals("O"))
					
				{
					
					winDir00++;
				}
					
			}
			
			// Checking the Vertical Win Direction of point (1,1)
			
			if (gameLogic.gameBoard[1][0].equals(" ") || gameLogic.gameBoard[1][0].equals("O"))
					
			{
				
				if (gameLogic.gameBoard[2][0].equals(" ") || gameLogic.gameBoard[2][0].equals("O"))
					
				{
				
					winDir00++;
					
				}
					
			}

			winDir[0][0] = winDir00;
			
		}
		
		else 
		
		{
			
			winDir[0][0] = -1;
			
		}
		
	}
	
	/**
	 * Checks how many win directions are available at point (1,2), or at the game board index of [0][1].
	 * If a win direction is found, a count is incremented. Once all counts have been determined, the winDir01 integer
	 * is added to the winDir board at the index [0][1]. If that point is taken, then the winDir board at index [0][1] is set to
	 * -1 to represent that there are no win directions possible.
	 */
	
	private void checkWinDirection01()
	
	{
		
		int winDir01 = 0;
		
		// Checking if point (1,2), or gameLogic.gameBoard[0][1], is taken with an "O" or an "X"
		
		if ( ! gameLogic.gameBoard[0][1].equals("O") && ! gameLogic.gameBoard[0][1].equals("X") )
			
		{
			
			// Checking the Horizontal Win Direction of point (1,2)
			
			if (gameLogic.gameBoard[0][0].equals(" ") || gameLogic.gameBoard[0][0].equals("O"))
				
			{
				
				if (gameLogic.gameBoard[0][2].equals(" ") || gameLogic.gameBoard[0][2].equals("O"))
					
				{
				
					winDir01++;
					
				}
				
			}
			
			// Checking the Vertical Win Direction of point (1,2)
			
			if (gameLogic.gameBoard[1][1].equals(" ") || gameLogic.gameBoard[1][1].equals("O"))
					
			{
					
				if (gameLogic.gameBoard[2][1].equals(" ") || gameLogic.gameBoard[2][1].equals("O"))	
				
				{
				
					winDir01++;
				
				}
				
			}
			
			winDir[0][1] = winDir01;
			
		}
		
		else
			
		{
			
			winDir[0][1] = -1;
			
		}
		
	}
	
	/**
	 * Checks how many win directions are available at point (1,3), or at the game board index of [0][2].
	 * If a win direction is found, a count is incremented. Once all counts have been determined, the winDir02 integer
	 * is added to the winDir board at the index [0][2]. If that point is taken, then the winDir board at index [0][2] is set to
	 * -1 to represent that there are no win directions possible.
	 */
	
	private void checkWinDirection02()
	
	{
		
		int winDir02 = 0;
		
		// Checking if point (1,3), or gameLogic.gameBoard[0][2], is taken with an "O" or an "X"
		
		if ( ! gameLogic.gameBoard[0][2].equals("O") && ! gameLogic.gameBoard[0][2].equals("X") )
			
		{
			
			// Checking the Diagonal Win Direction of point (1,3)
			
			if (gameLogic.gameBoard[1][1].equals(" ") || gameLogic.gameBoard[1][1].equals("O"))
					
			{
				
				if (gameLogic.gameBoard[2][0].equals(" ") || gameLogic.gameBoard[2][0].equals("O"))
					
				{
					
					winDir02++;
					
				}
					
			}
			
			// Checking the Horizontal Win Direction of point (1,3)
			
			if (gameLogic.gameBoard[0][1].equals(" ") || gameLogic.gameBoard[0][1].equals("O"))
				
			{
				
				if (gameLogic.gameBoard[0][0].equals(" ") || gameLogic.gameBoard[0][0].equals("O"))
					
				{
				
					winDir02++;
					
				}
				
			}

			// Checking the Vertical Win Direction of point (1,3)
			
			if (gameLogic.gameBoard[1][2].equals(" ") || gameLogic.gameBoard[1][2].equals("O"))
					
			{
				
				if (gameLogic.gameBoard[2][2].equals(" ") || gameLogic.gameBoard[2][2].equals("O"))
					
				{
					
					winDir02++;
					
				}
				
			}
			
			winDir[0][2] = winDir02;

		}
		
		else
			
		{
			
			winDir[0][2] = -1;
			
		}
		
	}
	
	/**
	 * Checks how many win directions are available at point (2,1), or at the game board index of [1][0].
	 * If a win direction is found, a count is incremented. Once all counts have been determined, the winDir10 integer
	 * is added to the winDir board at the index [1][0]. If that point is taken, then the winDir board at index [1][0] is set to
	 * -1 to represent that there are no win directions possible.
	 */
	
	private void checkWinDirection10()
	
	{
		
		int winDir10 = 0;
		
		// Checking if point (2,1), or gameLogic.gameBoard[1][0], is taken with an "O" or an "X"
		
		if ( ! gameLogic.gameBoard[1][0].equals("O") && ! gameLogic.gameBoard[1][0].equals("X") )
			
		{
			
			// Checking the Horizontal Win Direction of point (2,1)
			
			if (gameLogic.gameBoard[1][1].equals(" ") || gameLogic.gameBoard[1][1].equals("O"))
				
			{
				
				if (gameLogic.gameBoard[1][2].equals(" ") || gameLogic.gameBoard[1][2].equals("O"))
					
				{
				
					winDir10++;
					
				}
				
			}
			
			// Checking the Vertical Win Direction of point (2,1)
			
			if (gameLogic.gameBoard[0][0].equals(" ") || gameLogic.gameBoard[0][0].equals("O"))
				
			{
				
				if (gameLogic.gameBoard[2][0].equals(" ") || gameLogic.gameBoard[2][0].equals("O"))
					
				{
				
					winDir10++;
					
				}
				
			}
			
			winDir[1][0] = winDir10;
			
		}
		
		else
			
		{
			
			winDir[1][0] = -1;
			
		}
		
	}
	
	/**
	 * Checks how many win directions are available at point (2,2), or at the game board index of [1][1].
	 * If a win direction is found, a count is incremented. Once all counts have been determined, the winDir11 integer
	 * is added to the winDir board at the index [1][1]. If that point is taken, then the winDir board at index [1][1] is set to
	 * -1 to represent that there are no win directions possible.
	 */
	
	private void checkWinDirection11()
	
	{
		
		int winDir11 = 0;
		
		// Checking if point (2,2), or gameLogic.gameBoard[1][1], is taken with an "O" or an "X"
		
		if ( ! gameLogic.gameBoard[1][1].equals("O") && ! gameLogic.gameBoard[1][1].equals("X") )
			
		{
			
			// Checking the Left Diagonal Win Direction of point (2,2)
			
			if (gameLogic.gameBoard[0][0].equals(" ") || gameLogic.gameBoard[0][0].equals("O"))
					
			{
				
				if (gameLogic.gameBoard[2][2].equals(" ") || gameLogic.gameBoard[2][2].equals("O"))
				
				{
				
					winDir11++;
					
				}
					
			}
			
			// Checking the Right Diagonal Win Direction of point (2,2)
			
			if (gameLogic.gameBoard[0][2].equals(" ") || gameLogic.gameBoard[0][2].equals("O"))
					
			{
				
				if (gameLogic.gameBoard[2][0].equals(" ") || gameLogic.gameBoard[2][0].equals("O"))
					
				{
					
					winDir11++;
					
				}
				
			}
			
			// Checking the Horizontal Win Direction of point (2,2)
			
			if (gameLogic.gameBoard[1][0].equals(" ") || gameLogic.gameBoard[1][0].equals("O"))
				
			{
				
				if (gameLogic.gameBoard[1][2].equals(" ") || gameLogic.gameBoard[1][2].equals("O"))
					
				{
				
					winDir11++;
					
				}
				
			}
			
			// Checking the Vertical Win Direction of point (2,2)
			
			if (gameLogic.gameBoard[0][1].equals(" ") || gameLogic.gameBoard[0][1].equals("O"))
						
			{
				
				if(gameLogic.gameBoard[2][1].equals(" ") || gameLogic.gameBoard[2][1].equals("O"))
					
				{
						
					winDir11++;
					
				}
						
			}
			
			winDir[1][1] = winDir11;

		}
		
		else
			
		{
			
			winDir[1][1] = -1;
			
		}
		
	}
	
	/**
	 * Checks how many win directions are available at point (2,3), or at the game board index of [1][2].
	 * If a win direction is found, a count is incremented. Once all counts have been determined, the winDir12 integer
	 * is added to the winDir board at the index [1][2]. If that point is taken, then the winDir board at index [1][2] is set to
	 * -1 to represent that there are no win directions possible.
	 */
	
	private void checkWinDirection12()
	
	{
		
		int winDir12 = 0;
		
		// Checking if point (2,3), or gameLogic.gameBoard[1][2], is taken with an "O" or an "X"
		
		if ( ! gameLogic.gameBoard[1][2].equals("O") && ! gameLogic.gameBoard[1][2].equals("X") )
			
		{
			
			// Checking the Horizontal Win Direction of point (2,3)
			
			if (gameLogic.gameBoard[1][1].equals(" ") || gameLogic.gameBoard[1][1].equals("O"))
				
			{
				
				if (gameLogic.gameBoard[1][0].equals(" ") || gameLogic.gameBoard[1][0].equals("O"))
					
				{
				
					winDir12++;
					
				}
				
			}
			
			// Checking the Vertical Win Direction of point (2,3)
			
			if (gameLogic.gameBoard[0][2].equals(" ") || gameLogic.gameBoard[0][2].equals("O"))
				
			{
				
				if (gameLogic.gameBoard[2][2].equals(" ") || gameLogic.gameBoard[2][2].equals("O"))
					
				{
				
					winDir12++;
					
				}
				
			}
			
			winDir[1][2] = winDir12;
			
		}
		
		else
			
		{
			
			winDir[1][2] = -1;
			
		}
		
	}
	
	/**
	 * Checks how many win directions are available at point (3,1), or at the game board index of [2][0].
	 * If a win direction is found, a count is incremented. Once all counts have been determined, the winDir20 integer
	 * is added to the winDir board at the index [2][0]. If that point is taken, then the winDir board at index [2][0] is set to
	 * -1 to represent that there are no win directions possible.
	 */
	
	private void checkWinDirection20()
	
	{
		
		int winDir20 = 0;
		
		// Checking if point (3,1), or gameLogic.gameBoard[2][0], is taken with an "O" or an "X"
		
		if ( ! gameLogic.gameBoard[2][0].equals("O") && ! gameLogic.gameBoard[2][0].equals("X") )
			
		{
			
			// Checking the Diagonal Win Direction of point (3,1)
			
			if (gameLogic.gameBoard[1][1].equals(" ") || gameLogic.gameBoard[1][1].equals("O"))
					
			{
				
				if (gameLogic.gameBoard[0][2].equals(" ") || gameLogic.gameBoard[0][2].equals("O"))
					
				{
					
					winDir20++;
					
				}
					
			}
			
			// Checking the Horizontal Win Direction of point (3,1)
			
			if (gameLogic.gameBoard[2][1].equals(" ") || gameLogic.gameBoard[2][1].equals("O"))
					
			{
				
				if (gameLogic.gameBoard[2][2].equals(" ") || gameLogic.gameBoard[2][2].equals("O"))
					
				{
					
					winDir20++;
					
				}
					
			}
			
			// Checking the Vertical Win Direction of point (3,1)
			
			if (gameLogic.gameBoard[1][0].equals(" ") || gameLogic.gameBoard[1][0].equals("O"))
				
			{
				
				if (gameLogic.gameBoard[0][0].equals(" ") || gameLogic.gameBoard[0][0].equals("O"))
					
				{
				
					winDir20++;
					
				}
				
			}
			
			winDir[2][0] = winDir20;

		}
		
		else
			
		{
			
			winDir[2][0] = -1;
			
		}
		
	}
	
	/**
	 * Checks how many win directions are available at point (3,2), or at the game board index of [2][1].
	 * If a win direction is found, a count is incremented. Once all counts have been determined, the winDir21 integer
	 * is added to the winDir board at the index [2][1]. If that point is taken, then the winDir board at index [2][1] is set to
	 * -1 to represent that there are no win directions possible.
	 */
	
	private void checkWinDirection21()
	
	{
		
		int winDir21 = 0;
		
		// Checking if point (3,2), or gameLogic.gameBoard[2][1], is taken with an "O" or an "X"
		
		if ( ! gameLogic.gameBoard[2][1].equals("O") && ! gameLogic.gameBoard[2][1].equals("X") )
			
		{
			
			// Checking the Horizontal Win Direction of point (3,2)
			
			if (gameLogic.gameBoard[2][0].equals(" ") || gameLogic.gameBoard[2][0].equals("O"))
				
			{
				
				if (gameLogic.gameBoard[2][2].equals(" ") || gameLogic.gameBoard[2][2].equals("O"))
					
				{
				
					winDir21++;
					
				}
				
			}
			
			// Checking the Vertical Win Direction of point (3,2)
			
			if (gameLogic.gameBoard[1][1].equals(" ") || gameLogic.gameBoard[1][1].equals("O"))
				
			{
				
				if (gameLogic.gameBoard[0][1].equals(" ") || gameLogic.gameBoard[0][1].equals("O"))
					
				{
				
					winDir21++;
					
				}
				
			}
			
			winDir[2][1] = winDir21;
			
		}
		
		else
			
		{
			
			winDir[2][1] = -1;
			
		}
		
	}
	
	/**
	 * Checks how many win directions are available at point (3,3), or at the game board index of [2][2].
	 * If a win direction is found, a count is incremented. Once all counts have been determined, the winDir22 integer
	 * is added to the winDir board at the index [2][2]. If that point is taken, then the winDir board at index [2][2] is set to
	 * -1 to represent that there are no win directions possible.
	 */
	
	private void checkWinDirection22()
	
	{
		
		int winDir22 = 0;
		
		// Checking if point (3,3), or gameLogic.gameBoard[2][2], is taken with an "O" or an "X"

		if ( ! gameLogic.gameBoard[2][2].equals("O") && ! gameLogic.gameBoard[2][2].equals("X") )
			
		{
			
			// Checking the Diagonal Win Direction of point (3,3)
			
			if (gameLogic.gameBoard[1][1].equals(" ") || gameLogic.gameBoard[1][1].equals("O"))
					
			{
				
				if (gameLogic.gameBoard[0][0].equals(" ") || gameLogic.gameBoard[0][0].equals("O"))
					
				{
					
					winDir22++;
					
				}
					
			}
			
			// Checking the Horizontal Win Direction of point (3,3)
			
			if (gameLogic.gameBoard[2][1].equals(" ") || gameLogic.gameBoard[2][1].equals("O"))
					
			{
				
				if (gameLogic.gameBoard[2][0].equals(" ") || gameLogic.gameBoard[2][0].equals("O"))
					
				{
					
					winDir22++;
					
				}
					
			}
			
			// Checking the Vertical Win Direction of point (3,3)
			
			if (gameLogic.gameBoard[1][2].equals(" ") || gameLogic.gameBoard[1][2].equals("O"))
				
			{
				
				if (gameLogic.gameBoard[0][2].equals(" ") || gameLogic.gameBoard[0][2].equals("O"))
					
				{
				
					winDir22++;
					
				}
				
			}
			
			winDir[2][2] = winDir22;

		}
		
		else
			
		{
			
			winDir[2][2] = -1;
			
		}
		
	}
	
	/**
	 * Calls all of the private methods in this class that check and count all win directions on the board for "O".
	 * This is the only public method in this AI_Win class to allow the AI class to evaluate all win directions.
	 */
	
	public void checkAllWinDir()
	
	{
		
		checkWinDirection00();
		checkWinDirection01();
		checkWinDirection02();
		checkWinDirection10();
		checkWinDirection11();
		checkWinDirection12();
		checkWinDirection20();
		checkWinDirection21();
		checkWinDirection22();
		
	}

}
