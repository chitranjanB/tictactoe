package com.game.tictactoe;

import java.util.Scanner;

public class GameRunner {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter the size of the board:");
		int size = scan.nextInt();
		Game game = new Game();
		game.createGameBoard(size);
		game.startGame();
	}

}
