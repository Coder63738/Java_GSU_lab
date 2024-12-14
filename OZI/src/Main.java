import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] alphabet = {"а","б","в","г","д","е","ё","ж","з","и","й","к","л","м","н","о","п","р","с","т","у","ф","х","ц","ч","ш","щ","ъ","ы","ь","э","ю","я"};
        Scanner string = new Scanner(System.in);
        System.out.println("Введите строку:");
        String notCipher = string.nextLine();
        String notCiphers = notCipher.toLowerCase();//преобразуем всё в малый регистр
        int key,choose,number=0,alph=0;
        System.out.println("Вы хотите зашифровать или расшифровать?\n1.Зашифровать\n2.Расшифровать");
        choose = string.nextInt();
        System.out.println("Введите ключ:");
        key = string.nextInt();
        key = key % 33;
        String symbol = " ";
        char Cip=0;
        String cipher=" ";
        if(choose==1) {
            for (int i = 0; i < notCiphers.length(); i++) {
               if(notCiphers.charAt(i) != symbol.charAt(0)){
                Cip=notCiphers.charAt(i);
                   for (int j = 0; j < 33; j++) {
                       if(Cip == alphabet[j].charAt(0)){
                           number = j;
                           break;
                       }
                   }
                   Cip = alphabet[(number+key)%33].charAt(0);
                   cipher += Cip;
               }else {
                   cipher += symbol;
               }
        }
        }
            if (choose==2) {
                for (int i = 0; i < notCiphers.length(); i++) {
                    alph=0;
                    if(notCiphers.charAt(i) != symbol.charAt(0)){
                        Cip=notCiphers.charAt(i);
                        for (int j = 0; j < 33; j++) {
                            if(Cip == alphabet[j].charAt(0)){
                                number = j;
                                break;
                            }
                        }
                        alph=number-key;
                        if (alph<0)
                            alph=33+alph;
                        Cip = alphabet[alph%33].charAt(0);
                        cipher += Cip;
                    }else {
                        cipher += symbol;
                    }
                }

    }
        System.out.println(cipher);
}}