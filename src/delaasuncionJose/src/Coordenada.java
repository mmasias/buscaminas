package delaasuncionJose.src;

public class Coordenada {
    private int x, y;
    private int[] tamaño;
    private Pedir pedir;
    
    public Coordenada(int[] tamaño) {
        this.tamaño = tamaño;
        this.pedir = new Pedir();
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
}