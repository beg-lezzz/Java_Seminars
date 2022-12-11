import java.util.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        userMenu();
    }

    private static void userMenu() throws InterruptedException {
        HashMap<String, String> phoneBook = new HashMap<>();
        Scanner in = new Scanner(System.in);
        boolean exit = false;
        while (!exit){
            Thread.sleep(1000);
            System.out.print("\n*** Меню ***\n0. Выйти\n1. Добавить контакт\n2. Добавить телефон к контакту\n" +
                    "3. Найти контакт\n4. Напечатать весть справочник\n******\n\nВведите номер действия из списка: ");
            String choice = in.nextLine();
            switch (choice){
                case "0":
                    System.out.println("\nСпасибо, что воспользовались нашим сервисом. Ждем Вас снова.");
                    exit = true;
                    break;
                case "1":
                    addContact(phoneBook);
                    break;
                case "2":
                    addPhone(phoneBook);
                    break;
                case "3":
                    searchPerson(phoneBook, 0);
                    break;
                case "4":
                    printAll(phoneBook);
                    break;
                default:
                    System.out.println("\nВыбрано некорректное значение. Попробуйте снова.\n");
            }
        }
    }

    private static void printAll(HashMap phoneBook) throws InterruptedException {
        Scanner in = new Scanner(System.in);
        if (!phoneBook.isEmpty()){
            loadImitation();
            System.out.printf("\n*** Записей в справочнике - %d ***\n\n", phoneBook.size());
            int n = 1;
            for (Object contact : phoneBook.keySet()) {
                System.out.printf("*** Запись №%d ***\n%s: %s\n\n", n, contact, phoneBook.get(contact));
                n++;
            }
        } else {
            System.out.print("\nСправочник пока пуст. Добавить первую запись? (Y / N): ");
            if (in.nextLine().equalsIgnoreCase("y")){
                addContact(phoneBook);
            }
        }

    }

    private static String[] searchPerson(HashMap phoneBook, int searchType) throws InterruptedException {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите ФИО для поиска: ");
        String searchString = in.nextLine();
        String[] output = new String[2];
        loadImitation();
        if (phoneBook.containsKey(searchString)){
            if (searchType != 1){
                System.out.printf("\n*** Найден контакт ***\n%s: %s\n\n", searchString, phoneBook.get(searchString));
            }
            output[0] = searchString;
            output[1] = (String) phoneBook.get(searchString);
        } else {
            System.out.println("\nКонтакт отсутствует в справочнике\n");
        }
        return output;
    }


    private static void addPhone(HashMap phoneBook) throws InterruptedException {
        Scanner in = new Scanner(System.in);
        String[] searchOutput = new String[2];
        searchOutput = searchPerson(phoneBook, 1);
        if (searchOutput[0] != null) {
            StringBuilder contacts = new StringBuilder();
            contacts.append(searchOutput[1]);
            System.out.printf("Введите номер телефона для добавления к контакту %s: ", searchOutput[0]);
            contacts.append(", ").append(in.nextLine());
            phoneBook.put(searchOutput[0], contacts.toString());
            loadImitation();
            System.out.println("\nКонтакт успешно обновлен\n");
        }
    }

    private static void addContact(HashMap phoneBook) throws InterruptedException {
        Scanner in = new Scanner(System.in);
        String contact = inputString("Введите ФИО: ");
        String phone = inputString("Введите телефон:");

        if (!phoneBook.containsKey(contact)){
            phoneBook.putIfAbsent(contact, phone);
            loadImitation();
            System.out.printf("\nКонтакт %s успешно добавлен\n", contact);
        } else {
            System.out.printf("\nКонтакт %s уже существует в справочнике. Обновить? (Y / N): ", contact);
            String answer = in.nextLine();
            if (answer.equalsIgnoreCase("y")){
                phoneBook.put(contact, phone);
                loadImitation();
                System.out.printf("\nКонтакт %s обновлен\n", contact);
            } else {
                System.out.printf("\nКонтакт %s не обновлен\n", contact);
            }
        }
        phoneBook.putIfAbsent(contact, phone);
    }

    private static String inputString(String message) {
        Scanner in = new Scanner(System.in);
        String inputString = "";
        while (inputString == ""){
            System.out.print(message);
            inputString = in.nextLine();
            if (inputString == ""){
                System.out.print("Поле не может быть пустым\n");
            }
        }
        return inputString;
    }

    private static void loadImitation() throws InterruptedException {
        System.out.printf("\nПожалуйста, подождите. Мы работаем над этим.\n");
        Thread.sleep(500);
        for (int i = 0; i < 60; i++) {
            System.out.print("\u2591");
            Thread.sleep(30);
        }
        System.out.print(" 100% \n");
        Thread.sleep(500);
    }
}