import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        int num = numInput();
        System.out.printf("Сумма чисел от 1 до %d = %d\n", num, nSum(num));
        System.out.printf("Произведение чисел от 1 до %d = %d\n", num, nFactorial(num));
        nFactorial(num);
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

    public static int nSum(Integer args) {
        int sum = args * (args + 1) / 2;

        return sum;
    }

    public static int nFactorial(int args) {
        if (args == 1 || args == 0) {
            return 1;
        }

        return args * nFactorial(args - 1);
    }
}