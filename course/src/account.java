import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class account {
    public static int check_account(String login,String password){
        int i=0;
        String privilege;
        String filename ="account.txt",line="";
        try(BufferedReader br = new BufferedReader(new FileReader(filename),65536)){
            line = br.readLine();
            if (line == null) {
                System.out.println("Файл пустой или не удалось считать строку.");
                return 0;
            }
        for (int j=0;;){
            try {
                i = 0;
                String[] parts = line.split(" ");
                String part = parts[j];
                j++;
                if (part.equals(login))
                    i++;
                part = parts[j];
                j++;
                if (part.equals(password)) ;
                i++;
                if (i == 2) {
                    privilege = parts[j];
                    switch (privilege) {
                        case "a":
                            return 2;
                        case "u":
                            return 1;
                    }
                }
                j++;
            }
            catch (ArrayIndexOutOfBoundsException e){
                break;
            }

        }
        }
        catch (IOException e){
        System.out.println("Файл не найден");
        }
        return 0;
    }
}
