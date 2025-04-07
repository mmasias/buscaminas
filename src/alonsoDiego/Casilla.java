package alonsoDiego;

public class Casilla {
    private boolean tieneMina;
    private boolean revelada;
    private int minasAlrededor;
    private boolean esBandera;

public Casilla() {
    this.tieneMina = false;
    this.revelada = false;
    this.minasAlrededor = 0;
    this.esBandera = false;
}
public boolean tieneMina() {
    return tieneMina;
}

public void setTieneMina(boolean tieneMina) {
    this.tieneMina = tieneMina;
}

public boolean estaRevelada() {
    return revelada;
}

public void setRevelada(boolean revelada) {
    this.revelada = revelada;
}

public int getMinasAlrededor() {
    return minasAlrededor;
}

public void setMinasAlrededor(int minasAlrededor) {
    this.minasAlrededor = minasAlrededor;
}

public boolean esBandera() {
    return esBandera;
}

public void setBandera(boolean esBandera) {
    this.esBandera = esBandera;
}
}
 
