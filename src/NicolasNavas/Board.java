package nicolasNavas;

import java.util.Random;

public class Board {

    private final int NUMBER_OF_ROWS = 6;
    private final int NUMBER_OF_COLUMS = 6;
    private final int NUMBER_OF_MINES = 6;

    private final char HIDDEN_CELL = '■';
    private final char FLAG = 'P';
    private final char MINE = '*';
    private final char CLEARED_CELL = '0';

    private char[][] board;
    private boolean hiddenCell = false;

    public Board() {
        board = new char[NUMBER_OF_ROWS][NUMBER_OF_COLUMS];
        initializeBoard();
        placeMinesRandomly();
    }

    private void initializeBoard() {
        for (int row = 0; row < NUMBER_OF_ROWS; row++) {
            for (int column = 0; column < NUMBER_OF_COLUMS; column++) {
                board[row][column] = HIDDEN_CELL;
            }
        }
    }

    private void placeMinesRandomly() {
        Random generateRandom = new Random();
        int placedMines = 0;

        while (placedMines < NUMBER_OF_MINES) {
            int randomRow = generateRandom.nextInt(NUMBER_OF_ROWS);
            int randomColumn = generateRandom.nextInt(NUMBER_OF_COLUMS);

            if (board[randomRow][randomColumn] != MINE) {
                board[randomRow][randomColumn] = MINE;
                placedMines++;
            }
        }
    }

    public void showBoard() {
        System.out.println();
        for (int column = 1; column <= NUMBER_OF_COLUMS; column++) {
            System.out.print(" " + column);
        }
        System.out.println();

        for (int row = 0; row < NUMBER_OF_ROWS; row++) {
            System.out.print((row + 1) + "  ");
            for (int column = 0; column < NUMBER_OF_COLUMS; column++) {
                char actualCell = board[row][column];

                if (actualCell == MINE && !hiddenCell) {
                    System.out.print(HIDDEN_CELL + " ");
                } else if (actualCell == MINE && hiddenCell) {
                    System.out.print(MINE + " ");
                } else {
                    System.out.print(actualCell + " ");
                }
            }
            System.out.println();
        }
    }

    public boolean clearCell(int row, int column) {
        if (board[row - 1][column - 1] == MINE) {
            hiddenCell = true;
            return false;
        }

        if (board[row - 1][column - 1] == HIDDEN_CELL) {
            board[row - 1][column - 1] = CLEARED_CELL;
        }

        return true;
    }

    public void markFlag(int row, int column) {
        if (board[row - 1][column - 1] == HIDDEN_CELL) {
            board[row - 1][column - 1] = FLAG;
        } else if (board[row - 1][column - 1] == FLAG) {
            board[row - 1][column - 1] = HIDDEN_CELL;
        }
    }

    public boolean isComplete() {
        for (int row = 0; row < NUMBER_OF_ROWS; row++) {
            for (int column = 0; column < NUMBER_OF_COLUMS; column++) {
                char cell = board[row][column];
                if ((cell == HIDDEN_CELL || cell == FLAG) && cell != MINE) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean hasValidCoordinates(int row, int column) {
        return row >= 1 && row <= NUMBER_OF_ROWS && column >= 1 && column <= NUMBER_OF_COLUMS;
    }
}
