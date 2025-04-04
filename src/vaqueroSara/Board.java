package Minesweeper;

public class Board {

    int[][] board = new int[6][6];

    public Board (){

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                board[i][j] = 0; 
            }
        }
    }
    

    public void showBoard() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                System.out.print("[" + board[i][j] + "] ");
            }
            System.out.println();
        }
    }
}


