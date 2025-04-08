public class Coordinate {
    private int x;
    private int y;
    private final int size[]={6,6};
    private Scan scan;
    public Coordinate(){
        this.scan=new Scan();
    }

    public void scan(){
        System.out.println("Colum number: ");
        x=scan.scanInt(1,size[0]);
        System.out.println("Row number: ");
        y=scan.scanInt(1,size[1]);    
    }
    public int getX() {
        return x - 1;
    }

    public int getY() {
        return y - 1;
    }
}
