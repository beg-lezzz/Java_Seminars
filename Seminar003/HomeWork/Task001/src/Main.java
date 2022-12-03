import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int[] arr = randomArrCreate(numInput());
        loadImitation("создания массива");
        System.out.printf("\nНе без помощи магии сгенерирован случайный массив из %d элементов:\n%s\n", arr.length, Arrays.toString(arr));
        Thread.sleep(500);
        loadImitation("сортировки");
        System.out.printf("\nЕще немного магии Хогвартса и массив отсортирован методом слияния: \n%s\n", Arrays.toString(mergeSort(arr)));
        Thread.sleep(3000);
        answerInput();
    }

    private static void loadImitation(String magicFor) throws InterruptedException {
        System.out.printf("\nПожалуйста, подождите. Идет выбор типа магии для %s\n", magicFor);
        Thread.sleep(500);
        for (int i = 0; i < 60; i++) {
            System.out.print("\u2591");
            Thread.sleep(50);
        }
        System.out.print(" 100% ");
        Thread.sleep(500);
    }


    public static int numInput() {
        Scanner in = new Scanner(System.in);
        boolean check = true;
        Integer n = null;
        while (check) {
            System.out.print("Введите максимальное число элементов случайного массива (целое, больше 0): ");
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

    public static void answerInput() {
        Scanner in = new Scanner(System.in);
        boolean check = true;
        String n = "";
        while (check) {
            System.out.print("\nВы пытаетесь сравнивть массивы? (Y/N): ");
            try {
                n = in.nextLine();
                if (n.equalsIgnoreCase("Y")) {
                    System.out.println("Стыдно не доверять магии Хонвартса.");
                    check = false;
                } else if (n.equalsIgnoreCase("N")) {
                    System.out.println("Вот это правильно. Магии Хонвартса нельзя не доверять.");
                    check = false;
                } else {
                    System.out.println("Стоп! Давайте еще разок попробуем. " +
                            "Да - Y или Нет - N");
                }
            }
            catch (Exception e) {
                System.out.println("Стоп! Давайте еще разок попробуем. " +
                        "Да - Y или Нет - N");
            }
        }
    }

    private static int[] randomArrCreate(int maxSize){
        Random rnd = new Random();
        int rndArrSize = rnd.nextInt(1, maxSize + 1);
        int[] rndArr = new int[rndArrSize];
        for (int i = 0; i < rndArr.length; i++) {
            rndArr[i] = rnd.nextInt(-100, 101);
        }
        return rndArr;
    }

    private static int[] mergeSort(int[] inputArr) {
        int curLen = inputArr.length;
        if (curLen == 1) return inputArr;
        int midOfArr = curLen / 2;
        int[] leftArr = new int[midOfArr];
        int[] rightArr = new int[curLen - midOfArr];

        for (int i = 0; i < midOfArr; i++)
            leftArr[i] = inputArr[i];
        for (int i = midOfArr; i < curLen; i++)
            rightArr[i - midOfArr] = inputArr[i];

        mergeSort(leftArr);
        mergeSort(rightArr);
        merge(inputArr, leftArr, rightArr);

        return inputArr;
    }

    private static void merge(int[] inputArr, int[] leftArr, int[] rightArr) {
        int leftLen = leftArr.length;
        int rightLen = rightArr.length;
        int lCounter = 0;
        int rCounter = 0;
        int mainCounter = 0;

        while (lCounter < leftLen && rCounter < rightLen){
            if (leftArr[lCounter] < rightArr[rCounter]){
                inputArr[mainCounter] = leftArr[lCounter];
                lCounter++;
            } else {
                inputArr[mainCounter] = rightArr[rCounter];
                rCounter++;
            }
            mainCounter++;
        }

        for (int lBalance = lCounter; lBalance < leftLen; lBalance++) {
            inputArr[mainCounter++] = leftArr[lBalance];
        }
        for (int rBalance = rCounter; rBalance < rightLen; rBalance++) {
            inputArr[mainCounter++] = rightArr[rBalance];
        }
    }
}