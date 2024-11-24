import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int i,j,k;
        Scanner num = new Scanner(System.in);
        System.out.print("Введите первое число: ");
        i = num.nextInt();
        System.out.print("\nВведите второе число: ");
        j = num.nextInt();
        System.out.print("\nВведите третье число: ");
        k = num.nextInt();
        int max=1,min=1;
        if(i>=j&&i>=k){
            max=i;
        } else if (j>=i&&j>=k) {
            max=j;
        } else if (k>=i&&k>=j) {
            max=k;
        }
        if(i<=j&&i<=k){
            min=i;
        } else if (j<=i&&j<=k) {
            min=j;
        } else if (k<=i&&k<=j) {
            min=k;
        }
        System.out.print("\nСреднее значение: "+(max+min)/2);
    }
}
