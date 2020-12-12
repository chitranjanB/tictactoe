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
						board[i][j] = Cons.SEPARATOR_SPACE;
					else
						board[i][j] = Cons.SEPARATOR_PIPE;
				} else {
					if (j % 2 == 0)
						board[i][j] = Cons.SEPARATOR_MINUS;
					else
						board[i][j] = Cons.SEPARATOR_PLUS;
				}

			}
		}
		this.gameBoard.setBoard(board);
	}

	public void startGame() {
		gameBoard.printGameBoard();
		System.out.println(Cons.MSG_BOARD_CREATION_SUCCESS);

		while (true) {
			Player player = new Player(gameBoard);
			String result;
			player.move(Cons.PLAYER_X);
			result = player.computeWinner();
			if (result.length() > 0) {
				System.out.println();
				gameBoard.printGameBoard();
				System.out.println(Cons.MSG_X_WINS);
				break;
			}
			player.move(Cons.PLAYER_O);
			result = player.computeWinner();
			if (result.length() > 0) {
				System.out.println();
				gameBoard.printGameBoard();
				System.out.println(Cons.MSG_O_WINS);
				break;
			}
		}

	}

}
