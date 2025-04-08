import java.util.Scanner;

public class Scan {
    private final String PROMPT="| >  ";
    private Scanner scanner = new Scanner(System.in);

    public int scanInt(int min, int max) {
        final String ERROR_MSG="Please input a number between "+min+" and "+max;
        int userNumber;
        boolean invalidNumber;

        do{
            System.out.println(PROMPT);
            do{
                System.out.println(ERROR_MSG);
                scanner.next();
                System.out.println(PROMPT);
            }while(!scanner.hasNextInt());
                userNumber=scanner.nextInt();
                invalidNumber=userNumber<min||userNumber>max;
            if (invalidNumber) {
                System.out.println(ERROR_MSG);
            }
        }while(invalidNumber);
        return userNumber;
    }

    public char scanCharacter(){
        System.out.println(PROMPT);
        return scanner.next().charAt(0);
    }
}
