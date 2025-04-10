package valdesCarlos;

public class Celda {
    private boolean tieneMina;
    private boolean revelada;
    private boolean marcada;
    private int numeroAlrededor;

    public Celda() {
        this.tieneMina = false;
        this.revelada = false;
        this.marcada = false;
        this.numeroAlrededor = 0;
    }

    public boolean tieneMina() {
        return tieneMina;
    }

    public void ponerMina() {
        this.tieneMina = true;
    }

    public boolean estaRevelada() {
        return revelada;
    }

    public void revelar() {
        this.revelada = true;
    }

    public boolean estaMarcada() {
        return marcada;
    }

    public void marcar(boolean marcada) {
        this.marcada = marcada;
    }

    public int getNumeroAlrededor() {
        return numeroAlrededor;
    }

    public void setNumeroAlrededor(int numero) {
        this.numeroAlrededor = numero;
    }
}
