package entregas.filothJose;

public class Casilla {
    private boolean mina;
    private boolean revelada;
    private boolean marcada;

    public Casilla() {
        this.mina = false;
        this.revelada = false;
        this.marcada = false;
    }

    public boolean tieneMina() {
        return mina;
    }

    public void colocarMina() {
        this.mina = true;
    }

    public boolean estaRevelada() {
        return revelada;
    }

    public void revelar() {
        this.revelada = true;
    }

    public void marcar() {
        this.marcada = !marcada;
    }

    public String mostrar() {
        if (revelada) {
            return mina ? "*" : "D";
        } else if (marcada) {
            return "M";
        } else {
            return "_";
        }
    }
}