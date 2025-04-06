package calderonJimena;

public class Celda {
    private boolean tieneMina;
    private boolean estaDescubierta;
    private boolean estaMarcada;
    private int cantidadMinasAlrededor;

    public Celda() {
        tieneMina = false;
        estaDescubierta = false;
        estaMarcada = false;
        cantidadMinasAlrededor = 0;
    }

    public void ponerMina() {
        tieneMina = true;
    }

    public boolean tieneMina() {
        return tieneMina;
    }

    public boolean estaDescubierta() {
        return estaDescubierta;
    }

    public void descubrir() {
        estaDescubierta = true;
    }

    public int obtenerCantidadMinasAlrededor() {
        return cantidadMinasAlrededor;
    }}
