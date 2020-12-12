package com.game.tictactoe;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import com.game.tictactoe.constants.GameConstants;

public class Player {

	private GameBoard gameBoard;
	private String player;

//	public Player() {
//	}

	public Player(GameBoard gameBoard) {
		this.gameBoard = gameBoard;

	}

	public void move(String p) {
		if (p == GameConstants.PLAYR_X)
			player = "X";
		else
			player = "O";
		System.out.println("Hi player " + player + ", enter your cell:");

		while (true) {
			int x = 1;
			int row = 0;
			int col = 0;
			do {
				try {
					Scanner scan = new Scanner(System.in);
					System.out.println("Enter row:");
					row = scan.nextInt();
					System.out.println("Enter column:");
					col = scan.nextInt();
					x = 2;
				} catch (Exception e) {
					System.out.println("Please enter an integer only: ");
				}
			} while (x == 1);

			if (row > 0 && row <= gameBoard.getSizeOfSquare() && col > 0 && col <= gameBoard.getSizeOfSquare()) // if
																												// row
																												// or
																												// col
																												// is
																												// not >
																												// 0,
																												// input
																												// 0
																												// works.
			{

				if (!gameBoard.fillSymbol(row, col, p)) {
					System.out.println("This cell is already filled. Please re enter the cell: "); // write if condition
																									// to check alreday
																									// filled cell
				} else {
					gameBoard.fillSymbol(row, col, p);
					System.out.println("");
					System.out.println("player " + player + ":");
					break;
				}
			} else {
				System.out.println("Please enter both row and column less that size of the bord nad greater than 0:");
			}
		}
		gameBoard.printGameBoard();
	}

	public String checkSet(Set s) {
		String winner = "";
		if (s.size() == 1 && !s.contains(' ')) {
			if (s.contains('X'))
				winner = "X";
			else
				winner = "O";
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
				if (gameGrid[i][j] != ' ')
					positionsFilled += 1;
			}
		}
		if (positionsFilled == (GameBoard.getSizeOfSquare() * GameBoard.getSizeOfSquare()) && result.isEmpty())
			result = GameConstants.NONE_WINS;

		return result;
	}

}
