public class Player {
    private boolean alive;
    private static final int MINE=1;
    private static final int CLEAR=2;
    private static final int MARKED=3;

    public Player() {
        this.alive=true;
    }

    public void play(Board board){
        Scan scan= new Scan();
        System.out.println("[D] to Dig or [M] to Mark a mine?");
        char character;

        do {
            character = Character.toUpperCase(scan.scanCharacter());
        } while (!(character == 'D' || character == 'M'));

        if (character == 'D') {
            clear(board);
        } else {
            mark(board);
        }
    }

    private  void clear(Board board){
        Coordinate coordinate=new Coordinate();
        coordinate.scan();
        int value=board.changeTile(coordinate);

        if(value==MINE){
            System.out.println("BEGONE! BOOM!");
            alive=false;
        }else{
            board.placeTile(coordinate,CLEAR);
        }
    }

    private void mark(Board board){
        Coordinate coordinate=new Coordinate();
        coordinate.scan();

        int value=board.changeTile(coordinate);
        board.placeTile(coordinate,value+MARKED);
    }

    public boolean alive(){
        return alive;
    }
}
