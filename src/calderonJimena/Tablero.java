package calderonJimena;

public class Tablero {
    private Celda[][] celdas;
    private int filas;
    private int columnas;
    
    public void mostrarTablero() {
        System.out.print("   ");
        for (int columna = 1; columna <= columnas; columna++) {
            System.out.print(columna + " ");
        }
        System.out.println();

        for (int fila = 0; fila < filas; fila++) {
            System.out.print(fila + 1 + "  ");
            for (int columna = 0; columna < columnas; columna++) {
                System.out.print(celdas[fila][columna] + " ");
            }
            System.out.println();
        }
    }

    public void marcarCelda(int fila, int columna) {
        if (coordenadaValida(fila, columna)) {
            celdas[fila][columna].marcar();
        }
    }

    private boolean coordenadaValida(int fila, int columna) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'coordenadaValida'");
    }

}
