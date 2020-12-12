package com.game.tictactoe;

public class GameBoard {

    private static int sizeOfBoard=0;
    private static int sizeOfSquare=0;
    public static int getSizeOfSquare() {
		return sizeOfSquare;
	}


	public static void setSizeOfSquare(int sizeOfSquare) {
		GameBoard.sizeOfSquare = sizeOfSquare;
	}

	private static char [][] board=null;
    
    private static GameBoard instance=null;
    
    public static GameBoard getGameBoard()
    {
    	if(instance==null)
    		instance=new GameBoard();
    	instance.createGameBoard();
    	return instance;
    }


    public static char[][]  getBoard() {
		return board;
	}

	public static void setBoard(char[][] board) {
		GameBoard.board = board;
	}

	private GameBoard() {
   
    }
    
    public static int getSizeOfBoard() {
		return sizeOfBoard;
	}

	public static void setSizeOfBoard(int sizeOfBoard) {
		GameBoard.sizeOfBoard = sizeOfBoard;
	}

	private static void createGameBoard() {
    	board=new char[sizeOfBoard][sizeOfBoard];
        for (int i = 0; i < sizeOfBoard; i++) {
            for (int j = 0; j < sizeOfBoard; j++) {
                if(i%2==0)
                {
                	if(j%2==0)
                		board[i][j]=' ';
                	else
                		board[i][j]='|';
                }
                else {
                	if(j%2==0)
                		board[i][j]='-';
                	else
                		board[i][j]='+';
                }
                	
                }
        }
        }   
public static boolean fillSymbol(int row, int col, String p) {
		char symbol = ' ';
		if(p.equals("X")) 
			symbol = 'X';
		
		else if(p.equals("O"))
			symbol ='O';
		
		if(row%2!=0)
			row=(row-1)*2; //If row or col is odd then there is a design char already. n=nxn-1 points to the empty cell.
		if(col%2!=0)
			col=(col-1)*2;
		if(board[row][col]=='X' || board[row][col]=='O')
			return false;
		else
			board[row][col]=symbol;
		
		return true;
	}
	
    public void printGameBoard()
    {
    	for(char[] row : board) {
 			for(char c : row) {
 				System.out.print(c);
 			}
 			System.out.println();
    }
    }
}