import java.util.InputMismatchException;
import java.util.Scanner;

public class security {
    public static int int_scanner_security(){
        int number=0,i=0;
        Scanner num = new Scanner(System.in);
        for ( ; ; ) {
            i=0;
            try {
                number = num.nextInt();
            }
            catch (InputMismatchException e){
                i++;
                System.out.println("Введите число.");
                num.next();
            }
            if(number<0){
                i++;
                System.out.println("Введите положительное число.");
            }
            if(i==0)
                break;
        }
        return number;
    }
    public static void waiting(){
        String key;
       Scanner wait = new Scanner(System.in);
        System.out.println("Введите любую клавишу для продолжения");
       key = wait.nextLine();
    }
}
