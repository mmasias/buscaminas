package castilloCayetano;

public class Coordenada {
    public int x;
    public int y;
    public Coordenada() {
        this.x = 0;
        this.y = 0;   
    }
    public Coordenada(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
}
