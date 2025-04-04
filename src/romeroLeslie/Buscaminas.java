import java.util.Random;
import java.util.Scanner;

public class Buscaminas {
    private int[][] tablero;
    private boolean[][] minas;
    private boolean[][] revelado;
    private int filas;
    private int columnas;
    private int totalDeMinas;


    public Buscaminas(int filas, int columnas, int totalDeMinas) {
        this.filas = filas;
        this.columnas = columnas;
        this.totalMinas = totalMinas;
        tablero = new int[filas][columnas];
        minas = new boolean[filas][columnas];
        revelado = new boolean[filas][columnas];
        colocarMinas();
        calcularVecinos();
    }


    private void colocarMinas() {
        Random rand = new Random();
        int minasColocadas = 0;

        while (minasColocadas < totalMinas) {
            int fila = rand.nextInt(filas);
            int columna = rand.nextInt(columnas);
            if (!minas[fila][columna]) {
                minas[fila][columna] = true;
                minasColocadas++;
            }
        }
    }