package orozcoBeatriz;

class Celda {
    private boolean tieneMina;
    private boolean estaDescubierta;
    private boolean estaMarcada;

    Celda() {
        this.tieneMina = false;
        this.estaDescubierta = false;
        this.estaMarcada = false;
    }
    
    public boolean tieneMina() {
        return tieneMina;
    }

    public boolean estaDescubierta() {
        return estaDescubierta;
    }

    public boolean estaMarcada() {
        return estaMarcada;
    }

    public void tieneMina(boolean tieneMina) {
        this.tieneMina = tieneMina;
    }

    public void estaMarcada(boolean estaMarcada) {
        this.estaMarcada = estaMarcada;
    }

    public void estaDescubierta(boolean estaDescubierta) {
        this.estaDescubierta = estaDescubierta;
    }
}
