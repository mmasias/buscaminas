package gonzalezMarcos;

public class Celda {
    private boolean tieneMina;
    private boolean estaRevelada;
    private boolean estaMarcada;

    public Celda(boolean tieneMina) {
        this.tieneMina = tieneMina;
        this.estaRevelada = false;
        this.estaMarcada = false;
    }

    public Celda() {
        this(false); 
    }

    public boolean tieneMina() {
        return tieneMina;
    }

    public boolean estaRevelada() {
        return estaRevelada;
    }

    public boolean estaMarcada() {
        return estaMarcada;
    }

    public void marcar() {
        if (!estaRevelada) {
            estaMarcada = !estaMarcada; 
        }
    }

    public void revelar() {
        if (!estaMarcada) {
            estaRevelada = true;
        }
    }

    public String mostrar() {
        if (estaMarcada) {
            return "🚩";
        } else if (!estaRevelada) {
            return "☁️";
        } else if (tieneMina) {
            return "💣";
        } else {
            return " ";
        }
    }
}