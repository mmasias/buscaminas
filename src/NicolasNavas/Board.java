package nicolasNavas;

import java.util.Random;
import javax.swing.text.Position;

public class Board {
    
    private final int NUMBER_OF_ROWS = 6;
    private final int NUMBER_OF_COLUMS = 6;
    private final int NUMBER_OF_MINES = 6;

    private final char HIDDEN_CELL = "■";
    private final char FLAG = "⚐";
    private final char MINE = '*';
    private final char CLEARED_CELL = '□';

    private char instanceBoard;
    private boolean hiddenCell = false;

    public Board() {
        instanceBoard = new char[NUMBER_OF_ROWS][NUMBER_OF_COLUMS];
        initializeBoard();
        placeMinesRandomly();
    }

}
