package nicolasNavas;

public class Minesweeper {
    private Board board;
    private Player player;

    public Minesweeper(){
        board = new Board();
        player = new Player();
    }

    public void play(){
        do {
            board.showBoard();
            player.play(board);
        }while(!board.isComplete() && player.isAlive());
    }
}
