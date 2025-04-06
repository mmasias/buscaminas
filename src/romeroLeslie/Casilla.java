public class Casilla {
    private boolean tieneMina;
    private boolean descubierta;
    private boolean marcada;
    private int minasCerca;
    
    
    public enum Estado {
        
    }
    
    
    public Casilla() {
        this.tieneMina = false;
        this.descubierta = false;
        this.marcada = false;
        this.minasCerca = 0;
    }
    
   
    public void ponerMina() {
        this.tieneMina = true;
    }
    
   
    public void incrementarMinasCerca() {
        if (!tieneMina) {
            this.minasCerca++;
        }
    }
    
  
    public boolean descubrir() {
        if (!marcada) {
            this.descubierta = true;
            return tieneMina;
        }
        return false;
    }
    
    public boolean alternarMarcado() {
        if (!descubierta) {
            this.marcada = !this.marcada;
        }
        return this.marcada;
    }
    
   
    public void marcar() {
        if (!descubierta) {
            this.marcada = true;
        }
    }
    

    public void desmarcar() {
        this.marcada = false;
    }
    
  
    public boolean tieneMina() {
        return tieneMina;
    }
    
   
    public boolean estaDescubierta() {
        return descubierta;
    }
    
    
    public boolean estaMarcada() {
        return marcada;
    }
    
   
    public Estado getEstado() {
        if (descubierta) {
            if (tieneMina) {
                return Estado.EXPLOTADA;
            }
            return Estado.DESCUBIERTA;
        } else if (marcada) {
            return Estado.MARCADA;
        } else {
            return Estado.OCULTA;
        }
    }
    
   
    public char getVisible() {
        if (marcada) return 'M';
        if (!descubierta) return '*';
        if (tieneMina) return 'X';
        return minasCerca > 0 ? (char) ('0' + minasCerca) : ' ';
    }
    

    public int getMinasCerca() {
        return minasCerca;
    }
    
    
    public void revelar() {
        this.descubierta = true;
    }
    
    public boolean esSegura() {
        return !tieneMina && !descubierta;
    }
    
    @Override
    public String toString() {
        return String.valueOf(getVisible());
    }
}