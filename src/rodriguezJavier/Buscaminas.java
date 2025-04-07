public class Buscaminas {
    public static void main(String[] args) {
        final int TAMANO = 6;
        final int MINAS = 6;
        
        System.out.println("¡Bienvenido al Buscaminas!");
        System.out.println("Instrucciones:");
        System.out.println("- Usa D para despejar una casilla");
        System.out.println("- Usa M para marcar/desmarcar una mina");
        System.out.println("- Las coordenadas van de 1 a " + TAMANO);
        
        Juego juego = new Juego(TAMANO, MINAS);
        juego.iniciar();
    }
}