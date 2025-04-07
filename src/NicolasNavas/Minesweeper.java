package nicolasNavas;

public class Minesweeper {
    private Board instanceBoard;
    private Player instancePlayer;

    public Minesweeper(){
        instanceBoard = new Board();
        instancePlayer = new Player();
    }

    public void play(){
        do {
            instanceBoard.showBoard();
            instancePlayer.play(instanceBoard);
        }while(!instanceBoard.isComplete() && instancePlayer.isAlive());
    }
}
