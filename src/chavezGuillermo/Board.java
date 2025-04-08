public class Board {
    private int board[][];
    private char tiles[];

    private final int EMPTY=0;

    public Board(int[][] board, char[] tiles) {
        this.board=board;
        this.tiles=tiles;
    }

    public int[] getSize(){
        return new int[]{board[0].length,board.length};
    }


    public void showBoard(){
        for (int i=0;i<board.length;i=i+1) {
            for (int j=0;j<board[i].length;j=j+1) {
                System.out.println(transformTile(board[i][j]));
            }
            System.out.println();
        }
    }

    private char transformTile(int tile){
        return(tile<=EMPTY)?'_':tiles[tile-1];
    }

    public void placeTile(Coordinate coordinate, int tile){
        board[coordinate.getY()][coordinate.getX()]=tile;
    }

    public int changeTile(Coordinate coordinate){
        int takenTile=board[coordinate.getY()][coordinate.getX()];
        board[coordinate.getY()][coordinate.getX()]=EMPTY;
        return takenTile;
    }
    
    public boolean isClear(){
        for (int i=0;i<board.length;i=i+1) {
            for (int j:board[i]){
                if(j==0||j==1){
                    return false;
                }
            }
            
        }
    return true;    
    }


}
