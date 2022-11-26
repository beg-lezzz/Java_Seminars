import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        double first = num_input();
        String math_operation = input_operation();
        double second = num_input();
        double result = result(first, second, math_operation);
        System.out.printf("%f %s %f = %f", first, math_operation, second, result);
    }

    public static String input_operation() {
        boolean check = true;
        Integer res = null;
        String math_operation = null;

        while (check) {
            System.out.print("Введите операцию (+, -, /, *): ");
            Scanner in = new Scanner(System.in);
            math_operation = (String) in.nextLine();
            if (Objects.equals("+", math_operation) || Objects.equals("-", math_operation) ||
                    Objects.equals("/", math_operation) || Objects.equals("*", math_operation)) {
                check = false;
            }
            else {
                System.out.println("Ошибка. Необходимо вводить символ (+, -, /, *)");
            }
        }
        return math_operation;
    }

    public static double result(double first, double second, String math_operation) {
        Double res = null;
        switch (math_operation) {
            case ("+"):
                res = num_sum(first, second);
                break;
            case ("-"):
                res = num_sub(first, second);
                break;
            case ("/"):
                res = num_div(first, second);
                break;
            case ("*"):
                res = num_mul(first, second);
                break;
        }
        return res;
    }

    public static double num_input() {
        Scanner in = new Scanner(System.in);
        boolean check = true;
        Double n = null;
        while (check) {
            System.out.print("Введите число: ");
            try {
                n = Double.parseDouble(in.nextLine().replaceAll(",", "."));
                check = false;
                }
            catch (Exception e) {
                System.out.println("Ошибка! Необходимо вводить число");
            }
        }
        return n;
    }

        public static double num_sum ( double first, double second){
            return first + second;
        }

        public static double num_sub ( double first, double second){
            return first - second;
        }

        public static double num_div ( double first, double second){
            return first / second;
        }

        public static double num_mul ( double first, double second){
            return first * second;
        }
}