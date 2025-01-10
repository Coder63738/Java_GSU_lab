import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int choose_action=0,choose_account=0,breaking=0;
        String login,password;
        Scanner string = new Scanner(System.in);
            System.out.print("Введите логин: ");
            login = string.nextLine();
            System.out.print("Введите пароль: ");
            password = string.nextLine();
            choose_account = account.check_account(login,password);
            switch (choose_account) {
                case 0:
                    System.out.print("Неверный логин или пароль: ");
                break;
                case 1:
                    System.out.println("Вы вошли как пользователь ");
                    for (;;) {
                        System.out.print("Выберите нужное вам действие:\n1.Просмотр списка лабораторных работ и сроков сдачи\n2.Просмотр оценок\n3.Выход ");
                        choose_action = security.int_scanner_security();
switch (choose_action){
    case 1:
    user.output_all_labaratories();
        break;
    case 2:
user.output_evaluations(login);
        break;
    case 3:
        breaking=1;
        break;
    default:
        break;
}
if(breaking == 1)
    break;
                    }
                break;
                case 2:
                    System.out.println("Вы вошли как администратор ");
                    for (;;){
                    System.out.print("Выберите нужное вам действие:\n1.Просмотр списка лабораторных работ и сроков сдачи\n2.Просмотр всех пользователей и их оценок\n3.Оценивание студента\n4.Создание новой лабораторной работы\n5.Удаление лабораторной работы\n6.Добавление пользователя\n7.Удаление пользователя\n8.Выход\n ");
                        choose_action = security.int_scanner_security();
                        switch (choose_action) {
                            case 1:
                                user.output_all_labaratories();
                                break;
                            case 2:
                                administrator.output_all_evaluations();
                                break;
                            case 3:
                                administrator.add_evaluations();
                                break;
                            case 4:
                                administrator.set_lab();
                                break;
                            case 5:
                                administrator.delete_lab();
                                break;
                            case 6:
                                administrator.add_user();
                                break;
                            case 7:
                                administrator.delete_user();
                                break;
                            case 8:
                            breaking = 1;
                            break;
                            default:
                                break;
                            }
                        if(breaking == 1)
                            break;
                    }
                    }
        }
    }
    /*1
1 Разработка приложений 1
03.01.2025
2 Разработка приложений 2
04.01.2025
3 Разработка приложений 3
05.01.2025
4 Разработка приложений 4
06.01.2025
5 Разработка приложений 5
07.01.2025

cat 1234 a dog 4321 u badboy 1234 a fox 2314 u itachi 2341 u
cat a Криволап В.С.
badboy a Кубе С.С.
dog u Халамов И.М. 10 10 10 10
fox u Баглай И.А. 5 10 10 7
itachi u Криволап К.П. 0 0 0 0 */