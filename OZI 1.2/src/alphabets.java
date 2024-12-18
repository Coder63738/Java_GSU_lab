public class alphabets {

    public static int check(String[] alphabet,char symbol){
        for (int i = 0; i < alphabet.length; i++) {
            if(alphabet[i].charAt(0)==symbol)
                return 1;
        }
    return 0;
}
}
