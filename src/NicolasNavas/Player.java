package nicolasNavas;

import java.util.Scanner;

public class Player {
    private Boolean isAlive;

    public Player(){
        isAlive = true;
    }

    public void play(Board instanceBoard){
        Scanner input = new Scanner(System.in);

        System.out.print("Quieres (D)espejar o (M)arcar una casilla");
        String selection = input.next().toUpperCase();

        System.out.print("Ingresar fila: ");
        int row = input.nextInt();

        System.out.print("Ingresar calumna: ");
        int column = input.nextInt();

        if(!instanceBoard.hasValidCoordinates(row, column)){
            System.out.println("Coordenadas invalidas, ingrese coordenadas dentro del rango por favor");
            return;
        }

        if(selection.equals("M")){
            instanceBoard.markCell(row, column);
        } else if (selection.equals("D")){
            boolean result = instanceBoard.clearCell(row, column);
            if(!result){
                isAlive = true;
                System.out.println("Mina Pisada. Fin del juego.");
            }
        } else {
            System.out.println("Opcion Invalida.");
        }
    }
    
    public boolean isAlive() {
        return isAlive;
    }
}
