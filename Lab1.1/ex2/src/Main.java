import java.lang.foreign.SymbolLookup;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner word = new Scanner(System.in);
        String word1,word2;
        word1 = word.nextLine();
        word2 = word.nextLine();
        revers(word1);
        revers(word2);
    }
    public static void revers(String word){
        int length;
       length = word.length();
        char[] reversWord = new char[length];
        for (int i = 0; i < length; i++){ reversWord[i] = word.charAt(length - i - 1);}
        for (int i = 0; i < length; i++){ System.out.print(reversWord[i]);}
        System.out.print(" ");
}}