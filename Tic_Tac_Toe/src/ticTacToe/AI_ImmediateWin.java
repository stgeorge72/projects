package ticTacToe;

/**
 * This class checks all the possible immediate win directions for "O" to be used to determine the best move.
 */

public class AI_ImmediateWin

{

	/**
	 * The gameLogic variable is created to gain access to the public methods in the GameLogic class.
	 */
	
	private GameLogic gameLogic;
	
	/**
	 * The immediateWinDir variable checks if there are any immediate win directions on the board at every index.
	 * If a immediate win is found, that index will be replaced with the integer 2. If nothing is found
	 * the integer values remain at 0.
	 */
	
	public int[][] immediateWinDir = { {0, 0, 0}, {0, 0, 0}, {0, 0, 0} };
	
	/**
	 * This constructor initializes the GameLogic class to gain access to their public methods.
	 * 
	 * @param gameLogicInit Initializes the GameLogic class.
	 */
	
	public AI_ImmediateWin(GameLogic gameLogicInit)
	
	{
		
		gameLogic = gameLogicInit;
		
	}
	
	/**
	 * Checks if an immediate win opportunity is available for "O". If a win is available on the next turn for the AI
	 * at the point (1,1), or at the game board index of [0][0], at one of its win directions, then a count called immediateWin00 is increased
	 * by 2 and its value is stored at the index [0][0] in the immediateWinDir board. This method increments by 2 to differentiate the integer stored in the
	 * immediateWinDir board from the integer stored in the dangerDir board in the AI_Danger class (which increments by 1). If nothing is found,
	 * the integer value at the immediateWinDir index [0][0] remains at its initialized value of 0, meaning there is no immediate win move currently possible.
	 */
	
	private void checkImmediateWin00()
	
	{
		
		int immediateWin00 = 0;
		
		// Checking if point (1,1), or gameLogic.gameBoard[0][0], is taken with an "O" or an "X"
		
		if ( ! gameLogic.gameBoard[0][0].equals("O") && ! gameLogic.gameBoard[0][0].equals("X") )
					
		{
		
			// Checking the Diagonal Immediate Win Direction of point (1,1)
			
			if (gameLogic.gameBoard[1][1].equals("O") && gameLogic.gameBoard[2][2].equals("O"))
				
			{
					
				immediateWin00 += 2;
					
			}
			
			// Checking the Horizontal Immediate Win Direction of point (1,1)
			
			if (gameLogic.gameBoard[0][1].equals("O") && gameLogic.gameBoard[0][2].equals("O"))
				
			{
				
				immediateWin00 += 2;
				
			}
			
			// Checking the Vertical Immediate Win Direction of point (1,1)
			
			if (gameLogic.gameBoard[1][0].equals("O") && gameLogic.gameBoard[2][0].equals("O"))
				
			{
				
				immediateWin00 += 2;
				
			}
			
			immediateWinDir[0][0] = immediateWin00;
			
		}
		
	}
	
	/**
	 * Checks if an immediate win opportunity is available for "O". If a win is available on the next turn for the AI
	 * at the point (1,2), or at the game board index of [0][1], at one of its win directions, then a count called immediateWin01 is increased
	 * by 2 and its value is stored at the index [0][1] in the immediateWinDir board. This method increments by 2 to differentiate the integer stored in the
	 * immediateWinDir board from the integer stored in the dangerDir board in the AI_Danger class (which increments by 1). If nothing is found,
	 * the integer value at the immediateWinDir index [0][1] remains at its initialized value of 0, meaning there is no immediate win move currently possible.
	 */
	
	private void checkImmediateWin01()
		
	{
			
		int immediateWin01 = 0;
			
		// Checking if point (1,1), or gameLogic.gameBoard[0][1], is taken with an "O" or an "X"
		
		if ( ! gameLogic.gameBoard[0][1].equals("O") && ! gameLogic.gameBoard[0][1].equals("X") )
					
		{
			
			// Checking the Horizontal Immediate Win Direction of point (1,2)
			
			if (gameLogic.gameBoard[0][0].equals("O") && gameLogic.gameBoard[0][2].equals("O"))
				
			{
				
				immediateWin01 += 2;
				
			}
			
			// Checking the Vertical Immediate Win Direction of point (1,2)
			
			if (gameLogic.gameBoard[1][1].equals("O") && gameLogic.gameBoard[2][1].equals("O"))
				
			{
				
				immediateWin01 += 2;
				
			}
			
			immediateWinDir[0][1] = immediateWin01;
			
		}
				
	}
	
	/**
	 * Checks if an immediate win opportunity is available for "O". If a win is available on the next turn for the AI
	 * at the point (1,3), or at the game board index of [0][2], at one of its win directions, then a count called immediateWin02 is increased
	 * by 2 and its value is stored at the index [0][2] in the immediateWinDir board. This method increments by 2 to differentiate the integer stored in the
	 * immediateWinDir board from the integer stored in the dangerDir board in the AI_Danger class (which increments by 1). If nothing is found,
	 * the integer value at the immediateWinDir index [0][2] remains at its initialized value of 0, meaning there is no immediate win move currently possible.
	 */
	
	private void checkImmediateWin02()
	
	{
		
		int immediateWin02 = 0;
		
		// Checking if point (1,3), or gameLogic.gameBoard[0][2], is taken with an "O" or an "X"
		
		if ( ! gameLogic.gameBoard[0][2].equals("O") && ! gameLogic.gameBoard[0][2].equals("X") )
					
		{
			
			// Checking the Diagonal Immediate Win Direction of point (1,3)
			
			if (gameLogic.gameBoard[1][1].equals("O") && gameLogic.gameBoard[2][0].equals("O"))
				
			{
				
				immediateWin02 += 2;
				
			}
			
			// Checking the Horizontal Immediate Win Direction of point (1,3)
			
			if (gameLogic.gameBoard[0][1].equals("O") && gameLogic.gameBoard[0][0].equals("O"))
				
			{
				
				immediateWin02 += 2;
				
			}
			
			// Checking the Vertical Immediate Win Direction of point (1,3)
			
			if (gameLogic.gameBoard[1][2].equals("O") && gameLogic.gameBoard[2][2].equals("O"))
				
			{
				
				immediateWin02 += 2;
				
			}
			
			immediateWinDir[0][2] = immediateWin02;
			
		}
		
	}
	
	/**
	 * Checks if an immediate win opportunity is available for "O". If a win is available on the next turn for the AI
	 * at the point (2,1), or at the game board index of [1][0], at one of its win directions, then a count called immediateWin10 is increased
	 * by 2 and its value is stored at the index [1][0] in the immediateWinDir board. This method increments by 2 to differentiate the integer stored in the
	 * immediateWinDir board from the integer stored in the dangerDir board in the AI_Danger class (which increments by 1). If nothing is found,
	 * the integer value at the immediateWinDir index [1][0] remains at its initialized value of 0, meaning there is no immediate win move currently possible.
	 */
	
	private void checkImmediateWin10()
	
	{
		
		int immediateWin10 = 0;
			
		// Checking if point (2,1), or gameLogic.gameBoard[1][0], is taken with an "O" or an "X"
		
		if ( ! gameLogic.gameBoard[1][0].equals("O") && ! gameLogic.gameBoard[1][0].equals("X") )
					
		{

			// Checking the Horizontal Immediate Win Direction of point (2,1)
			
			if (gameLogic.gameBoard[1][1].equals("O") && gameLogic.gameBoard[1][2].equals("O"))
				
			{
				
				immediateWin10 += 2;
				
			}
			
			// Checking the Vertical Immediate Win Direction of point (2,1)
			
			if (gameLogic.gameBoard[0][0].equals("O") && gameLogic.gameBoard[2][0].equals("O"))
				
			{
				
				immediateWin10 += 2;
				
			}
			
			immediateWinDir[1][0] = immediateWin10;
			
		}
		
	}
	
	/**
	 * Checks if an immediate win opportunity is available for "O". If a win is available on the next turn for the AI
	 * at the point (2,2), or at the game board index of [1][1], at one of its win directions, then a count called immediateWin11 is increased
	 * by 2 and its value is stored at the index [1][1] in the immediateWinDir board. This method increments by 2 to differentiate the integer stored in the
	 * immediateWinDir board from the integer stored in the dangerDir board in the AI_Danger class (which increments by 1). If nothing is found,
	 * the integer value at the immediateWinDir index [1][1] remains at its initialized value of 0, meaning there is no immediate win move currently possible.
	 */
	
	private void checkImmediateWin11()
	
	{
		
		int immediateWin11 = 0;
		
		// Checking if point (2,2), or gameLogic.gameBoard[1][1], is taken with an "O" or an "X"
		
		if ( ! gameLogic.gameBoard[1][1].equals("O") && ! gameLogic.gameBoard[1][1].equals("X") )
					
		{

			// Checking the Left Diagonal Immediate Win Direction of point (2,2)
			
			if (gameLogic.gameBoard[0][0].equals("O") && gameLogic.gameBoard[2][2].equals("O"))
				
			{
				
				immediateWin11 += 2;
				
			}
			
			// Checking the Right Diagonal Immediate Win Direction of point (2,2)
			
			if (gameLogic.gameBoard[0][2].equals("O") && gameLogic.gameBoard[2][0].equals("O"))
				
			{
				
				immediateWin11 += 2;
				
			}
			
			// Checking the Horizontal Immediate Win Direction of point (2,2)
			
			if (gameLogic.gameBoard[1][0].equals("O") && gameLogic.gameBoard[1][2].equals("O"))
				
			{
				
				immediateWin11 += 2;
				
			}
			
			// Checking the Vertical Immediate Win Direction of point (2,2)
			
			if (gameLogic.gameBoard[0][1].equals("O") && gameLogic.gameBoard[2][1].equals("O"))
				
			{
				
				immediateWin11 += 2;
				
			}
			
			immediateWinDir[1][1] = immediateWin11;
			
		}		
		
	}
	
	/**
	 * Checks if an immediate win opportunity is available for "O". If a win is available on the next turn for the AI
	 * at the point (2,3), or at the game board index of [1][2], at one of its win directions, then a count called immediateWin12 is increased
	 * by 2 and its value is stored at the index [1][2] in the immediateWinDir board. This method increments by 2 to differentiate the integer stored in the
	 * immediateWinDir board from the integer stored in the dangerDir board in the AI_Danger class (which increments by 1). If nothing is found,
	 * the integer value at the immediateWinDir index [1][2] remains at its initialized value of 0, meaning there is no immediate win move currently possible.
	 */
	
	private void checkImmediateWin12()
	
	{
		
		int immediateWin12 = 0;
		
		// Checking if point (2,3), or gameLogic.gameBoard[1][2], is taken with an "O" or an "X"
		
		if ( ! gameLogic.gameBoard[1][2].equals("O") && ! gameLogic.gameBoard[1][2].equals("X") )
			
		{

			// Checking the Horizontal Immediate Win Direction of point (2,3)
			
			if (gameLogic.gameBoard[1][1].equals("O") && gameLogic.gameBoard[1][0].equals("O"))
				
			{
				
				immediateWin12 += 2;
				
			}
			
			// Checking the Vertical Immediate Win Direction of point (2,3)
			
			if (gameLogic.gameBoard[0][2].equals("O") && gameLogic.gameBoard[2][2].equals("O"))
				
			{
				
				immediateWin12 += 2;
				
			}
			
			immediateWinDir[1][2] = immediateWin12;
			
		}
		
	}
	
	/**
	 * Checks if an immediate win opportunity is available for "O". If a win is available on the next turn for the AI
	 * at the point (3,1), or at the game board index of [2][0], at one of its win directions, then a count called immediateWin20 is increased
	 * by 2 and its value is stored at the index [2][0] in the immediateWinDir board. This method increments by 2 to differentiate the integer stored in the
	 * immediateWinDir board from the integer stored in the dangerDir board in the AI_Danger class (which increments by 1). If nothing is found,
	 * the integer value at the immediateWinDir index [2][0] remains at its initialized value of 0, meaning there is no immediate win move currently possible.
	 */
	
	private void checkImmediateWin20()
	
	{
		
		int immediateWin20 = 0;
		
		// Checking if point (3,1), or gameLogic.gameBoard[2][0], is taken with an "O" or an "X"
		
		if ( ! gameLogic.gameBoard[2][0].equals("O") && ! gameLogic.gameBoard[2][0].equals("X") )
			
		{

			// Checking the Diagonal Immediate Win Direction of point (3,1)
			
			if (gameLogic.gameBoard[1][1].equals("O") && gameLogic.gameBoard[0][2].equals("O"))
				
			{
				
				immediateWin20 += 2;
				
			}
			
			// Checking the Horizontal Immediate Win Direction of point (3,1)
			
			if (gameLogic.gameBoard[2][1].equals("O") && gameLogic.gameBoard[2][2].equals("O"))
				
			{
				
				immediateWin20 += 2;
				
			}
			
			// Checking the Vertical Immediate Win Direction of point (3,1)
			
			if (gameLogic.gameBoard[1][0].equals("O") && gameLogic.gameBoard[0][0].equals("O"))
				
			{
				
				immediateWin20 += 2;
				
			}
			
			immediateWinDir[2][0] = immediateWin20;
		
		}
		
	}
	
	/**
	 * Checks if an immediate win opportunity is available for "O". If a win is available on the next turn for the AI
	 * at the point (3,2), or at the game board index of [2][1], at one of its win directions, then a count called immediateWin21 is increased
	 * by 2 and its value is stored at the index [2][1] in the immediateWinDir board. This method increments by 2 to differentiate the integer stored in the
	 * immediateWinDir board from the integer stored in the dangerDir board in the AI_Danger class (which increments by 1). If nothing is found,
	 * the integer value at the immediateWinDir index [2][1] remains at its initialized value of 0, meaning there is no immediate win move currently possible.
	 */
	
	private void checkImmediateWin21()
	
	{
		
		int immediateWin21 = 0;
		
		// Checking if point (3,2), or gameLogic.gameBoard[2][1], is taken with an "O" or an "X"
		
		if ( ! gameLogic.gameBoard[2][1].equals("O") && ! gameLogic.gameBoard[2][1].equals("X") )
			
		{

			// Checking the Horizontal Immediate Win of point (3,2)
			
			if (gameLogic.gameBoard[2][0].equals("O") && gameLogic.gameBoard[2][2].equals("O"))
				
			{
				
				immediateWin21 += 2;
				
			}
			
			// Checking the Vertical Immediate Win of point (3,2)
			
			if (gameLogic.gameBoard[1][1].equals("O") && gameLogic.gameBoard[0][1].equals("O"))
				
			{
				
				immediateWin21 += 2;
				
			}	
			
			immediateWinDir[2][1] = immediateWin21;
			
		}
		
	}
	
	/**
	 * Checks if an immediate win opportunity is available for "O". If a win is available on the next turn for the AI
	 * at the point (3,2), or at the game board index of [2][2], at one of its win directions, then a count called immediateWin22 is increased
	 * by 2 and its value is stored at the index [2][2] in the immediateWinDir board. This method increments by 2 to differentiate the integer stored in the
	 * immediateWinDir board from the integer stored in the dangerDir board in the AI_Danger class (which increments by 1). If nothing is found,
	 * the integer value at the immediateWinDir index [2][2] remains at its initialized value of 0, meaning there is no immediate win move currently possible.
	 */
	
	private void checkImmediateWin22()
	
	{
		
		int immediateWin22 = 0;
		
		// Checking if point (3,3), or gameLogic.gameBoard[2][2], is taken with an "O" or an "X"
		
		if ( ! gameLogic.gameBoard[2][2].equals("O") && ! gameLogic.gameBoard[2][2].equals("X") )
			
		{

			// Checking the Diagonal Immediate Win Direction of point (3,3)
			
			if (gameLogic.gameBoard[1][1].equals("O") && gameLogic.gameBoard[0][0].equals("O"))
				
			{
				
				immediateWin22 += 2;
				
			}
			
			// Checking the Horizontal Immediate Win Direction of point (3,3)
			
			if (gameLogic.gameBoard[2][1].equals("O") && gameLogic.gameBoard[2][0].equals("O"))
				
			{
				
				immediateWin22 += 2;
				
			}	
			
			// Checking the Vertical Immediate Win Direction of point (3,3)
			
			if (gameLogic.gameBoard[1][2].equals("O") && gameLogic.gameBoard[0][2].equals("O"))
				
			{
				
				immediateWin22 += 2;
				
			}	
			
			immediateWinDir[2][2] = immediateWin22;
			
		}
				
	}
	
	/**
	 * Calls all of the private methods in this class that checks if an immediate win direction exists on the board for "O".
	 * This is the only public method in this AI_ImmediateWin class to allow the AI class to evaluate if any immediate win direction
	 * exists.
	 */
	
	public void checkAllImmediateWins()
	
	{
		
		checkImmediateWin00();
		checkImmediateWin01();
		checkImmediateWin02();
		checkImmediateWin10();
		checkImmediateWin11();
		checkImmediateWin12();
		checkImmediateWin20();
		checkImmediateWin21();
		checkImmediateWin22();
		
	}
	
}
