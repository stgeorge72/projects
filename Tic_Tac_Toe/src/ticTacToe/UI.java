package ticTacToe;

import java.util.Scanner;

/**
 * This class provides the user interface interaction for the player including, but not limited to, inputing moves and printing the Tic Tac Toe game board.
 */

public class UI

{
	
	/**
	 * The gameLogic variable is used to gain access to the public methods in the GameLogic class.
	 */
	
	private GameLogic gameLogic;
	
	/**
	 * The ai variable is used to gain access to the public methods in the AI class.
	 */
	
	private AI ai;
	
	/**
	 * This constructor initializes the GameLogic and AI classes to call their public methods. 
	 * 
	 * @param gameLogicInit Initializes the GameLogic class.
	 * @param aiInit Initializes the AI class.
	 */
	
	public UI(GameLogic gameLogicInit, AI aiInit)
	
	{
		
		gameLogic = gameLogicInit;
		ai = aiInit;
		
	}
	
	/**
	 * Prints the game instructions and coordinate input examples to the console in an easily readable format.
	 */
	
	public void gameInstructions()
	
	{
		
		System.out.println("Welcome to Tic Tac Toe!");
		System.out.println();
		
		System.out.println("Instructions:");
		System.out.println();
		
		System.out.println("- The Computer (AI) will be O and the Player (you) will be X.");
		System.out.println();
		
		System.out.println("- You, the player, will decide if you would like the Computer (AI) to go first or not.");
		System.out.println();
		
		System.out.println("- To make a move, when prompted, type a row followed by a single space then a column. For example"
				+ ", to place a move onto the upper right-hand corner of the board, type \"1 3\".");
		System.out.println();
		
		System.out.println("Given the input of \"1 3\", the board shall display as follows:");
		System.out.println();
		
		System.out.println("    1   2   3");
		System.out.println();
		
		System.out.println(" 1  " + " " + " | " + " " + " | " + "X");
		
		System.out.println("    ----------");
		
		System.out.println(" 2  " + " " + " | " + " " + " | " + " ");
		
		System.out.println("    ----------");
		
		System.out.println(" 3  " + " " + " | " + " " + " | " + " ");
		
		System.out.println();
		
	}
	
	/**
	 * Allows the user to start the game by pressing enter.
	 */
	
	public void startGame()
	
	{
		
		System.out.println("Press ENTER to start the game.");
		Scanner startGame = new Scanner(System.in);

		startGame.nextLine();
		
	}
	
	/**
	 * Takes in user input to ask the player if they would like the computer or themselves to place the first move.
	 * 
	 * @return Returns "O", if the computer is selected to go first, or "X", if the player would like to go first.
	 */
	
	public String whoGoesFirst()
	
	{
		
		String whoGoesFirst;

		while (true)
			
		{
		
			Scanner computerOrPlayer = new Scanner(System.in);
			System.out.println("Would you like the computer to go first?");
			System.out.print("NOTE: You may type : \"Yes\", \"Y\", \"No\", or \"N\" (Not Case Sensitive) : ");
			
			String userSelection = computerOrPlayer.nextLine();
			
			if (userSelection.toUpperCase().equals("Y") || userSelection.toUpperCase().equals("YES"))
				
			{
				
				whoGoesFirst = "O";
				break;
				
			}
			
			else if (userSelection.toUpperCase().equals("N") || userSelection.toUpperCase().equals("NO"))
			
			{
				
				whoGoesFirst = "X";
				break;

			}
			
			else
				
			{
				
				System.out.println();
				System.out.println("Invalid input. Please type a valid Yes or No.");
				System.out.println();
				continue;
				
			}
			
		}
		
		System.out.println();
		
		return whoGoesFirst;
		
	}
	
	/**
	 * Captures input from the user to record and implement their desired move and update the game board.
	 * The input format must be an integer followed by a single space then another integer with both integers needing to be between 1 and 3.
	 * If the user input is not in the proper format, an exception will be raised and be thrown to the catch statement
	 * where the user will be re-prompted for valid input in the required format.
	 * If the input is valid, then the move is updated on the game board with an "X".
	 */
	
	public void coordInput()
	
	{
		
		String[] rowCol;
		int row;
		int col;
		
		while (true)
			
		{

			System.out.print("Please enter the row and column where you would like to place an \"X\": ");
			Scanner rowColInput = new Scanner(System.in);
			
			rowCol = rowColInput.nextLine().split(" ");
			
			try
			
			{
				
				row = Integer.parseInt(rowCol[0]);
				col = Integer.parseInt(rowCol[1]);
				
				if (row > 3 || row < 0 || col > 3 || col < 0)
					
				{
					
					System.out.println();
					System.out.println("Input is out of bounds. Please move to an empty space on the board.");
					System.out.println();
					continue;
					
				}
				
				if (gameLogic.gameBoard[row - 1][col - 1].equals("O") || gameLogic.gameBoard[row - 1][col - 1].equals("X"))
					
				{
					
					System.out.println();
					System.out.println("Your inputed move is already occupied by a character on the board. Please move to an empty space on the board.");
					System.out.println();
					continue;
					
				}
				
				break;
				
			}
			
			catch(NumberFormatException except)
			
			{
				
				System.out.println();
				System.out.println("Invalid coordiantes.");
				System.out.println();
				System.out.println("Remember: To make a move, please type the row, followed by a space, then a column like this -> \"1 3\" "
						+ "and make sure your row and column inputs are between 1 and 3.");
				System.out.println();
				continue;
				
			}
			
		}
		
		System.out.println();
		
		gameLogic.gameBoard[row - 1][col - 1] = "X";

	}
	
	/**
	 * Prints the current Tic Tac Toe board to the console and an easily readable format.
	 */
	
	public void printBoard()
	
	{
		
		System.out.println("    1   2   3");
		System.out.println();
		
		System.out.println(" 1  " + gameLogic.gameBoard[0][0] + " | " + gameLogic.gameBoard[0][1] + " | " + gameLogic.gameBoard[0][2]);
		
		System.out.println("    ----------");
		
		System.out.println(" 2  " + gameLogic.gameBoard[1][0] + " | " + gameLogic.gameBoard[1][1] + " | " + gameLogic.gameBoard[1][2]);
		
		System.out.println("    ----------");
		
		System.out.println(" 3  " + gameLogic.gameBoard[2][0] + " | " + gameLogic.gameBoard[2][1] + " | " + gameLogic.gameBoard[2][2]);
		
		System.out.println();
		
	}
	
	/**
	 * Runs the Tic Tac Toe game in its entirety.
	 * A while loop runs until a winner is found or the game is tied.
	 */
	
	public void runGame()
	
	{
		
		gameInstructions();
		startGame();
		String currentTurn;
		currentTurn = whoGoesFirst();
		
		if (currentTurn.equals("X"))
			
		{
			
			printBoard();
			
		}
		
		while (true)
			
		{
			
			if (currentTurn.equals("O"))
				
			{
				
				ai.evaluateBoard();
				ai.AI_BestMove();
				
				printBoard();
				
				boolean checkWinXorO = gameLogic.didXorOWin();
				boolean checkTie = gameLogic.isGameTied();
				
				if (checkWinXorO)
					
				{

					System.out.println("O Wins! Game Over.");
					break;
					
				}
				
				else if (checkTie)
					
				{
					
					System.out.println("The Game is Tied! Game Over.");
					break;
					
				}
				
				currentTurn = gameLogic.changeTurn(currentTurn);
				continue;
				
			}
			
			if (currentTurn.equals("X"))
				
			{

				coordInput();

				boolean checkStatus = gameLogic.didXorOWin();
				boolean checkTie = gameLogic.isGameTied();
				
				if (checkStatus)
					
				{

					printBoard();
					System.out.println("X Wins! Game Over.");
					break;
					
				}
				
				else if (checkTie)
					
				{
					
					printBoard();
					System.out.println("The Game is Tied! Game Over.");
					break;
					
				}
				
				currentTurn = gameLogic.changeTurn(currentTurn);
				continue;
				
			}
			
		}

	}

	/**
	 * Creates the GameLogic, AI_Win, AI_Block, AI_ImmediateWin, AI_Danger, AI, and UI objects.
	 * The gameLogic variable is used in every object's constructor except for the GameLogic object.
	 * The ai variable is used in the UI constructor only.
	 * The aiWin, aiBlock, aiImmediateWin, and aiDanger variables are only used in the AI constructor.
	 * The runGame method in the UI class is called to run the game entirely.
	 */
	
	public static void main (String[] args)
	
	{

		GameLogic gameLogic = new GameLogic();
		AI_Win aiWin = new AI_Win(gameLogic);
		AI_Block aiBlock = new AI_Block(gameLogic);
		AI_ImmediateWin aiImmediateWin = new AI_ImmediateWin(gameLogic);
		AI_Danger aiDanger = new AI_Danger(gameLogic);
		AI ai = new AI(gameLogic, aiWin, aiBlock, aiImmediateWin, aiDanger);
		UI ui = new UI(gameLogic, ai);
		
		ui.runGame();

	}
	
}
