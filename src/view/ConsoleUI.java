package src.view;

import src.model.member.Gender;
import src.model.member.Human;
import src.presenter.Presenter;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleUI implements View {
    private Presenter presenter;
    private Scanner scanner;
    private boolean work;
    private Menu menu;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        work = true;
        menu = new Menu(this);
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    private String scan() {
        return scanner.nextLine();
    }

    @Override
    public void print(String text) {
        System.out.print(text);
    }

    @Override
    public void start() {
        while (work) {
            try {
                print(menu.print() + "-> ");
                while (!scanner.hasNextInt()) {
                    print("Некорректный ввод. Введите число");
                    scanner.next();
                }
                int choice = scanner.nextInt();
                scan();
                menu.execute(choice);
            } catch (IndexOutOfBoundsException e) {
                print("Такого пункта меню нет. Выберите пункт из списка.");
            } catch (InputMismatchException e) {
                print("Пожалуйста введите число");
                scanner.next();
            } catch (Exception e) {
                print("Произошла ошибка " + e.getMessage());
            }
        }

    }

    public void printTree() {
        System.out.println("_".repeat(80));
        presenter.printTree();
        System.out.println();
    }

    public void addMember() {
        String name = null;
        String surname = null;
        Gender sex = null;
        String birthDate = null;
        Human mother = null;
        Human father = null;
        while (name == null) {
            System.out.println("Введите имя: ");
            String input = scan();
            if (input.trim().isEmpty()) {
                System.out.println("Имя не может быть пустым.");
            } else {
                name = input.trim();
            }
        }

        while (surname == null) {
            System.out.println("Введите фамилию: ");
            String input = scan();
            if (input.trim().isEmpty()) {
                System.out.println("Фамилия не может быть пустой.");
            } else {
                surname = input.trim();
            }
        }

        while (sex == null) {
            System.out.println("Введите пол 'm' - мужской или 'f' - женский: ");
            String input = scan();
            if (input.trim().isEmpty()) {
                System.out.println("Пол не может быть пустым.");
            } else if (input.trim().equalsIgnoreCase("m")) {
                sex = Gender.Male;
            } else if (input.trim().equalsIgnoreCase("f")) {
                sex = Gender.Female;
            } else {
                System.out.println("Некорректный ввод пола.");
            }
        }

        while (birthDate == null) {
            System.out.println("Введите дату рождения в формате ДД.ММ.ГГГГ: ");
            String input = scan();
            if (input.trim().isEmpty()) {
                System.out.println("Поле не может быть пустым.");
            } else {
                birthDate = input.trim();
            }
        }

        System.out.println("Введите имя матери (если неизвестно, нажмите Enter): ");
        String motherName = scan();
        if (!motherName.trim().isEmpty()) {
            try {
                mother = presenter.searchMemberByName(motherName.trim());
                if (mother == null) {
                    System.out.println("Матерь с именем '" + motherName + "' не найдена в дереве.");
                    return;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("Введите имя отца (если неизвестно, нажмите Enter): ");
        String fatherName = scan();
        if (!fatherName.trim().isEmpty()) {
            try {
                father = presenter.searchMemberByName(fatherName.trim());
                if (father == null) {
                    System.out.println("Отец с именем '" + fatherName + "' не найден в дереве.");
                    return;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        try {
            presenter.addMember(name, surname, sex, birthDate, father, mother);
            System.out.println("Человек был успешно добавлен в дерево.\n");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void removeMember() {
        System.out.println("Введите имя: ");
        String name = scan();
        try {
            presenter.removeMember(name);
            System.out.println();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void searchMemberByName() {
        System.out.println("Введите имя: ");
        String name = scan();
        if (presenter.searchMemberByName(name) != null) {
            System.out.println(presenter.searchMemberByName(name).getInfo());
        } else {
            System.out.println("Попробуйте еще раз");
        }

        System.out.println("_".repeat(80));
    }

    public void clearTree() {
        System.out.println("_".repeat(80));
        presenter.clearTree();
        System.out.println("Дерево очищено\n");
    }

    public void loadTree() {
        System.out.println("Введите имя файла для загрузки: ");
        String fileName = scan();
        String fullName = "src/" + fileName + ".dat";
        presenter.loadTree(fullName);
        System.out.println("Дерево загружено");
    }

    public void saveTree() {
        System.out.println("Введите имя файла для сохранения: ");
        String fileName = scan();
        String fullName = "src/" + fileName + ".dat";
        presenter.saveTree(fullName);
        System.out.println("Дерево сохранено");
    }

    public void finish() {
        work = false;
    }
}
