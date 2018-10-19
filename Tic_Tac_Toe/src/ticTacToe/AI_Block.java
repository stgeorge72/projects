package ticTacToe;

/**
 * This class counts all the possible block directions for "O" to be used to determine the best move.
 */

public class AI_Block

{

	/**
	 * The gameLogic variable is created to gain access to the public methods in the GameLogic class.
	 */
	
	private GameLogic gameLogic;
	
	/**
	 * The blockDir variable represents the Tic Tac Toe game board that stores the count of every possible block direction for "O"
	 * currently available on the board.
	 */
	
	public int[][] blockDir = { {0, 0, 0}, {0, 0, 0}, {0, 0, 0} };
	
	/**
	 * This constructor initializes the GameLogic class to gain access to their public methods.
	 * 
	 * @param gameLogicInit Initializes the GameLogic class.
	 */
	
	public AI_Block(GameLogic gameLogicInit)
	
	{
		
		gameLogic = gameLogicInit;
		
	}
	
	/**
	 * Checks how many block directions are available at point (1,1), or at the game board index of [0][0].
	 * If a block direction is found, a count is incremented. Once all counts have been determined, the blockDir00 integer
	 * is added to the blockDir board at the index [0][0]. If that point is taken, then the blockDir board at index [0][0] is set to
	 * -1 to represent that there are no block directions possible.
	 */
	
	private void checkBlockDirection00()
	
	{
		
		int blockDir00 = 0;
		
		// Checking if point (1,1), or gameLogic.gameBoard[0][0], is taken with an "O" or an "X"
		
		if ( ! gameLogic.gameBoard[0][0].equals("O") && ! gameLogic.gameBoard[0][0].equals("X") )
			
		{
			
			// Checking the Diagonal Block Direction of point (1,1)
			
			if (gameLogic.gameBoard[1][1].equals(" ") || gameLogic.gameBoard[1][1].equals("O") || gameLogic.gameBoard[1][1].equals("X"))
				
			{
				
				if (gameLogic.gameBoard[2][2].equals(" ") || gameLogic.gameBoard[2][2].equals("O") || gameLogic.gameBoard[2][2].equals("X"))
					
				{
				
					blockDir00++;
					
				}
				
			}
			
			// Checking the Horizontal Block Direction of point (1,1)
			
			if (gameLogic.gameBoard[0][1].equals(" ") || gameLogic.gameBoard[0][1].equals("O") || gameLogic.gameBoard[0][1].equals("X"))
					
			{
				
				if (gameLogic.gameBoard[0][2].equals(" ") || gameLogic.gameBoard[0][2].equals("O") || gameLogic.gameBoard[0][2].equals("X"))
					
				{
					
					blockDir00++;
					
				}
					
			}
			
			// Checking the Vertical Block Direction of point (1,1)
			
			if (gameLogic.gameBoard[1][0].equals(" ") || gameLogic.gameBoard[1][0].equals("O") || gameLogic.gameBoard[1][0].equals("X"))
					
			{
				
				if (gameLogic.gameBoard[2][0].equals(" ") || gameLogic.gameBoard[2][0].equals("O") || gameLogic.gameBoard[2][0].equals("X"))
					
				{
					
					blockDir00++;
					
				}
					
			}
			
			blockDir[0][0] = blockDir00;
			
		}
		
		else
			
		{
			
			blockDir[0][0] = -1;
			
		}
		
	}
	
	/**
	 * Checks how many block directions are available at point (1,2), or at the game board index of [0][1].
	 * If a block direction is found, a count is incremented. Once all counts have been determined, the blockDir01 integer
	 * is added to the blockDir board at the index [0][1]. If that point is taken, then the blockDir board at index [0][1] is set to
	 * -1 to represent that there are no block directions possible.
	 */
	
	private void checkBlockDirection01()
	
	{
		
		int blockDir01 = 0;
		
		// Checking if point (1,2), or gameLogic.gameBoard[0][1], is taken with an "O" or an "X"
		
		if ( ! gameLogic.gameBoard[0][1].equals("O") && ! gameLogic.gameBoard[0][1].equals("X") )
			
		{
			
			// Checking the Horizontal Block Direction of point (1,2)
			
			if (gameLogic.gameBoard[0][0].equals(" ") || gameLogic.gameBoard[0][0].equals("O") || gameLogic.gameBoard[0][0].equals("X"))
				
			{
				
				if (gameLogic.gameBoard[0][2].equals(" ") || gameLogic.gameBoard[0][2].equals("O") || gameLogic.gameBoard[0][2].equals("X"))
					
				{
				
					blockDir01++;
					
				}
				
			}
			
			// Checking the Vertical Block Direction of point (1,2)
			
			if (gameLogic.gameBoard[1][1].equals(" ") || gameLogic.gameBoard[1][1].equals("O") || gameLogic.gameBoard[1][1].equals("X"))
					
			{
				
				if (gameLogic.gameBoard[2][1].equals(" ") || gameLogic.gameBoard[2][1].equals("O") || gameLogic.gameBoard[2][1].equals("X"))
					
				{
				
					blockDir01++;
					
				}
					
			}
			
			blockDir[0][1] = blockDir01;
			
		}
		
		else
			
		{
			
			blockDir[0][1] = -1;
			
		}
		
	}
	
	/**
	 * Checks how many block directions are available at point (1,3), or at the game board index of [0][2].
	 * If a block direction is found, a count is incremented. Once all counts have been determined, the blockDir02 integer
	 * is added to the blockDir board at the index [0][2]. If that point is taken, then the blockDir board at index [0][2] is set to
	 * -1 to represent that there are no block directions possible.
	 */
	
	private void checkBlockDirection02()
	
	{
		
		int blockDir02 = 0;
		
		// Checking if point (1,3), or gameLogic.gameBoard[0][2], is taken with an "O" or an "X"
		
		if ( ! gameLogic.gameBoard[0][1].equals("O") && ! gameLogic.gameBoard[0][1].equals("X") )
			
		{
			
			// Checking the Diagonal Block Direction of point (1,3)
			
			if (gameLogic.gameBoard[1][1].equals(" ") || gameLogic.gameBoard[1][1].equals("O") || gameLogic.gameBoard[1][1].equals("X"))
				
			{
				
				if (gameLogic.gameBoard[2][0].equals(" ") || gameLogic.gameBoard[2][0].equals("O") || gameLogic.gameBoard[2][0].equals("X"))
					
				{
				
					blockDir02++;
					
				}
				
			}
			
			// Checking the Horizontal Block Direction of point (1,3)
			
			if (gameLogic.gameBoard[0][1].equals(" ") || gameLogic.gameBoard[0][1].equals("O") || gameLogic.gameBoard[0][1].equals("X"))
				
			{
				
				if (gameLogic.gameBoard[0][0].equals(" ") || gameLogic.gameBoard[0][0].equals("O") || gameLogic.gameBoard[0][0].equals("X"))
					
				{
				
					blockDir02++;
					
				}
				
			}
			
			// Checking the Vertical Block Direction of point (1,3)
			
			if (gameLogic.gameBoard[1][2].equals(" ") || gameLogic.gameBoard[1][2].equals("O") || gameLogic.gameBoard[1][2].equals("X"))
				
			{
				
				if (gameLogic.gameBoard[2][2].equals(" ") || gameLogic.gameBoard[2][2].equals("O") || gameLogic.gameBoard[2][2].equals("X"))
					
				{
				
					blockDir02++;
					
				}
				
			}
			
			blockDir[0][2] = blockDir02;
					
		}
		
		else
			
		{
			
			blockDir[0][2] = -1;
			
		}
		
	}
	
	/**
	 * Checks how many block directions are available at point (2,1), or at the game board index of [1][0].
	 * If a block direction is found, a count is incremented. Once all counts have been determined, the blockDir10 integer
	 * is added to the blockDir board at the index [1][0]. If that point is taken, then the blockDir board at index [1][0] is set to
	 * -1 to represent that there are no block directions possible.
	 */
	
	private void checkBlockDirection10()
	
	{
		
		int blockDir10 = 0;
		
		// Checking if point (2,1), or gameLogic.gameBoard[1][0], is taken with an "O" or an "X"
		
		if ( ! gameLogic.gameBoard[1][0].equals("O") && ! gameLogic.gameBoard[1][0].equals("X") )
					
		{
			
			// Checking the Horizontal Block Direction of point (2,1)
			
			if (gameLogic.gameBoard[1][1].equals(" ") || gameLogic.gameBoard[1][1].equals("O") || gameLogic.gameBoard[1][1].equals("X"))
					
			{
				
				if (gameLogic.gameBoard[1][2].equals(" ") || gameLogic.gameBoard[1][2].equals("O") || gameLogic.gameBoard[1][2].equals("X"))
					
				{
					
					blockDir10++;
					
				}
					
			}
			
			// Checking the Vertical Block Direction of point (2,1)
			
			if (gameLogic.gameBoard[0][0].equals(" ") || gameLogic.gameBoard[0][0].equals("O") || gameLogic.gameBoard[0][0].equals("X"))
				
			{
				
				if (gameLogic.gameBoard[2][0].equals(" ") || gameLogic.gameBoard[2][0].equals("O") ||  gameLogic.gameBoard[2][0].equals("X"))
					
				{
				
					blockDir10++;
					
				}
				
			}
			
			blockDir[1][0] = blockDir10;
			
		}
						
		else
			
		{
			
			blockDir[1][0] = -1;
			
		}
		
	}
	
	/**
	 * Checks how many block directions are available at point (2,2), or at the game board index of [1][1].
	 * If a block direction is found, a count is incremented. Once all counts have been determined, the blockDir11 integer
	 * is added to the blockDir board at the index [1][1]. If that point is taken, then the blockDir board at index [1][1] is set to
	 * -1 to represent that there are no block directions possible.
	 */
	
	private void checkBlockDirection11()
	
	{
		
		int blockDir11 = 0;
		
		// Checking if point (2,2), or gameLogic.gameBoard[1][1], is taken with an "O" or an "X"
		
		if ( ! gameLogic.gameBoard[1][1].equals("O") && ! gameLogic.gameBoard[1][1].equals("X") )
					
		{
			
			// Checking the Left Diagonal Block Direction of point (2,2)
			
			if (gameLogic.gameBoard[0][0].equals(" ") || gameLogic.gameBoard[0][0].equals("O") || gameLogic.gameBoard[0][0].equals("X"))
				
			{
				
				if (gameLogic.gameBoard[2][2].equals(" ") || gameLogic.gameBoard[2][2].equals("O") || gameLogic.gameBoard[2][2].equals("X"))
					
				{
				
					blockDir11++;
				
				}
				
			}
			
			// Checking the Right Diagonal Block Direction of point (2,2)
			
			if (gameLogic.gameBoard[0][2].equals(" ") || gameLogic.gameBoard[0][2].equals("O") || gameLogic.gameBoard[0][2].equals("X"))
					
			{
					
				if (gameLogic.gameBoard[2][0].equals(" ") || gameLogic.gameBoard[2][0].equals("O") || gameLogic.gameBoard[2][0].equals("X"))
					
				{
					
					blockDir11++;
					
				}
					
			}
			
			// Checking the Horizontal Block Direction of point (2,2)
			
			if (gameLogic.gameBoard[1][0].equals(" ") || gameLogic.gameBoard[1][0].equals("O") || gameLogic.gameBoard[1][0].equals("X"))
					
			{
					
				if (gameLogic.gameBoard[1][2].equals(" ") || gameLogic.gameBoard[1][2].equals("O") || gameLogic.gameBoard[1][2].equals("X"))
					
				{
				
					blockDir11++;
					
				}
					
			}
			
			// Checking the Vertical Block Direction of point (2,2)
			
			if (gameLogic.gameBoard[0][1].equals(" ") || gameLogic.gameBoard[0][1].equals("O") || gameLogic.gameBoard[0][1].equals("X"))
					
			{
				
				if (gameLogic.gameBoard[2][1].equals(" ") || gameLogic.gameBoard[2][1].equals("O") || gameLogic.gameBoard[2][1].equals("X"))
					
				{
				
					blockDir11++;
					
				}
					
			}
			
			blockDir[1][1] = blockDir11;
			
		}
		
		else
		
		{
			
			blockDir[1][1] = -1;
			
		}
		
	}
	
	/**
	 * Checks how many block directions are available at point (2,3), or at the game board index of [1][2].
	 * If a block direction is found, a count is incremented. Once all counts have been determined, the blockDir12 integer
	 * is added to the blockDir board at the index [1][2]. If that point is taken, then the blockDir board at index [1][2] is set to
	 * -1 to represent that there are no block directions possible.
	 */
	
	public void checkBlockDirection12()
	
	{
		
		int blockDir12 = 0;
		
		// Checking if point (2,3), or gameLogic.gameBoard[1][2], is taken with an "O" or an "X"
		
		if ( ! gameLogic.gameBoard[1][2].equals("O") && ! gameLogic.gameBoard[1][2].equals("X") )
					
		{
			
			// Checking the Horizontal Block Direction of point (2,3)
			
			if (gameLogic.gameBoard[1][1].equals(" ") || gameLogic.gameBoard[1][1].equals("O") || gameLogic.gameBoard[1][1].equals("X"))
				
			{
				
				if (gameLogic.gameBoard[1][0].equals(" ") || gameLogic.gameBoard[1][0].equals("O") || gameLogic.gameBoard[1][0].equals("X"))
					
				{
				
					blockDir12++;
					
				}
				
			}
			
			// Checking the Vertical Block Direction of point (2,3)
			
			if (gameLogic.gameBoard[0][2].equals(" ") || gameLogic.gameBoard[0][2].equals("O") || gameLogic.gameBoard[0][2].equals("X"))
				
			{
				
				if (gameLogic.gameBoard[2][2].equals(" ") || gameLogic.gameBoard[2][2].equals("O") || gameLogic.gameBoard[2][2].equals("X"))
					
				{
				
					blockDir12++;
					
				}
				
			}
			
			blockDir[1][2] = blockDir12;
			
		}
		
		else
			
		{
			
			blockDir[1][2] = -1;
			
		}
		
	}
	
	/**
	 * Checks how many block directions are available at point (3,1), or at the game board index of [2][0].
	 * If a block direction is found, a count is incremented. Once all counts have been determined, the blockDir20 integer
	 * is added to the blockDir board at the index [2][0]. If that point is taken, then the blockDir board at index [2][0] is set to
	 * -1 to represent that there are no block directions possible.
	 */
	
	private void checkBlockDirection20()
	
	{
	
		int blockDir20 = 0;
		
		// Checking if point (3,1), or gameLogic.gameBoard[2][0], is taken with an "O" or an "X"
		
		if ( ! gameLogic.gameBoard[2][0].equals("O") && ! gameLogic.gameBoard[2][0].equals("X") )
					
		{
			
			// Checking the Diagonal Block Direction of point (3,1)
			
			if (gameLogic.gameBoard[1][1].equals(" ") || gameLogic.gameBoard[1][1].equals("O") || gameLogic.gameBoard[1][1].equals("X"))
					
			{
				
				if (gameLogic.gameBoard[0][2].equals(" ") || gameLogic.gameBoard[0][2].equals("O") || gameLogic.gameBoard[0][2].equals("X"))
					
				{
					
					blockDir20++;
					
				}
				
			}
			
			// Checking the Horizontal Block Direction of point (3,1)
			
			if (gameLogic.gameBoard[2][1].equals(" ") || gameLogic.gameBoard[2][1].equals("O") || gameLogic.gameBoard[2][1].equals("X"))
				
			{
				
				if (gameLogic.gameBoard[2][2].equals(" ") || gameLogic.gameBoard[2][2].equals("O") || gameLogic.gameBoard[2][2].equals("X"))
					
				{
					
					blockDir20++;
					
				}
				
			}
			
			// Checking the Vertical Block Direction of point (3,1)
			
			if (gameLogic.gameBoard[1][0].equals(" ") || gameLogic.gameBoard[1][0].equals("O") || gameLogic.gameBoard[1][0].equals("X"))
				
			{
				
				if (gameLogic.gameBoard[0][0].equals(" ") || gameLogic.gameBoard[0][0].equals("O") || gameLogic.gameBoard[0][0].equals("X"))
					
				{
				
					blockDir20++;
					
				}
				
			}
			
			blockDir[2][0] = blockDir20;
			
		}
		
		else
			
		{
			
			blockDir[2][0] = -1;
			
		}
	
	}
	
	/**
	 * Checks how many block directions are available at point (3,2), or at the game board index of [2][1].
	 * If a block direction is found, a count is incremented. Once all counts have been determined, the blockDir21 integer
	 * is added to the blockDir board at the index [2][1]. If that point is taken, then the blockDir board at index [2][1] is set to
	 * -1 to represent that there are no block directions possible.
	 */
	
	private void checkBlockDirection21()
	
	{
		
		int blockDir21 = 0;
		
		// Checking if point (3,2), or gameLogic.gameBoard[2][1], is taken with an "O" or an "X"
		
		if ( ! gameLogic.gameBoard[2][1].equals("O") && ! gameLogic.gameBoard[2][1].equals("X") )
					
		{
			
			// Checking the Horizontal Block Direction of point (3,2)
			
			if (gameLogic.gameBoard[2][0].equals(" ") || gameLogic.gameBoard[2][0].equals("O") || gameLogic.gameBoard[2][0].equals("X"))
				
			{
				
				if (gameLogic.gameBoard[2][2].equals(" ") || gameLogic.gameBoard[2][2].equals("O") || gameLogic.gameBoard[2][2].equals("X"))
					
				{
				
					blockDir21++;
					
				}
				
			}
			
			// Checking the Vertical Block Direction of point (3,2)
			
			if (gameLogic.gameBoard[1][1].equals(" ") || gameLogic.gameBoard[1][1].equals("O") || gameLogic.gameBoard[1][1].equals("X"))
				
			{
				
				if (gameLogic.gameBoard[0][1].equals(" ") || gameLogic.gameBoard[0][1].equals("O") || gameLogic.gameBoard[0][1].equals("X"))
					
				{
					
					blockDir21++;
					
				}
				
			}
			
			blockDir[2][1] = blockDir21;
			
		}
		
		else
			
		{
			
			blockDir[2][1] = -1;
			
		}
		
	}
	
	/**
	 * Checks how many block directions are available at point (3,3), or at the game board index of [2][2].
	 * If a block direction is found, a count is incremented. Once all counts have been determined, the blockDir22 integer
	 * is added to the blockDir board at the index [2][2]. If that point is taken, then the blockDir board at index [2][2] is set to
	 * -1 to represent that there are no block directions possible.
	 */
	
	public void checkBlockDirection22()
	
	{
		
		int blockDir22 = 0;
		
		// Checking if point (3,3), or gameLogic.gameBoard[2][2], is taken with an "O" or an "X"
		
		if ( ! gameLogic.gameBoard[2][2].equals("O") && ! gameLogic.gameBoard[2][2].equals("X") )
					
		{
			
			// Checking the Diagonal Block Direction of point (3,3)
			
			if (gameLogic.gameBoard[1][1].equals(" ") || gameLogic.gameBoard[1][1].equals("O") || gameLogic.gameBoard[1][1].equals("X"))
				
			{
				
				if (gameLogic.gameBoard[0][0].equals(" ") || gameLogic.gameBoard[0][0].equals("O") || gameLogic.gameBoard[0][0].equals("X"))
					
				{
				
					blockDir22++;
					
				}
				
			}
			
			// Checking the Horizontal Block Direction of point (3,3)
			
			if (gameLogic.gameBoard[2][1].equals(" ") || gameLogic.gameBoard[2][1].equals("O") || gameLogic.gameBoard[2][1].equals("X"))
				
			{
				
				if (gameLogic.gameBoard[2][0].equals(" ") || gameLogic.gameBoard[2][0].equals("O") || gameLogic.gameBoard[2][0].equals("X"))
					
				{
				
					blockDir22++;
					
				}
				
			}
			
			// Checking the Vertical Block Direction of point (3,3)
			
			if (gameLogic.gameBoard[1][2].equals(" ") || gameLogic.gameBoard[1][2].equals("O") || gameLogic.gameBoard[1][2].equals("X"))
					
			{
				
				if (gameLogic.gameBoard[0][2].equals(" ") || gameLogic.gameBoard[0][2].equals("O") || gameLogic.gameBoard[0][2].equals("X"))
					
				{
					
					blockDir22++;
					
				}
					
			}
			
			blockDir[2][2] = blockDir22;
			
		}
		
		else
			
		{
			
			blockDir[2][2] = -1;
			
		}
		
	}
	
	/**
	 * Calls all of the private methods in this class that check and count all block directions on the board for "O".
	 * This is the only public method in this AI_Block class to allow the AI class to evaluate all block directions.
	 */
	
	public void checkAllBlockDir()
	
	{
		
		checkBlockDirection00();
		checkBlockDirection01();
		checkBlockDirection02();
		checkBlockDirection10();
		checkBlockDirection11();
		checkBlockDirection12();
		checkBlockDirection20();
		checkBlockDirection21();
		checkBlockDirection22();

	}
	
}
