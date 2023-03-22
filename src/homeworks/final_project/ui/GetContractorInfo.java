package homeworks.final_project.ui;

import homeworks.final_project.model.Contractor;
import homeworks.final_project.service.DataService;

import java.util.List;
import java.util.Scanner;

public class GetContractorInfo implements BaseMenu {

    @Override
    public void showMenu(DataService service) {
        Scanner scanner = new Scanner(System.in);
        List<Contractor> list = service.getAllContractorsName();
        System.out.println("Меню информации о контакте.");
        while (true) {
            System.out.println("Выберете действие:\n" +
                    "1. Показать информацию о всех контактах.\n" +
                    "2. Показать информацию о контакте.\n" +
                    "3. Вернуться в предыдущее меню.\n" +
                    "0. Выйти из программы.");
            System.out.print(">>>\t");
            String input = scanner.next();

            if (input.equals("1")) {
                System.out.println("Список всех контактов по именам:");
                System.out.println("===================================");
                for (Contractor contractor : list) {
                    System.out.printf("\t%s\n", contractor.getName());
                }
                System.out.println("===================================");
                continue;
            }

            if (input.equals("2")) {
                while (true) {
                    System.out.println("Введите ФИО контакта:");
                    System.out.print(">>>\t");
                    input = scanner.next();
                    for (Contractor contractor : list) {
                        if (contractor.getName().equalsIgnoreCase(input)) {
                            System.out.println("===================================");
                            System.out.println(contractor);
                            System.out.println("===================================");
                        }
                    }
                    System.out.println("Показать информацию о другом контакте?\nВведите \"Y\" - получить информацию.\nВведите любой символ чтобы вернуться в меню выбора.\n");
                    System.out.print(">>>\t");
                    input = scanner.next();

                    if (input.equalsIgnoreCase("Y")) {
                        continue;
                    }
                    break;
                }
                break;
            }

            if (input.equals("3")) {
                System.out.println("Выход в предыдущее меню.");
                break;
            }

            if (input.equals("0")) {
                System.out.println("Выход из программы.");
                System.exit(0);
            }
            System.out.println("Некорректный ввод, попробуйте еще раз.");
        }
    }
}
