import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        boolean check = true;
        while (check) {
            System.out.print("Введите целое число больше 0: ");
            try {
                int n = Integer.parseInt(in.nextLine());
                if (n < 1) {
                    System.out.println("Ошибка! Необходимо вводить целое число больше 0");
                }
                else {
                    System.out.printf("Сумма чисел от 1 до %d = %d\n", n, n_sum(n));
                    System.out.printf("Произведение чисел от 1 до %d = %d\n", n, n_factorial(n));
                    check = false;
                }
            }
            catch (Exception e) {
                System.out.println("Ошибка! Необходимо вводить целое число больше 0");
            }
        }
    }

    public static int n_sum(Integer args) {
        int sum = args * (args + 1) / 2;

        return sum;
    }

    public static int n_factorial(int args) {
        if (args == 1 || args == 0) {
            return 1;
        }

        return args * n_factorial(args - 1);
    }
}