import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
int number,number1=1;
        Scanner num = new Scanner(System.in);
        System.out.println("Введите число от которого взять факториал:");
        number = num.nextInt();
        for (int i = 0; i < number; i++) {
          number1 = number1*(i+1);
        }
        System.out.println("факториал числа: "+number1);
    }
}