package homeworks.final_project.controller;

import homeworks.final_project.service.DataService;
import homeworks.final_project.ui.*;

import java.util.Scanner;

public class Controller {

    BaseMenu[] view;
    DataService dataService;

    public Controller(DataService dataService) {
        this.dataService = dataService;
        view = new BaseMenu[]{new ContractorMenu(), new CommunicationMenu(), new GetContractorInfo()};
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Справочник контактов организации");
        System.out.println();

        while (true) {
            System.out.println("Выберете действие:\n" +
                    "1. Добавить/удалить контакт.\n" +
                    "2. Добавить/удалить способ связи.\n" +
                    "3. Посмотреть информацию о контактах.\n" +
                    "0. Выход из программы.\n");
            System.out.print(">>>\t");
            int input = scanner.nextInt();

            if (input >= 1 && input <= 3) {
                view[input - 1].showMenu(dataService);
            }
            if (input == 0) {
                System.out.println("До свидания!!!");
                break;
            }
        }

        scanner.close();
    }
}
