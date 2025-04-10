package valdesCarlos;

public class Coordenadas {
    
    private int fila;
    private int columna;

    
    public Coordenadas(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
    }

    
    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }

    
    public void setFila(int fila) {
        this.fila = fila;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    
    public boolean esValida() {
        return fila >= 1 && fila <= 6 && columna >= 1 && columna <= 6;
    }

    
    public String toString() {
        return "(" + fila + ", " + columna + ")";
    }
}
