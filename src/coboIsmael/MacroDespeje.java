package coboIsmael;

public class MacroDespeje {

    public static void hacerMacrodespeje(Tablero tablero, int fila, int columna) {
        for (int i = fila - 1; i <= fila + 1; i++) {
            for (int j = columna - 1; j <= columna + 1; j++) {
                if (!tablero.hayMina(i, j)) {
                    tablero.forzarDespeje(i, j);
                }
            }
        }
    }
}