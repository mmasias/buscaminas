public class Coordenada {
    private int x, y;
    private final int[] tamaño = { 6, 6 };
    private Pedir pedir;

    public Coordenada() {
        this.pedir = new Pedir();
    }

    public void pedir() {
        System.out.print("Columna (1 a " + tamaño[0] + "): ");
        x = pedir.pedirNumeroEntero(1, tamaño[0]);

        System.out.print("Fila (1 a " + tamaño[1] + "): ");
        y = pedir.pedirNumeroEntero(1, tamaño[1]);
    }

    public int getX() {
        return x - 1;
    }

    public int getY() {
        return y - 1;
    }
}
