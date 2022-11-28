import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        checkOnPrime(numInput());
    }

    public static int numInput() {
        Scanner in = new Scanner(System.in);
        boolean check = true;
        Integer n = null;
        while (check) {
            System.out.print("Введите целое число больше 0: ");
            try {
                n = Integer.parseInt(in.nextLine());
                if (n < 1) {
                    System.out.println("Ошибка! Необходимо вводить целое число больше 0");
                }
                else {
                    check = false;
                }
            }
            catch (Exception e) {
                System.out.println("Ошибка! Необходимо вводить целое число больше 0");
            }
        }
        return n;
    }

    public static void checkOnPrime(int num) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 2; i <= num; i++) {
            boolean checkPrime = true;
            for (int j = 2; j < i; j++) {
                if(i % j == 0){
                    checkPrime = false;
                    break;}
            }
            if(checkPrime)
                arrayList.add(i);
        }
        if (arrayList.size() > 0) {
            System.out.printf("Список простых чисел от 1 до %d => %s", num, arrayList);
        }
        else {
            System.out.printf("В диапазоне от 1 до %d простые числа отсутствуют", num);
        }
    }
}