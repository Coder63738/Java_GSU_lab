import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class administrator {
    public static void output_all_evaluations(){
        String filename ="account.txt", line="",evaluation;
        try(BufferedReader br = new BufferedReader(new FileReader(filename),65536)) {
            br.readLine();
            for (;;) {
                if ((line = br.readLine()) == null)
                    break;
                String[] parts = line.split(" ");
                if (parts[1].equals("u")) {
                        System.out.println("Имя пользователя: " + parts[2] + " " + parts[3]);
                        try {
                            for (int i = 4; ; i++) {
                                evaluation = parts[i];
                                System.out.println("Лабораторная " + (i - 3) + ": " + evaluation);
                            }
                        } catch (ArrayIndexOutOfBoundsException e) {
                            System.out.println("");
                        }
                }

            }
        }
        catch (IOException e){
            System.out.println("Файл не найден");
        }
        security.waiting();
    }
    public static void add_evaluations(){
        String filename ="account.txt",surname,line,file_data="";
        int number,evaluations;
        boolean insert = false;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите фамилию пользователя: ");
        surname = scanner.nextLine();
        System.out.println("Введите номер лабораторной которую вы хотите оценить: ");
        number = security.int_scanner_security();
        System.out.println("Введите оценку: ");
        evaluations = security.int_scanner_security();
        try(BufferedReader br = new BufferedReader(new FileReader(filename),65536)) {
            line = br.readLine();
            file_data = file_data + line + "\n";
            while ((line=br.readLine())!=null){
                String[] parts = line.split(" ");
                if(parts[2].equals(surname)&&!insert){
                    file_data = file_data + parts[0] + " "+ parts[1]+ " " + parts[2]+ " " + parts[3]+" ";
                    for (int i = 0;; i++) {
                        if(i!=(number-1)) {
                            try {
                            file_data = file_data + parts[4+i]+" ";}
                            catch (ArrayIndexOutOfBoundsException e){
                                break;
                            }
                        }
                        else {
                            file_data = file_data + "" + evaluations+" ";
                        }
                    }
                    file_data = file_data + "\n";
            }
                else {
                    file_data = file_data + line + "\n";
                }
            }
        }
        catch (IOException e){
            System.out.println("Файл не найден");
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, false))) {
            writer.write(file_data);
            System.out.println("Содержимое файла успешно обновлено.");
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл: " + e.getMessage());
        }
    }
        public static void set_lab() {
            String labName, number, filename = "lab.txt",filenames ="account.txt", line, fileData = "";
            int day, month, year, num;

            Scanner scanner = new Scanner(System.in);

            // Ввод данных о новой лабораторной работе
            System.out.print("Введите название лабораторной: ");
            labName = scanner.nextLine();

            System.out.print("Введите день сдачи лабораторной: ");
            day = security.int_scanner_security();

            System.out.print("Введите месяц сдачи лабораторной: ");
            month = security.int_scanner_security();

            do {
                System.out.print("Введите год сдачи лабораторной: ");
                year = security.int_scanner_security();
                if (year < 2000) {
                    System.out.println("Введите правильный год.");
                }
            } while (year < 2000);

            System.out.print("Введите номер лабораторной для вставки (например, 2): ");
            number = scanner.nextLine();

            try {
                num = Integer.parseInt(number); // Преобразуем строку в число
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: номер лабораторной должен быть числом.");
                return;
            }

            // Чтение файла и создание обновлённого содержимого
            try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
                StringBuilder fileBuilder = new StringBuilder();
                boolean inserted = false;

                while ((line = br.readLine()) != null) {
                    String[] parts = line.split(" ");
                    int currentNum;

                    try {
                        currentNum = Integer.parseInt(parts[0]); // Читаем номер лабораторной
                    } catch (NumberFormatException e) {
                        fileBuilder.append(line).append("\n");
                        continue;
                    }

                    // Если дошли до нужного места, вставляем новую лабораторную
                    if (!inserted && currentNum >= num) {
                        fileBuilder.append(num).append(" ").append(labName).append("\n");
                        fileBuilder.append(String.format("%02d.%02d.%d%n", day, month, year));
                        inserted = true;
                    }

                    // Обновляем номер для последующих лабораторных
                    if (inserted) {
                        fileBuilder.append((currentNum + 1)).append(" ");
                        for (int i = 1; i < parts.length; i++) {
                            fileBuilder.append(parts[i]).append(" ");
                        }
                        fileBuilder.append("\n");
                        fileBuilder.append(br.readLine()).append("\n"); // Добавляем дату
                    } else {
                        // Просто копируем текущую строку
                        fileBuilder.append(line).append("\n");
                        fileBuilder.append(br.readLine()).append("\n"); // Добавляем дату
                    }
                }

                // Если вставка не произошла (например, файл пустой), добавляем лабораторную в конец
                if (!inserted) {
                    fileBuilder.append(num).append(" ").append(labName).append("\n");
                    fileBuilder.append(String.format("%02d.%02d.%d%n", day, month, year));
                }

                fileData = fileBuilder.toString();
            } catch (IOException e) {
                System.out.println("Ошибка при чтении файла: " + e.getMessage());
            }

            // Запись обновлённых данных обратно в файл
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, false))) {
                writer.write(fileData);
                System.out.println("Содержимое файла успешно обновлено.");
            } catch (IOException e) {
                System.out.println("Ошибка при записи в файл: " + e.getMessage());
            }

            try(BufferedReader br = new BufferedReader(new FileReader(filenames),65536)){
                line = br.readLine();
                fileData = "";
                fileData = fileData + line+"\n";
                while ((line= br.readLine())!=null){
                    String[] parts = line.split(" ");
                    if(parts[1].equals("u")){
                        fileData = fileData + parts[0] + " "+ parts[1]+ " " + parts[2]+ " " + parts[3]+" ";
                        for (int k=1;;k++){
                            if(k==num){
                                fileData = fileData + "0 "+parts[3+k]+" ";
                            }
                            else {
                                try {
                                fileData = fileData + parts[3+k]+" ";}
                                catch (ArrayIndexOutOfBoundsException e){
                                    break;
                                }
                            }
                        }
                        fileData = fileData + "\n";
                    }
                    else {
                        fileData = fileData + line+"\n";
                    }
                }
            }
            catch (IOException e){
                System.out.println("Ошибка при чтении файла: " + e.getMessage());
            }
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filenames, false))) {
                writer.write(fileData);
                System.out.println("Содержимое файла успешно обновлено.");
            } catch (IOException e) {
                System.out.println("Ошибка при записи в файл: " + e.getMessage());
            }
        }






















































        
    public static void delete_lab(){
        String filename = "lab.txt",fileData="",line,filenames="account.txt";
        boolean inserted = false;
        int index=0;
        System.out.println("Введите номер удаляемой лабораторной: ");
        Scanner scanner = new Scanner(System.in);
        String numberToDelete =scanner.nextLine();
        int number = Integer.parseInt(numberToDelete);
        try(BufferedReader br = new BufferedReader(new FileReader(filename),65536)) {
            while ((line=br.readLine())!=null){
                String[] parts = line.split(" ");
                if(parts[0].equals(numberToDelete)){
                    line= br.readLine();
                    line= br.readLine();
                    parts = line.split(" ");
                    inserted = true;
                }
                if(!inserted){
                   fileData = fileData + line+"\n";
                   line= br.readLine();
                    fileData = fileData + line+"\n";
                }
                if(inserted){
                    fileData = fileData + (number+index)+" ";
                    try {
                        for(int i=0;;i++){
                            fileData = fileData + parts[1+i]+" ";
                        }
                    }
                    catch (ArrayIndexOutOfBoundsException e){
                    }
                }
                if(inserted){
                    line = br.readLine();
                    fileData = fileData + "\n" + line+"\n";
                    index++;
                }
            }
        }
        catch (IOException e){
            System.out.println("Файл не найден");
        }
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, false))) {
                writer.write(fileData);
                System.out.println("Работа с номером " + numberToDelete + " успешно удалена.");
            }
        catch (IOException e) {
            System.out.println("Ошибка при обработке файла: " + e.getMessage());
        }
        try(BufferedReader br = new BufferedReader(new FileReader(filenames),65536)){
            line = br.readLine();
            fileData = "";
            fileData = fileData + line+"\n";
            while ((line= br.readLine())!=null){
                String[] parts = line.split(" ");
                if(parts[1].equals("u")){
                    fileData = fileData + parts[0] + " "+ parts[1]+ " " + parts[2]+ " " + parts[3]+" ";
                    for(int k=0;;k++){
                        try {
                         if(number==(k+1)){
                         }
                         else{
                             fileData = fileData + parts[4+k]+" ";
                         }
                        }
                        catch (ArrayIndexOutOfBoundsException e){
                            break;
                        }
                    }
                    fileData = fileData +"\n";
                }
                else {
                    fileData = fileData + line + "\n";
                }}
        }
        catch (IOException e){
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filenames, false))) {
            writer.write(fileData);
            System.out.println("Содержимое файла успешно обновлено.");
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл: " + e.getMessage());
        }
    }
    public static void add_user(){
        int i=0;
                Scanner scanner = new Scanner(System.in);
                String filename = "account.txt",line,fileData="";
                System.out.println("Введите логин аккаунта:");
                String login = scanner.nextLine();

                System.out.println("Введите пароль:");
                String password = scanner.nextLine();

                System.out.println("Введите фамилию: ");
                String surname = scanner.nextLine();

                System.out.println("Введите имя: ");
                String firstname = scanner.nextLine();
                firstname.toUpperCase();

                System.out.println("Введите отчество: ");
                String dadname = scanner.nextLine();
                dadname.toUpperCase();

                System.out.println("Введите роль u/a: ");
                String role = scanner.nextLine();
                role.toLowerCase();
        try(BufferedReader br = new BufferedReader(new FileReader(filename),65536)){
            line = br.readLine();
            fileData = fileData +line+ " " + login +" "+password+" "+role+"\n";
            while ((line= br.readLine())!=null){
                fileData = fileData + line +"\n";
                String[] parts = line.split(" ");
                if (parts[1].equals("u")){
                for(i =0;;i++){
                    try {
                        String part = parts[4+i];
                    }
                    catch (ArrayIndexOutOfBoundsException e){
                        break;
                    }
                }
            }}
            fileData = fileData + login +" "+ role +" " + surname +" "+firstname.charAt(0)+"."+dadname.charAt(0)+". ";
            if(!role.equals("a"))
            for (int k = 0; k < i; k++) {
                fileData = fileData + "0 ";
            }
        }catch (IOException e){
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
    }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, false))) {
            writer.write(fileData);
            System.out.println("Содержимое файла успешно обновлено.");
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл: " + e.getMessage());
        }
    }
    public static void delete_user(){
        String filename="account.txt",login,line,fileData="";
        System.out.println("Введите логин пользователя для удаления.");
        Scanner scanner = new Scanner(System.in);
        login = scanner.nextLine();
        try(BufferedReader br = new BufferedReader(new FileReader(filename),65536)){
            line= br.readLine();
            String[] parts = line.split(" ");
            for(int i = 0;;i++){
                try {
                    if(!parts[i].equals(login)){
                    fileData = fileData + parts[i] + " ";}
                    else {
                        i=i+2;
                    }
                }
                catch (ArrayIndexOutOfBoundsException e){
                    break;
                }
            }
            fileData = fileData + "\n";
            while ((line= br.readLine())!=null){
                parts = line.split(" ");
                if(!parts[0].equals(login)){
                    fileData = fileData + line +"\n";
                }
                else {
                }
            }
        }
    catch (IOException e){
        System.out.println("Ошибка при чтении файла: " + e.getMessage());
    }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, false))) {
            writer.write(fileData);
            System.out.println("Содержимое файла успешно обновлено.");
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл: " + e.getMessage());
        }
    }
}
