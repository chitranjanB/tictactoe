package com.game.tictactoe;

import com.game.tictactoe.constants.GameConstants;

public class Game {

	private Player player;
	private GameBoard gameBoard;

	public Game(int size) {
		gameBoard.setSizeOfSquare(size);
		gameBoard.setSizeOfBoard(size + size - 1);// Size of the game board being set dynamically (n+n-1)
		gameBoard = GameBoard.getGameBoard();
		showOnStart();
	}

	public void showOnStart() {

		System.out.println("Game Board Creation...");
		System.out.println();
		gameBoard.printGameBoard();
		System.out.println("Board Created.");
		System.out.println("The game will start with player X");
		System.out.println();
		startGame();
	}

	public void startGame() {
		while (true) {
			player = new Player(gameBoard);
			String result;
			player.move("X");
			result = player.computeWinner();
			if (result.length() > 0) {
				System.out.println();
				gameBoard.printGameBoard();
				System.out.println();
				System.out.println(GameConstants.X_WINS);
				break;
			}
			player.move("O");
			result = player.computeWinner();
			if (result.length() > 0) {
				System.out.println();
				gameBoard.printGameBoard();
				System.out.println();
				System.out.println(GameConstants.O_WINS);
				break;

			}
		}

	}

}
