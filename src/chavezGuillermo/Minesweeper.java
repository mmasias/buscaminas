public class Minesweeper {

    private Board board; 
    private Player player;
    private final char[] tiles={'_','D','M','.','X'};

    public Minesweeper(){
        final int SIZE=6;
        final int MINES=6;
        int boardGeneration[][]=generateBoard(MINES,SIZE);
        board = new Board(boardGeneration,tiles);
        player = new Player();
    }

    public void play(){
        while(!board.isClear() && player.alive());{
            board.showBoard();
            player.play(board);
        }

        board.showBoard();

        if(player.alive()){
            System.out.println("YOU WIN!");
        }
        else{
            System.out.println("DEAD, you LOOSE");
        }
    }
    private int[][] generateBoard(int mineCount,int size){
        int[][] board=new int[size][size];

        for(int i=0;i<mineCount;i=i+1){
            int x;
            int y;
            while(board[x][y]==1){
                x = (int) (Math.random()*size);
                y = (int) (Math.random()*size);
            }
            board[x][y]=1;
        }
        return board;
    }
}