import java.util.Scanner;

public class Pedir {
    private final String PROMPT = "| >  ";
    private Scanner scanner = new Scanner(System.in);

    public int pedirNumeroEntero(int min, int max) {
        final String MENSAJE_ERROR = "Por favor, ingrese un número dentro del intervalo [" + min + "," + max + "]  N";
        int numeroUsuario;
        boolean esInvalido;

        do {
            System.out.print(PROMPT);
            while (!scanner.hasNextInt()) {
                System.out.println(MENSAJE_ERROR);
                scanner.next();
                System.out.print(PROMPT);
            }
            numeroUsuario = scanner.nextInt();
            esInvalido = numeroUsuario < min || numeroUsuario > max;
            if (esInvalido) {
                System.out.println(MENSAJE_ERROR);
            }
        } while (esInvalido);
        return numeroUsuario;
    }

    public char pedirCaracter() {
        System.out.print(PROMPT);
        return scanner.next().charAt(0);
    }
}
