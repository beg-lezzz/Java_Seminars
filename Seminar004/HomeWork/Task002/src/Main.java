import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        LinkedList<Integer> rndList = randomListCreate(numInput("Введите число элементов случайного списка (целое, больше 0): ", 0));
        printResult(rndList.toString(), "Исходный односвязный список: ");
        int numForAdd = numInput("Введите число для добавления в список (целое): ", 1);
        enqueue(rndList, numForAdd);
        printResult(rndList.toString(), "После добавления в конец списка числа " + numForAdd + ": ");
        printResult(dequeue(rndList).toString(), "Удален первый элемент = ");
        printResult(rndList.toString(), "Список после удаления первого элемента: ");
        printResult(first(rndList).toString(), "Первый элемент = ");
    }

    private static Integer first(LinkedList<Integer> inputList) {
        return inputList.get(0);
    }

    private static Integer dequeue(LinkedList<Integer> inputList) {
        return inputList.remove(0);
    }

    private static void enqueue(LinkedList<Integer> inputList, Integer element) {
        inputList.add(element);
    }

    public static void printResult(String result, String message) throws InterruptedException {
        System.out.printf("\n%s\n%s\n", message, result);
//        Thread.sleep(500);
    }

    public static int numInput(String message, int param) {
        Scanner in = new Scanner(System.in);
        boolean check = true;
        Integer n = null;
        while (check) {
            System.out.print(message);
            try {
                n = Integer.parseInt(in.nextLine());
                if (param == 0 && n < 1) {
                    System.out.println("Стоп! Давайте еще разок попробуем. " +
                            "Целое число больше 0 - это 1, 2, 3 ... Ну Вы поняли.");
                } else {
                    check = false;
                }
            }
            catch (Exception e) {
                if (param == 0){
                    System.out.println("Стоп! Давайте еще разок попробуем. " +
                            "Целое число больше 0 - это 1, 2, 3 ... Ну Вы поняли.");
                } else {
                    System.out.println("Стоп! Давайте еще разок попробуем. " +
                            "Целое число - это -1, 0, 1, 2, 3 ... Ну Вы поняли.");
                }
            }
        }
        return n;
    }

    private static LinkedList<Integer> randomListCreate(int maxSize){
        Random rnd = new Random();
        LinkedList<Integer> rndList = new LinkedList<>();
        for (int i = 0; i < maxSize; i++) {
            rndList.add(rnd.nextInt(-100, 101));
        }
        return rndList;
    }
}