package alonsoDiego;

public class Jugador {
    private String nombre;
    private int puntuacion;
    private boolean turno;
    private boolean perdio;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.puntuacion = 0;
        this.turno = false;
        this.perdio = false;
    }

    public void marcarCasilla(Tablero tablero, int fila, int columna) {
        if (!tablero.getCasilla(fila, columna).estaRevelada()) {
            tablero.getCasilla(fila, columna).setBandera(!tablero.getCasilla(fila, columna).esBandera());
        }
    }

    public void revelarCasilla(Tablero tablero, int fila, int columna) {
        Casilla casilla = tablero.getCasilla(fila, columna);
        
        if (!casilla.estaRevelada() && !casilla.esBandera()) {
            casilla.setRevelada(true);
            
            if (casilla.tieneMina()) {
                perdio = true;
            } else if (casilla.getMinasAlrededor() == 0) {
                revelarCasillasVacias(tablero, fila, columna);
            }
            
            actualizarPuntuacion();
        }
    }

    private void revelarCasillasVacias(Tablero tablero, int fila, int columna) {
        for (int i = Math.max(0, fila-1); i <= Math.min(tablero.getFilas()-1, fila+1); i++) {
            for (int j = Math.max(0, columna-1); j <= Math.min(tablero.getColumnas()-1, columna+1); j++) {
                if (!tablero.getCasilla(i, j).estaRevelada() && !tablero.getCasilla(i, j).esBandera()) {
                    tablero.getCasilla(i, j).setRevelada(true);
                    if (tablero.getCasilla(i, j).getMinasAlrededor() == 0) {
                        revelarCasillasVacias(tablero, i, j);
                    }
                }
            }
        }
    }

    private void actualizarPuntuacion() {
        this.puntuacion += 10;
    }

    public boolean haPerdido() {
        return perdio;
    }

    public boolean haGanado(Tablero tablero) {
        for (int i = 0; i < tablero.getFilas(); i++) {
            for (int j = 0; j < tablero.getColumnas(); j++) {
                Casilla casilla = tablero.getCasilla(i, j);
                if (!casilla.tieneMina() && !casilla.estaRevelada()) {
                    return false;
                }
            }
        }
        return true;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public boolean esTurno() {
        return turno;
    }

    public void setTurno(boolean turno) {
        this.turno = turno;
    }
}
