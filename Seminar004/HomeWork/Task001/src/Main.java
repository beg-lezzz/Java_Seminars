import java.util.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        LinkedList<Integer> rndList = randomListCreate(numInput());
        printResult(rndList.toString(), "Исходный односвязный список: ");
        printResult(reverseLinkedList(rndList).toString(), "Перевернутый односвязный список: ");
    }

    public static LinkedList<Integer> reverseLinkedList(LinkedList<Integer> inputList){
        for (int i = 0; i < inputList.size(); i++) {
            inputList.add(i, inputList.removeLast());
        }
        return inputList;
    }

    public static void printResult(String result, String message) throws InterruptedException {
        System.out.printf("\n%s\n%s\n", message, result);
//        Thread.sleep(500);
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

    private static LinkedList<Integer> randomListCreate(int maxSize){
        Random rnd = new Random();
        LinkedList<Integer> rndList = new LinkedList<>();
        for (int i = 0; i < maxSize; i++) {
            rndList.add(rnd.nextInt(-100, 101));
        }
        return rndList;
    }
}