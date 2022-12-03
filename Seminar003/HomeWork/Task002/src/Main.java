import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<Integer> rndList = new ArrayList<>(randomListCreate(numInput()));
        System.out.println("\nЗаполняем список случайными значениями");
        loadImitation(50);
        System.out.printf("\n\nВот, что получилось:\n%s\n", rndList);
        Thread.sleep(500);
        System.out.println("\nИщем четные числа в списке");
        loadImitation(30);
        System.out.println("\nУдаляем их из списка");
        loadImitation(10);
        removeEvens(rndList);
        System.out.printf("\n\nВот, что получилось:\n%s\n", rndList);
    }

    private static void loadImitation(Integer sleepTime) throws InterruptedException {
        Thread.sleep(500);
        for (int i = 0; i < 60; i++) {
            System.out.print("\u2591");
            Thread.sleep(sleepTime);
        }
        System.out.print(" 100% ");
        Thread.sleep(500);
    }

    private static void removeEvens(ArrayList<Integer> rndList) {
        int n = 0;
        int end = rndList.size();
        for (int i = 0; i < end; i++) {
            if (rndList.get(i - n) % 2 == 0){
                rndList.remove(i - n);
                n++;
            }
        }
    }

    public static int numInput() {
        Scanner in = new Scanner(System.in);
        boolean check = true;
        Integer n = null;
        while (check) {
            System.out.print("Введите число элементов случайного списка (целое, больше 0): ");
            try {
                n = Integer.parseInt(in.nextLine());
                if (n < 1) {
                    System.out.println("Стоп! Давайте еще разок попробуем. " +
                            "Целое число больше 0 - это 1, 2, 3 ... Ну Вы поняли.");
                }
                else {
                    check = false;
                }
            }
            catch (Exception e) {
                System.out.println("Стоп! Давайте еще разок попробуем. " +
                        "Целое число больше 0 - это 1, 2, 3 ... Ну Вы поняли.");
            }
        }
        return n;
    }

    private static ArrayList<Integer> randomListCreate(int maxSize){
        Random rnd = new Random();
        ArrayList<Integer> rndList = new ArrayList<>();
        for (int i = 0; i < maxSize; i++) {
            rndList.add(rnd.nextInt(-100, 101));
        }
        return rndList;
    }
}