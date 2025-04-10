package delaasuncionJose.src;

public class Coordenada {
    private int x, y;
    private int[] tamaño;
    private Pedir pedir;
    
    public Coordenada(int[] tamaño) {
        this.tamaño = tamaño;
        this.pedir = new Pedir();
    }

    public Coordenada(int[] tamaño,int x,int y) {
        this(tamaño);
        this.x = x;
        this.y = y;
    }

    public void pedir() {
        System.out.println("Eje X:");
        x = pedir.numeroEntero(1, tamaño[0]);
        System.out.println("Eje Y:");
        y = pedir.numeroEntero(1, tamaño[1]);
    }

    public int x(){
        return x-1;
    }

    public int y() {
        return tamaño[1] - y;
    }

    public Coordenada[] adyacente() {
        Coordenada[] adyacentes = new Coordenada[8];
        int posicion=0;

        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                if (dx == 0 && dy == 0) continue;
    
                int nuevoX = x + dx;
                int nuevoY = y + dy;
    
                if (nuevoX >= 1 && nuevoX <= tamaño[0] && nuevoY >= 1 && nuevoY <= tamaño[1]) {
                    adyacentes[posicion] = new Coordenada(tamaño,nuevoX,nuevoY);
                } else {
                    adyacentes[posicion] = null;
                }
                posicion++;
            }
        }

        return adyacentes;
    }
}