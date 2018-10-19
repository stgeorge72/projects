package ticTacToe;

import java.util.Arrays;

/**
 * This class checks all the possible danger of losing directions for "O" to be used to block the opponent from winning.
 * If a danger move is found on the board, it will take priority over all other possible moves.
 */

public class AI_Danger

{

	/**
	 * The gameLogic variable is created to gain access to the public methods in the GameLogic class.
	 */
	
	private GameLogic gameLogic;
	
	/**
	 * The dangerDir variable checks if any danger of losing directions exist at any
	 * point on the board. If a danger move is found, that index will be replaced with the integer 1 and that move will take
	 * priority over all other possible moves on the board. If nothing is found, the integer values remain at 0.
	 */
	
	public int[][] dangerDir = { {0, 0, 0}, {0, 0, 0}, {0, 0, 0} };
	
	/**
	 * This constructor initializes the GameLogic class to gain access to their public methods.
	 * 
	 * @param gameLogicInit Initializes the GameLogic class.
	 */
	
	public AI_Danger(GameLogic gameLogicInit)
	
	{
		
		gameLogic = gameLogicInit;
		
	}
	
	/**
	 * This method checks 8 different edge cases that the other AI logic in the AI_Win, AI_Block, AI_ImmediateWin, and AI_Danger
	 * classes cannot compensate for.
	 * The first 2 edge cases (leftDiagonalCase, rightDiagonalCase) cover if the user moves to any of the four corners on the board first.
	 * The next 2 edge cases (upperMidCase, bottomMidCase) cover if the user moves to the top middle or bottom middle first.
	 * The next 2 edge cases (leftMidRightDiagonalCase, rightMidLeftDiagonalCase) cover if the user moves to the left middle and the upper right corner
	 * or right middle and the upper left corner first.
	 * The last 2 edge cases (leftDiagonalBottomMidCase, rightDiagonalBottomMidCase) cover if the user moves to the left corner and the bottom middle or
	 * the right corner and the bottom middle first.
	 * These 8 cases are common "trap" cases in Tic Tac Toe.
	 * 
	 * If leftDiagonalCase equals the current board, then the AI will prioritize a move at index [1][0] ignoring any other potential moves.
	 * If rightDiagonalCase equals the current board, then the AI will prioritize a move at index [1][2] ignoring any other potential moves.
	 * If upperMidCase equals the current board, then the AI will prioritize a move at index [0][0] ignoring any other potential moves.
	 * If bottomMidCase equals the current board, then the AI will prioritize a move at index [2][2] ignoring any other potential moves.
	 * If leftMidRightDiagonalCase equals the current board, then the AI will prioritize a move at index [0][0] ignoring any other potential moves.
	 * If rightMidLeftDiagonalCase equals the current board, then the AI will prioritize a move at index [0][2] ignoring any other potential moves.
	 * If leftDiagonalBottomMidCase equals the current board, then the AI will prioritize a move at index [2][0] ignoring any other potential moves.
	 * If rightDiagonalBottomMidCase equals the current board, then the AI will prioritize a move at index [2][2] ignoring any other potential moves.
	 */
	
	private void edgeCaseCheck()
	
	{
		
		int edgeCaseFlag = 0;
		
		String[][] leftDiagonalCase = { {"X", " ", " "},  {" ", "O", " "}, {" ", " ", "X"} };
		
		String[][] rightDiagonalCase = { {" ", " ", "X"},  {" ", "O", " "}, {"X", " ", " "} };
		
		String[][] upperMidCase = { {" ", "X", " "},  {" ", " ", " "}, {" ", " ", " "} };
		
		String[][] bottomMidCase = { {" ", " ", " "},  {" ", " ", " "}, {" ", "X", " "} };
		
		String[][] leftMidRightDiagonalCase = { {" ", " ", "X"},  {"X", "O", " "}, {" ", " ", " "} };
		
		String[][] rightMidLeftDiagonalCase = { {"X", " ", " "},  {" ", "O", "X"}, {" ", " ", " "} };
		
		String[][] leftDiagonalBottomMidCase = { {"X", " ", " "},  {" ", "O", " "}, {" ", "X", " "} };
		
		String[][] rightDiagonalBottomMidCase = { {" ", " ", "X"},  {" ", "O", " "}, {" ", "X", " "} };
		
		
		if (Arrays.deepEquals(gameLogic.gameBoard, leftDiagonalCase))
			
		{

			edgeCaseFlag++;
			dangerDir[1][0] = edgeCaseFlag;
			
		}
		
		if (Arrays.deepEquals(gameLogic.gameBoard, rightDiagonalCase))
			
		{
			
			edgeCaseFlag++;
			dangerDir[1][2] = edgeCaseFlag;
			
		}

		
		if (Arrays.deepEquals(gameLogic.gameBoard, upperMidCase))
		
		{
			
			edgeCaseFlag++;
			dangerDir[0][0] = edgeCaseFlag;
			
		}
		
		if (Arrays.deepEquals(gameLogic.gameBoard, bottomMidCase))
			
		{
			
			edgeCaseFlag++;
			dangerDir[2][2] = edgeCaseFlag;
			
		}
		
		if (Arrays.deepEquals(gameLogic.gameBoard, leftMidRightDiagonalCase))
			
		{
			
			edgeCaseFlag++;
			dangerDir[0][0] = edgeCaseFlag;
			
		}
		
		if (Arrays.deepEquals(gameLogic.gameBoard, rightMidLeftDiagonalCase))
			
		{
			
			edgeCaseFlag++;
			dangerDir[0][2] = edgeCaseFlag;
			
		}
		
		if (Arrays.deepEquals(gameLogic.gameBoard, leftDiagonalBottomMidCase))
			
		{
			
			edgeCaseFlag++;
			dangerDir[2][0] = edgeCaseFlag;
			
		}
		
		if (Arrays.deepEquals(gameLogic.gameBoard, rightDiagonalBottomMidCase))
			
		{
			
			edgeCaseFlag++;
			dangerDir[2][2] = edgeCaseFlag;
			
		}

	}
	
	/**
	 * Checks if "O" is in danger of losing the game at the point (1,1), or at the game board index of [0][0],
	 * by checking if its "danger" directions are occupied by 2 "X"s. If the AI is about to lose the game at this index then
	 * the dangerDir00 variable is incremented by 1 and its value is stored at the index [0][0] in the dangerDir board telling
	 * the AI to move immediately at the point (1,1) disregarding any other possible move. EXCEPTION: If dangerDir indexed
	 * at [0][0] is already 1 because of an edge case assignment, then the assignment of the dangerDir00 integer will be ignored
	 * until the next turn. If no danger moves are found, then the integer value at the dangerDir index [0][0] remains at its
	 * initialized value of 0.
	 */
	
	private void checkDanger00()
	
	{
		
		int dangerDir00 = 0;
		
		// Checking if point (1,1), or gameLogic.gameBoard[0][0], is taken with an "O" or an "X"
		
		if ( ! gameLogic.gameBoard[0][0].equals("O") && ! gameLogic.gameBoard[0][0].equals("X") )
					
		{
		
			// Checking the Diagonal Danger Direction of point (1,1)
			
			if (gameLogic.gameBoard[1][1].equals("X") && gameLogic.gameBoard[2][2].equals("X"))
				
			{

				dangerDir00++;
					
			}
			
			// Checking the Horizontal Danger Direction of point (1,1)
			
			if (gameLogic.gameBoard[0][1].equals("X") && gameLogic.gameBoard[0][2].equals("X"))
				
			{

				dangerDir00++;
				
			}
			
			// Checking the Vertical Danger Direction of point (1,1)
			
			if (gameLogic.gameBoard[1][0].equals("X") && gameLogic.gameBoard[2][0].equals("X"))
				
			{

				dangerDir00++;
				
			}
			
			if (dangerDir[0][0] != 1)
				
			{

				dangerDir[0][0] = dangerDir00;
				
			}
			
		}
		
	}
	
	/**
	 * Checks if "O" is in danger of losing the game at the point (1,2), or at the game board index of [0][1],
	 * by checking if its "danger" directions are occupied by 2 "X"s. If the AI is about to lose the game at this index then
	 * the dangerDir01 variable is incremented by 1 and its value is stored at the index [0][1] in the dangerDir board telling
	 * the AI to move immediately at the point (1,2) disregarding any other possible move. If no danger moves are found,
	 * then the integer value at the dangerDir index [0][1] remains at its initialized value of 0.
	 */
	
	private void checkDanger01()
		
	{
			
		int dangerDir01 = 0;
			
		// Checking if point (1,2), or gameLogic.gameBoard[0][1], is taken with an "O" or an "X"
		
		if ( ! gameLogic.gameBoard[0][1].equals("O") && ! gameLogic.gameBoard[0][1].equals("X") )
					
		{
			
			// Checking the Horizontal Danger Direction of point (1,2)
			
			if (gameLogic.gameBoard[0][0].equals("X") && gameLogic.gameBoard[0][2].equals("X"))
				
			{
				
				dangerDir01++;
				
			}
			
			// Checking the Vertical Danger Direction of point (1,2)
			
			if (gameLogic.gameBoard[1][1].equals("X") && gameLogic.gameBoard[2][1].equals("X"))
				
			{
				
				dangerDir01++;
				
			}
			
			dangerDir[0][1] = dangerDir01;
			
		}
				
	}
	
	/**
	 * Checks if "O" is in danger of losing the game at the point (1,3), or at the game board index of [0][2],
	 * by checking if its "danger" directions are occupied by 2 "X"s. If the AI is about to lose the game at this index then
	 * the dangerDir02 variable is incremented by 1 and its value is stored at the index [0][2] in the dangerDir board telling
	 * the AI to move immediately at the point (1,3) disregarding any other possible move. EXCEPTION: If dangerDir indexed
	 * at [0][2] is already 1 because of an edge case assignment, then the assignment of the dangerDir02 integer will be ignored
	 * until the next turn. If no danger moves are found, then the integer value at the dangerDir index [0][2] remains at its
	 * initialized value of 0.
	 */
	
	private void checkDanger02()
	
	{
		
		int dangerDir02 = 0;
		
		// Checking if point (1,3), or gameLogic.gameBoard[0][2], is taken with an "O" or an "X"
		
		if ( ! gameLogic.gameBoard[0][2].equals("O") && ! gameLogic.gameBoard[0][2].equals("X") )
					
		{
			
			// Checking the Diagonal Danger Direction of point (1,3)
			
			if (gameLogic.gameBoard[1][1].equals("X") && gameLogic.gameBoard[2][0].equals("X"))
				
			{
				
				dangerDir02++;
				
			}
			
			// Checking the Horizontal Danger Direction of point (1,3)
			
			if (gameLogic.gameBoard[0][1].equals("X") && gameLogic.gameBoard[0][0].equals("X"))
				
			{
				
				dangerDir02++;
				
			}
			
			// Checking the Vertical Danger Direction of point (1,3)
			
			if (gameLogic.gameBoard[1][2].equals("X") && gameLogic.gameBoard[2][2].equals("X"))
				
			{
				
				dangerDir02++;
				
			}
			
			if (dangerDir[0][2] != 1)
				
			{
			
				dangerDir[0][2] = dangerDir02;
				
			}
			
		}
		
	}
	
	/**
	 * Checks if "O" is in danger of losing the game at the point (2,1), or at the game board index of [1][0],
	 * by checking if its "danger" directions are occupied by 2 "X"s. If the AI is about to lose the game at this index then
	 * the dangerDir10 variable is incremented by 1 and its value is stored at the index [1][0] in the dangerDir board telling
	 * the AI to move immediately at the point (2,1) disregarding any other possible move. EXCEPTION: If dangerDir indexed
	 * at [1][0] is already 1 because of an edge case assignment, then the assignment of the dangerDir10 integer will be ignored
	 * until the next turn. If no danger moves are found, then the integer value at the dangerDir index [1][0] remains at its
	 * initialized value of 0.
	 */
	
	private void checkDanger10()
	
	{
		
		int dangerDir10 = 0;
			
		// Checking if point (2,1), or gameLogic.gameBoard[1][0], is taken with an "O" or an "X"
		
		if ( ! gameLogic.gameBoard[1][0].equals("O") && ! gameLogic.gameBoard[1][0].equals("X") )
					
		{

			// Checking the Horizontal Danger Direction of point (2,1)
			
			if (gameLogic.gameBoard[1][1].equals("X") && gameLogic.gameBoard[1][2].equals("X"))
				
			{
				
				dangerDir10++;
				
			}
			
			// Checking the Vertical Danger Direction of point (2,1)
			
			if (gameLogic.gameBoard[0][0].equals("X") && gameLogic.gameBoard[2][0].equals("X"))
				
			{
				
				dangerDir10++;
				
			}
			
			if (dangerDir[1][0] != 1)
				
			{
			
				dangerDir[1][0] = dangerDir10;
				
			}
			
		}
		
	}
	
	/**
	 * Checks if "O" is in danger of losing the game at the point (2,2), or at the game board index of [1][1],
	 * by checking if its "danger" directions are occupied by 2 "X"s. If the AI is about to lose the game at this index then
	 * the dangerDir11 variable is incremented by 1 and its value is stored at the index [1][1] in the dangerDir board telling
	 * the AI to move immediately at the point (2,2) disregarding any other possible move. If no danger moves are found,
	 * then the integer value at the dangerDir index [1][1] remains at its initialized value of 0.
	 */
	
	private void checkDanger11()
	
	{
		
		int dangerDir11 = 0;
		
		// Checking if point (2,2), or gameLogic.gameBoard[1][1], is taken with an "O" or an "X"
		
		if ( ! gameLogic.gameBoard[1][1].equals("O") && ! gameLogic.gameBoard[1][1].equals("X") )
					
		{

			// Checking the Left Diagonal Danger Direction of point (2,2)
			
			if (gameLogic.gameBoard[0][0].equals("X") && gameLogic.gameBoard[2][2].equals("X"))
				
			{
				
				dangerDir11++;
				
			}
			
			// Checking the Right Diagonal Danger Direction of point (2,2)
			
			if (gameLogic.gameBoard[0][2].equals("X") && gameLogic.gameBoard[2][0].equals("X"))
				
			{
				
				dangerDir11++;
				
			}
			
			// Checking the Horizontal Danger Direction of point (2,2)
			
			if (gameLogic.gameBoard[1][0].equals("X") && gameLogic.gameBoard[1][2].equals("X"))
				
			{
				
				dangerDir11++;
				
			}
			
			// Checking the Vertical Danger Direction of point (2,2)
			
			if (gameLogic.gameBoard[0][1].equals("X") && gameLogic.gameBoard[2][1].equals("X"))
				
			{
				
				dangerDir11++;
				
			}
			
			dangerDir[1][1] = dangerDir11;
			
		}		
		
	}
	
	/**
	 * Checks if "O" is in danger of losing the game at the point (2,3), or at the game board index of [1][2],
	 * by checking if its "danger" directions are occupied by 2 "X"s. If the AI is about to lose the game at this index then
	 * the dangerDir12 variable is incremented by 1 and its value is stored at the index [1][2] in the dangerDir board telling
	 * the AI to move immediately at the point (2,3) disregarding any other possible move. EXCEPTION: If dangerDir indexed
	 * at [1][2] is already 1 because of an edge case assignment, then the assignment of the dangerDir12 integer will be ignored
	 * until the next turn. If no danger moves are found, then the integer value at the dangerDir index [1][2] remains at its
	 * initialized value of 0.
	 */
	
	private void checkDanger12()
	
	{
		
		int dangerDir12 = 0;
		
		// Checking if point (2,3), or gameLogic.gameBoard[1][2], is taken with an "O" or an "X"
		
		if ( ! gameLogic.gameBoard[1][2].equals("O") && ! gameLogic.gameBoard[1][2].equals("X") )
			
		{

			// Checking the Horizontal Danger Direction of point (2,3)
			
			if (gameLogic.gameBoard[1][1].equals("X") && gameLogic.gameBoard[1][0].equals("X"))
				
			{
				
				dangerDir12++;
				
			}
			
			// Checking the Vertical Danger Direction of point (2,3)
			
			if (gameLogic.gameBoard[0][2].equals("X") && gameLogic.gameBoard[2][2].equals("X"))
				
			{

				dangerDir12++;
				
			}
			
			if (dangerDir[1][2] != 1)
				
			{

				dangerDir[1][2] = dangerDir12;
				
			}
			
		}
		
	}
	
	/**
	 * Checks if "O" is in danger of losing the game at the point (3,1), or at the game board index of [2][0],
	 * by checking if its "danger" directions are occupied by 2 "X"s. If the AI is about to lose the game at this index then
	 * the dangerDir20 variable is incremented by 1 and its value is stored at the index [2][0] in the dangerDir board telling
	 * the AI to move immediately at the point (3,1) disregarding any other possible move. If no danger moves are found,
	 * then the integer value at the dangerDir index [2][0] remains at its initialized value of 0.
	 */
	
	private void checkDanger20()
	
	{
		
		int dangerDir20 = 0;
		
		// Checking if point (3,1), or gameLogic.gameBoard[2][0], is taken with an "O" or an "X"
		
		if ( ! gameLogic.gameBoard[2][0].equals("O") && ! gameLogic.gameBoard[2][0].equals("X") )
			
		{

			// Checking the Diagonal Danger Direction of point (3,1)
			
			if (gameLogic.gameBoard[1][1].equals("X") && gameLogic.gameBoard[0][2].equals("X"))
				
			{
				
				dangerDir20++;
				
			}
			
			// Checking the Horizontal Danger Direction of point (3,1)
			
			if (gameLogic.gameBoard[2][1].equals("X") && gameLogic.gameBoard[2][2].equals("X"))
				
			{
				
				dangerDir20++;
				
			}
			
			// Checking the Vertical Danger Direction of point (3,1)
			
			if (gameLogic.gameBoard[1][0].equals("X") && gameLogic.gameBoard[0][0].equals("X"))
				
			{
				
				dangerDir20++;
				
			}
			
			if (dangerDir[2][0] != 1)
				
			{
			
				dangerDir[2][0] = dangerDir20;
				
			}

		}
		
	}
	
	/**
	 * Checks if "O" is in danger of losing the game at the point (3,2), or at the game board index of [2][1],
	 * by checking if its "danger" directions are occupied by 2 "X"s. If the AI is about to lose the game at this index then
	 * the dangerDir21 variable is incremented by 1 and its value is stored at the index [2][1] in the dangerDir board telling
	 * the AI to move immediately at the point (3,2) disregarding any other possible move. If no danger moves are found,
	 * then the integer value at the dangerDir index [2][1] remains at its initialized value of 0.
	 */
	
	private void checkDanger21()
	
	{
		
		int dangerDir21 = 0;
		
		// Checking if point (3,2), or gameLogic.gameBoard[2][1], is taken with an "O" or an "X"
		
		if ( ! gameLogic.gameBoard[2][1].equals("O") && ! gameLogic.gameBoard[2][1].equals("X") )
			
		{

			// Checking the Horizontal Danger Direction of point (3,2)
			
			if (gameLogic.gameBoard[2][0].equals("X") && gameLogic.gameBoard[2][2].equals("X"))
				
			{
				
				dangerDir21++;
				
			}
			
			// Checking the Vertical Danger Direction of point (3,2)
			
			if (gameLogic.gameBoard[1][1].equals("X") && gameLogic.gameBoard[0][1].equals("X"))
				
			{
				
				dangerDir21++;
				
			}	
			
			dangerDir[2][1] = dangerDir21;
			
		}
		
	}
	
	/**
	 * Checks if "O" is in danger of losing the game at the point (3,3), or at the game board index of [2][2],
	 * by checking if its "danger" directions are occupied by 2 "X"s. If the AI is about to lose the game at this index then
	 * the dangerDir22 variable is incremented by 1 and its value is stored at the index [2][2] in the dangerDir board telling
	 * the AI to move immediately at the point (3,3) disregarding any other possible move. EXCEPTION: If dangerDir indexed
	 * at [2][2] is already 1 because of an edge case assignment, then the assignment of the dangerDir22 integer will be ignored
	 * until the next turn. If no danger moves are found, then the integer value at the dangerDir index [2][2] remains at its
	 * initialized value of 0.
	 */
	
	private void checkDanger22()
	
	{
		
		int dangerDir22 = 0;
		
		// Checking if point (3,3), or gameLogic.gameBoard[2][2], is taken with an "O" or an "X"
		
		if ( ! gameLogic.gameBoard[2][2].equals("O") && ! gameLogic.gameBoard[2][2].equals("X") )
			
		{

			// Checking the Diagonal Danger Direction of point (3,3)
			
			if (gameLogic.gameBoard[1][1].equals("X") && gameLogic.gameBoard[0][0].equals("X"))
				
			{
				
				dangerDir22++;
				
			}
			
			// Checking the Horizontal Danger Direction of point (3,3)
			
			if (gameLogic.gameBoard[2][1].equals("X") && gameLogic.gameBoard[2][0].equals("X"))
				
			{
				
				dangerDir22++;
				
			}	
			
			// Checking the Vertical Danger Direction of point (3,3)
			
			if (gameLogic.gameBoard[1][2].equals("X") && gameLogic.gameBoard[0][2].equals("X"))
				
			{
				
				dangerDir22++;
				
			}	
			
			if (dangerDir[2][2] != 1)
				
			{
			
				dangerDir[2][2] = dangerDir22;
				
			}
			
		}
				
	}
	
	/**
	 * Calls all of the private methods in this class that check if a danger direction exists on the game board for "O".
	 * This is the only public method in this AI_Danger class to allow the AI class to evaluate if any danger direction
	 * exists.
	 */
	
	public void checkAllDangerDir()
	
	{
		
		edgeCaseCheck();
		checkDanger00();
		checkDanger01();
		checkDanger02();
		checkDanger10();
		checkDanger11();
		checkDanger12();
		checkDanger20();
		checkDanger21();
		checkDanger22();
		
	}
	
}
