import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int i=0,j=1,k,border;
        Scanner num = new Scanner(System.in);
        System.out.println("Введите границу для чисел фибоначи:");
        border = num.nextInt();
        System.out.print("1 ");
        for (;;) {
        k=i+j;
        if(k>border)
            break;
        System.out.print(k + " ");
        i=j;
        j=k;
        }
    }
}