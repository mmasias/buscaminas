package martinezDiego;

public class Buscaminas {
    private Tablero tablero;
    private Jugador jugador;

    public Buscaminas() {
        tablero = new Tablero();
        jugador = new Jugador();
    }

   
   
   
    public void jugar() {

        while(!tablero.hasGanado() || !tablero.hasPerdido()) {

            tablero.imprimir();
            tablero.seleccionarCasilla();
            tablero.generarMinas();
            tablero.plantarBandera();
            tablero.seleccionarCasilla();
            tablero.revelarMinas();
            
        }


       
       
    }

}
