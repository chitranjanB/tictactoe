package com.game.tictactoe;

public class GameBoard {

	private int sizeOfBoard = 0;
	private int sizeOfSquare = 0;
	private char[][] board = null;

	public GameBoard(int sizeOfBoard, int sizeOfSquare) {
		this.sizeOfBoard = sizeOfBoard;
		this.sizeOfSquare = sizeOfSquare;
	}

	public char[][] getBoard() {
		return this.board;
	}

	public void setBoard(char[][] board) {
		this.board = board;
	}

	public int getSizeOfSquare() {
		return this.sizeOfSquare;
	}

	public void setSizeOfSquare(int sizeOfSquare) {
		this.sizeOfSquare = sizeOfSquare;
	}

	public int getSizeOfBoard() {
		return this.sizeOfBoard;
	}

	public void setSizeOfBoard(int sizeOfBoard) {
		this.sizeOfBoard = sizeOfBoard;
	}

	public boolean fillSymbol(int row, int col, String p) {
		char symbol = ' ';
		if (p.equals("X"))
			symbol = 'X';

		else if (p.equals("O"))
			symbol = 'O';

		if (row % 2 != 0)
			row = (row - 1) * 2; // If row or col is odd then there is a design char already. n=nxn-1 points to
									// the empty cell.
		if (col % 2 != 0)
			col = (col - 1) * 2;
		if (board[row][col] == 'X' || board[row][col] == 'O')
			return false;
		else
			board[row][col] = symbol;

		return true;
	}

	public void printGameBoard() {
		for (char[] row : board) {
			for (char c : row) {
				System.out.print(c);
			}
			System.out.println();
		}
	}
}