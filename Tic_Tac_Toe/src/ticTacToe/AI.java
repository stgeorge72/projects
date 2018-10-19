package ticTacToe;

/**
 * This class uses the public methods and variables in the AI_Win, AI_Block, AI_ImmediateWin, and AI_Danger classes
 * to create an AI that can never lose at Tic Tac Toe.
 *
 */

public class AI

{
	
	/**
	 * The gameLogic variable is created to gain access to the public methods in the GameLogic class.
	 */
	
	private GameLogic gameLogic;
	
	/**
	 * The aiWin variable is created to gain access to the public methods in the AI_Win class.
	 */
	
	private AI_Win aiWin;
	
	/**
	 * The aiBlock variable is created to gain access to the public methods in the AI_Block class.
	 */
	
	private AI_Block aiBlock;
	
	/**
	 * The aiImmediateWin variable is created to gain access to the public methods in the AI_ImmediateWin class.
	 */
	
	private AI_ImmediateWin aiImmediateWin;
	
	/**
	 * The aiDanger variable is created to gain access to the public methods in the AI_Danger class.
	 */
	
	private AI_Danger aiDanger;
	
	
	/**
	 * This constructor initializes the GameLogic, AI_Win, AI_Block, AI_ImmediateWin, and AI_Danger classes to gain access to their methods.
	 * 
	 * @param gameLogicInit Initializes the GameLogic class.
	 * @param aiWinInit Initializes the AI_Win class.
	 * @param aiBlockInit Initializes the AI_Block class.
	 * @param immediateWinInit Initializes the AI_ImmediateWin class.
	 * @param aiDangerInit Initializes the AI_Danger class.
	 */
	
	public AI(GameLogic gameLogicInit, AI_Win aiWinInit, AI_Block aiBlockInit, AI_ImmediateWin immediateWinInit, AI_Danger aiDangerInit)
	
	{
		
		gameLogic = gameLogicInit;
		aiWin = aiWinInit;
		aiBlock = aiBlockInit;
		aiImmediateWin = immediateWinInit;
		aiDanger = aiDangerInit;
		
	}

	/**
	 * Evaluates all possible win directions, block directions, danger of losing directions, and immediate win directions
	 * for "O" in the AI_Win, AI_Block, AI_ImmediateWin, and AI_Danger classes respectively and returns their dedicated
	 * counts to their respective 2D array.
	 */
	
	public void evaluateBoard()
	
	{
		
		aiWin.checkAllWinDir();
		aiBlock.checkAllBlockDir();
		aiImmediateWin.checkAllImmediateWins();
		aiDanger.checkAllDangerDir();
		
	}
	
	/**
	 * Determines the best move by checking the win directions and the block directions for "O" and adds both the win and block
	 * integers at every index in a for loop. The best move is based on the addition of the win and block directions and the highest number added
	 * is the move that is placed on the board at that recorded index by the AI.
	 * 
	 * Another for loop underneath the win and block for loop checks if the AI is about to win and if not it checks if it is about to
	 * lose. If the AI is about to win, an "O" is placed on the last win index to win the game. If the AI is in danger of losing, and
	 * the AI is not immediately going to win, the AI prioritizes a move to block the opponent from wining.
	 */
	
	public void AI_BestMove()
	
	{
		
		int bestMoveIndexI = 0;
		int bestMoverIndexJ = 0;
		int bestMove = 0;
		
		for (int i = 0; i < aiWin.winDir.length; i++)
			
		{
			
			for (int j = 0; j < aiBlock.blockDir.length; j++)
				
			{
				
				if (aiBlock.blockDir[i][j] > 0 && aiWin.winDir[i][j] > 0)
					
				{
					
					if ( (aiBlock.blockDir[i][j] + aiWin.winDir[i][j]) > bestMove)
						
					{

						bestMove = aiBlock.blockDir[i][j] + aiWin.winDir[i][j];
						bestMoveIndexI = i;
						bestMoverIndexJ = j;
						
					}
					
				}
				
			}
			
		}
		
		outerLoop:
		for (int i = 0; i < aiImmediateWin.immediateWinDir.length; i++)
			
		{
			
			for(int j = 0; j < aiDanger.dangerDir.length; j++)
			
			{

				if (aiImmediateWin.immediateWinDir[i][j] == 2)
					
				{

					bestMoveIndexI = i;
					bestMoverIndexJ = j;
					break outerLoop;
					
				}
				
				else if (aiDanger.dangerDir[i][j] == 1)
					
				{
					
					bestMoveIndexI = i;
					bestMoverIndexJ = j;
					aiDanger.dangerDir[i][j] = 0;
					
				}	
				
			}
			
		}

		gameLogic.gameBoard[bestMoveIndexI][bestMoverIndexJ] = "O";
		
	}
	
}
