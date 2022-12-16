import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        NoteBook noteBook1 = new NoteBook(1, 256, 500, "HP", "Pavilion",
                "Windows 7", "black");
        NoteBook noteBook2 = new NoteBook(1, 512, 1000, "Lenovo", "P3120",
                "Windows 10", "white");
        NoteBook noteBook3 = new NoteBook(1, 1024, 250, "Asus", "VivoBook",
                "Windows 11", "gold");
        NoteBook noteBook4 = new NoteBook(1, 1024, 500, "Acer", "Transform",
                "CentOS", "black");
        NoteBook noteBook5 = new NoteBook(1, 2048, 2000, "Apple", "MacBook Air",
                "MacOS", "silver");
        NoteBook noteBook6 = new NoteBook(1, 1024, 2000, "HP", "H128970",
                "Windows 10", "black");
        NoteBook noteBook7 = new NoteBook(1, 512, 500, "Lenovo", "Excite",
                "Windows 11", "red");
        NoteBook noteBook8 = new NoteBook(1, 256, 250, "Asus", "LightView",
                "CentOS", "gold");
        NoteBook noteBook9 = new NoteBook(1, 512, 1000, "Acer", "Z2398",
                "Windows 11", "white");
        NoteBook noteBook10 = new NoteBook(1, 4096, 4000, "Apple", "MacBook Pro",
                "MacOS", "Gold");
        NoteBook noteBook11 = new NoteBook(1, 1024, 1000, "HP", "Quattro",
                "RedHat", "gold");

        NoteBook[] noteBooks = new NoteBook[]{noteBook1, noteBook2, noteBook3, noteBook4, noteBook5, noteBook6, noteBook7, noteBook8, noteBook9, noteBook10, noteBook11};



//        System.out.println(NoteBook.getByRam(noteBooks, 512, 1024));
//        System.out.println(NoteBook.getByOS(noteBooks, "Windows 11"));
        userMenu(noteBooks);


    }

    private static void userMenu(NoteBook[] noteBooks) throws InterruptedException {
        HashMap<String, String> phoneBook = new HashMap<>();
        Scanner in = new Scanner(System.in);
        boolean exit = false;
        while (!exit){
            Thread.sleep(1000);
            System.out.print("\n*** Меню ***\n0. Выйти\n1. Поиск по RAM\n2. Поиск по HDD\n" +
                    "3. Поиск по цвету\n4. Поиск по операционной системе\n******\n\nВведите номер действия из списка: ");
            String choice = in.nextLine();
            switch (choice){
                case "0":
                    System.out.println("\nСпасибо, что воспользовались нашим сервисом. Ждем Вас снова.");
                    exit = true;
                    break;
                case "1":
                    System.out.println("Введите минимальный объем: ");
                    int min = Integer.parseInt(in.nextLine());
                    System.out.println("Введите максимальный объем: ");
                    int max = Integer.parseInt(in.nextLine());
                    loadImitation();
                    StringBuilder result = NoteBook.getByRam(noteBooks, min, max);
                    if (result.length()>0){
                        System.out.printf("\nНоутбуки с объемом RAM от %d до %d:\n\n%s", min, max, result);
                    } else {
                        System.out.printf("Ноутбуки с объемом RAM от %d до %d не найдены.\n", min, max);
                    }
                    break;
                case "2":
                    System.out.println("Введите минимальный объем: ");
                    min = Integer.parseInt(in.nextLine());
                    System.out.println("Введите максимальный объем: ");
                    max = Integer.parseInt(in.nextLine());
                    loadImitation();
                    result = NoteBook.getByHD(noteBooks, min, max);
                    if (result.length()>0){
                        System.out.printf("\nНоутбуки с объемом HDD от %d до %d:\n\n%s", min, max, result);
                    } else {
                        System.out.printf("Ноутбуки с объемом HDD от %d до %d не найдены.\n", min, max);
                    }
                    break;
                case "3":
                    System.out.println("Введите цвет: ");
                    String colour = in.nextLine();
                    loadImitation();
                    result = NoteBook.getByColour(noteBooks, colour);
                    if (result.length()>0){
                        System.out.printf("\nНоутбуки цвета %s:\n\n%s", colour, result);
                    } else {
                        System.out.printf("Ноутбуки цвета %s не найдены.\n", colour);
                    }
                    break;
                case "4":
                    System.out.println("Введите операцтонную систему: ");
                    String os = in.nextLine();
                    loadImitation();
                    result = NoteBook.getByColour(noteBooks, os);
                    if (result.length()>0){
                        System.out.printf("\nНоутбуки с операционной системой %s:\n\n%s", os, result);
                    } else {
                        System.out.printf("Ноутбуки с операционной системой %s не найдены.\n", os);
                    }
                    break;
                default:
                    System.out.println("\nВыбрано некорректное значение. Попробуйте снова.\n");
            }
        }
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
