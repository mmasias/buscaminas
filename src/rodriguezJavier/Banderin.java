public class Banderin {
    private boolean colocado;
    
    public Banderin() {
        this.colocado = false;
    }
    
    public void colocar() {
        this.colocado = true;
    }
    
    public void quitar() {
        this.colocado = false;
    }
    
    public boolean estaColocado() {
        return colocado;
    }
}