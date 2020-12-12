package com.game.tictactoe;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import com.game.tictactoe.constants.Cons;

public class Player {

	private GameBoard gameBoard;
	private String playerName;

	public Player(GameBoard gameBoard) {
		this.gameBoard = gameBoard;
	}

	public void move(String p) {
		if (p == Cons.PLAYER_X) {
			playerName = Cons.PLAYER_X;
		} else {
			playerName = Cons.PLAYER_O;
		}
		System.out.println(String.format(Cons.MSG_YOUR_MOVE_PROMPT, playerName));

		while (true) {
			int x = 1;
			int row = 0;
			int col = 0;
			do {
				try {
					Scanner scan = new Scanner(System.in);
					System.out.println(Cons.MSG_ENTER_ROW_PROMPT);
					row = scan.nextInt();
					System.out.println(Cons.MSG_ENTER_COL_PROMPT);
					col = scan.nextInt();
					x = 2;
				} catch (Exception e) {
					System.out.println(Cons.ERR_INVALID_TYPE);
				}
			} while (x == 1);

			if (row > 0 && row <= gameBoard.getSizeOfSquare() && col > 0 && col <= gameBoard.getSizeOfSquare()) {

				if (!gameBoard.fillSymbol(row, col, p)) {
					System.out.println(Cons.ERR_POSITION_TAKEN);
				} else {
					gameBoard.fillSymbol(row, col, p);
					System.out.println("");
					System.out.println("player " + playerName + ":");
					break;
				}
			} else {
				System.out.println(Cons.ERR_INVALID_MOVE);
			}
		}
		gameBoard.printGameBoard();
	}

	public String checkSet(Set s) {
		String winner = "";
		if (s.size() == 1 && !s.contains(Cons.CHAR_SPACE)) {
			if (s.contains(Cons.CHAR_X))
				winner = Cons.PLAYER_X;
			else
				winner = Cons.PLAYER_O;
		}
		return winner;

	}

	public String computeWinner() {
		String result = "";
		int positionsFilled = 0;
		boolean flag = false;
		char[][] gameGrid = gameBoard.getBoard();
		Set winningRow = new HashSet<>();
		Set winningCol = new HashSet<>();
		Set winningDiagonal = new HashSet<>();
		Set winningCrossDiagonal = new HashSet<>();
		for (int i = 0; i <= gameBoard.getSizeOfBoard(); i += 2) {
			winningRow.clear();
			winningCol.clear();
			winningDiagonal.clear();
			winningCrossDiagonal.clear();
			for (int j = 0; j <= gameBoard.getSizeOfBoard(); j += 2) {
				winningRow.add(gameGrid[i][j]);
			}
			result = checkSet(winningRow);
			if (!result.isEmpty())
				return result;

			for (int j = 0; j <= gameBoard.getSizeOfBoard(); j += 2) {
				winningCol.add(gameGrid[j][i]);
			}
			result = checkSet(winningCol);
			if (!result.isEmpty())
				return result;
			for (int j = 0; j <= gameBoard.getSizeOfBoard(); j += 2) {
				for (int k = 0; k <= gameBoard.getSizeOfBoard(); k += 2) {
					if (j == k)
						winningDiagonal.add(gameGrid[j][k]);
				}
			}
			result = checkSet(winningDiagonal);
			if (!result.isEmpty())
				return result;

			for (int j = 0; j <= gameBoard.getSizeOfBoard(); j += 2) {
				for (int k = 0; k <= gameBoard.getSizeOfBoard(); k += 2) {
					if ((j + k) == (gameBoard.getSizeOfBoard() - 1))
						winningCrossDiagonal.add(gameGrid[j][k]);
				}
			}
			result = checkSet(winningCrossDiagonal);
			if (!result.isEmpty())
				return result;

			for (int j = 0; j <= gameBoard.getSizeOfBoard(); j += 2) {
				if (gameGrid[i][j] != Cons.CHAR_SPACE)
					positionsFilled += 1;
			}
		}
		if (positionsFilled == (gameBoard.getSizeOfSquare() * gameBoard.getSizeOfSquare()) && result.isEmpty())
			result = Cons.MSG_NONE_WINS;

		return result;
	}

}
