package com.game.tictactoe.constants;

public class Cons {

	/**
	 * Player constants
	 */
	public static final String MSG_X_WINS = "\nPLAYER X WON\n";
	public static final String MSG_O_WINS = "\nPLAYER O WON\n";
	public static final String MSG_NONE_WINS = "GAME ENDS WITH A DRAW";

	public static final String PLAYER_X = "X";
	public static final String PLAYER_O = "O";
	public static final char CHAR_X = 'X';
	public static final char CHAR_O = 'O';
	public static final char CHAR_SPACE = ' ';

	/**
	 * Game constants
	 */
	public static final String MSG_INITAL_PROMPT = "Please enter the size of the board:";
	public static final String MSG_BOARD_CREATION_SUCCESS = "Board Created.\nThe game will start with player X\n";
	public static final String MSG_YOUR_MOVE_PROMPT = "Hi player %s, enter your cell:";
	public static final String MSG_ENTER_ROW_PROMPT = "Enter row:";
	public static final String MSG_ENTER_COL_PROMPT = "Enter column:";

	public static final String ERR_INVALID_TYPE = "Please enter an integer only:";
	public static final String ERR_POSITION_TAKEN = "This cell is already filled. Please re enter the cell: ";
	public static final String ERR_INVALID_MOVE = "Please enter both row and column less that size of the board and greater than 0:";

	/**
	 * Board Layouts
	 */
	public static final char SEPARATOR_SPACE = ' ';
	public static final char SEPARATOR_PIPE = '|';
	public static final char SEPARATOR_MINUS = '-';
	public static final char SEPARATOR_PLUS = '+';;

}
