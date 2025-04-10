import java.util.Random;
import java.util.Scanner;

class Celda {
    boolean tieneMina;
    boolean revelada;
    boolean marcada;
    int minasCercanas;

     public Celda() {
        this.tieneMina = false;
        this.revelada = false;
        this.marcada = false;
        this.minasCercanas = 0;
    }
}