import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int counter = 0;
        String[] alphabet = {"а","б","в","г","д","е","ё","ж","з","и","й","к","л","м","н","о","п","р","с","т","у","ф","х","ц","ч","ш","щ","ы","ь","ъ","э","ю","я"};
        Scanner string = new Scanner(System.in);
        System.out.println("Введите строку: ");
        String text = string.nextLine();
        System.out.println("Введите кодовое слово: ");
        String codeWord = string.nextLine();
        String cipher="";
        int k,j;
        String[] codeWords = new String[text.length()];
        for (int i = 0; i < text.length(); i++) {
            codeWords[i] = Character.toString(codeWord.charAt(i%codeWord.length()));
        }
        int[] register = new int[text.length()];
        String[] symbol = {",","."," ","!","?","-"};
        for (int i = 0;i<text.length() ;i++) {
            for ( j = 0; j < 33; j++) {
                if(text.charAt(i)==alphabet[j].charAt(0)){
                    register[i]=1;
                    break;
                }
                if(text.charAt(i)==symbol[0].charAt(0)||text.charAt(i)==symbol[1].charAt(0)||text.charAt(i)==symbol[2].charAt(0)||text.charAt(i)==symbol[3].charAt(0)||text.charAt(i)==symbol[4].charAt(0)||text.charAt(i)==symbol[5].charAt(0)){
                    register[i]=2;
                    break;
                }
            }
        }
        text = text.toLowerCase();
        String[][] table = new String[33][33];
        for (int i = 0; i < 33; i++) {
            for ( j = 0; j < 33; j++) {
                if((j+counter)>=33)
                {
                    for ( k = 0; k < 33-j; k++) {
                        table[i][j+k] = alphabet[k];
                    }
                    break;
                }
                table[i][j] = alphabet[j+counter];
            }
            counter++;
        }
        for (int i = 0; i < text.length(); i++) {
            for ( j = 0; j < 33; j++) {
            if (codeWords[i].charAt(0)==alphabet[j].charAt(0))
                break;
            }
            for ( k = 0; k < 33; k++) {
                if (text.charAt(i)==alphabet[k].charAt(0))
                    break;
            }
            if(alphabets.check(alphabet,text.charAt(i))==1){
                String transformedChar = table[k][j];
                if (register[i] == 0) {
                    transformedChar = transformedChar.toUpperCase();
                }
                cipher = cipher + transformedChar;
            } else {
                cipher = cipher + text.charAt(i);
            }
        }

        System.out.println(cipher);
            }}