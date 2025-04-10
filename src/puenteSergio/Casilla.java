package puenteSergio;

public class Casilla {
    private boolean mina = false;
    private boolean marcada = false;
    private boolean revelada = false;

    public boolean revelar() {
        if (revelada || marcada) return true;
        revelada = true;
        return !mina;
    }

    public void marcar() {
        if (!revelada) {
            marcada = !marcada;
        }
    }

    public boolean estaMarcada() {
        return marcada;
    }

    public boolean estaRevelada() {
        return revelada;
    }

    public boolean tieneMina() {
        return mina;
    }

    public void colocarMina() {
        this.mina = true;
    }
}
