public class Tablero {
    private char[][] celdas;
    private boolean[][] reveladas;
    private Banderin[][] banderines;
    private Mina minas;
    
    public Tablero(int tamano, int cantidadMinas) {
        this.celdas = new char[tamano][tamano];
        this.reveladas = new boolean[tamano][tamano];
        this.banderines = new Banderin[tamano][tamano];
        this.minas = new Mina(tamano, cantidadMinas);
        
        inicializarTablero();
    }
    
    private void inicializarTablero() {
        for (int i = 0; i < celdas.length; i++) {
            for (int j = 0; j < celdas[i].length; j++) {
                banderines[i][j] = new Banderin();
                
                if (minas.hayMina(i, j)) {
                    celdas[i][j] = 'X';
                } else {
                    int num = minas.contarMinasAlrededor(i, j);
                    celdas[i][j] = num > 0 ? (char)(num + '0') : ' ';
                }
            }
        }
    }
    
    public boolean revelarCasilla(int fila, int columna) {
        if (banderines[fila][columna].estaColocado() || reveladas[fila][columna]) {
            return true;
        }
        
        reveladas[fila][columna] = true;
        
        if (celdas[fila][columna] == 'X') {
            return false;
        }
        
        if (celdas[fila][columna] == ' ') {
            revelarAdyacentes(fila, columna);
        }
        
        return true;
    }
    
    private void revelarAdyacentes(int fila, int columna) {
        for (int i = Math.max(0, fila-1); i <= Math.min(celdas.length-1, fila+1); i++) {
            for (int j = Math.max(0, columna-1); j <= Math.min(celdas[0].length-1, columna+1); j++) {
                if (!reveladas[i][j] && !banderines[i][j].estaColocado()) {
                    revelarCasilla(i, j);
                }
            }
        }
    }
    
    public void marcarCasilla(int fila, int columna) {
        if (!reveladas[fila][columna]) {
            if (banderines[fila][columna].estaColocado()) {
                banderines[fila][columna].quitar();
            } else {
                banderines[fila][columna].colocar();
            }
        }
    }
    
    public boolean verificarVictoria() {
        for (int i = 0; i < celdas.length; i++) {
            for (int j = 0; j < celdas[i].length; j++) {
                if (!minas.hayMina(i, j) && !reveladas[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public void mostrar(boolean mostrarMinas) {
        System.out.print("  ");
        for (int j = 0; j < celdas[0].length; j++) {
            System.out.print((j+1) + " ");
        }
        System.out.println();
        
        for (int i = 0; i < celdas.length; i++) {
            System.out.print((i+1) + " ");
            for (int j = 0; j < celdas[i].length; j++) {
                if (banderines[i][j].estaColocado()) {
                    System.out.print("M ");
                } else if (!reveladas[i][j]) {
                    System.out.print("- ");
                } else if (mostrarMinas && celdas[i][j] == 'X') {
                    System.out.print("X ");
                } else {
                    System.out.print(celdas[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
    
    public int getTamano() {
        return celdas.length;
    }
}