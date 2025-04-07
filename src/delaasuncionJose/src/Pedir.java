package delaasuncionJose.src;

import java.util.Scanner;

public class Pedir {
    private final String EMBELLECEDOR = "| >  ";
    private Scanner scanner = new Scanner(System.in);

    public int numeroEntero(int minimo, int maximo) {
        final String ERROR = "Porfavor introduzca un numero dentro del intervalo de ["+ minimo +","+ maximo +"]∈ N";
        int numeroUsuario;
        boolean taMal;

        do {
            System.out.print(EMBELLECEDOR);
            while(!scanner.hasNextInt()){
                System.out.println(ERROR);
                scanner.next();
                System.out.print(EMBELLECEDOR);
            }
            numeroUsuario = scanner.nextInt();
            taMal = numeroUsuario > maximo || numeroUsuario < minimo;
            if (taMal) {
                System.out.println(ERROR);
            }
        } while(taMal);
        return numeroUsuario;
    }

    public char character() {
        System.out.print(EMBELLECEDOR);
        return scanner.next().charAt(0);
    }
}