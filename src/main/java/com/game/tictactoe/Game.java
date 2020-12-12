package com.game.tictactoe;

import com.game.tictactoe.constants.Cons;

public class Game {

	private GameBoard gameBoard;

	public void createGameBoard(int sizeOfBoard) {
		this.gameBoard = new GameBoard(sizeOfBoard, sizeOfBoard + sizeOfBoard - 1);
		char[][] board = new char[sizeOfBoard][sizeOfBoard];
		for (int i = 0; i < sizeOfBoard; i++) {
			for (int j = 0; j < sizeOfBoard; j++) {
				if (i % 2 == 0) {
					if (j % 2 == 0)
						board[i][j] = ' ';
					else
						board[i][j] = '|';
				} else {
					if (j % 2 == 0)
						board[i][j] = '-';
					else
						board[i][j] = '+';
				}

			}
		}
		this.gameBoard.setBoard(board);
	}

	public void startGame() {

		System.out.println("Game Board Creation...");
		System.out.println();
		gameBoard.printGameBoard();
		System.out.println("Board Created.");
		System.out.println("The game will start with player X");
		System.out.println();

		while (true) {
			Player player = new Player(gameBoard);
			String result;
			player.move("X");
			result = player.computeWinner();
			if (result.length() > 0) {
				System.out.println();
				gameBoard.printGameBoard();
				System.out.println();
				System.out.println(Cons.X_WINS);
				break;
			}
			player.move("O");
			result = player.computeWinner();
			if (result.length() > 0) {
				System.out.println();
				gameBoard.printGameBoard();
				System.out.println();
				System.out.println(Cons.O_WINS);
				break;

			}
		}

	}

}
