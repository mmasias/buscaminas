package delaasuncionJose.src;
import java.util.Scanner;

public class Coordenada {
    private int x, y;
    private Scanner scanner = new Scanner(System.in);

    private int[] tamaño;
    
    public Coordenada(int[] tamaño) {
        this.tamaño = tamaño;
    }

    public void pedir() {
        x = obtenerNumeroUsuario(1, tamaño[0]);
        y = obtenerNumeroUsuario(1, tamaño[1]);
    }

    private int obtenerNumeroUsuario(int minimo, int maximo) {
        final String ERROR = "Porfavor introduzca un numero dentro del intervalo de ["+ minimo +","+ maximo +"]∈ N";
        final String EMBELLECEDOR = "| >  ";
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

    public int x(){
        return x-1;
    }

    public int y() {
        return tamaño[1] - y;
    }
}