package miguelgomez;

public class Celda {
    private boolean contieneMina;
    private boolean descubierta;
    private boolean marcada;

    public Celda() {
        this.contieneMina = false;
        this.descubierta = false;
        this.marcada = false;
    }

    public boolean tieneMina() {
        return contieneMina;
    }

    public void colocarMina() {
        this.contieneMina = true;
    }

    public boolean estaDescubierta() {
        return descubierta;
    }

    public void descubrir() {
        this.descubierta = true;
    }

    public boolean estaMarcada() {
        return marcada;
    }

    public void alternarMarcado() {
        this.marcada = !this.marcada;
    }
}