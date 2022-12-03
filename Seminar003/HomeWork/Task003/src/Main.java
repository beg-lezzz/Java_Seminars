import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<Integer> rndList = new ArrayList<>(randomListCreate(numInput()));
        System.out.println("\nЗаполняем список случайными значениями");
        loadImitation(15);
        printResult(rndList.toString(), "Список чисел:\n");
        Thread.sleep(500);
        System.out.println("\nИщем максимальное значение в списке");
        loadImitation(5);
        printResult(Integer.toString(findMax(rndList)), "Максимум = ");
        System.out.println("\nИщем минимальное значение в списке");
        loadImitation(5);
        printResult(Integer.toString(findMin(rndList)), "Минимум = ");
        System.out.println("\nИщем среднее из всех значений списка");
        loadImitation(5);
        printResult(Double.toString(findAverage(rndList)), "Среднее = ");
    }

    private static void printResult(String result, String message) throws InterruptedException {
        System.out.printf("\n%s%s\n", message, result);
        Thread.sleep(500);
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

    private static int findMin(ArrayList<Integer> rndList) {
        int min = rndList.get(0);
        for (int element : rndList) {
            min = Math.min(element, min);
//            min = element < min ? element : min;
        }
        return min;
    }

    private static int findMax(ArrayList<Integer> rndList) {
        int max = rndList.get(0);
        for (int element : rndList) {
            max = Math.max(element, max);
//            max = element > max ? element : max;
        }
        return max;
    }

    private static double findAverage(ArrayList<Integer> rndList) {
        int sum = 0;
        for (int element : rndList) {
            sum += element;
        }
        return (double)sum / (double)rndList.size();
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