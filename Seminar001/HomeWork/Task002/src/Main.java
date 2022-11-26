import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        checkPrime(num_input());
    }

    public static int num_input() {
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

    public static void checkPrime(int num) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 2; i <= num; i++) {
            boolean check_Prime = true;
            for (int j = 2; j < i; j++) {
                if(i % j == 0){
                    check_Prime = false;
                    break;}
            }
            if(check_Prime)
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