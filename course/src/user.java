import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class user {
    public static void output_all_labaratories(){
        String filename ="lab.txt", line1="",line2="";
        try(BufferedReader br = new BufferedReader(new FileReader(filename),65536)){
        while (((line1= br.readLine()) != null)&&(line2= br.readLine()) != null){
            System.out.println(line1+" "+line2);
        }
        }
        catch (IOException e){
            System.out.println("Файл не найден");
        }
        security.waiting();
    }
    public static void output_evaluations(String login){
        String filename ="account.txt", line="",evaluation;
        try(BufferedReader br = new BufferedReader(new FileReader(filename),65536)) {
            br.readLine();
            for (;;) {
                line = br.readLine();
                String[] parts = line.split(" ");
                if (parts[0].equals(login)) {
                    System.out.println("Имя пользователя: "+parts[2]+" "+parts[3]);
                    try {
                        for (int i = 4;;i++) {
                            evaluation=parts[i];
                            System.out.println("Лабораторная "+(i-3)+": "+evaluation);
                        }
                    }
                    catch (ArrayIndexOutOfBoundsException e){
                        break;
                    }
                }
            }
        }
        catch (IOException e){
            System.out.println("Файл не найден");
        }
    security.waiting();
    }
}
