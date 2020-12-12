package com.game.tictactoe;

import java.util.Scanner;

import com.game.tictactoe.constants.Cons;

public class GameRunner {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.println(Cons.MSG_INITAL_PROMPT);
		int size = scan.nextInt();
		Game game = new Game();
		game.createGameBoard(size);
		game.startGame();
		scan.close();
	}

}
